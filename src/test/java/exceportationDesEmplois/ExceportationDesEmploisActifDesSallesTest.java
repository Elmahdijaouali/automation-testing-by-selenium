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

public class ExceportationDesEmploisActifDesSallesTest extends BaseTest {



    @Test
    public void exceportationDesEmploisActifDesSalles()
    {
        driver.get(url);

        WebElement btnDownload = await(By.xpath("//button[@id='btn-download-emplois-salles']"));

        btnDownload.click();



        WebElement btnDownloadInPopup = await(By.xpath("//button[@id='popup-btn-download']")) ;
        btnDownloadInPopup.click();



        WebElement divMessage = await(By.cssSelector(".message-success") , 120 ) ;

        //System.out.println(divMessage.getText());

        assertEquals("Les emplois du temps des salles ont été téléchargés avec succès."  , divMessage.getText());


    }


}
