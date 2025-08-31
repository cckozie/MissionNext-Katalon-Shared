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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.io.File as File

page = 'Register'

filePath = WebUI.callTestCase(findTestCase('_functions/Get Output Directory'), [:], FailureHandling.STOP_ON_FAILURE)

baseName = (filePath + 'Journey Goer_')

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://journey.missionnext.org/signup/candidate')

WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : page], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://journey.missionnext.org/login-here/')

WebUI.setText(findTestObject('Screenshots/Journey Goer/input_Username'), 'cktest15jc')

WebUI.setEncryptedText(findTestObject('Screenshots/Journey Goer/input_Password'), 'gnYzEwUXvDp+5uGLsmRWLQ==')

WebUI.click(findTestObject('Screenshots/Journey Goer/button_Log In'))

tabs = ['Contact Info', 'Experience', 'Situation', 'Availability', 'ServiceComment', 'Your Ministry Prefs', 'IT Skills and Interest'
    , 'Spouse Info', 'Spouse Experience', 'Spouse Ministry Prefs']

WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : 'Dashboard'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Screenshots/Journey Goer/a_My Profile'))

for (def tab : tabs) {
    WebUI.click(findTestObject('Screenshots/Journey Goer/a_' + tab))

    if (tab == 'Contact Info') {
        WebUI.scrollToElement(findTestObject('Object Repository/Screenshots/Journey Goer/select_Marital Status'), 2)

        WebUI.delay(1)

        WebUI.selectOptionByValue(findTestObject('Object Repository/Screenshots/Journey Goer/select_Marital Status'), 'Married', 
            false)
    }
    
    if (tab == 'Spouse Info') {
        WebUI.scrollToElement(findTestObject('Object Repository/Screenshots/Journey Goer/input_Spouse Serving with You Yes'), 
            2)

        WebUI.delay(1)

        WebUI.click(findTestObject('Object Repository/Screenshots/Journey Goer/input_Spouse Serving with You Yes'))
    }
    
    if (tab == 'Experience') {
        WebUI.scrollToElement(findTestObject('Object Repository/Screenshots/Journey Goer/input_IT Professional'), 2)

        WebUI.delay(1)

		checked = WebUI.verifyElementChecked(findTestObject('Object Repository/Screenshots/Journey Goer/input_IT Professional'), 1, FailureHandling.OPTIONAL)
		
		if(!checked) {
			WebUI.click(findTestObject('Object Repository/Screenshots/Journey Goer/input_IT Professional'))
		}
		
    } else if (tab == 'Availability') {
        WebUI.scrollToElement(findTestObject('Object Repository/Screenshots/Journey Goer/input_Interested in Short-Term'), 
            2)

        WebUI.delay(1)

        WebUI.click(findTestObject('Object Repository/Screenshots/Journey Goer/input_Interested in Short-Term'))
    }
    
	WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : tab], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.scrollToPosition(0, 0)
	
	WebUI.delay(1)

}

WebUI.closeBrowser()

