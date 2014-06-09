package hctest.model.domain;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import hctest.model.domain.common.EmbededValue;

public enum ValueType {
  String            (EqualsStrategy.SIMPLE_VALUE),
  Integer           (EqualsStrategy.SIMPLE_VALUE),
  Currency          (EqualsStrategy.SIMPLE_VALUE),
  Boolean           (EqualsStrategy.SIMPLE_VALUE),
  Date              (EqualsStrategy.SIMPLE_VALUE) {
    @Override
    public Object convertSingleValue(Object value) {
      return new Date( (((Date)value).getTime()/1000l) * 1000l );
    }
  },
  LongString        (EqualsStrategy.SIMPLE_VALUE),
  DictionaryValueRef(EqualsStrategy.DICTIONARY_VALUE_REFERENCE),
  CategoryRef       (EqualsStrategy.CATEGORY_REFERENCE),
  EnumRef           (EqualsStrategy.SIMPLE_VALUE),
  AvailabilityRef   (EqualsStrategy.EMBEDDED_VALUE),
  PriceRef          (EqualsStrategy.EMBEDDED_VALUE),
  Map               (EqualsStrategy.SIMPLE_VALUE) {
    @SuppressWarnings("unchecked")
    @Override
    public Object convertSingleValue(Object value) {
      Map<Object, Object> map = (Map<Object, Object>) value;
      for (Entry<Object, Object> entry : map.entrySet()) {
        if (!(entry.getValue() instanceof Date)) {
          break;
        }
        entry.setValue(Date.convertSingleValue(entry.getValue()));
      }
      return map;
    }
  }
  ,
  Transient         (null);
  
  private EqualsStrategy equalsStrategy;
  
  ValueType(EqualsStrategy equalsStrategy){
    this.equalsStrategy = equalsStrategy;
  }
  
  public EqualsStrategy getEqualsStrategy() {
    return equalsStrategy;
  }
  
  //FIXME:Dodać boolean hasNaturalStringConversion jako zmienna prywatna enuma. Dodać mechanizm zwracania komparatora wartości przez enum
  public boolean hasNaturalStringConversion() {
    return (this.equals(ValueType.String) || this.equals(ValueType.DictionaryValueRef) || this.equals(ValueType.LongString));
  }

  public Object convertSingleValue(Object value) {
    return value;
  }

  public enum EqualsStrategy {
    SIMPLE_VALUE {
      @Override
      public boolean singleValueEquals(Object singleValue1, Object singleValue2) {
        return singleValue1.equals(singleValue2);
      }
    },
    EMBEDDED_VALUE {
      @Override
      public boolean singleValueEquals(Object singleValue1, Object singleValue2) {
        return ((EmbededValue) singleValue1).equalsValue((EmbededValue) singleValue2);
      }
    },
    DICTIONARY_VALUE_REFERENCE {
      @Override
      public boolean singleValueEquals(Object singleValue1, Object singleValue2) {
        return ((DictionaryValue) singleValue1).getIdDictionaryValue() == ((DictionaryValue) singleValue2).getIdDictionaryValue();
      }
    },
    CATEGORY_REFERENCE {
      @Override
      public boolean singleValueEquals(Object singleValue1, Object singleValue2) {
        return ((Category) singleValue1).getCatId().equals(((Category) singleValue2).getCatId());
      }
    };

    public abstract boolean singleValueEquals(Object singleValue1, Object singleValue2);
  }
}
