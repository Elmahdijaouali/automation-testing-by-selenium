package exceportationDesEmplois;

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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExporterUnEmploisActifDeFormateurTest extends BaseTest {

    @Test
    public void exporterUnEmploisActifDeFormateur()
    {

        driver.get(url);



        WebElement linkNavigateToPageGenerateEmplois = await(By.xpath("//a[@href='/administrateur/dashboard/emplois-du-temps-actif/formateurs']"));

        linkNavigateToPageGenerateEmplois.click();


        WebElement linkAfficher = await(By.className("navigate-to-display-emplois-formateur"));

        linkAfficher.click();



        WebElement btnDownload = await(By.xpath("//button[@id='btn-download-emplois-formateur']"));

        btnDownload.click();



        WebElement btnDownloadInPopup = await(By.xpath("//button[@id='popup-btn-download']")) ;
        btnDownloadInPopup.click();


        WebElement divMessage = await(By.cssSelector(".message-success") , 60) ;

      //  System.out.println(divMessage.getText());

        assertEquals("L'emploi du temps a été téléchargé avec succès !" , divMessage.getText());


    }



}
