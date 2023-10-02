package com.bluenile.testkit.locators;

import org.openqa.selenium.By;

public class GlobalLocators {

    //** SUPER-GLOBAL LOCATORS **//
    public static By breadCrumbs = By.cssSelector("[data-qa*='breadCrumbs']");
    public static By pageBody = By.id("body1");

    //** ITEM PAGE GLOBAL LOCATORS **//
    public static By closeCertificateButton = By.cssSelector("[data-qa='close-cert-popup']");
    public static By continueShoppingPopUpBody = By.cssSelector("[data-qa='continue_shopping__modal']");
    public static By skuNumberFromItemPage = By.cssSelector("[data-qa='stock_number_value']");
    public static By itemPageBoxImage = By.cssSelector("[src*='box.']");
    public static By addARingSetting = By.cssSelector("[data-qa='add_a_ring_setting']");
    public static By tablePropertiesShowMore = By.cssSelector("[data-qa='show-more']");
    public static By itemSuperZoomImage = By.cssSelector("[src*='/bn/Diamond-round-1']");
    public static By boxRingImageItemPage = By.cssSelector("[src*='diamonds-bn/Ringbox']");
    public static By certificateImageItemPage = By.cssSelector("[src*='ion.bluenile.com/certs/']");
    public static By itemImageAttribute = By.xpath("//*[contains(@src, 'https://ion.bluenile.com//sgmdirect/') or contains(@src, 'https://ion.bluenile.com/sgmdirect/')  or contains(@src, 'https://ion.bluenile.com/sets/Jewelry')]");
    public static By jewelLifeStyleImageItemPage = By.cssSelector("[style*='https://ion.r2net.com/sets/Jewelry-bn']");
    public static By freeReturnImageJewelBox = By.cssSelector("[src*=static-dyo-bn/freeReturns']");
    public static By trackFastImageJewelBox = By.cssSelector("[src*='static-dyo-bn/trackFastShipping']");
    public static By appraisalImageJewelBox = By.cssSelector("src*='static-dyo-bn/appraisalIncluded']");
    public static By GeneralElementDiv = By.cssSelector("[class*='customerUi']");
    public static By selectThisPopUp = By.cssSelector("[data-qa='popup']");
    public static By selectThisBody = By.cssSelector("[data-qa='select_this_button_modal']");
    public static By svgImageItemPage = By.cssSelector("[xmlns='http://www.w3.org/2000/svg']");
    public static By descriptionSummerySectionItemPage = By.cssSelector("[class*='summery-section-details-table-']");
    public static By backToGalleryButton = By.cssSelector("[data-qa='back-to-gallery_ItemPage']");
    public static By selectThisButton = By.cssSelector("[data-qa='select_this_button']");
    public static By addToCartButton = By.xpath("//*[text()='ADD TO CART']");
    public static By addToCartFromPopUp = By.cssSelector("[data-qa*='add_to_cart']");
    public static By updateCartButton = By.cssSelector("button[data-qa*='update']"); // Global for item page and complete page
    public static By colorValueFromItem = By.cssSelector("[data-qa='ops-color']");

