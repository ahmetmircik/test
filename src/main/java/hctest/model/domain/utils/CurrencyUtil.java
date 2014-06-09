package hctest.model.domain.utils;

import java.math.BigDecimal;

public class CurrencyUtil {
  
  /**
   * if bigDecimal.scale != 2, returns new bigDecimal with scale = 2
   */
  public static BigDecimal setCurrencyScale(BigDecimal bigDecimal) {
    int scale = 2;
    if (bigDecimal == null)
      return null;
    
    if (bigDecimal.scale() != scale)
      return bigDecimal.setScale(scale);
    else       
      return bigDecimal;
  }
}
