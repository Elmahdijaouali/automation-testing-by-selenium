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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateLesEmploisDuTempsDesFormateursEnAnneeTest extends BaseTest {


    @Test
    public void generateDesEmploisDuTempsDesFormateursEnAnnee() throws InterruptedException {


        driver.get(url);


        WebElement linkNavigateToPageGenerateEmplois = await( By.xpath("//a[@href='/administrateur/parameters']")) ;


        linkNavigateToPageGenerateEmplois.click();



        WebElement el = await( By.xpath("//button[@title='Générer automatiquement les emplois du temps']"))  ;


        el.click();



        WebElement divMessage =   await(By.cssSelector(".message-success") , 60) ;

        assertEquals(divMessage.getText(),"succès générer les emplois du temps des formateurs");

    }




}
