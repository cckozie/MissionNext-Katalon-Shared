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
import com.kms.katalon.core.configuration.RunConfiguration
import java.io.File

page = 'Register'

filePath = WebUI.callTestCase(findTestCase('_functions/Get Output Directory'), [:], FailureHandling.STOP_ON_FAILURE)

baseName = filePath + 'Journey Sender_'

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://journey.explorenext.org/signup/organization')

WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : page], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://journey.explorenext.org/journey-home/login-here/')

WebUI.setText(findTestObject('Screenshots/Journey Sender/input_Username'), 'cktest02jp')

WebUI.setEncryptedText(findTestObject('Screenshots/Journey Sender/input_Password'), 'J+U8o5fvtGfb5LDZyGLqyg==')

WebUI.click(findTestObject('Screenshots/Journey Sender/button_Log In'))

WebUI.click(findTestObject('Object Repository/Screenshots/Journey Sender/a_My Profile'))

tabs = ['Contact Information', 'Organization Info', 'Service Options', 'Readiness', 'Ministry Prefs', 'IT Positions', 'Match Filters',
	 'Recruiting Countries']

for (def tab : tabs) {

	WebUI.click(findTestObject('Screenshots/Journey Sender/a_' + tab))
	
	if(tab == 'Organization Info') {
		
				WebUI.scrollToElement(findTestObject('Object Repository/Screenshots/Journey Sender/input_Hide Listing'),2)
				WebUI.delay(1)
				WebUI.click(findTestObject('Object Repository/Screenshots/Journey Sender/input_Hide Listing'))
				
				
	} else	if(tab == 'Service Options') {
		
				WebUI.scrollToElement(findTestObject('Object Repository/Screenshots/Journey Sender/input_Awareness Trip'),2)
				WebUI.delay(1)
				WebUI.click(findTestObject('Object Repository/Screenshots/Journey Sender/input_Awareness Trip'))
				
				WebUI.click(findTestObject('Object Repository/Screenshots/Journey Sender/input_Vision Trip'))
				
				WebUI.scrollToElement(findTestObject('Object Repository/Screenshots/Journey Sender/input_Need Candidates for Short-Term Assignments'),2)
				WebUI.delay(1)
				WebUI.click(findTestObject('Object Repository/Screenshots/Journey Sender/input_Need Candidates for Short-Term Assignments'))
	}
	
	WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : tab], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.scrollToPosition(0, 0)
	
	WebUI.delay(1)
	
}

WebUI.closeBrowser()
