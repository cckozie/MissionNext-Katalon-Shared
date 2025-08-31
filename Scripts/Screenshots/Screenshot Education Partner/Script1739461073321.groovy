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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration
import java.io.File

page = 'Register'

filePath = WebUI.callTestCase(findTestCase('_functions/Get Output Directory'), [:], FailureHandling.STOP_ON_FAILURE)

baseName = filePath + 'Education Sender_'

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://education.missionnext.org/signup/organization')

WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : page], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://education.missionnext.org/education-home/login-here/')

WebUI.setText(findTestObject('Screenshots/Education Goer/input_Username'), 'cktest16ep')

WebUI.setEncryptedText(findTestObject('Screenshots/Education Goer/input_Password'), '+U8cizQtaJJPakb6Fbbuqw==')

WebUI.click(findTestObject('Screenshots/Education Goer/button_Log In'))

WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : 'Dashboard'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Screenshots/Education Sender/a_My Profile'))

tabs = ['Contact Info', 'School Info', 'Positions Needed', 'Service Options', 'Readiness', 'Match Filters', 
	'Recruiting Countries', 'Admin Info']

for (def tab : tabs) {

	WebUI.click(findTestObject('Screenshots/Education Sender/a_' + tab))
	
	if(tab == 'School Info') {

		WebUI.scrollToElement(findTestObject('Object Repository/Screenshots/Education Sender/input_Vision Trip'),2)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Screenshots/Education Sender/input_Vision Trip'))
		WebUI.scrollToElement(findTestObject('Object Repository/Screenshots/Education Sender/input_Hide Listing'),2)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/Screenshots/Education Sender/input_Hide Listing'))
	}
		
	WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : tab], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.scrollToPosition(0, 0)
	
	WebUI.delay(1)
}

WebUI.closeBrowser()