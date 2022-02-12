

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

    String
            firstName = "Alex",
            lastName = "Egorov",
            email = "alex@egorov.com",
            userNumber = "1231231230",
            day = "30",
            month = "July",
            year = "2008",
            userGender = "Other",
            subjects = "Math",
            hobbies = "Sports",
            loadPicture = "ava.jpg",
            address = "Some address 1",
            state = "NCR",
            City = "Delhi";


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
                .setBirthDat(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .loadPicture(loadPicture)
                .setAddress(address)
                .setState(state)
                .setCity(City)
                .submitClick();



        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationPage
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", email)
                .checkForm("Gender", userGender);
    }
}
