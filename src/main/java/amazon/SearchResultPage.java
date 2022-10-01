package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4']")
    List<WebElement> itemList;

    public void chooseRandomItem() {
        Random random = new Random();
        int randomNumber = random.nextInt(1, itemList.size());
        WebElement chooseRandomItem = driver.findElement
                (By.xpath("//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4']" + "[" + randomNumber + "]"));
        chooseRandomItem.click();

    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfAllElements(itemList));
    }
}


