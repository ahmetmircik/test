package hctest.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static hctest.model.domain.AttributeConsts.ATTR_AVAILABILITY;
import static hctest.model.domain.AttributeConsts.ATTR_EDITION_DATE;
import static hctest.model.domain.AttributeConsts.ATTR_LICENSE_COUNTRIES_CODES;
import static hctest.model.domain.AttributeConsts.ATTR_PRICE;
import static hctest.model.domain.AttributeConsts.ATTR_RATE_COUNT;
import static hctest.model.domain.AttributeConsts.ATTR_RATE_SCORE_SUM;
import static hctest.model.domain.AttributeConsts.ATTR_RESALE_DATE;
import static hctest.model.domain.AttributeConsts.ATTR_SALE_DATE;
import static hctest.model.domain.AttributeConsts.ATTR_TARGET_AVAILABILITY;
import static hctest.model.domain.AttributeConsts.ATTR_VISIBLE;
import static hctest.model.domain.AttributeConsts.ATT_ALBUM_OR_TRACK;
import static hctest.model.domain.AttributeConsts.ATT_DISPLAY_NAME;
import static hctest.model.domain.AttributeConsts.ATT_FORMATS_MAP;
import static hctest.model.domain.AttributeConsts.ATT_IMAGE1_PATH;
import static hctest.model.domain.AttributeConsts.ATT_ISBN_MAP;
import static hctest.model.domain.AttributeConsts.ATT_TYPE;
import static hctest.model.domain.AttributeValues.ALBUM_OR_TRACK_VALUE_ALBUM;
import static hctest.model.domain.AttributeValues.ALBUM_OR_TRACK_VALUE_TRACK;
import static hctest.model.domain.AttributeValues.ALBUM_OR_TRACK_VALUE_TRACK_OLD;

public class Product implements Serializable {

  /**
   * Zwiększyć o jeden, gdy następuje zmiana dotycząca trwałych właściwości
   * obiektu (takich, które nie są Transient). Po zmianie trzeba zadbać o to, by
   * wszystkie projekty, które maja w zależnościach product-catalog-api
   * posługiwały się nowszą wersją product-catalog-api.
   */
  private static final long serialVersionUID = 2L;

  private static final String FOREIGN_CATEGORY_PREFIX = "20";

  public static final String SEP = ", ";

  private Catalog catalogContext;

  protected String id;

  protected long catalogVersion;

  protected String goldId;

  protected String mdmIndex;

  protected Map<String, Attribute> attributes = new HashMap<String, Attribute>();

  protected Set<Catalog> catalogs = new HashSet<Catalog>();

  /**
   * Transient, see {@link #getAvailabilityCode()}
   */
  protected Integer availabilityCode;

  private boolean stockLevelsCheckEnabledForCategory;

  public Product() {
  }

  public Product(String id, long catalogVersion, String goldId, String mdmIndex) {
    this(id, mdmIndex, goldId);
    this.catalogVersion = catalogVersion;
  }

  public Product(String id, String mdmindex, String goldId) {
    this.id = id;
    this.goldId = goldId;
    this.mdmIndex = mdmindex;
  }

  /**
   * Główny klucz biznesowy - identyfikator produktu używany przez cache. <br/>
   * Pole <b>productId</b> w starym modelu
   */
  public String getId() {
    return id;
  }

  public String getGoldId() {
    return goldId;
  }

  public String getMdmIndex() {
    return mdmIndex;
  }

  public long getCatalogVersion() {
    return catalogVersion;
  }

  // -- transient

  // -- gettery ulatwiające wyciąganie dobrze znanych atrybutow z hashMapy
  // -----------------------