    public static By itemPageCertificate = By.cssSelector("[class*='bottom-button']:nth-child(1)");
    public static By continueButtonFromPopUp = By.cssSelector("[data-qa='continue_button']");
    public static By itemPageBottomInfoValues = By.cssSelector("[class*='settings-section-value']");
    public static By keepShoppingButton = By.cssSelector("[name*='Continue']");
    public static By addToWishlistItemPage = By.cssSelector("[data-qa*=add-to-wishlist]");
    public static By itemPageSalePrice = By.cssSelector("[data-qa*='salePrice-product']");
    public static By itemPageMainPrice = By.cssSelector("[data-qa*='price-product']");
    public static By itemAndCompletePageTitle = By.xpath("//*[contains(@data-qa, 'title-itemPage') or contains(@data-qa, 'complete_header')]");
    public static By itemPageItemMainTitle = By.cssSelector("[data-qa='title-itemPage']");
    public static By completePageMainTitle = By.cssSelector("[data-qa='complete_header']");
    public static By itemPageShippingElement = By.cssSelector("[class*='shipsByWrapper']");
    public static By freeOvernightShippingLink = By.cssSelector("[data-qa='free_overnight_shipping_tooltip_button']");
    public static By freeOvernightShipToolTip = By.xpath("//*[contains(text(), 'Place')]/..");
    public static By hassleFreeToolTip = By.xpath("//*[contains(text(), 'Hassle-')]/..");
    public static By hassleFreeReturnLink = By.cssSelector("[data-qa='hassle_free_returns_tooltip_button']");
    public static By fullPriceItemPage = By.cssSelector("[data-qa='price-product-item']");
    public static By yourOrderSectionFreeShipping = By.cssSelector("[data-qa='your-order-section_free-shipping']");
    public static By yourOrderSectionAppraisalIncludes = By.cssSelector("[data-qa='your-order-section_appraisal-includes']");
    public static By yourOrderSectionFreeReturns = By.cssSelector("[data-qa='your-order-section_free-returns']");
    public static By discretePackagingBottom = By.cssSelector("[data-qa='discrete-packaging-bottom']");
    public static By secureAndConvenientBottom = By.cssSelector("[data-qa='discrete-packaging-bottom']");
    public static By freeShippingBottom = By.cssSelector("[data-qa='free-shipping-bottom']");
    public static By mainImgSwiperItemPage = By.cssSelector("img[class*='swiper-slide-active']");
    public static By currentImagePagination = By.className("swiper-pagination-current");
    public static By imagePaginationTotal = By.className("swiper-pagination-total");

    // There is a Jira to make all the item page metal filters synchronized (some appear as undefined in different pages). R2NET-26366.
    public static By metalFilter14KWGItemPage = By.cssSelector("[data-qa*='filter_14K_White_Gold']");
    public static By metalFilter14KYGItemPage = By.cssSelector("[data-qa*='filter_14K_Yellow_Gold']");
    public static By metalFilter14KRGItemPage = By.cssSelector("[data-qa*='filter_14K_Rose_Gold']");
    public static By metalFilter18KWGItemPage = By.cssSelector("[data-qa*='filter_18K_White_Gold']");
    public static By metalFilter18KYGItemPage = By.cssSelector("[data-qa*='filter_18K_Yellow_Gold']");
    public static By metalFilter18KRGItemPage = By.cssSelector("[data-qa*='filter_18K_Rose_Gold']");
    public static By metalFilterPlatinumItemPage = By.cssSelector("[data-qa*='filter_Platinum']");
    public static By metalFiltersLabelTextItemPage = By.cssSelector("[data-qa*='metal_title']");
    public static By itemPageShipsByContainer = By.cssSelector("[alt*='Fast Shipping']");
    public static By itemPageShipsByDate = By.tagName("time");

    //** ITEM PAGE IMAGES LOCATORS **//
    public static By lifeStyleAllThumbnailsItemPage = By.cssSelector("[data-qa*='life-style-img']");
    public static By lifeStyleFirstThumbnailItemPage = By.cssSelector("[data-qa='life-style-img-0']");
    public static By lifeStyleSecondThumbnailItemPage = By.cssSelector("[data-qa='life-style-img-1']");
    public static By lifeStyleThirdThumbnailItemPage = By.cssSelector("[data-qa='life-style-img-2']");
    public static By lifeStyleFourthThumbnailItemPage = By.cssSelector("[data-qa='life-style-img-3']");
    public static By lifeStyleFifthThumbnailItemPage = By.cssSelector("[data-qa='life-style-img-4']");
    public static By lifeStyleSixthThumbnailItemPage = By.cssSelector("[data-qa='life-style-img-5']");

