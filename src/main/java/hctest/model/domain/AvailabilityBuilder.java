package hctest.model.domain;

import hctest.model.domain.utils.DateUtil;

import java.util.Date;

/**
 * replaces complex class constructor
 */
public class AvailabilityBuilder {
  private OrderableCode orderableCode;
  private Integer availabilityFrom;
  private Integer availabilityTo;
  private Date datePremieres;
  private StockAvailability stockAvailability;

  public AvailabilityBuilder setStockAvailability(StockAvailability stockAvailability) {
    this.stockAvailability = stockAvailability;
    return this;
  }

  public AvailabilityBuilder setOrderableCode(OrderableCode orderableCode) {
    this.orderableCode = orderableCode;
    return this;
  }

  public AvailabilityBuilder setAvailabilityFrom(Integer availabilityFrom) {
    this.availabilityFrom = availabilityFrom;
    return this;
  }

  public AvailabilityBuilder setAvailabilityTo(Integer availabilityTo) {
    this.availabilityTo = availabilityTo;
    return this;
  }

  public AvailabilityBuilder setDatePremieres(Date datePremieres) {
    this.datePremieres = datePremieres;
    return this;
  }

  public Availability createAvailability() {
    Availability availability = new Availability();
    availability.setOrderableCode(orderableCode);
    availability.setAvailabilityFrom(availabilityFrom);
    availability.setAvailabilityTo(availabilityTo);
    Date datePremieres = this.datePremieres == null ? null : DateUtil.truncToSec(this.datePremieres);
    availability.setDatePremieres(datePremieres);
    availability.setStockAvailability(stockAvailability);
    return availability;
  }
}