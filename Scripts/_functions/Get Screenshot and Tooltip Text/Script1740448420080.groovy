import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import javax.swing.*;

frame = new JFrame("");
JPanel p = new JPanel();
JLabel l = new JLabel('Getting screenshot and tooltip text...', SwingConstants.CENTER);
frame.add(l);
frame.setSize(300, 100);
frame.setLocation(600, 0);
frame.setAlwaysOnTop (true)
frame.show();

fileBase = varFileBase

page = varPage

WebUI.takeFullPageScreenshot((fileBase + page) + '_Screenshot.png')

fieldTooltips = [:]

tooltipMap = [:]

WebDriver driver = DriverFactory.getWebDriver()

// Find all of the tooltips on the page
tooltips = driver.findElements(By.className('field-tooltip'))

// Get the tooltip locations
for(it in tooltips) {
	if (it.isDisplayed()) {
		ttText = it.getAttribute('data-original-title')
		
		ttLocation = it.getLocation()

		yLocation = ttLocation.getY()

		xLocation = ttLocation.getX()

		fieldTooltips.put(ttText, yLocation)
	}
}

// If tooltips were found, get all of the field labels that are left of the tooltip locations
if (fieldTooltips.size() > 0) {
	
	rightBorder = xLocation

	fieldLabels = [:]

	labels = driver.findElements(By.xpath('//label'))

	labels.each({
			label = it.getText().replace('*','')	//Strip off the required field indicator

			label = label.replace('?','')	//Strip off question marks

			labelLocation = it.getLocation()

			xLocation = labelLocation.getX()

			if (xLocation < rightBorder) {
				yLocation = labelLocation.getY()

				fieldLabels.put(label, yLocation)
			}
		})

//	Match up the tooltips with their associated field labels based on the field and toolip's y (vertical) location
	for (def label : fieldLabels) {
		
		y = label.value

		for (def tooltip : fieldTooltips) {
			
			if (((tooltip.value == y) || (tooltip.value == (y + 1))) || (tooltip.value == (y - 1))) {
				
				tooltipMap.put(label.key, tooltip.key)

				break
			}
		}
	}
}

// If there were tooltips on the page, write the fields and associated tooltips to a CSV file
if (tooltipMap.size() > 0) {
	
	file = (fileBase + page + '_Tooltips.csv')
	
	outText = 'FIELD LABEL' + ',' + 'TOOLTIP TEXT' + '\n\n'
	
	for(it in tooltipMap) {
		
		name = it.key
		
		it.value = it.value.replace('\n','') //Because some tooltips have lots of carriage returns

//		it.value = it.value.replace(",", "','") //Encapsulate commas in quotes for CSV
		
		it.value = '"' + it.value + '"'
		outText = outText + name + ',' + it.value
		outText = outText + '\n'
		println(outText)
	}

	outFile = new File(file)
	
	println(outText)

	outFile.write(outText)
}

frame.dispose()