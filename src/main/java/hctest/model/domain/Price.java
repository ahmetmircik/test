package hctest.model.domain;

import hctest.model.domain.common.EmbededValue;
import hctest.model.domain.utils.CurrencyUtil;
import org.apache.commons.lang.builder.EqualsBuilder;

import java.io.Serializable;
import java.math.BigDecimal;

public class Price implements Serializable, EmbededValue {

  /**
   * Zwiększyć o jeden, gdy następuje zmiana dotycząca trwałych właściwości obiektu (takich, które nie są Transient).
   * Po zmianie trzeba zadbać o to, by wszystkie projekty, które maja w zależnościach product-catalog-api posługiwały się nowszą wersją product-catalog-api.
   */
  private static final long serialVersionUID = 1L;
  
  protected BigDecimal basePrice;
  protected BigDecimal salePrice;
  protected Integer vatCode;

  public Price(BigDecimal basePrice, BigDecimal salePrice, Integer vatCode) {
    this.basePrice = CurrencyUtil.setCurrencyScale(basePrice);
    this.salePrice = CurrencyUtil.setCurrencyScale(salePrice);
    this.vatCode = vatCode;
  }

  private Price(){

  }
  
  public BigDecimal getBasePrice() {
    return basePrice;
  }

  public BigDecimal getSalePrice() {
    return salePrice;
  }

  public Integer getVatCode() {
    return vatCode;
  }
  
  public BigDecimal getMarketPrice() {
    if (basePrice == null) {
      return salePrice;
    }

    return (salePrice.compareTo(basePrice) > 0) ? salePrice : basePrice;
  }

  @Override
  public boolean equals(Object o) {
   
    if(o == null || !(o instanceof Price))
      return false;
    
    return equalsValue((EmbededValue)o); 
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((basePrice == null) ? 0 : basePrice.hashCode());
    result = prime * result + ((salePrice == null) ? 0 : salePrice.hashCode());
    result = prime * result + ((vatCode == null) ? 0 : vatCode.hashCode());
    return result;
  }
  
  @Override
  public boolean equalsValue(EmbededValue obj) {
    if (obj == null) { return false; }
    if (obj == this) { return true; }
    if (! (obj instanceof Price) ) { return false; } 
    
    Price value = (Price)obj;
    
    return new EqualsBuilder()
                  .append(basePrice,     value.basePrice)
                  .append(salePrice,     value.salePrice)
                  .append(vatCode,       value.vatCode)                 
                  .isEquals();
  }
  
  @Override
  public String toString() {
    return "Price [basePrice=" + basePrice + ", salePrice=" + salePrice
        + ", vatCode=" + vatCode + "]";
  }
  
}