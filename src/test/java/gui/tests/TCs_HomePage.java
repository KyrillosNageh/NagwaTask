package gui.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.shaft.driver.SHAFT;

import gui.web.pages.HomePage;
import gui.web.pages.HomePage.Language;
import gui.web.pages.HomePage.PageTitle;;

public class TCs_HomePage {

	SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    
    @Test
    public void verifyCompanyLogo()
    {
    	new HomePage(driver)
		.navigate()
		.verifyLogoImageExsisting();
    }
    
    @Test
    public void verifyHomePageLanguage()
    {
    	new HomePage(driver)
		.navigate()
		.validateHomePageLanguage(PageTitle.Nagwa)
		.chooseLanguage(Language.العربية)
		.validateHomePageLanguage(PageTitle.نجوى)
		.chooseLanguage(Language.English);
    }
    
    @Test
    public void verifySearchBoxExsist()
    {
    	new HomePage(driver)
		.navigate()
		.clickOnSearchIcon()
		.verifySearchBoxExsisting();
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
