package hctest;

import com.hazelcast.config.Config;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.Hazelcast;
import hctest.model.domain.Product;
import hctest.model.domain.serialization.ProductKryoSerializer;

/**
 * Hello world!
 */
public class HcServer {
    public static final String MAP_NAME = "MAP_NAME";

    public static void main(String[] args) {
        Integer nodeCount = Integer.valueOf(args[0]);

        Config config = new Config();
        config.getGroupConfig().setName("test-ahmet");
        SerializerConfig productSerializerConfig = new SerializerConfig().setImplementation(new ProductKryoSerializer()).setTypeClass(Product.class);
        config.getSerializationConfig().addSerializerConfig(productSerializerConfig);

        for (int i = 0; i < nodeCount; i++) {
            Hazelcast.newHazelcastInstance(config);
        }
    }
}
