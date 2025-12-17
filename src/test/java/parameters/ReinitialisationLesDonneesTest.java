package parameters;


import config.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReinitialisationLesDonneesTest extends BaseTest {

    @Test
    public void reinitialisationLesDonneesTest(){
        driver.get(url);


        WebElement linkNavigateToPageParamters = await( By.xpath("//a[@href='/administrateur/parameters']")) ;

        linkNavigateToPageParamters.click();


        WebElement reinitailisationDesDonnee =  await( By.id("reinitailisationDesDonnee")) ;
        reinitailisationDesDonnee.click();



        WebElement inputPassword =  await( By.id("resetPassword")) ;
        inputPassword.sendKeys(passwordAdmin);

        driver.findElement(By.id("confirm")).click();

        String message = await(By.cssSelector(".message-success")).getText();

        assertEquals("Base de données réinitialisée avec succès. Toutes les données ont été supprimées sauf les comptes administrateurs. Vous allez être redirigé vers la page de connexion dans 2 secondes." , message ); ;


    }
}
