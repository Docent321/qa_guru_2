package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage<userMailInput> {
    // components
    private CalendarComponent calendarComponent = new CalendarComponent();

    // locators
    private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable = $(".table-responsive"),
            userMailInput = $("#userEmail"),
            userNumberInput =  $("#userNumber"),
            userGenderClikc = $("#genterWrapper"),
            userjectsInput = $("#subjectsInput"),
            userHobbies = $("#hobbiesWrapper"),
            loadPicture = $("#uploadPicture"),
            useraddress =  $("#currentAddress");

    // actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage  setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setUserEmail(String email) {
        userMailInput.setValue(email);
        return this;
    }


    public RegistrationPage setUserNumber (String number) {
        userNumberInput.setValue(number);
        return this;
    }


    public RegistrationPage setSubjects(String subjects) {
        userjectsInput.setValue(subjects).pressEnter();
        return this;

    }


    public RegistrationPage setGender (String gender) {
        userGenderClikc.$(byText("Other")).click();
        return this;
    }

    public RegistrationPage setHobbies (String name) {
        userHobbies.$(byText("Sports")).click();
        return this;
    }

    public RegistrationPage loadPicture(String name) {
        loadPicture.uploadFromClasspath("ava.jpg");
        return this;
    }



    public  RegistrationPage setAddress (String name){
        useraddress.setValue("Some address 1");
        return this;
    }


    public void setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
    }



    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }
}