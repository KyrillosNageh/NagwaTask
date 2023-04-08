package gui.web.pages;

import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;

public class HomePage {
	
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	SHAFT.GUI.WebDriver  driver;
	private final String home_URL= "https://www.nagwa.com/en/";
	
	public  enum Language {English,Español,Français,Português,العربية};
	public  enum PageTitle {Nagwa,نجوى};
	
	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public HomePage (SHAFT.GUI.WebDriver  driver)
	{
		this.driver =driver;
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
	private static By defaultLanguage()
	{
		return By.cssSelector(":nth-child(4) > [href=\"#\"] > span");
	}
	
	private static By languages_selector(Language languageEnum)
	{
		return By.xpath("//li[@class='dropdown open']  //ul  //*[text()='"+languageEnum+"']");
	}
	
	private static By search_icon()
	{
		return By.cssSelector("[type=\"button\"] > .search-icon");
	}
	
	private static By search_inTxt()
	{
		return By.id("txt_search_query");
	}
	
	private static By searchSubmit_btn()
	{
		return By.id("btn_global_search");
	}
	
	private static By logo_img()
	{
		return By.cssSelector(".container > .logo > a > img");
	}
	
	
	
	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
	
	/**
	 * Navigate to Nagwa home page URL.
	 * 
	 * @return
	 * a self-reference to be used to chain actions
	 */
	@Step("Navigate to Nagwa home page")
	public HomePage navigate()
	{
		driver.browser().navigateToURL(home_URL);
		return this;
	}
	
	/**
	 * Choose a language to open the home page with it.
	 * @param 
	 * languageEnum Select language from this list{English,Español,Français,Português,العربية}
	 * @return
	 * a self-reference to be used to chain actions
	 */
	@Step("Choose a language to open the home page.")
	public HomePage chooseLanguage(Language languageEnum)
	{
		driver.element()
		.click(defaultLanguage())
		.click(languages_selector(languageEnum));
		return this;
	}
	
	/**
	 * Click on search icon to open search box.
	 * @return
	 * a self-reference to be used to chain actions
	 */
	@Step("Use the search icon to start searching on Nagwa lessons.")
	public HomePage clickOnSearchIcon()
	{
		driver.element()
		.click(search_icon());
		
		return this;
	}
	
	/**
	 * Write any lesson name for example “arabic” then search.
	 * @param 
	 * keyword String word that is used for searching.
	 * @return
	 * navigate to search page.
	 */
	@Step("Write any lesson name for example “addition” then search.")
	public SearchPage search(String keyword)
	{
		driver.element()
		.type(search_inTxt(), keyword)
		.click(searchSubmit_btn());
		
		return new SearchPage(driver);
	}

	/**
	 * Verify logo image is existing and match the reference.
	 * @return
	 * a self-reference to be used to chain actions
	 */
	@Step("Verify logo image is existing.")
	public HomePage verifyLogoImageExsisting()
	{
		driver.assertThat()
		.element(logo_img())
		.matchesReferenceImage()
		.perform();
		
		return this;
		
	}
	
	/**
	 * Verify that the search box is visible.
	 * @return
	 * a self-reference to be used to chain actions
	 */
	@Step("Verify that the search box is present.")
	public HomePage verifySearchBoxExsisting()
	{
		driver.assertThat()
		.element(search_inTxt())
		.matchesReferenceImage()
		.perform();
		
		return this;
		
	}
	
	/**
	 * Verify Home page title language and logo exists
	 * @param title Select PageTitlr from this list {Nagwa,نجوى}
	 * @return
	 * a self-reference to be used to chain actions
	 */
	@Step("Validate the home page opened with the selected language.")
	public HomePage validateHomePageLanguage(PageTitle title)
	{
		driver.verifyThat()
		.element(logo_img())
		.isVisible()
		.perform();
		
		
		driver.verifyThat()
		.browser()
		.title()
		.isEqualTo(title)
		.perform();
		return this;
	}
}