    //** ITEM PAGE MOBILE IMAGES LOCATORS **//
    public static By lifeStyleAllThumbnailsMobileItemPage = By.cssSelector("[class*='swiper-slide']");
    public static By lifeStyleFirstThumbnailMobileItemPage = By.cssSelector("[class*='swiper-slide']:nth-of-type(1)");
    public static By lifeStyleSecondThumbnailMobileItemPage = By.cssSelector("[class*='swiper-slide']:nth-of-type(2)");
    public static By lifeStyleThirdThumbnailMobileItemPage = By.cssSelector("[class*='swiper-slide']:nth-of-type(3)");
    public static By lifeStyleFourthThumbnailMobileItemPage = By.cssSelector("[class*='swiper-slide']:nth-of-type(4)");
    public static By lifeStyleFifthThumbnailMobileItemPage = By.cssSelector("[class*='swiper-slide']:nth-of-type(5)");
    public static By lifeStyleSixthThumbnailMobileItemPage = By.cssSelector("[class*='swiper-slide']:nth-of-type(6)");
    public static By lifeStyleNextArrowButton = By.cssSelector("[name='Next']");

    // There is a Jira to make all the stones item page property labels synchronized (need to match it to diamonds syntax). R2NET-26508.
    public static By stoneVarietyLabelItemPage = By.cssSelector("[data-qa*='variety']");
    public static By stoneColorLabelItemPage = By.cssSelector("[data-qa*='color']");
    public static By stoneMeasurementsLabelItemPage = By.cssSelector("[data-qa*='measurements']");
    public static By stoneCaratLabelItemPage = By.cssSelector("[data-qa*='carat']");


    //** GALLERY GLOBAL LOCATORS **//
    //todo change list view locator asap once there is data qa- and locator name till there is stable data qa for element
    public static By genericButtonFromGallery = By.cssSelector("[class*='selectionWrapper']");
    public static By itemDescriptionGlobal = By.cssSelector("[data-qa*='description-page']");
    public static By galleryResultNumber = By.xpath("//*[contains(@data-qa, 'resultsNumber') or contains(@data-qa, 'resultNumber') or contains(@data-qa, 'filtered-results-text')]");
    public static By gemstoneGalleryResultNumber = By.cssSelector("[class*='top-results']");
    public static By newArrivalsRingSGalleryDropOption = By.cssSelector("[data-qa='Sort-index-4']");
    public static By galleryResetAllFilters = By.xpath("//*[text()='Reset Filters']");
    //todo its with comment till dev add data qa on the reset filter button at all galleries
//    public static By galleryResetAllFiltersOtherGalleries = By.cssSelector("[data-qa='gallery_filters_reset_button']");

    //todo change list view locator asap once there is data qa
    // public static By listViewButton = By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[5]/div[2]/div[2]/button[3]");
    public static By galleryTitle = By.cssSelector("[data-qa='showing_text-gallery']");
    public static By galleryDescription = By.cssSelector("[data-qa*='galleryDescription']");

    //** GALLERY ITEMS LOCATORS **//
    public static By galleryItemPrice = By.cssSelector("[data-qa='price2-itemPage_Desktop']");
    public static By galleryItemSalePrice = By.cssSelector("[data-qa*='price1-itemPage']");
    public static By galleryItemMainPrice = By.cssSelector("[data-qa*='price2-itemPage']");
    public static By galleryPriceContainer = By.xpath("//*[contains(@class, 'bn_comp_priceWrapper')]//*[contains(@class, 'itemPriceContainer')]");
    public static By galleryItemOne = By.cssSelector("[data-qa='galleryItem_1_0']");
    public static By galleryItemOneSortedListPicture = By.cssSelector("[data-qa='gallery_item_1_0_image']");
    public static By galleryItemOnePlayer = By.cssSelector("[data-qa='gallery_item__1_0_player']");
    public static By galleryItemTwo = By.cssSelector("[data-qa='galleryItem_1_1']");
    public static By galleryItemThree = By.cssSelector("[data-qa='galleryItem_1_2']");
    public static By galleryItemFour = By.cssSelector("[data-qa='galleryItem_1_3']");
    public static By galleryItemSeven = By.cssSelector("[data-qa='galleryItem_1_6']");
    public static By galleryItemEight = By.cssSelector("[data-qa=galleryItem_1_7]");
    public static By galleryItemOneDescription = By.cssSelector("[data-qa='description-page1-item0']");
    public static By galleryItemTwoDescription = By.cssSelector("[data-qa='description-page1-item1']");

