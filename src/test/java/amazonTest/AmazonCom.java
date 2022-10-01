package amazonTest;

import amazon.HomePage;
import amazon.ProductPage;
import amazon.SearchResultPage;
import createDriver.CommonActions;
import createDriver.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonCom {
    @Test
    public void testAmazon() {
        CommonActions.createDriver(Config.PLATFORM_AND_BROWSER);
        HomePage homePage = new HomePage(CommonActions.getDriver());
        homePage.goTo();
        homePage.waitForPageLoad();
        homePage.chooseTopicButton();
        homePage.waitForPreviousCategoryItemVisibility();
        homePage.chooseCategory("Smart Home");
        homePage.waitForPreviousTopicItemVisibility();
        homePage.chooseType("Smart Home Lighting");
        SearchResultPage searchResultPage = new SearchResultPage(CommonActions.getDriver());
        searchResultPage.waitForPageLoad();
        searchResultPage.chooseRandomItem();
        ProductPage productPage = new ProductPage(CommonActions.getDriver());
        productPage.waitForPageLoad();
        Assert.assertEquals(100, productPage.sumMarks());

    }
}
