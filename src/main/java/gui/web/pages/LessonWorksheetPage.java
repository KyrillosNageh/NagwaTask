package gui.web.pages;

import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.ReportManager;
import io.qameta.allure.Step;

public class LessonWorksheetPage {


	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	SHAFT.GUI.WebDriver  driver;

	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public LessonWorksheetPage (SHAFT.GUI.WebDriver  driver)
	{
		this.driver =driver;
	}
	

	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
	
	private static By Questions_list()
	{
		return By.className("one-part-question");
	}
	
	private static By LessonWorksheetPageTitle()
	{
		return By.xpath("//*[@class='page-title with-cta'] ");
	}
	
	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
	
	/**
	 * Count number of questions displayed on Work sheet Page and display it on the SHAFT Report.
	 * @return
	 * a self-reference to be used to chain actions
	 */
	@Step("Count number of questions displayed on Worksheet Page.")
	public LessonWorksheetPage countNumberOfQuestion()
	{

		ReportManager.log("The count of questions are"+
		driver.element()
		.getElementsCount(Questions_list())+ " questions");		
		
		return this;
	}
	
	/**
	 * Verify the title of Lesson Work sheet Page.
	 * @return
	 * a self-reference to be used to chain actions
	 */
	@Step("Verify that the Lesson Worksheet Page.")
	public LessonWorksheetPage validateLessonWorksheetPage()
	{

		driver.verifyThat()
		.element(LessonWorksheetPageTitle())
		.text()
		.contains("Lesson Worksheet")
		.perform();
		
		driver.browser()
		.assertThat()
		.title()
		.contains("Lesson Worksheet")
		.perform();
		
		
		return this;
	}
	


	
	
	
}