    public static By galleryItemThreeDescription = By.cssSelector("[data-qa='description-page1-item2']");

    public static By galleryPageTwoItemThreeDescription = By.cssSelector("[data-qa='description-page2-item4']");
    public static By galleryPageFourItemOneDescription = By.cssSelector("[data-qa='description-page4-item0']");
    public static By galleryPageSixItemTwelfthDescription = By.cssSelector("[data-qa='description-page6-item13']");
    public static By galleryPageEightItemTwoDescription = By.cssSelector("[data-qa='description-page8-item1']");
    public static By galleryPageNineItemSixDescription = By.cssSelector("[data-qa='description-page9-item7']");
    public static By galleryPageTenthItemFourDescription = By.cssSelector("[data-qa='description-page10-item4']");
    public static By galleryPageTwelfthItemTwelfthDescription = By.cssSelector("[data-qa='description-page12-item12']");

    //** GALLERY SORT BY LOCATORS**//
    public static By sortDropDown = By.cssSelector("[data-qa='Sort-filter-dd']");
    public static By priceLowToHigh = By.cssSelector("[data-qa='Sort-Low_to_High-11']");
    public static By priceHighToLow = By.cssSelector("[data-qa='Sort-Low_to_High-12']");

    public static By caratHighToLow = By.cssSelector("[data-qa='Sort-High_to_Low-4']");
    public static By highToLowColor = By.cssSelector("[data-qa='Sort-High_to_Low-6']");
    public static By highToLowClarity = By.cssSelector("[data-qa='Sort-High_to_Low-8']");
    public static By highToLowCut = By.cssSelector("[data-qa='Sort-High_to_Low-10']");
    public static By sortByFastShippingOption = By.cssSelector("[data-qa='Sort-index-3']");
    public static By sortByHighToLow = By.cssSelector("[data-qa='Sort-High_to_Low']");
    public static By sortByLowToHigh = By.cssSelector("[data-qa='Sort-Low_to_High']");
    public static By colorLowToHigh = By.cssSelector("[data-qa='Sort-Low_to_High-5']");
    public static By sortByBestSellersOption = By.cssSelector("[data-qa='Sort-index-0']");
    public static By sortByDropDown = By.cssSelector("[data-qa='Sort']");
    public static By galleryItemFastShippingIcon = By.cssSelector("[class*=r2comp_byFastShippingStones-image]");
    public static By stoneGallerySortByGalleryViewContainer = By.cssSelector("[class='viewFilter']");
    public static By stoneGallerySortGalleryFilterList = By.xpath("//*[contains(@class, 'viewFilter')]//*[contains(@class, 'r2comp_selectionWrapper')]");

