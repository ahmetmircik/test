package hctest.model.domain;

import hctest.model.domain.Catalog;

/**
 * Visitor po wszystkich (katalogi) wartościach prostych 
 * 
 * @author bwalacik
 */
public interface AttributeValuesVisitor {
  
  /** 
   * @param simpleValue dla multivalue - element listy
   * @param catalog katalog do którego należy wartość, null - default catalog
   * @param order dla multivalue - kolejność na liście, wpp null 
   */
  public void inspectValue(Object simpleValue, Catalog catalog, Integer order);
}
