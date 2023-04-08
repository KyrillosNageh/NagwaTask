package gui.web.pages;

import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;

public class SearchPage {
	
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	SHAFT.GUI.WebDriver  driver;

	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public SearchPage (SHAFT.GUI.WebDriver  driver)
	{
		this.driver =driver;
	}
	

	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
	
	private static By searchResult_txt()
	{
		return By.xpath("//h1[contains(text(),'Search results')]");
	}
	
	private static By listSearchResult_txt(int index)
	{
		return By.xpath("//li["+ index +"] /div[@class='right'] /p ");
	}
	
	private static By CountSearchResult()
	{
		return By.xpath("//div[@class='right'] /p ");
	}
	
	private static By Lessons_Url(int index)
	{
		return By.xpath("//li["+ index +"] /div[@class='right'] /a ");
	}
	
	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
	
	/**
	 * Verify search result matches the search query where is a loop on the result to check if contains the search word.
	 * @param 
	 * searchQuery String word that was used for searching
	 * @return
	 * a self-reference to be used to chain actions
	 */
	@Step("Verify search result.")
	public SearchPage verifySearchResult(String searchQuery)
	{
		int count = driver.element()
				    .getElementsCount(CountSearchResult());
		
		for(int i=1; i<= count; i++) {
			driver.verifyThat()
			.element(listSearchResult_txt(i))
			.text()
			.contains(searchQuery)
			.withCustomReportMessage("Verify search result.")
			.perform();
		}
		
		return this;
	}
	
	/**
	 * Verify navigation to the search page.
	 * @return
	 * a self-reference to be used to chain actions
	 */
	@Step("Verify navigation to the search page.")
	public SearchPage verifyNavigationToSearchPage()
	{
		driver
		.verifyThat()
		.element(searchResult_txt())
		.exists()
		.perform();
		
		return this;
	}
	
	/**
	 * Click on selected a lesson by its index to open it.
	 * @param 
	 * index 
	 * @return
	 * navigate to the selected lesson
	 */
	@Step("Click on 2nd lesson in the search results to open its home page.")
	public LessonsPage ClickOnSelectedLessonInSearchResults(int index)
	{

		driver.element()
		.click(Lessons_Url(index));
		
		return new LessonsPage(driver);
	}

}
