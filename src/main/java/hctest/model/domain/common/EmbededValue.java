package hctest.model.domain.common;

/**
 * @author bwalacik
 */
public interface EmbededValue {
  
  /**
   * Implementacja powinna porównywać po wszystkich persystentnych propertisach z wyj. @Id
   */
  public boolean equalsValue(EmbededValue someValue);
}