  public Set<Catalog> calculateAllCatalogWithValuesForAttributeSkipDefaultCatalog(String attributeName) {
    final Attribute attribute = getAttribute(attributeName);
    final Set<Catalog> attributeCatalogs = new HashSet<Catalog>();
    if (attribute != null) {
      attributeCatalogs.addAll(attribute.getCatalogContexts());
    }
    if (attributeCatalogs.remove(Catalog.DEFAULT_CATALOG)) {
      attributeCatalogs.addAll(catalogs);
    }
    return attributeCatalogs;
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public Date getLastAvailabilityChangeDate() {
    return getAttributeValue(AttributeConsts.ATTR_LAST_AVAILABILITY_CHANGE_DATE, Date.class);
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public boolean isAutovisible() {
    Boolean autovisible = getAttributeValue(AttributeConsts.ATTR_AUTO_VISIBILITY, Boolean.class);
    if (autovisible == null) {
      return true;
    }
    return autovisible;
  }

  public boolean isAutoavailable() {
    return !Boolean.FALSE.equals(getAttributeValue(AttributeConsts.ATT_AUTO_AVAILABILITY_ENABLED, Boolean.class));
  }


  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public String getLongDescription() {
    return getAttributeValue(AttributeConsts.ATT_LONG_DESCRIPTION, String.class);
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public boolean isEventualyVisible() {
    Boolean eventualyVisible = (Boolean) getAttributeValue(AttributeConsts.ATTR_TARGET_VISIBILITY);
    if (eventualyVisible == null) {
      return true;
    }
    return eventualyVisible;
  }

  public boolean isConcept() {
    // FIXME: Podobne sprawdzenie jest w komendzie!
    return Boolean.TRUE.equals(getAttributeValue(AttributeConsts.ATT_CONCEPT));
  }

  public boolean isLicenceBlocked() {
    return Boolean.TRUE.equals(getAttributeValue(AttributeConsts.ATTR_LICENCE_BLOCKED));
  }

  @SuppressWarnings("unchecked")
  public List<String> getVariantsIds() {
    return getAttributeValue(AttributeConsts.ATT_CONCEPT_VARIANTS, List.class, new ArrayList<String>());
  }

  @SuppressWarnings("unchecked")
  public List<String> getVariantsMdmIndexes() {
    return getAttributeValue(AttributeConsts.ATT_CONCEPT_VARIANTS_MDMINDEXES, List.class, new ArrayList<String>());
  }

  public boolean isVariant() {
    if (!attributes.containsKey(AttributeConsts.ATT_PARENT_CONCEPT)) {
      return false;
    }
    return hasValuesForConceptAttributes();
  }

  private boolean hasValuesForConceptAttributes() {
    List<String> conceptAttributesNames = getConceptAttributesNames();
    if (conceptAttributesNames.isEmpty()) {
      return false;
    }
    for (String attributeName : conceptAttributesNames) {
      if (getAttributeValue(attributeName) == null) {
        return false;
      }
    }
    return true;
  }

  public String getConceptId() {
    return getAttributeValueAsString(AttributeConsts.ATT_PARENT_CONCEPT);
  }

  @SuppressWarnings("unchecked")
  public List<String> getConceptAttributesNames() {
    if (isConcept()) {
      return getAttributeValue(AttributeConsts.ATT_CONCEPT_ATTRIBUTES_NAMES, List.class, new ArrayList<String>());
    }
    return getAttributeValue(AttributeConsts.ATT_PARENT_CONCEPT_ATTRIBUTES_NAMES, List.class, new ArrayList<String>());
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public ProductState getState() {
    return (ProductState) getAttributeValue(AttributeConsts.ATTR_PRODUCT_STATE);
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public Category getMainCategory() {
    return getAttributeValue(AttributeConsts.ATTR_MAIN_CATEGORY, Category.class);
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public Integer getType() {
    return getAttributeValue(ATT_TYPE, Integer.class);
  }




  public boolean isExclusivenessProgram() {
    return Boolean.TRUE.equals(getAttributeValue(AttributeConsts.ATT_EXCLUSIVENESS));
  }





  /**
   * Jeśli nie ma atrybutu - zwraca 0,
   *
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public Integer getRateCount() {
    return nullValueReplace(getAttributeValue(ATTR_RATE_COUNT, Integer.class), 0);
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public Boolean isVisible() {
    if (isMainCategoryHidden()) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE.equals(getAttributeValue(ATTR_VISIBLE, Boolean.class));
  }

  private boolean isMainCategoryHidden() {
    return getMainCategory() != null && getMainCategory().getHidden() != null && getMainCategory().getHidden();
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public String getDisplayName() {
    return getAttributeValue(ATT_DISPLAY_NAME, String.class);
  }

  /**
   * Jeśli nie ma atrybutu - zwraca 0,
   *
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public Integer getRateScoreSum() {
    return nullValueReplace(getAttributeValue(ATTR_RATE_SCORE_SUM, Integer.class), 0);
  }

  public Float getRateScore() {
    if (getRateCount() == null || getRateScoreSum() == null || getRateScoreSum() == 0) {
      return 0f;
    }

    return getRateScoreSum() / (float) getRateCount();
  }

  public Price getPrice() {
    return getAttributeValue(ATTR_PRICE, Price.class);
  }

  public String getUrl() {
    return (String) getAttributeValue(AttributeConsts.ATT_URL);
  }



  /**
   * przeklejone ze starego modelu
   */
  @Deprecated
  public Boolean isForeign() {
    return getCategoryId() != null && getCategoryId().startsWith(FOREIGN_CATEGORY_PREFIX);
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public Availability getTargetAvailability() {
    return getAttributeValue(ATTR_TARGET_AVAILABILITY, Availability.class);
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public Availability getAvailability() {
    return getAttributeValue(ATTR_AVAILABILITY, Availability.class);
  }

  public boolean getOnStock() {
    Availability availability = getAvailability();
    return availability.getStockAvailability() == StockAvailability.ON_STOCK;
  }



  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public boolean isInStock() {
    Availability ava = getAvailability();

    if (ava == null) {
      return false;
    } else {
      return (isVisible() && isAvailable());
    }

  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public boolean isAvailable() {
    Availability availability = getAvailability();
    if (availability == null) {
      return false;
    }
    BigDecimal salePrice = getSalePrice();
    if (salePrice == null || salePrice.compareTo(BigDecimal.ZERO) <= 0) {
      return false;
    }
    return (!availability.getOrderableCode().equals(OrderableCode.UNAVAILABLE));
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public String getCategoryId() {
    final Category mainCategory = getMainCategory();
    if (mainCategory == null) {
      return null;
    }
    return mainCategory.getCatId();
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public String getImage1Path() {
    return getAttributeValue(ATT_IMAGE1_PATH, String.class);
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public String getLicenseCountriesCodes() {
    return getAttributeValue(ATTR_LICENSE_COUNTRIES_CODES, String.class);
  }



  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public BigDecimal getBasePrice() {
    final Price price = getPrice();
    if (price == null) {
      return null;
    }
    return price.getBasePrice();
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public BigDecimal getSalePrice() {
    final Price price = getPrice();
    if (price == null) {
      return null;
    }
    return price.getSalePrice();
  }

  public Date getSaleDate() {
    return getAttributeValue(ATTR_SALE_DATE, Date.class);
  }

  public Date getEditionDate() {

    Date date = getSaleDate();
    if (date != null)
      return date;

    return getAttributeValue(ATTR_EDITION_DATE, Date.class);

  }

  public Date getResaleDate(){
    return getAttributeValue(ATTR_RESALE_DATE, Date.class);
  }

  public Integer getProvider() {

    Integer providerAttribute = getAttributeValue(AttributeConsts.ATT_PROVIDER, Integer.class);
    if (providerAttribute != null && providerAttribute != 0) {
      return providerAttribute;
    }

    DictionaryValue dict = getAttributeValue(AttributeConsts.ATT_MDM_PROVIDER, DictionaryValue.class);
    return dict != null ? Integer.parseInt(dict.getItemCode()) : null;

  }

  // -- EOF gettery ulatwiające wyciąganie dobrze znanych atrybutow z hashMapy
  // -------------------

  /**
   * Jeśli null - generic product, wpp produkt z kontekstowymi propertisami
   */
  public Catalog getCatalogContext() {
    return catalogContext;
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  @SuppressWarnings("unchecked")
  public <T extends Object> T getAttributeValue(String name, Class<T> returnType) {

    // TODO: to chyba można usunąć to bo to niepotrzebne powtarza się w
    // getAttributeValue
    if (!attributes.containsKey(name))
      return null;

    Object val = getAttributeValue(name);

    if (val == null) {
      return null;
    }

    if (returnType.isAssignableFrom(val.getClass()))
      return (T) val;
    else
      throw new IllegalStateException("attribute value class is incompatible, expected:" + returnType.getName() + " , got: " + val.getClass().getName());
  }

  public <T extends Object> T getAttributeValue(String name, Class<T> returnType, T defaultValue) {
    T value = getAttributeValue(name, returnType);
    return value != null ? value : defaultValue;
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public BigDecimal getMarketPrice() {
    final Price price = getPrice();
    if (price == null) {
      return null;
    }

    return price.getMarketPrice();
  }

  // -- EOF gettery ulatwiające wyciąganie dobrze znanych atrybutow z hashMapy
  // -------------------

  /*
   * public void recalculateState(ProductStateResolver stateResolver) {
   * getAttribute(ATTR_PRODUCT_STATE);
   *
   * for(Entry<Catalog, ProductState> resolvedState :
   * stateResolver.resolve(this).entrySet()) { //resolvedState. } if (getPrice()
   * != null && getPrice().getSalePrice() != null) { //state =
   * ProductState.Valid; } }
   */
  @Deprecated
  public boolean isValid() {
    return ProductState.Valid.equals(getState());
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  public Object getAttributeValue(String name) {
    if (!attributes.containsKey(name))
      return null;

    if (getAttribute(name).valueInRange(catalogContext))
      return getAttribute(name).getValue(catalogContext);
    else
      return null;
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  protected Object getAttributeValueWithoutDefault(String name) {
    if (!attributes.containsKey(name))
      return null;

    if (getAttribute(name).valueInRange(catalogContext))
      return getAttribute(name).getCatalogValue(catalogContext);
    else
      return null;
  }

  /**
   * wynik zależy od pola {@link #getCatalogContext()}
   */
  protected Object getAttributeDefaultValue(String name) {
    if (!attributes.containsKey(name))
      return null;

    if (getAttribute(name).valueInRange(Catalog.DEFAULT_CATALOG))
      return getAttribute(name).getDefaultValue();
    else
      return null;
  }

  /*
   * @Deprecated public Object getAttributeValueForCatalog(String name, Catalog
   * catalogContext) { if (!attributes.containsKey(name)) return null;
   *
   * return getAttribute(name).getValue(catalogContext); }
   */

  /**
   * @return new HashSet<String>(attributes.keySet());
   */
  public Set<String> getAttributeNames() {
    return new HashSet<String>(attributes.keySet());
  }

  public List<String> getAttributeNamesSorted() {
    List<String> names = new ArrayList<String>(attributes.keySet());
    Collections.sort(names);
    return names;
  }

  public Attribute getAttribute(String name) {
    return attributes.get(name);
  }

  /**
   * Dodaje transientowy atrybut z wartością w bieżącym catalogContext
   */
  public void setTransientAttribute(String attributeName, Object value) {
    if (attributeName == null || value == null) {
      throw new IllegalArgumentException("attributeName == null || value == null");
    }

    AttributeType attrType = new AttributeType(attributeName, ValueType.Transient, false, null, false);

    Attribute attr = new Attribute(attrType);
    attr.setValue(catalogContext, value);

    attributes.put(attr.getName(), attr);
  }

  public void setAttribute(Attribute attr) {
    if (attr == null) {
      throw new IllegalArgumentException("attr == null");
    }
    if (attr.isEmpty()) {
      throw new IllegalArgumentException("attr is empty");
    }

    attributes.put(attr.getName(), attr);
  }

  public void removeAttribute(Attribute attr) {
    if (attr == null) {
      throw new IllegalArgumentException("attr == null");
    }

    removeAttributeByName(attr.getName());
  }

  public void removeAttributeByName(String attributeToRemoveName) {
    if (!attributes.containsKey(attributeToRemoveName)) {
      throw new IllegalArgumentException("attribute [" + attributeToRemoveName + "] not found in this product instance");
    }

    attributes.remove(attributeToRemoveName);
  }

  /**
   * Zbiór sklepów/katalogów w którym dany produkt jest <b>dostępny</b>
   */
  public Set<Catalog> getCatalogs() {
    return catalogs;
  }

  /*
   * public void setPrice(Price price) { if (price.getBasePrice() != null) {
   * setAttributeValue(ATTR_BASE_PRICE, price.getBasePrice()); }
   *
   * if (price.getSalePrice() != null) { setAttributeValue(ATTR_SALE_PRICE,
   * price.getSalePrice()); }
   *
   * if (price.getVatCode() != null) { setAttributeValue(ATTR_VAT_CODE,
   * price.getVatCode()); } }
   */

  public String printAttributes() {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    for (String name : getAttributeNamesSorted()) {
      Attribute a = attributes.get(name);
      sb.append(i + ". " + a.toString());
      i++;
    }
    return sb.toString();
  }

  public String printDetails() {
    Set<String> catalogNames = new HashSet<String>();
    for (Catalog catalog : catalogs) {
      catalogNames.add(catalog.getName());
    }
    return "Product details [Catalogs: " + catalogNames.toString() + "], [Attributes: " + printAttributes() + "]";
  }


  public String getAttributeValueAsString(String attributeName) {
    if (!attributes.containsKey(attributeName)) {
      return null;
    }
    final Object attributeValue = getAttributeValue(attributeName);
    final AttributeType attributeType = getAttribute(attributeName).getAttributeType();
    if (!attributeType.getAttrType().hasNaturalStringConversion()) {
      throw new IllegalArgumentException("Cannot convert attribute [" + attributeType.getName() + "] to string!");
    }
    if (attributeType.isMultivalue()) {
      List list = (List) attributeValue;
      StringBuffer buf = new StringBuffer();
      for (Object singleValue : list) {
        buf.append(extractStringIfExists(attributeType, singleValue));
        buf.append(SEP);
      }
      return org.apache.commons.lang.StringUtils.removeEnd(buf.toString(), SEP);
    } else {
      return extractStringIfExists(attributeType, attributeValue);
    }

  }

  private String extractStringIfExists(AttributeType attributeType, Object attributeSingleValue) {
    if (attributeType.getAttrType().equals(ValueType.DictionaryValueRef)) {
      return ((DictionaryValue) attributeSingleValue).getItemValue();
    }
    return (String) attributeSingleValue;
  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", catalogVersion=" + catalogVersion + ", goldId=" + goldId + ", mdmIndex=" + mdmIndex + "]";
  }

  public List<String> getPegiSystems() {
    return getAttributeValue(AttributeConsts.ATT_PEGI_SYSTEM, List.class);
  }

  public Date getReleaseDate() {
    return getAttributeValue(AttributeConsts.ATT_RELEASE_DATE, Date.class);
  }

  // -- setters
  public void setId(String id) {
    this.id = id;
  }

  public void setGoldId(String goldId) {
    this.goldId = goldId;
  }

  public void setMdmIndex(String mdmIndex) {
    this.mdmIndex = mdmIndex;
  }

  public void setCatalogVersion(long catalogVersion) {
    this.catalogVersion = catalogVersion;
  }

  public void setCatalogContext(Catalog catalogContext) {
    this.catalogContext = catalogContext;
  }

  public void setCatalogs(Set<Catalog> catalogs) {
    this.catalogs = catalogs;
  }

  public void setAvailabilityCode(Integer availabilityCode) {
    this.availabilityCode = availabilityCode;
  }

  private Integer nullValueReplace(Integer value, Integer valueIfNull) {
    if (value == null)
      return valueIfNull;
    else
      return value;
  }

  public String getExternalProductIdForProvider(Integer providerId) {
    Map<Integer, String> isbnMap = (Map<Integer, String>) getAttributeValue(ATT_ISBN_MAP);
    if (isbnMap != null) {
      return isbnMap.get(providerId);
    }
    return null;
  }

  public List<String> getAllAvailableFormats() {
    Map<String, String> formatsMap = (Map<String, String>) getAttributeValue(ATT_FORMATS_MAP);
    if (formatsMap != null) {
      return new ArrayList<String>(formatsMap.keySet());
    }
    return null;
  }

  public boolean isTrack() {
    DictionaryValue trackOrAlbum = (DictionaryValue) getAttributeValue(ATT_ALBUM_OR_TRACK);
    return trackOrAlbum != null &&
        (trackOrAlbum.getItemValue().equals(ALBUM_OR_TRACK_VALUE_TRACK)
            || trackOrAlbum.getItemValue().equals(ALBUM_OR_TRACK_VALUE_TRACK_OLD)) ? true : false;
  }

  public boolean isAlbum() {
    DictionaryValue trackOrAlbum = (DictionaryValue) getAttributeValue(ATT_ALBUM_OR_TRACK);
    return trackOrAlbum != null && trackOrAlbum.getItemValue().equals(ALBUM_OR_TRACK_VALUE_ALBUM) ? true : false;
  }





  private boolean isPresale() {
    return getAvailability().getOrderableCode().equals(OrderableCode.ADVANCE_SALE);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }


  public Map<String, Attribute> getAttributes() {
    return attributes;
  }

  public void setAttributes(Map<String, Attribute> attributes) {
    this.attributes = attributes;
  }

  public boolean isStockLevelsCheckEnabledForCategory() {
    return stockLevelsCheckEnabledForCategory;
  }

  public void setStockLevelsCheckEnabledForCategory(boolean stockLevelsCheckEnabledForCategory) {
    this.stockLevelsCheckEnabledForCategory = stockLevelsCheckEnabledForCategory;
  }
}
