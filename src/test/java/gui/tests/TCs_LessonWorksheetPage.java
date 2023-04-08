package gui.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.shaft.driver.SHAFT;
import gui.web.pages.HomePage;


public class TCs_LessonWorksheetPage {

	SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    
    @Test
    public void verifyLessonPageOpenedAnddisplayCountQuestions() {
    	new HomePage(driver)
		.navigate()
		.clickOnSearchIcon()
		.search( testData.getTestData("searchQuery") )
		.ClickOnSelectedLessonInSearchResults(Integer.parseInt(testData.getTestData("SelectedLesson")))
		.ClickOnWorksheetSection()
		.countNumberOfQuestion();
    }

    @BeforeClass
    public void beforeClass() {
       	driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("data.json");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        driver.quit();
   	}
}
