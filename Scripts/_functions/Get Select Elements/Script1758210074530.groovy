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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By

fileBase = varBaseName

page = varPage

selectLists = [:]

WebDriver driver = DriverFactory.getWebDriver()

selectElements = driver.findElements(By.tagName("select"));

println(selectElements.size() + 'select lists found')

displayedLists = []

selectElements.each {
	if(it.isDisplayed()) {
		displayedLists.add(it)
	}
}

println(displayedLists.size() + 'displayed lists found')

if(displayedLists.size() > 0) {
	
	displayedLists.each {
//	for(it in displayedLists) {
		
		if (it.isDisplayed()) {
		
			options = []
			
			parent = it.findElement(By.xpath("./.."))
			
			preceding = parent.findElement(By.xpath("preceding-sibling::*[1]"))
			
			label = preceding.getText().replace('*', '')
			
			Select select = new Select(it);
			
			List<WebElement> optionList = select.getOptions();
			
			optionList.each {
				
				options.add(it.getText())
			}
			
			selectLists.put(label,options)
			println(options)
		}
		
		file = (fileBase + page + '_Select Lists.csv')
		
		outFile = new File(file)
		
		outText = 'FIELD LABEL' + ',' + 'OPTIONS' + '\n\n'
		
		outFile.write(outText)
		
		for(list in selectLists) {
			
			optionsString = ''
			
			label = '"' + list.key + '"'
			
			options = list.value
			
			options.each {
				if(it.contains(',')) {
					it = '"'  + it + '"'
				}
				optionsString = optionsString + it + ','
			}
			
			outText = label + ',' + optionsString.substring(0, optionsString.length() - 1)
			
			println(outText) 
			
			outFile.append(outText + '\n')
		}
	}
}