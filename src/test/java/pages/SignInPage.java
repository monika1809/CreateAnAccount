package pages;

import model.Address;
import model.PersonalInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementVisibleUtils;

import java.time.Duration;

public class SignInPage extends BasePage {

    @FindBy(className = "info-account")
    WebElement registerInfoAccountParagraph;
    private WebDriverWait wait;

    @FindBy(id = "email_create")
    WebElement inputEmail;

    @FindBy(id = "SubmitCreate")
    WebElement submitEmail;

    @FindBy(className = "clearfix")
    WebElement chooseTitle;

    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "days")
    WebElement day;

    @FindBy(id = "months")
    WebElement month;

    @FindBy(id = "years")
    WebElement year;

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement state;

    @FindBy(id = "postcode")
    WebElement postcode;

    @FindBy(id = "id_country")
    WebElement country;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhone;

    @FindBy(id = "alias")
    WebElement alias;

    @FindBy(className = "alert-danger")
    WebElement alertDangerBoxRegisterAccount;

    @FindBy(id = "submitAccount")
    WebElement registerButton;

    public SignInPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.sendKeys(email);
    }

    public void createNewAccount() {
        wait.until(ExpectedConditions.visibilityOf(submitEmail));
        submitEmail.click();
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }

    private boolean isAlertBoxDisplayed(WebElement box) {
        wait.until(ExpectedConditions.visibilityOf(box));
        return ElementVisibleUtils.isElementVisible(box);
    }

    public boolean isRegisterInfoAccountParagraphDisplayed() {
        return isAlertBoxDisplayed(registerInfoAccountParagraph);
    }

    public boolean isAlertDangerBoxRegisterAccountDisplayed() {
        return isAlertBoxDisplayed(alertDangerBoxRegisterAccount);
    }

    public void sendPersonalInformation(PersonalInformation personalInformation) {
        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(personalInformation.getFirstName());
        lastName.sendKeys(personalInformation.getLastName());
        password.sendKeys(personalInformation.getPassword());
        day.sendKeys(personalInformation.getDayOfBirth().getValue());
        month.sendKeys(personalInformation.getMonthOfBirth().getValue());
        year.sendKeys(personalInformation.getYearOfBirth().getValue());
    }

    public void sendAddressInformation(Address address) {
        address1.sendKeys(address.getAddressLine1());
        city.sendKeys(address.getCity());
        state.sendKeys(address.getCity());
        postcode.sendKeys(address.getPostalCode().toString());
        country.sendKeys(address.getCountry().getValue());
        mobilePhone.sendKeys(address.getMobilePhone().toString());
        alias.sendKeys(address.getAddressAlias());
    }
}
