package hctest.model.domain;

import java.util.Collection;

import hctest.model.domain.CartType;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;

public enum CartType {
  C1(1), C2(2);
  private final int number;

  private CartType(int number) {
    this.number = number;
  }

  public static CartType valueOf(int cartNumber) {
    for (CartType cartType : values()) {
      if (cartType.number == cartNumber)
        return cartType;
    }
    throw new IllegalArgumentException("Problem z ustaleniem koszyka dla " + cartNumber);
  }

  public int getNumber() {
    return number;
  }

  public static Collection<Integer> toNumbers(Collection<CartType> cartTypes) {
    return Collections2.transform(cartTypes, new Function<CartType, Integer>() {

      @Override
      public Integer apply(CartType arg0) {
        return arg0.getNumber();
      }

    });
  }
}