    //** GALLERY STYLE FILTER **// (The current data qa selectors for filter dropdown options is only valid for DESKTOP - we have a Jira R2NET-25542)
    public static By galleryStyleMainFilterButton = By.cssSelector("[data-qa*='AllStyles-filter']");
    public static By galleryStyleFilterAllStylesOption = By.cssSelector("[data-qa='AllStyles-All']");
    public static By galleryStyleFilterEternityOption = By.cssSelector("[data-qa='AllStyles-Eternity']");
    public static By galleryStyleFilterStackableOption = By.cssSelector("[data-qa='AllStyles-Stackable']");
    public static By galleryStyleFilterPaveOption = By.cssSelector("[data-qa='AllStyles-Pavé']");
    public static By galleryStyleFilterFashionOption = By.cssSelector("[data-qa='AllStyles-Fashion']");
    public static By galleryStyleFilterChannelSetOption = By.cssSelector("[data-qa='AllStyles-Channel_Set']");
    public static By galleryStyleFilterDesignerOption = By.cssSelector("[data-qa='AllStyles-Designer']");
    public static By galleryStyleFilterSimpleOption = By.cssSelector("[data-qa='AllStyles-Simple']");
    public static By galleryStyleFilterVintageOption = By.cssSelector("[data-qa='AllStyles-Vintage']");
    public static By galleryStyleFilterInfinityOption = By.cssSelector("[data-qa='AllStyles-Infinity']");
    public static By galleryStyleFilterAnniversaryOption = By.cssSelector("[data-qa='AllStyles-Anniversary']");
    public static By galleryStyleFilterClassicOption = By.cssSelector("[data-qa='AllStyles-Classic']");
    public static By galleryStyleFilterUniqueOption = By.cssSelector("[data-qa='AllStyles-Unique']");
    public static By galleryStyleFilterCocktailOption = By.cssSelector("[data-qa='AllStyles-Cocktail']");
    public static By galleryStyleFilterDiamondOption = By.cssSelector("[data-qa='AllStyles-Diamond']");
    public static By galleryStyleFilterAllSubCategories = By.cssSelector("li[data-qa*='AllStyles']");

    //** GALLERY METAL FILTER **// (The current data qa selectors for filter dropdown options is only valid for DESKTOP - we have a Jira R2NET-25542)
    public static By galleryMetalMainFilterButton = By.cssSelector("[data-qa*='MetalType-filter']");
    public static By galleryMetalFilterAllMetalsOption = By.cssSelector("[data-qa='MetalType-All']");
    public static By galleryMetalFilterWhiteGoldOption = By.cssSelector("[data-qa='MetalType-White_Gold']");
    public static By galleryMetalFilterYellowGoldOption = By.cssSelector("[data-qa='MetalType-Yellow_Gold']");
    public static By galleryMetalFilterRoseGoldOption = By.cssSelector("[data-qa='MetalType-Rose_Gold']");
    public static By galleryMetalFilterPlatinumOption = By.cssSelector("[data-qa='MetalType-Platinum']");
    public static By galleryMMetalFilterTantalumOption = By.cssSelector("[data-qa='MetalType-Tantalum']");
    public static By galleryMetalFilterCobaltChromeOption = By.cssSelector("[data-qa='MetalType-Cobalt_Chrome']");
    public static By galleryMetalFilterBlackTitaniumOption = By.cssSelector("[data-qa='MetalType-Black_Titanium']");
    public static By galleryMetalFilterCeramicOption = By.cssSelector("[data-qa='MetalType-Ceramic']");
    public static By galleryMetalFilterTungstenCarbideOption = By.cssSelector("[data-qa='MetalType-Tungsten_Carbide']");
    public static By galleryMetalFilterSterlingSilverOption = By.cssSelector("[data-qa='MetalType-Sterling_silver']");
    public static By galleryMetalFilterAllSubCategories = By.cssSelector("li[data-qa*='MetalType']");

    //** GALLERY GENDER FILTER **//
    public static By galleryGenderMainFilterButton = By.cssSelector("[data-qa*='gender-filter']");
    public static By galleryGenderFilterAllOptions = By.cssSelector("[data-qa*='gender-All']");
    public static By galleryGenderFilterWomenOption = By.cssSelector("[data-qa='gender-Women']");
    public static By galleryGenderFilterMenOption = By.cssSelector("[data-qa='gender-Men']");
    public static By galleryGenderFilterAllSubCategories = By.cssSelector("li[data-qa*='gender']");

    //** GALLERY PRICE FILTER **//
    public static By galleryPriceMainFilterButton = By.cssSelector("[data-qa='Price']");
    public static By galleryPriceSlider = By.cssSelector("[data-qa='Price-sliderMain']");
    public static By galleryPriceMinInputField = By.cssSelector("[data-qa='price-min-input']");
    public static By galleryPriceMaxInputField = By.cssSelector("[data-qa='price-max-input']");
    public static By galleryPriceMinDraggableElement = By.cssSelector("[data-qa='gallery-Price-btn-min-controller']");
    public static By galleryPriceMaxDraggableElement = By.cssSelector("[data-qa='gallery-Price-btn-max-controller']");

