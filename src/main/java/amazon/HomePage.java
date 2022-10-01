package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@aria-label='Open Menu']")
    private WebElement chooseTopic;
    @FindBy(xpath = "//a[@aria-label='Open Menu']")
    private WebElement chooseType;
    @FindBy(xpath = "//div[@class='nav-logo-base nav-sprite']")
    protected WebElement logo;
    @FindBy(xpath = "//a[text()='Sign in']")
    protected WebElement signInButton;
    @FindBy(xpath = "//a[text()='Other Solutions']")
    protected WebElement itemTopic;


    public void goTo() {
        driver.get(SITE_URL);
    }

    public void chooseTopicButton() {
        chooseTopic.click();

    }

    public void chooseCategory(String category) {
        WebElement chooseType = driver.findElement(By.xpath("//div[text()='" + category + "']"));
        chooseType.click();

    }

    public void chooseType(String type) {
        WebElement chooseCategory = driver.findElement(By.xpath("//a[text()='" + type + "']"));
        chooseCategory.click();
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(logo));
    }

    public void waitForPreviousCategoryItemVisibility() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(signInButton));

    }

    public void waitForPreviousTopicItemVisibility() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(itemTopic));
    }

}
