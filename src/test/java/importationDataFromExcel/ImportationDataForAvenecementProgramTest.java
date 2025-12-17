package importationDataFromExcel;

import config.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImportationDataForAvenecementProgramTest  extends BaseTest {




    @Test
    public  void importDataAvencementProgram(){
        driver.get(url);

        WebElement linkNavigateToPageGenerateEmplois = await(By.xpath("//a[@href='/administrateur/generer-emplois-du-temps']"));

        linkNavigateToPageGenerateEmplois.click();

        var urlFileTest = getFilePathForTestFiles("AvancementProgramme.xlsx");
        var fileInput =  driver.findElement(By.id("importData")) ;

        fileInput.sendKeys(urlFileTest) ;



        WebElement divMessage = await(By.cssSelector(".message-success"));

        // System.out.println(divMessage.getText());

        assertEquals(divMessage.getText(),"succès la importation des données");

    }


    @Test
    public  void errorImportDataAvencementProgram(){
        driver.get(url);


        WebElement linkNavigateToPageGenerateEmplois = await(By.xpath("//a[@href='/administrateur/generer-emplois-du-temps']"));

        linkNavigateToPageGenerateEmplois.click();

        var urlFileTest = getFilePathForTestFiles("formateurs_avec_des_salle.xlsx");
        var fileInput =  driver.findElement(By.id("importData")) ;

        fileInput.sendKeys(urlFileTest) ;



        WebElement divMessage =  await(By.cssSelector(".message-error"));

        // System.out.println(divMessage.getText());

        assertEquals(divMessage.getText(),"Veuillez choisir un fichier correct !");

    }



}