    //** GALLERY CARAT FILTER **//
    public static By galleryCaratSlider = By.cssSelector("[data-qa='Carat-sliderMain']");
    public static By galleryCaratMinInputField = By.cssSelector("[data-qa='carat-min-input']");
    public static By galleryCaratMaxInputField = By.cssSelector("[data-qa='carat-max-input']");
    public static By galleryCaratMinDraggableElement = By.cssSelector("[data-qa='gallery-Carat-btn-min-controller']");
    public static By galleryCaratMaxDraggableElement = By.cssSelector("[data-qa='gallery-Carat-btn-max-controller']");

    //** GALLERY SHAPE FILTERS (GEMSTONES, DIAMONDS AND IN THE FUTURE ENGAGEMENT) **//
    public static By galleryShapeFilterSubCategories = By.cssSelector("li[data-qa*='Shape']");
    public static By galleryShapeFilterRoundButton = By.cssSelector("[data-qa='Shape-Round']");
    public static By galleryShapeFilterPrincessButton = By.cssSelector("[data-qa='Shape-Princess']");
    public static By galleryShapeFilterEmeraldButton = By.cssSelector("[data-qa='Shape-Emerald']");
    public static By galleryShapeFilterAsscherButton = By.cssSelector("[data-qa='Shape-Asscher']");
    public static By galleryShapeFilterCushionButton = By.cssSelector("[data-qa='Shape-Cushion']");
    public static By galleryShapeFilterMarquiseButton = By.cssSelector("[data-qa='Shape-Marquise']");
    public static By galleryShapeFilterRadiantButton = By.cssSelector("[data-qa='Shape-Radiant']");
    public static By galleryShapeFilterOvalButton = By.cssSelector("[data-qa='Shape-Oval']");
    public static By galleryShapeFilterPearButton = By.cssSelector("[data-qa='Shape-Pear']");
    public static By galleryShapeFilterHeartButton = By.cssSelector("[data-qa='Shape-Heart']");

    //** GALLERY SHIPPING BY LOCATORS **//
    public static By galleryShippingDateByFilterMainButton = By.cssSelector("[data-qa='ShippingDate-filter-dd']");
    public static By galleryShippingDateAllOptionsList = By.cssSelector("[class*='bn_comp_filterSingletem']");
    public static By galleryShippingDateByOptionSelectionTwo = By.cssSelector("[data-qa*='ShippingDate']:nth-child(2)");
    public static By galleryShippingDateByOptionSelectionOne = By.cssSelector("[data-qa*='ShippingDate']:nth-child(1)");
    public static By galleryShippingDateByOptionSelectionThree = By.cssSelector("[data-qa*='ShippingDate']:nth-child(3)");
    public static By galleryShippingDateByOptionSelectionFive = By.cssSelector("[data-qa*='ShippingDate']:nth-child(5)");

    //** GALLERY MOBILE LOCATORS **//
    public static By genericMobileFilterOption = By.cssSelector("[class*='bn_comp_selectionWrapper']");
    public static By viewResultsButton = By.cssSelector("[data-qa='filtered-results-text']");
    public static By clearFilterButton = By.cssSelector("[data-qa='clearFilterSelection-btn']");
    public static By filtersBodyMobile = By.xpath("//*[contains(@id, 'headlessui-dialog-panel')]");


    //** ADD TO WISHLIST FROM GALLERY **//
    public static By closeWishListPopupButton = By.cssSelector("[data-qa='close_button-modal']");
    public static By galleryFirstItemWishlistIcon = By.cssSelector("[data-qa='wishList_button_1_0']");
    public static By galleryThirdItemWishlistIcon = By.cssSelector("[data-qa='wishList_button_1_2']");
    public static By gallerySecondItemWishlistIcon = By.cssSelector("[data-qa='wishList_button_1_1']");

