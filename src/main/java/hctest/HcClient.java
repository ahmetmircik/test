package hctest;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import hctest.model.domain.Attribute;
import hctest.model.domain.AttributeType;
import hctest.model.domain.ChangesSource;
import hctest.model.domain.Product;
import hctest.model.domain.ValueType;
import hctest.model.domain.serialization.ProductKryoSerializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class HcClient {
  public static final int NUM_ATTRIBUTES = 50;
  private static CountDownLatch startLatch;
  private static CountDownLatch endLatch;
  private static HazelcastInstance hc;

  public static void main(String[] args) throws Exception {
    Integer numProducts = Integer.valueOf(args[0]);
    Integer numReadThreads = Integer.valueOf(args[1]);

    hc = getHazelcastInstance();

    startLatch = new CountDownLatch(1);
    endLatch = new CountDownLatch(numReadThreads);

    System.out.println(String.format("Spawning %d blocked reader threads", numReadThreads));

    for (int i = 0; i < numReadThreads; i++) {
      new Thread(new Reader(numProducts)).start();
    }

    System.out.println(String.format("Filling map with %d products",numProducts));

    fillMap(numProducts);

    System.out.println("Map filled. Unblocking reader threads");

    long start = System.currentTimeMillis();
    startLatch.countDown();
    endLatch.await();

    long end = System.currentTimeMillis();
    System.out.println(String.format("\n-----------\nDone. Took %.2f seconds\n-----------\n", (end-start)/1000.0));

    System.out.println("Clearing map");
    getMap().clear();
    System.out.println("Shutting down HC client");

    hc.shutdown();

  }

  private static class Reader implements Runnable {
    private int numProducts;

    private Reader(int numProducts) {
      this.numProducts = numProducts;
    }

    @Override
    public void run() {
      try {
        startLatch.await();
        for (int i = 0; i < numProducts; i++) {
          Product p = (Product) getMap().get(getProductId(i));
          assert p != null;
          assert p.getAttributes().size() == NUM_ATTRIBUTES;
        }
        endLatch.countDown();
      } catch (InterruptedException ex) {
      }
    }


  }

  private static IMap<Object, Object> getMap() {
    return hc.getMap(HcServer.MAP_NAME);
  }

  private static void fillMap(int numProducts) {
    for (int i = 0; i < numProducts; i++) {
      Product product = getProduct(i);
      String productId = getProductId(i);
      getMap().put(productId, product);
    }
  }

  private static List<Integer> getProductIdsToRead(int numProducts) {
    List<Integer> ids = new ArrayList<Integer>();
    for (int i = 0; i < numProducts; i++) {
      ids.add(i);
    }

    Collections.shuffle(ids);
    return ids;
  }

  private static HazelcastInstance getHazelcastInstance() {
    ClientConfig config = new ClientConfig();
      config.getGroupConfig().setName("test-ahmet");
    SerializerConfig productSerializerConfig = new SerializerConfig().setImplementation(new ProductKryoSerializer()).setTypeClass(Product.class);
    config.getSerializationConfig().addSerializerConfig(productSerializerConfig);

    return HazelcastClient.newHazelcastClient(config);
  }

  private static String getProductId(int i) {
    return "product_" + i;
  }

  private static Product getProduct(int id) {
    Product product = new Product();

    for (int i = 0; i < NUM_ATTRIBUTES; i++) {
      AttributeType attributeType = new AttributeType("attribueType_" + i, ValueType.String, false, ChangesSource.PORTAL, false);
      Attribute attribute = new Attribute(attributeType, "att_" + i);
      product.setAttribute(attribute);
    }

    return product;
  }

}
