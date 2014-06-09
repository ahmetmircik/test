package hctest.model.domain.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import hctest.model.domain.Catalog;

import java.io.IOException;

/**
 * Created by aoldak at 12/19/13
 */
public class CatalogKryoSerializer extends KryoSerializer<Catalog> {
  private static final ThreadLocal<Kryo> kryoThreadLocal = new ThreadLocal<Kryo>() {
    @Override
    protected Kryo initialValue() {
      Kryo kryo = new Kryo();
      kryo.register(Catalog.class);
      return kryo;
    }
  };
  
  @Override
  public void writeObjectData(Kryo kryo, Output output, Catalog catalog) {
    kryo.writeObjectOrNull(output, catalog.getIdCatalog(), Integer.class);
    kryo.writeObjectOrNull(output, catalog.getName(), String.class);
    kryo.writeObjectOrNull(output, catalog.getPricingId(), Integer.class);
  }

  @Override
  public void write(ObjectDataOutput out, Catalog catalog) throws IOException {
    Kryo kryo = kryoThreadLocal.get();
    writeDataWithCompression(kryo, out, catalog);
  }

  @Override
  public Catalog read(ObjectDataInput in) throws IOException {
    Input input = getObjectDataInput(in);
    Kryo kryo = kryoThreadLocal.get();

    Catalog catalog = new Catalog();
    catalog.setIdCatalog ( kryo.readObjectOrNull(input, Integer.class));
    catalog.setName ( kryo.readObjectOrNull(input, String.class));
    catalog.setPricingId( kryo.readObjectOrNull(input, Integer.class));
    input.close();

    return catalog;
  }

  @Override
  public int getTypeId() {
    return KRYO_TYPE_ID_CATALOG;
  }

  @Override
  public void destroy() {
    //To change body of implemented methods use File | Settings | File Templates.
  }
}
