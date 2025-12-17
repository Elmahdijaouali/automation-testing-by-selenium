package config;

import exceportationDesEmplois.*;
import generationEmploisDuTemps.GenerateEmploisDuTempsDesGroupesTest;
import generationEmploisDuTemps.GenerateLesEmploisDuTempsDesFormateursEnAnneeTest;
import generationEmploisDuTemps.GenerateTimetableBeforeImportation;
import importationDataFromExcel.ImportationDataForAvenecementProgramTest;
import importationDataFromExcel.ImportationDataForSallesTest;
import importationDataFromExcel.ImportationDataForUpdateAvenecementProgramTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import parameters.ReinitialisationLesDonneesTest;


@Suite
@SelectClasses({
        ReinitialisationLesDonneesTest.class,
        GenerateTimetableBeforeImportation.class ,
        ImportationDataForSallesTest.class ,
        ImportationDataForAvenecementProgramTest.class ,
        GenerateLesEmploisDuTempsDesFormateursEnAnneeTest.class  ,
        ImportationDataForUpdateAvenecementProgramTest.class ,
        GenerateEmploisDuTempsDesGroupesTest.class ,
        ExceportationDesEmploisDesFormateurEnAnneeTest.class  ,
        ExporterUnEmploisDeFormateurEnAnneeTest.class ,
        ExceportationDesEmploisActifDesGroupesTest.class ,
        ExceportationDesEmploisActifDesFormateursTest.class ,
        ExceportationDesEmploisActifDesSallesTest.class ,
        ExporterUnEmploisActifDeGroupeTest.class ,
        ExporterUnEmploisActifDeFormateurTest.class ,
        ExporterUnEmploisActifDeSalleTest.class ,

})


public class PrimaryTestSuite {

}
