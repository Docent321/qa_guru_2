
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTestPageObject {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Alex";
    String lastName = "Egorov";
    String email = "alex@egorov.com";
    String userNumber = "1231231230";
    String userGender = "Other";
    String subjects = "Math";
    String hobbies = "Sports";
    String loadPicture = "ava.jpg";
    String address = "Some address 1";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setUserNumber(userNumber)
                .setGender(userGender)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .loadPicture(loadPicture)
                .setAddress(address)
                .setBirthDate("30", "July", "2008");


//        $("#currentAddress").setValue("Some address 1");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationPage
                .checkForm("Student Name", firstName + " Egorov")
                .checkForm("Student Email", "alex@egorov.com")
                .checkForm("Gender", "Other");
    }
}
