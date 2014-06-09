package hctest.model.domain;

import hctest.model.domain.utils.DateUtil;
import org.apache.commons.lang.builder.EqualsBuilder;

import java.io.Serializable;
import java.util.Date;

public class ValidRange implements Serializable {

  /**
   * Zwiększyć o jeden, gdy następuje zmiana dotycząca trwałych właściwości obiektu (takich, które nie są Transient).
   * Po zmianie trzeba zadbać o to, by wszystkie projekty, które maja w zależnościach product-catalog-api posługiwały się nowszą wersją product-catalog-api.
   */
  private static final long serialVersionUID = 1L;

  private Date validFrom;
  private Date validTo;

  public ValidRange(Date validFrom, Date validTo) {
    this.validFrom = DateUtil.truncToSec(validFrom);
    this.validTo = DateUtil.truncToSec(validTo);
  }

  private ValidRange(){

  }

  public Date getValidFrom() {
    return validFrom;
  }

  public Date getValidTo() {
    return validTo;
  }

  @Override
  public String toString() {
    return "[validRange] : " + DateUtil.format(getValidFrom()) + " - " + DateUtil.format(getValidTo());
  }  
  
  @Override
  public boolean equals(Object obj) {
    if (obj == null)  return false; 
    if (obj == this)  return true;
    
    if (! (obj instanceof ValidRange) ) 
      return false;  
    
    ValidRange value = (ValidRange)obj;
    
    return new EqualsBuilder()
                  .append(getValidFrom(),   value.getValidFrom())
                  .append(getValidTo(),     value.getValidTo())                  
                  .isEquals();
  }
  
  public boolean inRange(Date date) {
    if (date == null) 
      return false;
    
    if (getValidFrom() != null) {
      if (getValidFrom().after(date))
        return false;
    }
    
    if (getValidTo() != null) {
      if (getValidTo().before(date))
        return false;
    }
      
    return true;
  }

  public Date nearestChangeDateFrom(Date date) {
    if(dateNotSetOrAfter(validFrom, date)) {
      if(dateNotSetOrAfter(validTo, date)) {
        return null;
      }
      return validTo;
    }
    return validFrom;
  }

  public boolean dateNotSetOrAfter(Date dateToCheck, Date date) {
    return dateToCheck == null || date.after(dateToCheck);
  }
}
