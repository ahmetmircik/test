package hctest.model.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.*;

@Deprecated
public enum ProductAvailability {

  AVAILABILITY_101(101, true),
  AVAILABILITY_102(102, true),
  AVAILABILITY_103(103, true),
  AVAILABILITY_104(104, true),
  AVAILABILITY_108(108, true),
  AVAILABILITY_110(110, true),
  AVAILABILITY_115(115, true),
  AVAILABILITY_120(120, true),
  AVAILABILITY_121(121, true),
  AVAILABILITY_122(122, true),
  AVAILABILITY_123(123, true),
  AVAILABILITY_124(124, true),
  AVAILABILITY_125(125, true),
  AVAILABILITY_126(126, true),
  AVAILABILITY_201(201, true),
  AVAILABILITY_202(202, false),
  AVAILABILITY_203(203, true),
  AVAILABILITY_21(21, true),
  AVAILABILITY_22(22, true),
  AVAILABILITY_301(301, false);

  Integer code;
  boolean available;

  private ProductAvailability(Integer code, boolean available) {
    this.code = code;
    this.available = available;
  }

  public final static Map<AvailabilityPair, Integer> distance = new HashMap<AvailabilityPair, Integer>();

  static {
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_203), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_101), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_103), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_120), 3);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_102), 4);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_104), 4);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_121), 5);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_122), 6);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_108), 7);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_110), 8);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_123), 9);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_124), 10);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_115), 11);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_125), 12);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_126), 13);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_201), 14);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_21), 15);
    distance.put(new AvailabilityPair(AVAILABILITY_203, AVAILABILITY_22), 15);


    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_101), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_103), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_120), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_102), 3);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_104), 3);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_121), 4);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_122), 5);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_108), 6);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_110), 7);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_123), 8);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_124), 9);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_115), 10);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_125), 11);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_126), 12);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_201), 13);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_21), 14);
    distance.put(new AvailabilityPair(AVAILABILITY_101, AVAILABILITY_22), 15);

    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_103), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_120), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_102), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_104), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_121), 3);
    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_122), 4);
    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_108), 5);
    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_110), 6);
    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_123), 7);
    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_124), 8);
    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_115), 9);
    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_125), 10);
    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_126), 11);
    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_201), 12);
    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_21), 13);
    distance.put(new AvailabilityPair(AVAILABILITY_103, AVAILABILITY_22), 14);

    distance.put(new AvailabilityPair(AVAILABILITY_120, AVAILABILITY_120), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_120, AVAILABILITY_102), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_120, AVAILABILITY_104), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_120, AVAILABILITY_121), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_120, AVAILABILITY_122), 3);
    distance.put(new AvailabilityPair(AVAILABILITY_120, AVAILABILITY_108), 4);
    distance.put(new AvailabilityPair(AVAILABILITY_120, AVAILABILITY_110), 5);
    distance.put(new AvailabilityPair(AVAILABILITY_120, AVAILABILITY_123), 6);
    distance.put(new AvailabilityPair(AVAILABILITY_120, AVAILABILITY_124), 7);
    distance.put(new AvailabilityPair(AVAILABILITY_120, AVAILABILITY_115), 8);
    distance.put(new AvailabilityPair(AVAILABILITY_120, AVAILABILITY_125), 9);
    distance.put(new AvailabilityPair(AVAILABILITY_120, AVAILABILITY_126), 10);
    distance.put(new AvailabilityPair(AVAILABILITY_120, AVAILABILITY_201), 11);
    distance.put(new AvailabilityPair(AVAILABILITY_120, AVAILABILITY_21), 12);
    distance.put(new AvailabilityPair(AVAILABILITY_120, AVAILABILITY_22), 13);

    distance.put(new AvailabilityPair(AVAILABILITY_102, AVAILABILITY_102), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_102, AVAILABILITY_104), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_102, AVAILABILITY_121), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_102, AVAILABILITY_122), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_102, AVAILABILITY_108), 3);
    distance.put(new AvailabilityPair(AVAILABILITY_102, AVAILABILITY_110), 4);
    distance.put(new AvailabilityPair(AVAILABILITY_102, AVAILABILITY_123), 5);
    distance.put(new AvailabilityPair(AVAILABILITY_102, AVAILABILITY_124), 6);
    distance.put(new AvailabilityPair(AVAILABILITY_102, AVAILABILITY_115), 7);
    distance.put(new AvailabilityPair(AVAILABILITY_102, AVAILABILITY_125), 8);
    distance.put(new AvailabilityPair(AVAILABILITY_102, AVAILABILITY_126), 9);
    distance.put(new AvailabilityPair(AVAILABILITY_102, AVAILABILITY_201), 10);
    distance.put(new AvailabilityPair(AVAILABILITY_102, AVAILABILITY_21), 11);
    distance.put(new AvailabilityPair(AVAILABILITY_102, AVAILABILITY_22), 12);

    distance.put(new AvailabilityPair(AVAILABILITY_104, AVAILABILITY_104), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_104, AVAILABILITY_121), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_104, AVAILABILITY_122), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_104, AVAILABILITY_108), 3);
    distance.put(new AvailabilityPair(AVAILABILITY_104, AVAILABILITY_110), 4);
    distance.put(new AvailabilityPair(AVAILABILITY_104, AVAILABILITY_123), 5);
    distance.put(new AvailabilityPair(AVAILABILITY_104, AVAILABILITY_124), 6);
    distance.put(new AvailabilityPair(AVAILABILITY_104, AVAILABILITY_115), 7);
    distance.put(new AvailabilityPair(AVAILABILITY_104, AVAILABILITY_125), 8);
    distance.put(new AvailabilityPair(AVAILABILITY_104, AVAILABILITY_126), 9);
    distance.put(new AvailabilityPair(AVAILABILITY_104, AVAILABILITY_201), 10);
    distance.put(new AvailabilityPair(AVAILABILITY_104, AVAILABILITY_21), 11);
    distance.put(new AvailabilityPair(AVAILABILITY_104, AVAILABILITY_22), 12);

    distance.put(new AvailabilityPair(AVAILABILITY_121, AVAILABILITY_121), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_121, AVAILABILITY_122), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_121, AVAILABILITY_108), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_121, AVAILABILITY_110), 3);
    distance.put(new AvailabilityPair(AVAILABILITY_121, AVAILABILITY_123), 4);
    distance.put(new AvailabilityPair(AVAILABILITY_121, AVAILABILITY_124), 5);
    distance.put(new AvailabilityPair(AVAILABILITY_121, AVAILABILITY_115), 6);
    distance.put(new AvailabilityPair(AVAILABILITY_121, AVAILABILITY_125), 7);
    distance.put(new AvailabilityPair(AVAILABILITY_121, AVAILABILITY_126), 8);
    distance.put(new AvailabilityPair(AVAILABILITY_121, AVAILABILITY_201), 9);
    distance.put(new AvailabilityPair(AVAILABILITY_121, AVAILABILITY_21), 10);
    distance.put(new AvailabilityPair(AVAILABILITY_121, AVAILABILITY_22), 11);

    distance.put(new AvailabilityPair(AVAILABILITY_122, AVAILABILITY_122), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_122, AVAILABILITY_108), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_122, AVAILABILITY_110), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_122, AVAILABILITY_123), 3);
    distance.put(new AvailabilityPair(AVAILABILITY_122, AVAILABILITY_124), 4);
    distance.put(new AvailabilityPair(AVAILABILITY_122, AVAILABILITY_115), 5);
    distance.put(new AvailabilityPair(AVAILABILITY_122, AVAILABILITY_125), 6);
    distance.put(new AvailabilityPair(AVAILABILITY_122, AVAILABILITY_126), 7);
    distance.put(new AvailabilityPair(AVAILABILITY_122, AVAILABILITY_201), 8);
    distance.put(new AvailabilityPair(AVAILABILITY_122, AVAILABILITY_21), 9);
    distance.put(new AvailabilityPair(AVAILABILITY_122, AVAILABILITY_22), 10);

    distance.put(new AvailabilityPair(AVAILABILITY_108, AVAILABILITY_108), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_108, AVAILABILITY_110), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_108, AVAILABILITY_123), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_108, AVAILABILITY_124), 3);
    distance.put(new AvailabilityPair(AVAILABILITY_108, AVAILABILITY_115), 4);
    distance.put(new AvailabilityPair(AVAILABILITY_108, AVAILABILITY_125), 5);
    distance.put(new AvailabilityPair(AVAILABILITY_108, AVAILABILITY_126), 6);
    distance.put(new AvailabilityPair(AVAILABILITY_108, AVAILABILITY_201), 7);
    distance.put(new AvailabilityPair(AVAILABILITY_108, AVAILABILITY_21), 8);
    distance.put(new AvailabilityPair(AVAILABILITY_108, AVAILABILITY_22), 9);

    distance.put(new AvailabilityPair(AVAILABILITY_110, AVAILABILITY_110), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_110, AVAILABILITY_123), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_110, AVAILABILITY_124), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_110, AVAILABILITY_115), 3);
    distance.put(new AvailabilityPair(AVAILABILITY_110, AVAILABILITY_125), 4);
    distance.put(new AvailabilityPair(AVAILABILITY_110, AVAILABILITY_126), 5);
    distance.put(new AvailabilityPair(AVAILABILITY_110, AVAILABILITY_201), 6);
    distance.put(new AvailabilityPair(AVAILABILITY_110, AVAILABILITY_21), 7);
    distance.put(new AvailabilityPair(AVAILABILITY_110, AVAILABILITY_22), 8);

    distance.put(new AvailabilityPair(AVAILABILITY_123, AVAILABILITY_123), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_123, AVAILABILITY_124), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_123, AVAILABILITY_115), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_123, AVAILABILITY_125), 3);
    distance.put(new AvailabilityPair(AVAILABILITY_123, AVAILABILITY_126), 4);
    distance.put(new AvailabilityPair(AVAILABILITY_123, AVAILABILITY_201), 5);
    distance.put(new AvailabilityPair(AVAILABILITY_123, AVAILABILITY_21), 6);
    distance.put(new AvailabilityPair(AVAILABILITY_123, AVAILABILITY_22), 7);

    distance.put(new AvailabilityPair(AVAILABILITY_124, AVAILABILITY_124), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_124, AVAILABILITY_115), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_124, AVAILABILITY_125), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_124, AVAILABILITY_126), 3);
    distance.put(new AvailabilityPair(AVAILABILITY_124, AVAILABILITY_201), 4);
    distance.put(new AvailabilityPair(AVAILABILITY_124, AVAILABILITY_21), 5);
    distance.put(new AvailabilityPair(AVAILABILITY_124, AVAILABILITY_22), 6);

    distance.put(new AvailabilityPair(AVAILABILITY_115, AVAILABILITY_115), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_115, AVAILABILITY_125), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_115, AVAILABILITY_126), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_115, AVAILABILITY_201), 3);
    distance.put(new AvailabilityPair(AVAILABILITY_115, AVAILABILITY_21), 4);
    distance.put(new AvailabilityPair(AVAILABILITY_115, AVAILABILITY_22), 5);

    distance.put(new AvailabilityPair(AVAILABILITY_125, AVAILABILITY_125), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_125, AVAILABILITY_126), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_125, AVAILABILITY_201), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_125, AVAILABILITY_21), 3);
    distance.put(new AvailabilityPair(AVAILABILITY_125, AVAILABILITY_22), 4);

    distance.put(new AvailabilityPair(AVAILABILITY_126, AVAILABILITY_126), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_126, AVAILABILITY_201), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_126, AVAILABILITY_21), 2);
    distance.put(new AvailabilityPair(AVAILABILITY_126, AVAILABILITY_22), 3);

    distance.put(new AvailabilityPair(AVAILABILITY_201, AVAILABILITY_201), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_201, AVAILABILITY_21), 1);
    distance.put(new AvailabilityPair(AVAILABILITY_201, AVAILABILITY_22), 2);

    distance.put(new AvailabilityPair(AVAILABILITY_21, AVAILABILITY_21), 0);
    distance.put(new AvailabilityPair(AVAILABILITY_21, AVAILABILITY_22), 1);

    distance.put(new AvailabilityPair(AVAILABILITY_22, AVAILABILITY_22), 0);
  }

  public static class AvailabilityPair {
    public AvailabilityPair(ProductAvailability x, ProductAvailability y) {
      super();
      this.x = x;
      this.y = y;
    }

    private ProductAvailability x;
    private ProductAvailability y;

    @Override
    public int hashCode() {
      return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
      return EqualsBuilder.reflectionEquals(this, obj);
    }
  }

  public static class DistanceAvailabilityComparator implements Comparator<ProductAvailability> {
    private static final int MAX_DISTANCE = 100;
    private ProductAvailability referenceAvailability;

    public DistanceAvailabilityComparator(ProductAvailability referenceAvailability) {
      this.referenceAvailability = referenceAvailability;
    }

    @Override
    public int compare(ProductAvailability o1, ProductAvailability o2) {
      Integer d1 = getDistance(referenceAvailability, o1);
      Integer d2 = getDistance(referenceAvailability, o2);
      return d1.compareTo(d2);
    }

    private int getDistance(ProductAvailability pa1, ProductAvailability pa2) {
      Integer dist = distance.get(new AvailabilityPair(pa1, pa2));
      if (dist != null) {
        return dist;
      }
      dist = distance.get(new AvailabilityPair(pa2, pa1));
      if (dist != null) {
        return dist;
      }
      return MAX_DISTANCE;
    }

  }

  public static class AvailabilityComparator implements Comparator<ProductAvailability> {

    @Override
    public int compare(ProductAvailability o1, ProductAvailability o2) {

      if ((o1 == o2) || (o1 == AVAILABILITY_102 && o2 == AVAILABILITY_104) || (o2 == AVAILABILITY_102 && o1 == AVAILABILITY_104)) {
        return 0;
      }

      if (o1 == AVAILABILITY_21 && o2 != AVAILABILITY_301) {
        return 1;
      }
      if (o2 == AVAILABILITY_21 && o1 != AVAILABILITY_301) {
        return -1;
      }

      if (o1 == AVAILABILITY_102 && o2 == AVAILABILITY_103) {
        return 1;
      }
      if (o1 == AVAILABILITY_103 && o2 == AVAILABILITY_102) {
        return -1;
      }

      /** hak - kod 203 (wysylamy natychmiast) jest przed 21 (przedsprzedaz) dlatego
       *  do porownania w ustalaniu kolejnosci // podstwiona jest wartosc 22
       */
      Integer cmpValue1 = o1.getCode();
      Integer cmpValue2 = o2.getCode();
      if (cmpValue1.equals(AVAILABILITY_203.getCode())) {
        cmpValue1 = 22;
      }
      if (cmpValue2.equals(AVAILABILITY_203.getCode())) {
        cmpValue2 = 22;
      }

      return cmpValue1 - cmpValue2;
    }

  }

  private static final HashMap<Integer, ProductAvailability> lookup = new HashMap<Integer, ProductAvailability>();

  static {
    for (ProductAvailability pa : EnumSet.allOf(ProductAvailability.class))
      lookup.put(pa.code, pa);
  }

  public static ProductAvailability valueOf(Integer availabilityCode) {
    ProductAvailability productAvailability = lookup.get(availabilityCode);
    if (productAvailability == null) {
      throw new IllegalArgumentException("no product availability for code: " + availabilityCode);
    }
    return productAvailability;
  }

  public static boolean isAvailable(Integer availabilityCode) {
    try {
      return valueOf(availabilityCode).isAvailable();
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  public Integer getCode() {
    return code;
  }

  public boolean isAvailable() {
    return available;
  }

  /**
   * Konwertuje set do stringa nadajacego sie w selectie do bazy, np:
   * ('301','101')
   */
  public static String toDbString(EnumSet<ProductAvailability> availabilities) {
    Iterator<ProductAvailability> iterator = availabilities.iterator();

    StringBuilder result = new StringBuilder();
    result.append("(");

    for (; ; ) {
      ProductAvailability e = iterator.next();
      result.append("'").append(e.getCode()).append("'");
      if (!iterator.hasNext())
        return result.append(")").toString();
      result.append(", ");
    }

  }
}
