package info.seleniumcucumber.methods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MouseManeuver extends SelectElementByType implements BaseTest{


	public void dragAndDrop(String accessTypeSource, String accessValueSource, String accessTypeTarget, String accessValueTarget)
	{
		final WebElement source = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessTypeSource, accessValueSource)));
		final WebElement target = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessTypeTarget, accessValueTarget)));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}

	public void dragAndDropWithOffset(String accessTypeSource, String accessValueSource, String accessTypeTarget, String accessValueTarget, int offsetX, int offsetY) {
		WebElement source = wait.until(ExpectedConditions.presenceOfElementLocated(this.getelementbytype(accessTypeSource, accessValueSource)));
		WebElement target = wait.until(ExpectedConditions.presenceOfElementLocated(this.getelementbytype(accessTypeTarget, accessValueTarget)));
		Actions action = new Actions(this.driver);
		action.clickAndHold(source).moveToElement(target, offsetX, offsetY).release().perform();
	}

	public void startDragging(String accessTypeSource, String accessValueSource){
		WebElement source = wait.until(ExpectedConditions.presenceOfElementLocated(this.getelementbytype(accessTypeSource, accessValueSource)));
		Actions action = new Actions(this.driver);
		action.clickAndHold(source).perform();
	}

	public void finishDragging(String accessTypeTarget, String accessValueTarget){
		WebElement target = wait.until(ExpectedConditions.presenceOfElementLocated(this.getelementbytype(accessTypeTarget, accessValueTarget)));
		Actions action = new Actions(this.driver);
		action.moveToElement(target).release().perform();
	}
}
