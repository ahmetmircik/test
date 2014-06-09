package hctest.model.domain;

public enum ChangesSource {

  MDM(false),
  FLAGGING_PRICING(true),
  PORTAL(true),
  SCHEDULER(false),
  DICTIONARY(false),
  PRODUCT_CATALOG(false),
  CONCEPT(false) {
    @Override
    public boolean cleanAllowed() {
      return true;
    }
  },
  VIRTUALO(false) {
    @Override
    public boolean cleanAllowed() {
      return true;
    }
  };

  private boolean perCatalog;

  private ChangesSource(boolean perCatalog) {
    this.perCatalog = perCatalog;
  }

  //FIXME: to jest bezpośrednio używane przez ProductCatalog, powinno być używane przez komendę jedynie i powinien być dodany na to test.
  public boolean perCatalog() {
    return perCatalog;
  }

  public boolean cleanAllowed() {
    return isMdmCommand();
  }

  public boolean allowsReject() {
    return isMdmCommand();
  }

  public boolean allowsCatalogsChanges() {
    return isMdmCommand();
  }

  //FIXME: można by wymyśleć lepszą nazwę
  public boolean modifiesAutoavailability() {
    return isMdmCommand();
  }

  public boolean canCreateAttributeType() {
    return isMdmCommand();
  }

  protected boolean isMdmCommand() {
    return this.equals(MDM);
  }

  public boolean modifiesGoldId() {
    return isMdmCommand();
  }
}
