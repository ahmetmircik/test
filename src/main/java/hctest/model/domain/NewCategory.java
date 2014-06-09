package hctest.model.domain;

import java.io.Serializable;

import hctest.model.domain.NewCategory;

  
@Deprecated
public class NewCategory implements Serializable{
  
  /**
   * Zwiększyć o jeden, gdy następuje zmiana dotycząca trwałych właściwości obiektu (takich, które nie są Transient).
   * Po zmianie trzeba zadbać o to, by wszystkie projekty, które maja w zależnościach product-catalog-api posługiwały się nowszą wersją product-catalog-api.
   */
  private static final long serialVersionUID = 1L;

  protected Integer id;
  protected String oldIdWithTreeStructure;
  protected String name;
  protected NewCategory parent;

  public String getOldIdWithTreeStructure() {
    return oldIdWithTreeStructure;
  }

  public String getName() {
    return name;
  }

  public NewCategory getParent() {
    return parent;
  }
  
  public Integer getId() {
    return id;
  }

  public NewCategory(Integer id, String categoryId, String name, NewCategory parent) {
    this.oldIdWithTreeStructure = categoryId;
    this.name = name;
    this.parent = parent;
    this.id = id;
  }

}
