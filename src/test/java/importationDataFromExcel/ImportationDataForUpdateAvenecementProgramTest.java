package importationDataFromExcel;

import config.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImportationDataForUpdateAvenecementProgramTest extends BaseTest {





    @Test
    public  void importDataAvencementProgramUpdate(){

        driver.get(url);


        WebElement linkNavigateToPageGenerateEmplois = await(By.xpath("//a[@href='/administrateur/generer-emplois-du-temps']"));

        linkNavigateToPageGenerateEmplois.click();


        var urlFileTest = getFilePathForTestFiles("AvancementProgramme_updated.xlsx");
        var fileInput =  driver.findElement(By.id("importData")) ;

        fileInput.sendKeys(urlFileTest) ;


        WebElement divMessage =  await(By.cssSelector(".message-success"));

        // System.out.println(divMessage.getText());

        assertEquals(divMessage.getText(),"succès la importation des données");
    }


}
