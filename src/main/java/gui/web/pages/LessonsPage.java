package gui.web.pages;

import org.openqa.selenium.By;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;

public class LessonsPage {
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	SHAFT.GUI.WebDriver  driver;

	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public LessonsPage (SHAFT.GUI.WebDriver  driver)
	{
		this.driver =driver;
	}

	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
	
	private static By lessonWorksheet()
	{
		return By.className("question-preview");
	}
	
	private static By LessonPageTitle()
	{
		return By.xpath("//*[@class='page-title with-badge flex'] ");
	}
	
	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
	
	/**
	 * Verify Navigation to the lesson page and its title.
	 * @return
	 * a self-reference to be used to chain actions
	 */
	@Step("Verify that the Lesson Page.")
	public LessonsPage validateLessonPage()
	{

		driver.verifyThat()
		.element(LessonPageTitle())
		.text()
		.contains("Lesson")
		.perform();
		
		driver.browser()
		.assertThat()
		.title()
		.contains("Lesson")
		.perform();
		
		
		return this;
	}
	
	/**
	 * Click on work sheet section 
	 * @return
	 * navigate to the lesson work sheet page.
	 */
	@Step("Go to worksheet section then click preview button.")
	public LessonWorksheetPage  ClickOnWorksheetSection()
	{

		driver.element()
		.hover(lessonWorksheet())
		.and()
		.click(lessonWorksheet());
		
		return new LessonWorksheetPage(driver);
	}

}
