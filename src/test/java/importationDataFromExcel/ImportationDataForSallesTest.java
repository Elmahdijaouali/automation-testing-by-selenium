package importationDataFromExcel;

import config.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;



public class ImportationDataForSallesTest extends BaseTest {


    @Test
    public void errorImportDataLesSalles(){
        driver.get(url);


        WebElement linkNavigateToPageGenerateEmplois =  await(By.xpath("//a[@href='/administrateur/salles']"));

        linkNavigateToPageGenerateEmplois.click();

        var urlFileTest = "/home/enigma/projects/Timetable-Generator/datatest/AvancementProgramme.xlsx";

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement fileInput =  driver.findElement(By.id("file")) ;

        fileInput.sendKeys(urlFileTest) ;

        // System.out.println(driver.getTitle() );;

        WebElement divMessage = await(By.cssSelector(".message-error"));

        //  System.out.println(divMessage.getText());

        assertEquals("Erreur lors de l'importation des salles" , divMessage.getText());

    }

    @Test
    public void importDataLesSalles(){

        driver.get(url);

        WebElement linkNavigateToPageGenerateEmplois = await(By.xpath("//a[@href='/administrateur/salles']"));
        linkNavigateToPageGenerateEmplois.click();

        String urlFileTest = "/home/enigma/projects/Timetable-Generator/datatest/formateurs_avec_des_salle.xlsx";

        WebElement fileInput =  driver.findElement(By.id("file")) ;

        fileInput.sendKeys(urlFileTest) ;


        WebElement divMessage = await(By.cssSelector(".message-success"));

     //   System.out.println(divMessage.getText());

        assertEquals("Importation terminée avec succès." , divMessage.getText());

    }




}
