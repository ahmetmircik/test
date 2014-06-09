package hctest.model.domain.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import hctest.model.domain.AttributeType;
import hctest.model.domain.ChangesSource;
import hctest.model.domain.ValueType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by aoldak at 12/19/13
 */
public class AttributeTypeKryoSerializer extends KryoSerializer<AttributeType> {
  private static final ThreadLocal<Kryo> kryoThreadLocal = new ThreadLocal<Kryo>() {
    @Override
    protected Kryo initialValue() {
      Kryo kryo = new Kryo();
      kryo.register(AttributeType.class);
      kryo.register(ValueType.class);
      kryo.register(ChangesSource.class);
      kryo.register(HashMap.class);
      kryo.register(ArrayList.class);
      return kryo;
    }
  };
  
  @Override
  public void writeObjectData(Kryo kryo, Output output, AttributeType attributeType) {
    kryo.writeObjectOrNull(output, attributeType.getIdAttributeType(), Integer.class);
    kryo.writeObjectOrNull(output, attributeType.getName(), String.class);
    kryo.writeObjectOrNull(output, attributeType.getAttrType(), ValueType.class);
    kryo.writeObjectOrNull(output, attributeType.getKeyAttrType(), ValueType.class);
    kryo.writeObjectOrNull(output, attributeType.getValueAttrType(), ValueType.class);
    kryo.writeObjectOrNull(output, attributeType.isMultivalue(), Boolean.class);
    kryo.writeObjectOrNull(output, attributeType.getAcceptableSource(), ChangesSource.class);
    kryo.writeObjectOrNull(output, attributeType.isDating(), Boolean.class);
    kryo.writeObjectOrNull(output, attributeType.isAutomaticallyAdded(), Boolean.class);
    kryo.writeObject(output, attributeType.getProperties());
    kryo.writeObject(output, attributeType.getMdmFields());  }

  @Override
  public void write(ObjectDataOutput out, AttributeType attributeType) throws IOException {
    Kryo kryo = kryoThreadLocal.get();
    writeDataWithCompression(kryo, out, attributeType);
  }

  @Override
  public AttributeType read(ObjectDataInput in) throws IOException {
    Input input = getObjectDataInput(in);
    Kryo kryo = kryoThreadLocal.get();

    AttributeType attributeType = new AttributeType();
    attributeType.setIdAttributeType ( kryo.readObjectOrNull(input, Integer.class));
    attributeType.setName ( kryo.readObjectOrNull(input, String.class));
    attributeType.setAttrType ( kryo.readObjectOrNull(input, ValueType.class));
    attributeType.setKeyAttrType ( kryo.readObjectOrNull(input, ValueType.class));
    attributeType.setValueAttrType ( kryo.readObjectOrNull(input, ValueType.class));
    attributeType.setMultivalue ( kryo.readObjectOrNull(input, Boolean.class));
    attributeType.setAcceptableSource ( kryo.readObjectOrNull(input, ChangesSource.class));
    attributeType.setDating ( kryo.readObjectOrNull(input, Boolean.class));
    attributeType.setAutomaticallyAdded ( kryo.readObjectOrNull(input, Boolean.class));
    attributeType.setProperties ( kryo.readObject(input, HashMap.class));
    attributeType.setMdmFields ( kryo.readObject(input, ArrayList.class));
    input.close();

    return attributeType;
  }

  @Override
  public int getTypeId() {
    return KRYO_TYPE_ID_ATTRIBUTE_TYPE;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void destroy() {
    //To change body of implemented methods use File | Settings | File Templates.
  }
}
