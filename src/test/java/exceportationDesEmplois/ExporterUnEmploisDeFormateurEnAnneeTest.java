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

public class ExporterUnEmploisDeFormateurEnAnneeTest extends BaseTest {


    @Test
    public void exportUnEmploisDeFormateurEnAnnee()
    {


        driver.get(url);


        WebElement linkNavigateToParamter = await(By.xpath("//a[@href=\"/administrateur/parameters\"]") , 20 );

        linkNavigateToParamter.click();




        WebElement linkNavigateToListEmploisFormateurEnAnnee = await(By.xpath("//a[@href='/administrateur/parameters/liste-emplois-du-temps-en-annee']"));

        linkNavigateToListEmploisFormateurEnAnnee.click();



        WebElement navigateToEmploi = await(By.className("navigate-to-display-emploi-formateur-en-annee"));

        navigateToEmploi.click();




        WebElement btnDownload = await(By.xpath("//button[@id='btn-download-emplois-formateur-en-annee']"));

        btnDownload.click();



        WebElement btnDownloadInPopup = await(By.xpath("//button[@id='popup-btn-download']")) ;
        btnDownloadInPopup.click();



        WebElement divMessage = await(By.cssSelector(".message-success")) ;

        // System.out.println(divMessage.getText());

        assertEquals("L'emploi du temps annuel du formateur a été téléchargé avec succès !"  , divMessage.getText());

    }


}
