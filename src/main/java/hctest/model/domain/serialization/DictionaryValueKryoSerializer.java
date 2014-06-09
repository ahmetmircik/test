package hctest.model.domain.serialization;

import hctest.model.domain.DictionaryValue;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;

import java.io.IOException;

/**
 * Created by aoldak at 12/19/13
 */
public class DictionaryValueKryoSerializer  extends KryoSerializer<DictionaryValue> {

  private static final ThreadLocal<Kryo> kryoThreadLocal = new ThreadLocal<Kryo>() {
    @Override
    protected Kryo initialValue() {
      Kryo kryo = new Kryo();
      kryo.register(DictionaryValue.class);
      return kryo;
    }
  };


  @Override
  public void writeObjectData(Kryo kryo, Output output, DictionaryValue dictionaryValue) {
    kryo.writeObjectOrNull(output, dictionaryValue.getIdDictionaryValue(), Integer.class);
    kryo.writeObjectOrNull(output, dictionaryValue.getDictionaryId(), Integer.class);
    kryo.writeObjectOrNull(output, dictionaryValue.getDictionaryCode(), String.class);
    kryo.writeObjectOrNull(output, dictionaryValue.getItemId(), Long.class);
    kryo.writeObjectOrNull(output, dictionaryValue.getItemValue(), String.class);
    kryo.writeObjectOrNull(output, dictionaryValue.getItemCode(), String.class);
  }

  @Override
  public void write(ObjectDataOutput out, DictionaryValue dictionaryValue) throws IOException {
    Kryo kryo = kryoThreadLocal.get();
    writeDataWithCompression(kryo, out, dictionaryValue);
  }

  @Override
  public DictionaryValue read(ObjectDataInput in) throws IOException {
    Input input = getObjectDataInput(in);
    Kryo kryo = kryoThreadLocal.get();

    DictionaryValue dictionaryValue = new DictionaryValue();
    dictionaryValue.setIdDictionaryValue ( kryo.readObjectOrNull(input, Integer.class));
    dictionaryValue.setDictionaryId ( kryo.readObjectOrNull(input, Integer.class));
    dictionaryValue.setDictionaryCode ( kryo.readObjectOrNull(input, String.class));
    dictionaryValue.setItemId ( kryo.readObjectOrNull(input, Long.class));
    dictionaryValue.setItemValue ( kryo.readObjectOrNull(input, String.class));
    dictionaryValue.setItemCode ( kryo.readObjectOrNull(input, String.class));
    input.close();

    return dictionaryValue;
  }

  @Override
  public int getTypeId() {
    return KRYO_TYPE_ID_DICTIONARY_VALUE;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void destroy() {
    //To change body of implemented methods use File | Settings | File Templates.
  }
}
