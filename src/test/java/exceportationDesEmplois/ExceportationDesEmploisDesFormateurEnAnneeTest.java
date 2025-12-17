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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExceportationDesEmploisDesFormateurEnAnneeTest extends BaseTest {


    @Test
    public void exceportationDesEmploisDesFormateurEnAnnee()
    {

        driver.get(url);



        WebElement linkNavigateToParamter =  await(By.xpath("//a[@href='/administrateur/parameters']"));

        linkNavigateToParamter.click();



        WebElement linkNavigateToListEmploisFormateurEnAnnee =  await(By.xpath("//a[@href='/administrateur/parameters/liste-emplois-du-temps-en-annee']"));

        linkNavigateToListEmploisFormateurEnAnnee.click();


        WebElement btnDownload = await(By.xpath("//button[@id='btn-download']"));

        btnDownload.click();




        WebElement btnDownloadInPopup = await(By.xpath("//button[@id='popup-btn-download']")) ;
        btnDownloadInPopup.click();



        WebElement divMessage =  await(By.cssSelector(".message-success") , 80) ;

        //System.out.println(divMessage.getText());

        assertEquals("Le téléchargement des emplois du temps a été effectué avec succès!" , divMessage.getText());


    }


}
