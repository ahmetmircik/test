package hctest.model.domain;

import hctest.model.domain.common.EmbededValue;
import hctest.model.domain.utils.DateUtil;
import org.apache.commons.lang.builder.CompareToBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * for object construction purposes please use: {@link AvailabilityBuilder}
 */
public class Availability implements Serializable, EmbededValue {

  /**
   * Zwiększyć o jeden, gdy następuje zmiana dotycząca trwałych właściwości obiektu (takich, które nie są Transient).
   * Po zmianie trzeba zadbać o to, by wszystkie projekty, które maja w zależnościach product-catalog-api posługiwały się nowszą wersją product-catalog-api.
   */
  private static final long serialVersionUID = 1L;

  protected Integer availabilityFrom;
  protected Integer availabilityTo;
  protected Date datePremieres;
  protected OrderableCode orderableCode;
  protected StockAvailability stockAvailability;

  protected void setAvailabilityFrom(Integer availabilityFrom) {
    this.availabilityFrom = availabilityFrom;
  }

  protected void setAvailabilityTo(Integer availabilityTo) {
    this.availabilityTo = availabilityTo;
  }

  protected void setDatePremieres(Date datePremieres) {
    this.datePremieres = datePremieres;
  }

  protected void setOrderableCode(OrderableCode orderableCode) {
    this.orderableCode = orderableCode;
  }

  protected void setStockAvailability(StockAvailability stockAvailability) {
    this.stockAvailability = stockAvailability;
  }

  public Integer getAvailabilityFrom() {
    return availabilityFrom;
  }

  public Integer getAvailabilityTo() {
    return availabilityTo;
  }

  public Date getDatePremieres() {
    return datePremieres;
  }

  public OrderableCode getOrderableCode() {
    return orderableCode;
  }

  public StockAvailability getStockAvailability() {
    return stockAvailability;
  }

  @Override
  public boolean equals(Object o) {

    if (o == null || !(o instanceof Availability))
      return false;

    return equalsValue((EmbededValue) o);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((availabilityFrom == null) ? 0 : availabilityFrom.hashCode());
    result = prime * result + ((availabilityTo == null) ? 0 : availabilityTo.hashCode());
    result = prime * result + ((datePremieres == null) ? 0 : datePremieres.hashCode());
    result = prime * result + ((orderableCode == null) ? 0 : orderableCode.hashCode());
    return result;
  }

  @Override
  public boolean equalsValue(EmbededValue obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Availability)) {
      return false;
    }

    Availability value = (Availability) obj;

    return new CompareToBuilder()
        .append(availabilityFrom, value.availabilityFrom)
        .append(availabilityTo, value.availabilityTo)
        .append(datePremieres, value.datePremieres)
        .append(orderableCode, value.orderableCode)
        .append(stockAvailability, value.stockAvailability)
        .toComparison() == 0;
  }

  @Override
  public String toString() {
    return "Availability [availabilityFrom=" + availabilityFrom + ", availabilityTo=" + availabilityTo
        + ", datePremieres=" + DateUtil.format(datePremieres) + ", orderable=" + orderableCode + ", stockAvailability="+stockAvailability+"]";
  }

}