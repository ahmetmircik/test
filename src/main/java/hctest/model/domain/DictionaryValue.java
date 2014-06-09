package hctest.model.domain;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;

import java.io.Serializable;

/**
 * MDM dictionaries
 *
 * @author bart
 * @version $Id: PriceUserType.java 13803 2011-02-24 14:46:18Z bart $
 */
public class DictionaryValue implements Serializable {

  /**
   * Zwiększyć o jeden, gdy następuje zmiana dotycząca trwałych właściwości obiektu (takich, które nie są Transient).
   * Po zmianie trzeba zadbać o to, by wszystkie projekty, które maja w zależnościach product-catalog-api posługiwały się nowszą wersją product-catalog-api.
   */
  private static final long serialVersionUID = 1L;

  private int idDictionaryValue;

  private int dictionaryId; // <dictionaryId>
  private String dictionaryCode; // <dictionaryCode>
  private long itemId; // <id>
  private String itemValue; // <label>
  private String itemCode; // <code>

  public DictionaryValue() {
  }

  public DictionaryValue(int dictionaryId, String dictionaryCode, long itemId, String itemValue, String itemCode) {

    this.dictionaryId = dictionaryId;
    this.dictionaryCode = dictionaryCode;
    this.itemId = itemId;
    this.itemValue = itemValue;
    this.itemCode = itemCode;

  }

  public String getMapKey() {
    return getMapKey(getDictionaryId(), +getItemId());
  }

  /**
   * just PK
   */
  public int getIdDictionaryValue() {
    return idDictionaryValue;
  }

  /**
   * MDM'owy id wartości słownikowanej - <id>
   */
  public long getItemId() {
    return itemId;
  }

  /**
   * MDM'owy code wartości słownikowanej - <code>
   */
  public String getItemCode() {
    return itemCode;
  }

  /**
   * Wartość słownikowana - <label>
   */
  public String getItemValue() {
    return itemValue;
  }

  /**
   * MDM'owy id słownika - <dictionaryId>
   */
  public int getDictionaryId() {
    return dictionaryId;
  }

  /**
   * MDM'owy code słownika - <dictionaryCode>
   */
  public String getDictionaryCode() {
    return dictionaryCode;
  }

  @Override
  public String toString() {

    return "DictionaryValue " +
        "idDictionaryValue[" + this.idDictionaryValue + "] " +
        "dictId[" + this.dictionaryId + "] " +
        "dictCode[" + this.dictionaryCode + "] " +
        "itemId[" + this.itemId + "] " +
        "itemValue[" + this.itemValue + "]" +
        "itemCode[" + this.itemCode + "]";

  }

  @Override
  public boolean equals(Object o) {

    if (o == null || !(o instanceof DictionaryValue))
      return false;

    return equalsValue((DictionaryValue) o);
  }

  public boolean equalsValue(DictionaryValue obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }

    return new EqualsBuilder()
        .append(dictionaryId, obj.dictionaryId)
        .append(dictionaryCode, obj.dictionaryCode)
        .append(itemId, obj.itemId)
        .append(itemCode, obj.itemCode)
        .append(itemValue, obj.itemValue)
        .isEquals();
  }

  @Override
  public int hashCode() {
    int result = dictionaryId;
    result = 31 * result + (dictionaryCode != null ? dictionaryCode.hashCode() : 0);
    result = 31 * result + (int) (itemId ^ (itemId >>> 32));
    result = 31 * result + (itemValue != null ? itemValue.hashCode() : 0);
    result = 31 * result + (itemCode != null ? itemCode.hashCode() : 0);
    return result;
  }

  public static String getMapKey(int dictionaryId, long itemId) {
    return dictionaryId + "," + itemId;
  }

  public static int getDictionaryIdFromMapKey(String mapKey) {
    if (mapKey.split(",").length != 2) {
      throw new RuntimeException("getDictionaryIdFromMapKey() : mapKey [" + mapKey + "] is malformed");
    }
    try {
      return Integer.parseInt(mapKey.split(",")[0]);
    } catch (NumberFormatException e) {
      throw new RuntimeException(e);
    }
  }

  public static long getItemIdFromMapKey(String mapKey) {
    if (mapKey.split(",").length != 2) {
      throw new RuntimeException("getItemIdFromMapKey() : mapKey [" + mapKey + "] is malformed");
    }
    try {
      return Long.parseLong(mapKey.split(",")[1]);
    } catch (NumberFormatException e) {
      throw new RuntimeException(e);
    }
  }

  public void setIdDictionaryValue(int idDictionaryValue) {
    this.idDictionaryValue = idDictionaryValue;
  }

  public void setDictionaryId(int dictionaryId) {
    this.dictionaryId = dictionaryId;
  }

  public void setDictionaryCode(String dictionaryCode) {
    this.dictionaryCode = dictionaryCode;
  }

  public void setItemId(long itemId) {
    this.itemId = itemId;
  }

  public void setItemValue(String itemValue) {
    this.itemValue = itemValue;
  }

  public void setItemCode(String itemCode) {
    this.itemCode = itemCode;
  }

  public void modify(DictionaryValue dictionaryValue) {
    Validate.isTrue(dictionaryId == dictionaryValue.dictionaryId, "Dictionary ids should be Equal.");
    Validate.isTrue(itemId == dictionaryValue.itemId, "Item ids should be Equal.");
    setItemValue(dictionaryValue.getItemValue());
    setItemCode(dictionaryValue.getItemCode());
    setDictionaryCode(dictionaryValue.getDictionaryCode());
  }

}
