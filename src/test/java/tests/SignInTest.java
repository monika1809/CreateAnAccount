package tests;

import com.github.javafaker.Faker;
import enums.*;
import model.Address;
import model.PersonalInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SignInPage;
import pages.TopMenuPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SignInTest extends BaseTest {
    private TopMenuPage topMenuPage;
    private SignInPage signInPage;

    private static Faker faker = new Faker();
    private String fakeEmail = faker.internet().emailAddress();
    private String fakeFirstName = faker.name().firstName();
    private String fakeLastName = faker.name().lastName();
    private String fakePassword = faker.lorem().characters(8);
    private String fakeAddress = faker.address().fullAddress();
    private String fakeCity = faker.country().capital();
    private Integer fakeZip = faker.random().nextInt(52356, 67845);
    private Integer fakePhone = faker.random().nextInt(78569855);
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

        assertThat(signInPage.isAlertDangerBoxRegisterAccountDisplayed()).isTrue();
    }

    @Test
    public void createNewAccountWithOnlyMandatoryFields() {
        topMenuPage.clickOnSignInLink();
        signInPage.enterEmail(fakeEmail);
        signInPage.createNewAccount();

        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setFirstName(fakeFirstName);
        personalInformation.setLastName(fakeLastName);
        personalInformation.setPassword(fakePassword);
        personalInformation.setDayOfBirth(DayOfBirth.FIVE);
        personalInformation.setMonthOfBirth(MonthOfBirth.APRIL);
        personalInformation.setYearOfBirth(YearOfBirth.Y1990);

        signInPage.sendPersonalInformation(personalInformation);

        Address address = new Address();
        address.setAddressLine1(fakeAddress);
        address.setCity(fakeCity);
        address.setState(State.CALIFORNIA);
        address.setPostalCode(fakeZip);
        address.setCountry(Country.UNITED_STATES);
        address.setMobilePhone(fakePhone);
        address.setAddressAlias(fakeAlias);

        signInPage.sendAddressInformation(address);
        signInPage.clickOnRegisterButton();

        assertThat(signInPage.isRegisterInfoAccountParagraphDisplayed()).isTrue();
    }
}
