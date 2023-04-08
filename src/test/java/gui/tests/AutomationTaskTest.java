package gui.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;

import gui.web.pages.HomePage;
import gui.web.pages.HomePage.Language;
import gui.web.pages.HomePage.PageTitle;

public class AutomationTaskTest {
	
	SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    
    @Test
    public void testScenario()
    {
    	new HomePage(driver)
		.navigate()
		.verifyLogoImageExsisting()
		.chooseLanguage(Language.العربية)
		.validateHomePageLanguage(PageTitle.نجوى)
		.chooseLanguage(Language.English)
		.clickOnSearchIcon()
		.verifySearchBoxExsisting()
		.search("arabic")
		.verifyNavigationToSearchPage()
		.verifySearchResult(testData.getTestData("searchQuery") )
		.ClickOnSelectedLessonInSearchResults(Integer.parseInt(testData.getTestData("SelectedLesson")))
		.validateLessonPage()
		.ClickOnWorksheetSection()
		.validateLessonWorksheetPage()
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
