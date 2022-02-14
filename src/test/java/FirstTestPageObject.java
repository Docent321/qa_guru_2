

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
            lastName = "Donskov",
            email = "alex@mail.com",
            userNumber = "1231231231",
            day = "12",
            month = "July",
            year = "2001",
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
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .loadPicture(loadPicture)
                .setAddress(address)
                .setState(state)
                .setCity(City)
                .submitClick();




        registrationPage
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", email)
                .checkForm("Gender", userGender)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", day + " " + month + "," + year)
                .checkForm("Subjects", subjects)
                .checkForm("Hobbies", hobbies)
                .checkForm("Picture", loadPicture)
                .checkForm("Address", address)
                .checkForm("State and City", state + " " + City);
    }
}