    //** HINT IT (item pages and wishlist) **//
    public static By selectThisButtonHeaderPopUp = By.cssSelector("[data-qa='header_title']");
    public static By facebookHintItShareBtn = By.cssSelector("[data-qa='share_button_facebook-itemPage']");
    public static By instagramHintItShareBtn = By.cssSelector("[data-qa='share_button_instagram-itemPage']");
    public static By twitterHintItShareBtn = By.cssSelector("[data-qa='share_button_twitter-itemPage']");
    public static By pinterestHintItShareBtn = By.cssSelector("[data-qa='share_button_pinterest-itemPage']");
    public static By emailHintItShareBtn = By.cssSelector("[data-qa='share_button_mail-itemPage']");
    public static By copyLinkHintItShareBtn = By.cssSelector("[data-qa='share_button_copy_link-itemPage']");
    public static By proceedToCartButton = By.cssSelector("[data-qa='proceed_shopping_cart_button-add_to_cart_popup-mobile']");
    public static By closeFilter = By.cssSelector("[class^='bn_comp_xButton']");

    //** GALLERY FILTERS CONTAINER DESKTOP AND MOBILE **//
    //Main filter buttons Desktop and Mobile
    public static By galleryMainFiltersButton = By.xpath("//*[contains(@class, 'chipButton') or contains(@class, 'filtersControlBtn') or contains(@class, 'filters-btn')]");
    //All Filter Selections - Desktop And Mobile
    public static By filtersSelectionOptions = By.xpath("//*[contains(@class, 'shape') or contains(@class, 'colorFilter') " +
            "or contains(@class, 'filterItemsList')]//*[contains(@class,'selectionWrapper') or contains(@class, 'filterSingletem')]");
    public static By galleryColorSelectionOptions = By.xpath("//*[contains(@class, 'colorFilter')]//*[contains(@class, 'bn_comp_selectionWrapper')]");
    public static By galleryShapeSelectionOptions = By.xpath("//*[contains(@class, 'shapeFilter')]//*[contains(@class, 'bn_comp_selectionWrapper')]");

    //** 404 AND ERROR PAGES **//
    public static By errorPageNotFoundTextContainer = By.cssSelector("[class*='textContainer']");

    //** WISHLIST AND SHOPPING CART GLOBAL LOCATORS **//
    public static By cartOrWishlistEmptyPage = By.cssSelector("[data-qa='main_title-empty_products']");
    public static By cartOrWishlistFirstItem = By.cssSelector("[data-qa='product-0']");
    public static By cartOrWishListItemsDescriptionContainer = By.cssSelector("[data-qa*='title-item']");
    public static By cartOrWishlistPageFirstItemFirstDescription = By.cssSelector("[data-qa*='title-item_0-product-0']");
    public static By cartOrWishListSecondItemsDescription = By.cssSelector("[data-qa*='title-item_0-product-1']");
    public static By cartOrWishlistPageFirstItemPrice = By.cssSelector("[data-qa*='product_price_0']");
    public static By cartOrWishlistFirstItemViewButton = By.cssSelector("[data-qa*='view_product_link']");
    public static By cartOrWishlistRemoveFirstItemFromButton = By.cssSelector("[data-qa*='remove_product_button-product-0']");
    public static By cartOrWishlistFirstItemImageContainer = By.xpath("//*[contains(@data-qa, 'main_image-product-0') or contains(@data-qa, 'left_image_button-product-0')]");
    public static By cartOrWishlistFirstItemPicture = By.cssSelector("[data-qa='main_image-product-0']");
    public static By cartOrWishlistFirstItemSecondDescription = By.cssSelector("[data-qa='title-item_1-product-0']");
    public static By cartOrWishlistItemPictureContainer = By.cssSelector("[data-qa*='image-product']");

}
