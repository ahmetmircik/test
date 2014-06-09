package hctest.model.domain;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import hctest.model.domain.OrderableCode;

public enum OrderableCode {

  UNAVAILABLE(0, false), IN_STOCK(1, true), ADVANCE_SALE(2, true), IMMEDIATELY_AVAILABLE(3, true), RE_SALE(4, true);

  private static final Map<Integer, OrderableCode> lookup = new HashMap<Integer, OrderableCode>();

  static {
    for (OrderableCode s : EnumSet.allOf(OrderableCode.class))
      lookup.put(s.getCode(), s);
  }

  private int orderableCode;
  private boolean isAvailable;

  OrderableCode(Integer orderableCode, boolean isAvailable) {
    this.orderableCode = orderableCode;
    this.isAvailable = isAvailable;
  }

  public int getCode() {
    return orderableCode;
  }

  public static OrderableCode getOrderableCode(int code) {
    return lookup.get(code);
  }

  public boolean isAvailable() {
    return isAvailable;
  }
}
