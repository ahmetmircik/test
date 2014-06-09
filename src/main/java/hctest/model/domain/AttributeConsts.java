package hctest.model.domain;

/**
 * @author czajkowski
 */
public interface AttributeConsts {
  public static final String ATT_AUTO_AVAILABILITY_ENABLED = "autoAvailabilityEnabled";

  public static final String ATTR_GRATIS = "gratis";

  // atrybut wyliczany przez Product (nie ma prawa przychodzić z zewnątrz)
  public static final String ATTR_PRODUCT_STATE = "productState";

  // Właściwa wartość
  public static final String ATTR_VISIBLE = "visible";

  // Przychodzi z MDMu
  public static final String ATTR_TARGET_VISIBILITY = "targetVisibility";

  public static final String ATTR_AUTO_VISIBILITY = "autoVisibility";

  public static final String TRANSIENT_ATTR_RATE = "transient_rate";

  public static final String ATT_MANUAL_RELATIONS = "manualRelations";
  
  public static final String ATT_CHANGE_REASON = "powodZmianyPowod";
  
  // Koncept
  public static final String ATT_CONCEPT_VARIANTS = "conceptVariants";
  public static final String ATT_CONCEPT_VARIANTS_MDMINDEXES = "conceptVariantsMdmIndexes";
  public static final String ATT_CONCEPT = "concept";
  public static final String ATT_PARENT_CONCEPT = "parentConcept";
  public static final String ATT_PARENT_CONCEPT_MDM_INDEX = "parentConceptMdmIndex";
  public static final String ATT_CONCEPT_ATTRIBUTES_NAMES = "conceptAttributesNames";
  public static final String ATT_PARENT_CONCEPT_ATTRIBUTES_NAMES = "parentConceptAttributesNames";

  public static final String ATTR_RATE_COUNT = "rate_count";
  public static final String ATTR_RATE_SCORE_SUM = "rate_score_sum";
  public static final String ATTR_MAIN_CATEGORY = "main_category";
  public static final String ATTR_LICENCE_BLOCKED = "licenceBlocked";
  public static final String ATTR_ADDITIONAL_CATEGORIES = "categories";

  public static final String ATTR_PRICE = "price";

  public static final String ATTR_SALE_DATE = "saleDate";
  public static final String ATTR_EDITION_DATE = "editionDate";
  public static final String ATTR_RESALE_DATE = "resaleDate";
  public static final String ATTR_LAST_AVAILABILITY_CHANGE_DATE = "lastAvailabilityChangeDate";

  public static final String ATTR_AVAILABILITY = "availability";
  public static final String ATTR_TARGET_AVAILABILITY = "targetAvailability";
  public static final String ATTR_LICENSE_COUNTRIES_CODES = "licenseCountriesCodes";

  public static final String RELATION_PROPERTY_CATALOGS = "catalogs";
  public static final String ATT_CATALOG_CONTEXT = "catalogContext";

  public static final String ATTR_LICENCE_TYPE = "licenceType";
  public static final String ATTR_EBOOK_FILES = "ebookFiles";

  public static final String ATT_TYPE = "type";
  public static final String ATT_TRACK_COUNT = "trackCount";
  public static final String ATT_ORCHESTRA = "orchestra";
  public static final String ATT_CARRIER = "carrier";
  public static final String ATT_CONDUCTOR = "conductor";
  public static final String ATT_SOLOIST = "soloist";
  public static final String ATT_COUNTRY = "country";
  public static final String ATT_SOUND = "sound";
  public static final String ATT_MUSIC_COUNT = "musicCount";
  public static final String ATT_RECORDING_YEAR = "recordingYear";
  public static final String ATT_EDITION = "edition";
  public static final String ATT_PHOTO_AUTHOR = "photoAuthor";
  public static final String ATT_AUTHOR = "author";
  public static final String ATT_READER_LANGUAGES = "readerLanguages";
  public static final String ATT_TEXT_FRAGMENT = "textFragment";
  public static final String ATT_WORDING = "wording";
  public static final String ATT_FORM = "form";

