package hctest.model.domain;

import java.io.Serializable;

/**
 * empik.com, smyk.pl, ...
 * 
 * @author bart
  */
public class Catalog implements Serializable, Comparable<Catalog> {

  /**
   * Zwiększyć o jeden, gdy następuje zmiana dotycząca trwałych właściwości obiektu (takich, które nie są Transient).
   * Po zmianie trzeba zadbać o to, by wszystkie projekty, które maja w zależnościach product-catalog-api posługiwały się nowszą wersją product-catalog-api.
   */
  private static final long serialVersionUID = 1L;

  public static final Catalog DEFAULT_CATALOG = new Catalog(-1,"DEFAULT_CATALOG",null);
  
	private int    idCatalog;
	private String name;
	private Integer pricingId;
	
	
	public Catalog() {
  }

  public Catalog(int idCatalog, String name, Integer pricingId) {
    this.idCatalog = idCatalog;
    this.name = name;
    this.pricingId = pricingId;
  }

  public boolean isDefault() {
    return this == DEFAULT_CATALOG;
  }
  
	public int getIdCatalog() {
		return idCatalog;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
	  return "Shop: "+name;
	}
	
	public Integer getPricingId() {
    return pricingId;
  }

  @Override
  public int compareTo(Catalog o) {
    if (o == null) return 1;

    if ( this.getIdCatalog() == o.getIdCatalog() ) {
      return 0;
    }
    if ( this.getIdCatalog() >  o.getIdCatalog() ) {
      return 1;
    }

    return -1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Catalog))
      return false;

    Catalog catalog = (Catalog) o;

    if (idCatalog != catalog.idCatalog)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    return idCatalog;
  }

  //-- setters

	public void setName(String name) {
		this.name = name;
	}

	public void setIdCatalog(int idCatalog) {
		this.idCatalog = idCatalog;
	}
	
	public void setPricingId(Integer pricingId) {
    this.pricingId = pricingId;
  }

}
