package hctest.model.domain;

import hctest.model.domain.ProductState;

public enum ProductState {
  
  Invalid(1), Valid(2), ValidDataWithWeakQuality(3), AutoInvisible(4);
  
  private Integer code;
  
  private ProductState(int code) {
    this.code = code;
  }

  public static ProductState fromCode(Integer code) {
    for(ProductState state : ProductState.values()) {
      if(state.code().equals(code)) {
        return state;
      }
    }
    return null;
  }

  public Integer code() {
    return code;
  }

}