  public static final String ATT_PAGES = "pages";
  @Deprecated
  public static final String ATT_PAGE_COUNT = "pageCount";
  @Deprecated
  public static final String ATT_PAGES_COUNT = "pagesCount";

  public static final String ATT_ORIGINAL_LANGUAGE = "originalLanguage";
  public static final String ATT_AWARDS = "awards";
  public static final String ATT_TABLE_OF_CONTENTS = "tableOfContents";

  @Deprecated
  public static final String ATT_TABLE_CONTENTS = "tableContents";
  public static final String ATT_BINDING = "binding";

  public static final String ATT_ISBN_SERIES = "isbnSeries";
  public static final String ATT_PUBLISHING_YEAR = "publishingYear";
  public static final String ATT_TRANSLATOR = "translator";
  public static final String ATT_HAS_TRANSLATION = "hasTranslation";
  public static final String ATT_PROMOTION = "promotion";

  public static final String ATT_SERIES = "series";
  public static final String ATT_LINE_SIZE = "lineSize";

  public static final String ATT_ALBUM_PHOTO_COUNT = "albumPhotoCount";

  public static final String ATT_PAPER_TYPE = "paperType";
  public static final String ATT_COLOUR = "colour";
  public static final String ATT_ISBN = "isbn";
  public static final String ATT_ISBN_MAP = "isbnMap";
  public static final String ATT_ALBUM_OR_TRACK = "albumOrTrack";
  public static final String ATT_ALBUM_BINDING = "albumBinding";
  public static final String ATT_CLIPFRAME_TYPE = "clipframeType";
  public static final String ATT_PAPER_COLLECTION = "paperCollection";
  public static final String ATT_ALBUM_COVER = "albumCover";
  public static final String ATT_FORMAT = "format";
  public static final String ATT_MATERIAL = "material";
  public static final String ATT_WITH_BATTERY = "withBattery";
  public static final String ATT_COLOURS_COUNT = "coloursCount";
  public static final String ATT_ALBUM_DESCRIPTION = "albumDescription";
  public static final String ATT_BINDING_TYPE = "bindingType";
  public static final String ATT_ALBUM_TYPE = "albumType";
  public static final String ATT_VAT = "vat";
  public static final String ATT_PKWIU = "pkwiu";
  public static final String ATT_IMAGE1_PATH = "image1Path";
  public static final String ATT_COUNTRY_ORIGIN = "countryOrigin";
  public static final String ATT_WEIGHT = "weight";
  public static final String ATT_EDITION_DATE = "editionDate";
  public static final String ATT_WIDTH = "width";
  // public static final String ATT_AVAILABILITY_DATE = "availabilityDate";
  public static final String ATT_GOLD_ID = "goldId";
  public static final String ATT_PATRONATE = "patronate";
  public static final String ATT_DEPTH = "depth";
  public static final String ATT_DISPLAY_NAME = "displayName";
  public static final String ATT_LONG_DESCRIPTION = "longDescription";
  public static final String ATT_HEIGHT = "height";
  public static final String ATT_MDMINDEX = "mdmIndex";
  public static final String ATT_REGION = "region";
  public static final String ATT_DISC_TYPE = "discType";
  public static final String ATT_SUB_TITLE = "subTitle";
  public static final String ATT_COMPOSER = "composer";
  public static final String ATT_HAS_LECTOR = "hasLector";
  public static final String ATT_HAS_DUBBING = "hasDubbing";
  public static final String ATT_TEXT = "text";
  public static final String ATT_DIRECTOR = "director";
  public static final String ATT_STAGE_DESIGN = "stageDesign";
  public static final String ATT_MOVIE_CAST = "movieCast";
  public static final String ATT_TABLE_EPISODES = "tableEpisodes";
  public static final String ATT_PRODUCER = "producer";
  public static final String ATT_DUBBING_ACTORS = "dubbingActors";
  public static final String ATT_LANGUAGE = "language";

