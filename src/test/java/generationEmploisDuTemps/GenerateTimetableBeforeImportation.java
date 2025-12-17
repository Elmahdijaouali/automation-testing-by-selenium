package generationEmploisDuTemps;

import config.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateTimetableBeforeImportation extends BaseTest {

    @Test
    public  void  tryGenerateEmploisDuTempsDesFormateursEnAnneeBeforeImportDataSalles()  {

        driver.get(url);



        WebElement linkNavigateToPageGenerateEmplois =  await(By.xpath("//a[@href='/administrateur/parameters']"));

        linkNavigateToPageGenerateEmplois.click();



        WebElement el = await(By.xpath("//button[@title='Générer automatiquement les emplois du temps']")) ;

        el.click();



        WebElement h1Error = await(By.cssSelector(".error"));

       // System.out.println(h1Error.getText());


    }


    @Test
    public void tryGenerateLesEmploisDuTempsDesGroupesBeforeImportationAvencementProgram() {


        driver.get(url);



        WebElement linkNavigateToPageGenerateEmplois =  await(By.xpath("//a[@href='/administrateur/generer-emplois-du-temps']"));

        linkNavigateToPageGenerateEmplois.click();

        WebElement inputDate = await(By.xpath("//input[@id='input-valid-a-partir']"));

        LocalDate today = LocalDate.now() ;
        today.format(DateTimeFormatter.ISO_LOCAL_DATE);
        inputDate.sendKeys(today.toString());

        WebElement el = await(By.xpath("//div[@title='generate-emplois-du-temps-des-groupes']")) ;

        el.click();



        WebElement h1Error = await(By.cssSelector(".error")) ;


       assertTrue(h1Error.getText().contains("Erreur"));

    }




}
