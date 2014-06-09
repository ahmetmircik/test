package hctest.model.domain.serialization;

import hctest.model.domain.*;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by aoldak at 12/19/13
 */
public class ProductKryoSerializer extends KryoSerializer<Product> {
  private static final ThreadLocal<Kryo> kryoThreadLocal = new ThreadLocal<Kryo>() {
    @Override
    protected Kryo initialValue() {
      Kryo kryo = new Kryo();
      kryo.register(Attribute.class);
      kryo.register(AttributeType.class);
      kryo.register(Availability.class);
      kryo.register(Catalog.class);
      kryo.register(Category.class);
      kryo.register(DictionaryValue.class);
      kryo.register(OrderableCode.class);
      kryo.register(Price.class);
      kryo.register(Product.class);
      kryo.register(ProductAvailability.class);
      kryo.register(ProductState.class);
      kryo.register(StockAvailability.class);
      kryo.register(ValidRange.class);
      kryo.register(ValueType.class);
      kryo.register(ChangesSource.class);
      kryo.register(HashMap.class);
      kryo.register(HashSet.class);
      kryo.register(BigDecimal.class);
      kryo.register(Date.class);
      return kryo;
    }
  };

  @Override
  public void writeObjectData(Kryo kryo, Output output, Product product) {
    kryo.writeObjectOrNull(output, product.getCatalogContext(), Catalog.class);
    kryo.writeObjectOrNull(output, product.getId(), String.class);
    kryo.writeObjectOrNull(output, product.getCatalogVersion(), Long.class);
    kryo.writeObjectOrNull(output, product.getGoldId(), String.class);
    kryo.writeObjectOrNull(output, product.getMdmIndex(), String.class);
    kryo.writeObject(output, product.getAttributes());
    kryo.writeObject(output, product.getCatalogs());
  }

  @Override
  public void write(ObjectDataOutput objectDataOutput, Product product) throws IOException {
    Kryo kryo = kryoThreadLocal.get();
    writeDataWithCompression(kryo, objectDataOutput, product);
  }

  @Override
  public Product read(ObjectDataInput objectDataInput) throws IOException {
    Input input = getObjectDataInput(objectDataInput);
    Kryo kryo = kryoThreadLocal.get();

    Product product = new Product();

    product.setCatalogContext ( kryo.readObjectOrNull(input, Catalog.class));
    product.setId ( kryo.readObjectOrNull(input, String.class));
    product.setCatalogVersion ( kryo.readObjectOrNull(input, Long.class));
    product.setGoldId ( kryo.readObjectOrNull(input, String.class));
    product.setMdmIndex ( kryo.readObjectOrNull(input, String.class));
    product.setAttributes ( kryo.readObject(input, HashMap.class));
    product.setCatalogs ( kryo.readObject(input, HashSet.class));
    input.close();

    return product;
  }

  @Override
  public int getTypeId() {
    return KRYO_TYPE_ID_PRODUCT;
  }

  @Override
  public void destroy() {
    //To change body of implemented methods use File | Settings | File Templates.
  }
}