  public static final String ATT_LECTOR = "lector";
  @Deprecated
  public static final String ATT_READER = "reader";

  public static final String ATT_PEGI_CODE = "pegiCode";
  public static final String ATT_PLATFORM = "platform";
  public static final String ATT_HARDWARE = "hardware";
  public static final String ATT_LANGUAGE_VERSION = "languageVersion";
  public static final String ATT_ADDITIONAL_CARRIER = "additionalCarrier";
  public static final String ATT_DISC_COUNT = "discCount";
  public static final String ATT_PACKING_TYPE = "packingType";
  public static final String ATT_DISTRIBUTOR = "distributor";
  public static final String ATT_EAN = "ean";
  public static final String ATT_PEGI_SYSTEM = "pegiSystems";
  public static final String ATT_ORIGINAL_TITLE = "originalTitle";
  public static final String ATT_EXCLUSIVENESS = "exclusiveness";
  @Deprecated
  /* Use dateFrom and DataTo from ProductCommandValue */
  public static final String ATT_EXCLUSIVENESS_START_DATE = "exclusivenessStartDate";
  @Deprecated
  /* Use dateFrom and DataTo from ProductCommandValue */
  public static final String ATT_EXCLUSIVENESS_END_DATE = "exclusivenessEndDate";
  public static final String ATT_EPRODUCT_TYPE = "eproductType";
  public static final String ATT_PUBLISHER = "publisher";
  public static final String ATT_PERFORMER = "performer";
  public static final String ATT_SCRIPTWRITER = "scriptWriter";
  public static final String ATT_ASPECT_RATIO = "aspectRatio";
  public static final String ATT_GENRE = "genre";
  public static final String ATT_BESTSELLER_YEAR = "bestRoku";
  public static final String ATT_BESTSELLER_YEAR_NOM = "bestRokuNom";
  public static final String ATT_GOLD_CATEGORY_ID = "goldCategoryId";
  public static final String ATT_TYPE_MAPS_ATLASES = "823";
  public static final String ATT_ADMISSION_NUMBER = "admissionNumber";

  /*Kategoria multimedia*/
  public static final String ATT_MULTIMEDIA_LANGUAGE = "multimediaLanguage";
  public static final String ATT_RANGE = "range";
  public static final String ATT_KIND_OF_MULTIMEDIA = "kindOfMultimedia";
  public static final String ATT_COMMUNICATION_WITH_A_DEVICE = "communicationWithADevice";
  public static final String ATT_MOUSE_TYPE = "mouseType";
  public static final String ATT_RESOLUTION = "resolution";
  public static final String ATT_KEYBOARD_LAYOUT = "keyboardLayout";
  public static final String ATT_CONNECTION_TYPE = "connectionType";

  /* Atrybuty SMYK */
  public static final String ATT_LICENSE = "license";
  public static final String ATT_GAME_TIME = "gameTime";
  public static final String ATT_NUMBER_OF_ITEMS_IN_RANGE = "numberOfItemsInRange";
  public static final String ATT_NUMBER_OF_ITEMS = "numberOfItems";
  public static final String ATT_BRAND = "brand";
  public static final String ATT_WEAR_COLOUR = "wearColour";
  public static final String ATT_WEAR_COLOUR_DESC = "wearColourDesc";
  public static final String ATT_SEX = "sex";
  public static final String ATT_BATTERY_TYPE = "batteryType";

  public static final String ATT_RECOMMENDED_WEIGHT = "recommendedWeight";
  public static final String ATT_RECOMMENDED_AGE = "recommendedAge";
  public static final String ATT_RECOMMENDED_AGE_DESC = "recommendedAgeDesc";
  public static final String ATT_SIZE = "size";
  public static final String ATT_PATRONATE_SMYK_COM = "patronateSmykCom";
  public static final String ATT_EXCLUSIVENESS_IN_SMYK = "exclusivenessInSmyk";
  public static final String ATT_EXCLUSIVENESS_IN_SMYK_COM = "exclusivenessInSmykCom";
  public static final String ATT_TV_ADVERTISE = "tvAdvertise";
  public static final String ATT_THEMED_PUZZLES = "themedPuzzles";
  public static final String ATT_RAW_MATERIAL = "rawMaterial";
  public static final String ATT_SEASON = "season";
  public static final String ATT_OKAZJA = "okazja";
  public static final String ATT_SPECIAL_OFFER = "specialOffer";
  public static final String ATT_SPECIAL_OFFER_FOR = "specialOfferFor";

