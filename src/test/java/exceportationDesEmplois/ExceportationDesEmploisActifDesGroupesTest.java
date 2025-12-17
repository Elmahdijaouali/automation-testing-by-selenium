package exceportationDesEmplois;

import config.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static org.junit.jupiter.api.Assertions.*;

public class ExceportationDesEmploisActifDesGroupesTest extends BaseTest {



    @Test
    public void exceportationDesEmploisActifDesGroupes()
    {
        driver.get(url);

        WebElement btnDownload = await(By.xpath("//button[@id='btn-download-emplois-groupes']"));

        btnDownload.click();



        WebElement btnDownloadInPopup = await(By.xpath("//button[@id='popup-btn-download']")) ;
        btnDownloadInPopup.click();



        WebElement divMessage =  await(By.cssSelector(".message-success") , 120 ) ;

       // System.out.println(divMessage.getText());

        assertEquals("Les emplois du temps des groupes ont été téléchargés avec succès."  , divMessage.getText());
    }


}
