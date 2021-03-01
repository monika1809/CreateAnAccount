package pages;

import model.Address;
import model.PersonalInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.ElementVisibleUtils;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

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

    @FindBy(id = "company")
    WebElement company;

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

    public void enterEmail(String email) {
    inputEmail.sendKeys(email);
    }

    public void createNewAccount() {
        submitEmail.click();
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }

//    public void firstNameInput(String name) {
//        firstName.sendKeys(name);
//    }

    public void lastNameInput(String name) {
        lastName.sendKeys(name);
    }

    public void passwordInput(String pass) {
        password.sendKeys(pass);
    }

    public void dayInput(String dayOfBirth) {
        day.sendKeys(dayOfBirth);
    }

    private boolean isAlertBoxDisplayed(WebElement box) {
        return ElementVisibleUtils.isElementVisible(box, wait);
    }

    public boolean isAlertDangerBoxRegisterAccountDisplayed() {
        return isAlertBoxDisplayed(alertDangerBoxRegisterAccount);
    }

    public void sendPersonalInformation(PersonalInformation personalInformation) {
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
        postcode.sendKeys(address.getAddressLine1());
        country.sendKeys(address.getCountry().getValue());
        mobilePhone.sendKeys(address.getMobilePhone());
        alias.sendKeys(address.getAddressAlias());
    }
}
