package hctest.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author bart
 * @version $Id: AttributeType.java 14046 2011-03-03 10:40:01Z bart $
 */
public class AttributeType implements Serializable {
  

  /**
   * Zwiększyć o jeden, gdy następuje zmiana dotycząca trwałych właściwości obiektu (takich, które nie są Transient).
   * Po zmianie trzeba zadbać o to, by wszystkie projekty, które maja w zależnościach product-catalog-api posługiwały się nowszą wersją product-catalog-api.
   */
  private static final long serialVersionUID = 2L;

  private int idAttributeType;
  private String name;
  private ValueType attrType;
  private ValueType keyAttrType;
  private ValueType valueAttrType;
  private boolean multivalue = false;

  private ChangesSource acceptableSource;

  private boolean dating;

  private boolean automaticallyAdded;

  private Map<String, String> properties;

  private List<String> mdmFields;

  public Map<String, String> getProperties() {
    return properties;
  }

  public List<String> getMdmFields() {
    return mdmFields;
  }

  public AttributeType() {
    properties = new HashMap<String, String>();
    mdmFields = new ArrayList<String>();
  }

  public AttributeType(String name, ValueType attrType, boolean multivalue, ChangesSource acceptableSource, boolean dating) {
    this();
    this.name = name;
    this.attrType = attrType;
    this.multivalue = multivalue;
    this.acceptableSource = acceptableSource;
    this.dating = dating;
  }

  public AttributeType(String name, ValueType attrType, boolean multivalue, ChangesSource acceptableSource, boolean dating, ValueType keyAttrType,
                       ValueType valueAttrType) {
    this(name, attrType, multivalue, acceptableSource, dating);
    this.keyAttrType = keyAttrType;
    this.valueAttrType = valueAttrType;
  }

  public int getIdAttributeType() {
    return idAttributeType;
  }

  public ChangesSource getAcceptableSource() {
    return acceptableSource;
  }

  public String getName() {
    return name;
  }

  public ValueType getAttrType() {
    return attrType;
  }

  /**
   * Typ klucza, używane tylko dla typu Map.
   */
  public ValueType getKeyAttrType() {
    return keyAttrType;
  }

  /**
   * Typ wartości, używane tylko dla typu Map.
   */
  public ValueType getValueAttrType() {
    return valueAttrType;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null)
      return false;
    if (this == o)
      return true;

    /*
     * przypadek wystepuje niezwykle rzadko (raz na okolo 30 milionów utworzonych
     * obiektów) Rózne obiekty moga dostac ten sam system.identityHashCode,
     * poniewaz Sun wylicza go na podstawie adresu obiektu na heap'ie. W wyniku
     * dzialania defragmentacji heap'a przez GC adres moze sie zmienic
     */
    if (this.getIdAttributeType() == 0) {
      return this == o;
    }

    if (o instanceof AttributeType) {
      AttributeType typeToCompare = (AttributeType) o;
      return typeToCompare.getIdAttributeType() == getIdAttributeType();
    }
    return false;
  }

  @Override
  public String toString() {
    return "AttributeType [idAttributeType=" + idAttributeType + ", name=" + name + ", attrType=" + attrType + ", multivalue=" + multivalue
        + ", acceptableSource=" + acceptableSource + ", dating=" + dating + ", keyAttrType=" + keyAttrType + ", valueAttrType=" + valueAttrType + "]";
  }

  public static ValueType determineType(Object value) {
    Class<?> clazz = value.getClass();

    if (clazz.equals(BigDecimal.class) || clazz.equals(Double.class)) {
      return ValueType.Currency;
    } else if (clazz.equals(Integer.class)) {
      return ValueType.Integer;
    } else if (clazz.equals(Boolean.class)) {
      return ValueType.Boolean;
    } else if (clazz.equals(Date.class)) {
      return ValueType.Date;
    } else if (clazz.equals(DictionaryValue.class)) {
      return ValueType.DictionaryValueRef;
    } else if (clazz.equals(Category.class)) {
      return ValueType.CategoryRef;
    } else if (clazz.equals(String.class)) {
      return ValueType.String;
    } else if (clazz.equals(Availability.class)) {
      return ValueType.AvailabilityRef;
    } else if (clazz.equals(Price.class)) {
      return ValueType.PriceRef;
    } else if (Map.class.isAssignableFrom(clazz)) {
      return ValueType.Map;
    } else {
      return null;
    }
  }

  /**
   * True dla listy wartości
   */
  public boolean isMultivalue() {
    return multivalue;
  }

  /**
   * True gdy wartość atrybutu jest ważna tylko w jakimś okresie.
   */
  public boolean isDating() {
    return dating;
  }

  /**
   * True gdy typ atrybutu został dodany automatycznie.
   */
  public boolean isAutomaticallyAdded() {
    return automaticallyAdded;
  }

  public void setIdAttributeType(int idAttributeType) {
    this.idAttributeType = idAttributeType;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAttrType(ValueType attrType) {
    this.attrType = attrType;
  }

  public void setKeyAttrType(ValueType keyAttrType) {
    this.keyAttrType = keyAttrType;
  }

  public void setValueAttrType(ValueType valueAttrType) {
    this.valueAttrType = valueAttrType;
  }

  public void setMultivalue(boolean multivalue) {
    this.multivalue = multivalue;
  }

  public void setAcceptableSource(ChangesSource acceptableSource) {
    this.acceptableSource = acceptableSource;
  }

  public void setDating(boolean dating) {
    this.dating = dating;
  }

  public void setAutomaticallyAdded(boolean automaticallyAdded) {
    this.automaticallyAdded = automaticallyAdded;
  }

  public void setProperties(Map<String, String> properties) {
    if (properties == null) {
      throw new IllegalArgumentException("Field properties cannot be set as null only as map");
    }
    this.properties = properties;
  }

  public void setMdmFields(List<String> mdmFields) {
    if (mdmFields == null) {
      throw new IllegalArgumentException("Field mdmFields cannot be set as null only as list");
    }
    this.mdmFields = mdmFields;
  }

  @SuppressWarnings("unchecked")
  public Object convertValue(Object value) {
    if (!multivalue) {
      return attrType.convertSingleValue(value);
    }
    final List<Object> list = (List<Object>) value;
    for (ListIterator<Object> iterator = list.listIterator(); iterator.hasNext(); ) {
      iterator.set(attrType.convertSingleValue(iterator.next()));
    }
    return list;
  }
}
