package hctest.model.domain.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.hazelcast.nio.serialization.StreamSerializer;

import java.io.*;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * Created by aoldak at 12/18/13
 */
public abstract class KryoSerializer<T> implements StreamSerializer<T> {
  public static final int KRYO_TYPE_ID_ARTICLE = 1;
  public static final int KRYO_TYPE_ID_PRODUCT = 2;
  public static final int KRYO_TYPE_ID_ATTRIBUTE_TYPE = 3;
  public static final int KRYO_TYPE_ID_CATALOG = 4;
  public static final int KRYO_TYPE_ID_CATEGORY = 5;
  public static final int KRYO_TYPE_ID_DICTIONARY_VALUE = 6;
  public static final int KRYO_TYPE_ID_RELATION = 7;
  public static final int KRYO_TYPE_ID_RELATED_ELEMENTS = 8;
  public static final int KRYO_TYPE_ID_PROMOTION_FIXED_PRICE_POOL = 9;
  public static final int KRYO_TYPE_ID_PRODUCT_POOL = 10;
  public static final int KRYO_TYPE_ID_PROMOTION_FIXED_PRICE = 11;

  public final static boolean COMPRESS = Boolean.parseBoolean(System.getProperty("hazelcast.kryo.compress", "true"));

  protected void writeDataWithCompression(Kryo kryo, DataOutput objectDataOutput, T object) throws IOException {
    if (COMPRESS) {
      //this is a work around, normally you would like to write directly to the objectDataOutput, but apparently
      //this isn't working. The Output.flush doesn't work correctly, only the Output.close is working, but we don't
      //want to close the objectDataOutput here. So we write to a ByteArrayOutputStream and these bytes we write to
      //the objectDataOutput
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
      DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
      Output output = new Output(deflaterOutputStream);
      writeObjectData(kryo, output, object);
      output.close();

      byte[] bytes = byteArrayOutputStream.toByteArray();
      objectDataOutput.write(bytes);
    } else {
      Output output = new Output((OutputStream) objectDataOutput);
      writeObjectData(kryo, output, object);
      output.flush();
    }
  }

  public abstract void writeObjectData(Kryo kryo, Output output, T object);


  protected Input getObjectDataInput(DataInput dataInput) {
    InputStream in = (InputStream)dataInput;
    if (COMPRESS) {
      in = new InflaterInputStream(in);
    }

    Input input = new Input(in);
    return input;
  }

}