  public static final String ATT_CHIPSET = "chipset";
  public static final String ATT_HDD = "hdd";
  public static final String ATT_FUNCIONALITIES = "funcionalities";
  public static final String ATT_PRODUCER_CODE = "producerCode";
  public static final String ATT_MATRIX = "matrix";
  public static final String ATT_MEMORY = "memory";
  public static final String ATT_PROCESSOR = "processor";
  public static final String ATT_OPERATING_SYSTEM = "operatingSystem";
  public static final String ATT_TECHNIQUE = "technique";
  public static final String ATT_PRINT_TECHNIQUE = "printTechnique";
  public static final String ATT_DEVICE_TYPE = "deviceType";
  public static final String ATT_SCREEN = "screen";

  public static final String ATT_LINE = "line";
  public static final String ATT_CAPACITY = "capacity";
  public static final String ATT_KIND = "kind";
  public static final String ATT_FRAGRANCE = "fragrance";
  public static final String ATT_SET = "set";
  public static final String ATT_FOR_WHOM = "forWhom";
  public static final String ATT_TIME_OF_YEAR = "timeOfYear";

  public static final String ATT_PROCESSOR_FAMILY = "processorFamily";
  public static final String ATT_PROCESSOR_SOCKET = "processorSocket";
  public static final String ATT_MEMORY_TYPE = "memoryType";
  public static final String ATT_CHIPSET_MANUFACTURER = "chipsetManufacturer";
  public static final String ATT_CHIPSET_TYPE = "chipsetType";
  public static final String ATT_DISK_TYPE = "diskType";
  public static final String ATT_DISK_FORMAT = "diskFormat";
  public static final String ATT_SCREEN_SIZE = "screenSize";
  public static final String ATT_SCREEN_TYPE = "screenType";
  public static final String ATT_DRIVE_TYPE = "driveType";
  public static final String ATT_FORM_FACTOR = "formFactor";
  public static final String ATT_MEMORY_CARD_TYPE = "memoryCardType";

  public static final String ATT_PROVIDER = "provider";

  public static final String ATT_MDM_PROVIDER = "mdmProvider";

  public static final String ATT_MP3_SAMPLE = "mp3Sample";
  public static final String ATT_DURATION = "duration";
  public static final String ATT_MUSIC_GENRE = "musicGenre";
  public static final String ATT_ACTION_COSMETIC = "actionCosmetic";
  public static final String ATT_NATURAL_CARE = "naturalCare";
  public static final String ATT_SKIN_TYPE = "skinType";
  public static final String ATT_COSMETIC_USAGE = "cosmeticUsage";
  public static final String ATT_RELEASE_DATE = "releaseDate";
  public static final String ATT_UPC = "UPC";
  public static final String ATT_ISRC = "ISRC";
  public static final String ATT_GRID = "GRID";
  public static final String ATT_IPID = "IPID";
  public static final String ATT_EMU_CODE = "EmuCode";
  public static final String ATT_PRODUCER_OR_WORKS = "producerOrWorks";
  public static final String ATT_PRODUCT_TYPE = "productType";
  public static final String ATT_PRODUCT_CODE = "productCode";
  public static final String ATT_PRICE_CATEGORY = "priceCategory";
  public static final String ATT_PRICE_CATEGORY_CODE = "priceCategoryCode";
  public static final String ATT_VERSION = "version";
  public static final String ATT_TEXT_AUTHOR = "textAuthor";
  public static final String ATT_DISC_NUMBER = "discNumber";
  public static final String ATT_ALBUM_ID = "albumId";
  public static final String ATT_ALBUM_TO_TRACK = "albumToTrack";
  public static final String ATT_TRACK_NUMBER = "trackNumber";
  public static final String ATT_TRACK_ID = "trackId";
  public static final String ATT_TRACK_LIST = "trackList";
  public static final String ATT_RELATED_ALBUMS = "relatedAlbums";

