package tests;

import com.github.javafaker.Faker;
import enums.*;
import model.Address;
import model.PersonalInformation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignInPage;
import pages.TopMenuPage;

public class SignInTest extends BaseTest {
    private TopMenuPage topMenuPage;
    private SignInPage signInPage;

    Faker faker = new Faker();
    String fakeEmail = faker.internet().emailAddress();
    String fakeFirstName = faker.name().firstName();
    String fakeLastName = faker.name().lastName();
    String fakePassword = faker.lorem().characters(8);
    String fakeAddress = faker.address().fullAddress();
    String fakeCity = faker.country().capital();
    String fakeZip = faker.address().zipCode();
    String fakePhone = String.valueOf(faker.phoneNumber());
    String fakeAlias = faker.name().username();

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);

        topMenuPage = new TopMenuPage(driver);
        signInPage = new SignInPage(driver);
    }

    @Test
    public void shouldNotAllowedToCreateAnAccountWithEmptyEmailAddress() {
        topMenuPage.clickOnSignInLink();
        signInPage.createNewAccount();

        Assertions.assertThat(signInPage.isAlertDangerBoxRegisterAccountDisplayed()).isTrue();
    }

    @Test
    public void createNewAccount() {
        topMenuPage.clickOnSignInLink();
        signInPage.enterEmail(fakeEmail);
        signInPage.createNewAccount();
        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setFirstName(fakeFirstName);
//        signInPage.firstNameInput(fakeFirstName);
//        signInPage.lastNameInput(fakeLastName);
//        personalInformation.setLastName(fakeLastName);
        signInPage.passwordInput(fakePassword);
//        personalInformation.setPassword(fakePassword);
        personalInformation.setDayOfBirth(DayOfBirth.FIVE);
        personalInformation.setMonthOfBirth(MonthOfBirth.APRIL);
        personalInformation.setYearOfBirth(YearOfBirth.Y1990);
        Address address = new Address();
        address.setAddressLine1(fakeAddress);
        address.setCity(fakeCity);
        address.setState(State.CALIFORNIA);
        address.setPostalCode(fakeZip);
        address.setCountry(Country.UNITED_STATES);
        address.setMobilePhone(fakePhone);
        address.setAddressAlias(fakeAlias);
        signInPage.clickOnRegisterButton();
    }
}
