package hctest.model.domain.serialization;

import hctest.model.domain.Category;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;

import java.io.IOException;

/**
 * Created by aoldak at 12/19/13
 */
public class CategoryKryoSerializer extends KryoSerializer<Category> {
  private static final ThreadLocal<Kryo> kryoThreadLocal = new ThreadLocal<Kryo>() {
    @Override
    protected Kryo initialValue() {
      Kryo kryo = new Kryo();
      kryo.register(Category.class);
      return kryo;
    }
  };
  
  @Override
  public void writeObjectData(Kryo kryo, Output output, Category category) {
    kryo.writeObjectOrNull(output, category.getCatId(), String.class);
    kryo.writeObjectOrNull(output, category.getName(), String.class);
    kryo.writeObjectOrNull(output, category.getParentCat(), Category.class);
    kryo.writeObjectOrNull(output, category.getHidden(), Boolean.class);
    kryo.writeObjectOrNull(output, category.getBusinessId(), String.class);
    kryo.writeObjectOrNull(output, category.getSeoPath(), String.class);
    kryo.writeObjectOrNull(output, category.getDisplayPath(), String.class);
  }

  @Override
  public void write(ObjectDataOutput out, Category category) throws IOException {
    Kryo kryo = kryoThreadLocal.get();
    writeDataWithCompression(kryo, out, category);
  }

  @Override
  public Category read(ObjectDataInput in) throws IOException {
    Input input = getObjectDataInput(in);
    Kryo kryo = kryoThreadLocal.get();

    Category category = new Category();
    category.setCatId ( kryo.readObjectOrNull(input, String.class));
    category.setName ( kryo.readObjectOrNull(input, String.class));
    category.setParentCat ( kryo.readObjectOrNull(input, Category.class));
    category.setHidden ( kryo.readObjectOrNull(input, Boolean.class));
    category.setBusinessId(kryo.readObjectOrNull(input, String.class));
    category.setSeoPath(kryo.readObjectOrNull(input, String.class));
    category.setDisplayPath(kryo.readObjectOrNull(input, String.class));
    input.close();

    return category;
  }

  @Override
  public int getTypeId() {
    return KRYO_TYPE_ID_CATEGORY;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void destroy() {
    //To change body of implemented methods use File | Settings | File Templates.
  }
}
