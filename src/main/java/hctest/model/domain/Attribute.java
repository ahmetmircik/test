package hctest.model.domain;

import java.io.Serializable;
import java.util.*;

import hctest.model.domain.AttributeType;
import hctest.model.domain.AttributeValuesVisitor;
import hctest.model.domain.Catalog;
import hctest.model.domain.ValidRange;

/**
 * Klasa modelu domenowego, nie jest encją Hibernate, see {@link AttributeHbm}
 * 
 * @author czajkowski
 * @author bart
 */
public class Attribute implements Serializable {

  /**
   * Zwiększyć o jeden, gdy następuje zmiana dotycząca trwałych właściwości obiektu (takich, które nie są Transient).
   * Po zmianie trzeba zadbać o to, by wszystkie projekty, które maja w zależnościach product-catalog-api posługiwały się nowszą wersją product-catalog-api.
   */
  private static final long serialVersionUID = 2L;

  private AttributeType attributeType;
  
  private Map<Catalog, Object>     values = new HashMap<Catalog, Object>();
  private Map<Catalog, ValidRange> ranges = new HashMap<Catalog, ValidRange>();
  
  public Attribute(AttributeType attributeType) {
    this.attributeType = attributeType;
  }
  
  public Attribute(AttributeType attributeType, Object defaultValue) {
    this(attributeType);
    setDefaultValue(defaultValue);
  }

  private Attribute(){

  }
  
  /**
   * Wartość atrybutu w kontekście sklepu/katalogu, 
   * jeśli catalogContext == null - zwraca default value
   */
  public Object getValue(Catalog catalogContext) {
    if (getCatalogContexts().contains(catalogContext)) {
      return values.get(catalogContext);
    } else {
      return getDefaultValue();
    }
  }
  
  public ValidRange getValueValidRange(Catalog catalogContext) {
    if (getCatalogContexts().contains(catalogContext)) {
      return ranges.get(catalogContext);
    } else {
      return getDefaultValueValidRange();
    }
  }
  
  /**
   * to samo co {@link #getValue(Catalog)} ale robi cast na Listę, jeśli attr nie jest multivalue, rzuci wyjątek
   */
  public List getValueAsList(Catalog catalogContext) {
    checkIfCanBeConvertedToList();
    return (List)getValue(catalogContext);
  }

  protected void checkIfCanBeConvertedToList() {
    if (getAttributeType().isMultivalue() == false) {
      throw new RuntimeException("Cannot get value as list : not a multivalue");
    }
  }

  /**
   * to samo co {@link #getCatalogValue(Catalog)} ale robi cast na Listę, jeśli attr nie jest multivalue, rzuci wyjątek
   */
  public List getCatalogValueAsList(Catalog catalog) {
    checkIfCanBeConvertedToList();
    return (List) getCatalogValue(catalog);
  }

  /**
   * Wartość atrybutu dla <b>konkretnego sklepu</b> katalogu,
   * w odróżnieniu od {@link #getValue(Catalog)} <b>nie</b> podmienia null na default value
   */
  public Object getCatalogValue(Catalog catalog) {
    return values.get(catalog);
  }

  /**
   * Wartość domyślna (dla Catalog.DEFAULT_CATALOG)
   */
  public Object getDefaultValue() {
    return values.get(Catalog.DEFAULT_CATALOG);
  }

  public ValidRange getDefaultValueValidRange() {
    return ranges.get(Catalog.DEFAULT_CATALOG);
  }

  /**
   * Zbiór kontekstów (sklepów/katalogów) dla których są różne wartości atrubutu. Nienullowy
   */
  public Set<Catalog> getCatalogContexts() {
    if (values == null) return new HashSet<Catalog>();

    return new HashSet<Catalog>(values.keySet());
  }

  /**
   * posortowana wersja {@link #getCatalogContexts()}
   */
  public List<Catalog> getCatalogContextsSorted() {
    if (values == null) return new ArrayList<Catalog>();

    List<Catalog> ret = new ArrayList<Catalog>(values.keySet());
    Collections.sort(ret);
    return ret;
  }

  /**
   * Wartość domyślna
   */
  public void setDefaultValue(Object value) {
    setValue(Catalog.DEFAULT_CATALOG, value);
  }

  public void setValue(Catalog catalog, Object value) {
    if (value == null) {
      throw new IllegalArgumentException("Null values not allowed");
    }

    if (catalog == null)
      throw new IllegalArgumentException("Catalog can't be null, did you mean DEFAULT_CATALOG?");

    final Object convertedValue = attributeType.convertValue(value);    // FIXME Powinno chyba udekorować lisŧę, bo add() na liście nie wywoła convertValue().
    values.put(catalog, convertedValue);
  }

  public void setValueValidRange(Catalog shopContext, ValidRange validRange) {
     ranges.put(shopContext, validRange);
  }


  public void removeValue(Catalog shopContext) {
    values.remove(shopContext);
  }

  public String getName() {
    return attributeType.getName();
  }

  public AttributeType getAttributeType() {
    return attributeType;
  }

  public void inspectValues(AttributeValuesVisitor visitor) {
    for (Catalog catalog : getCatalogContexts()) {
      Object catalogValue = getCatalogValue(catalog);

      if (getAttributeType().isMultivalue()) {
        List list= (List) catalogValue;

        for (int i=0; i<list.size(); i++) {
          visitor.inspectValue(list.get(i), catalog, i);
        }
      }
      else {
        visitor.inspectValue(catalogValue, catalog, null);
      }
     }
  }

  @Override
  public String toString() {
    StringBuffer buf = new StringBuffer();

    buf.append("Attribute <"+getAttributeType().getName()+">, type:"+getAttributeType().getAttrType()+", multi:"+getAttributeType().isMultivalue()+", value(s): \n");

    for (Catalog shop : getCatalogContextsSorted()) {
      if (isDating() && getValueValidRange(shop) != null) {
        ValidRange range = getValueValidRange(shop);
        buf.append(".. ["+shop+"] "+range+"\n");

      }
      buf.append(".. ["+shop+"] : "+ getValue(shop)+"\n");
    }

    return buf.toString();
  }

  private Map<Catalog, Object> getValues() {
    return values;
  }

  public boolean isEmpty() {
    return values.isEmpty();
  }

  boolean valueInRange(Catalog catalog) {
    //jeśli attr nie jest datowany
    if (!isDating())
      return true;

    ValidRange range = getValueValidRange(catalog);

    if (range == null)
      return true;

    if (range.inRange(new Date()) )
      return true;
    else
      return false;
  }

  public boolean isDating() {
    return getAttributeType().isDating();
  }

  Object getValueRangeAware(Catalog catalogContext){
    if (valueInRange(catalogContext))
      return getValue(catalogContext);
    return null;
  }
}
