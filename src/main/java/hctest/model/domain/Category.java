package hctest.model.domain;

import java.io.Serializable;

/**
 * Old-school category (copy, paste from portal)
 *
 * @author bart
 * @version $Id: Category.java 14046 2011-03-03 10:40:01Z bart $
 */
public class Category implements Serializable {

  /**
   * Zwiększyć o jeden, gdy następuje zmiana dotycząca trwałych właściwości obiektu (takich, które nie są Transient).
   * Po zmianie trzeba zadbać o to, by wszystkie projekty, które maja w zależnościach product-catalog-api posługiwały się nowszą wersją product-catalog-api.
   */
  private static final long serialVersionUID = 3L;

  private String catId;
  private String name;
  private Category parentCat;
  private Boolean hidden;
  private String businessId;
  private String displayPath;
  private String seoPath;

  public String getCatId() {
    return catId;
  }

  public Category getParentCat() {
    return parentCat;

  }

  public void setCatId(String catId) {
    this.catId = catId;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Category: " + name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setParentCat(Category parentCat) {
    this.parentCat = parentCat;
  }

  public Boolean getHidden() {
    return hidden;
  }

  public void setHidden(Boolean hidden) {
    this.hidden = hidden;
  }

  public String getBusinessId() {
    return businessId;
  }

  public void setBusinessId(String businessId) {
    this.businessId = businessId;
  }

  public String getDisplayPath() {
    return displayPath;
  }

  public void setDisplayPath(String displayPath) {
    this.displayPath = displayPath;
  }

  public String getSeoPath() {
    return seoPath;
  }

  public void setSeoPath(String seoPath) {
    this.seoPath = seoPath;
  }
}