  public static final String ATT_SAFE_FROM_PREGNANT = "safeForPregnant";
  public static final String ATT_AROMATHERAPY = "aromatherapy";
  public static final String ATT_PRODUCT_INGREDIENTS = "productIngredients";
  public static final String ATT_SPA = "spa";
  public static final String ATT_AGE = "age";
  public static final String ATT_NEW_BEAUTY = "nowosc_beauty";
  

  // kategoria sport
  public static final String ATT_NECKLINE_TYPE = "necklineType";
  public static final String ATT_LEG_LENGTH = "legLength";
  public static final String ATT_SLEEVE_LENGTH = "sleeveLength";
  public static final String ATT_SOX_LENGTH = "soxLength";
  public static final String ATT_SKIRT_DRESSES_LENGTH = "skirtDressesLength";
  public static final String ATT_WITH_HOOD = "withHood";
  public static final String ATT_KIND_OF_CUT = "kindOfCut";
  public static final String ATT_CLOTCHES_PARAMETER = "clothesParameter";
  public static final String ATT_KIND_OF_UNDERWEAR = "kindOfUnderwear";
  public static final String ATT_KIND_OF_CAP = "kindOfCap";
  public static final String ATT_KIND_OF_LEGS = "kindOfLegs";
  public static final String ATT_KIND_OF_TROUSERS = "kindOfTrousers";
  public static final String ATT_KIND_OF_SKIRT_AND_DRESSES = "kindOfSkirtAndDresses";
  public static final String ATT_FASTENING_CLOTCHES = "fasteningClothes";
  public static final String ATT_KIND_OF_HEEL = "kindOfHeel";
  public static final String ATT_KIND_OF_FOOTGEAR = "kindOfFootgear";
  public static final String ATT_KIND_OF_FASTENER_SHOES = "kindOfFastenerShoes";
  public static final String ATT_UPPER_HEIGHT = "upperHeight";
  public static final String ATT_HELL_HEIGHT = "heelHeight";
  public static final String ATT_CABIN_BAGGAGE = "cabinBaggage";
  public static final String ATT_BAGGAGE_CAPACITY = "baggageCapacity";
  public static final String ATT_BACKPACK_CAPACITY = "backpackCapacity";
  public static final String ATT_CLOCK_MECHANISM = "clockMechanism";
  public static final String ATT_CLOCK_SHIELD = "clockShield";
  public static final String ATT_WATERPROOF = "waterproof";
  public static final String ATT_CIRCLE_SIZE = "circleSize";
  public static final String ATT_FRAME_SIZE = "frameSize";
  public static final String ATT_BUSINESS = "business";
  public static final String ATT_SPORT_DISCIPLINE = "sportDiscipline";
  public static final String ATT_FILE_SIZE = "fileSize";
  public static final String ATT_FORMATS_MAP = "formatsMap";
  
  //gabaryt  
  public static final String ATT_HEIGHT_WITHOUT_ENVELOPE = "heightWithoutEnvelope";
  public static final String ATT_WIDTH_WITHOUT_ENVELOPE = "widthWithoutEnvelope";
  public static final String ATT_DEPTH_WITHOUT_ENVELOPE = "depthWithoutEnvelope";
  public static final String ATT_WEIGHT_WITHOUT_ENVELOPE = "weightWithoutEnvelope";
  public static final String ATT_DECLARATIVE_SIZE = "declarativeSize";
  public static final String ATT_DISABLE_SIZE = "disableSize";

  //prawidłowy, aktualny url produktu
  public static final String ATT_URL = "url";

}
