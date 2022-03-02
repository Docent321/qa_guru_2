import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class FirstTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");

        //Проверка, что попал на нужную форму
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        //Заполнение формы
        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Donsk");
        $("#userEmail").setValue("Alex85@mmail.com");
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__year-select").selectOptionByValue("1980");
        $(".react-datepicker__day--025").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("ava.jpg");
        $("#currentAddress").setValue("Moskov");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();


        //Проверка правильности заполнения
        $(".table-responsive").shouldHave(text("Anton Donsk"));
        $(".table-responsive").shouldHave(text("Alex85@mmail.com"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("25 may,1980"));
        $(".table-responsive").shouldHave(text("Physics"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("ava.jpg"));
        $(".table-responsive").shouldHave(text("Moskov"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));



    }
}
