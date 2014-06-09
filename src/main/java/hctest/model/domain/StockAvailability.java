package hctest.model.domain;

/**
 * User: artur
 * Date: 6/24/13 10:50 AM
 * Indicates how the product is available
 */
public enum StockAvailability {

  /**
   * available - there is a product on the stock
   */
  ON_STOCK,
  /**
   * not available - the product isn't on the stock...
   */
  NOT_ON_STOCK;
}
