package generationEmploisDuTemps;

import config.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateEmploisDuTempsDesGroupesTest extends BaseTest {

    @Test
    public void generateLesEmploisDuTempsDesGroupes() {


        driver.get(url);


        WebElement linkNavigateToPageGenerateEmplois = await(By.xpath("//a[@href='/administrateur/generer-emplois-du-temps']")) ;

        linkNavigateToPageGenerateEmplois.click();

        WebElement inputDate = await(By.xpath("//input[@id='input-valid-a-partir']")) ;

        LocalDate today = LocalDate.now() ;
               today.format(DateTimeFormatter.ISO_LOCAL_DATE);
        inputDate.sendKeys(today.toString());

        WebElement el = await(By.xpath("//div[@title='generate-emplois-du-temps-des-groupes']")) ;

        el.click();



        WebElement divMessage = await(By.cssSelector(".message-success") , 120) ;

       // System.out.println(divMessage.getText());

        assertTrue(divMessage.getText().contains("Enhanced timetable generation completed successfully"));

    }

    @Test
    public void errorEmptyInputDateBeforeGenerate() {

        driver.get(url);



        WebElement linkNavigateToPageGenerateEmplois = await(By.xpath("//a[@href='/administrateur/generer-emplois-du-temps']")) ;

        linkNavigateToPageGenerateEmplois.click();


        WebElement el = await(By.xpath("//div[@title='generate-emplois-du-temps-des-groupes']"));

        el.click();



        WebElement divMessage = await(By.cssSelector(".message-error")) ;


        assertEquals(divMessage.getText(),"valide_a_partir_de is required.");

    }



}
