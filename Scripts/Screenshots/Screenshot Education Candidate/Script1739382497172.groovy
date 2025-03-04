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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.io.File as File

page = 'Register'

filePath = WebUI.callTestCase(findTestCase('_functions/Get Output Directory'), [:], FailureHandling.STOP_ON_FAILURE)

baseName = (filePath + 'Education Goer_')

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://education.missionnext.org/signup/candidate')

WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : page], FailureHandling.STOP_ON_FAILURE)
	
WebUI.navigateToUrl('https://education.missionnext.org/education-home/login-here/')

WebUI.setText(findTestObject('Screenshots/Education Goer/input_Username'), username)

WebUI.setEncryptedText(findTestObject('Screenshots/Education Goer/input_Password'), password)

WebUI.click(findTestObject('Screenshots/Education Goer/button_Log In'))

tabs = ['Contact Info', 'Experience', 'Education', 'Situation', 'Availability', 'Preferences', 'OptionsComment', 'Spouse Info'
    , 'Spouse Experience', 'Spouse Service Prefs', 'Spouse Education', 'Spouse Teaching Prefs']

for (def tab : tabs) {
    WebUI.click(findTestObject('Screenshots/Education Goer/a_' + tab))

    if (tab == 'Contact Info') {
        WebUI.scrollToElement(findTestObject('Object Repository/Screenshots/Education Goer/select_Marital Status'), 2)

        WebUI.delay(1)

        WebUI.selectOptionByValue(findTestObject('Object Repository/Screenshots/Education Goer/select_Marital Status'), 
            'Married', false)
    }
    
    if (tab == 'Spouse Info') {
        WebUI.scrollToElement(findTestObject('Object Repository/Screenshots/Education Goer/input_Spouse Serving with You'), 
            2)

        WebUI.delay(1)

        WebUI.click(findTestObject('Object Repository/Screenshots/Education Goer/input_Spouse Serving with You'))
    }
    
    if (tab == 'Spouse Experience') {
        WebUI.scrollToElement(findTestObject('Object Repository/Screenshots/Education Goer/input_Spouse an Educator'), 2)

        WebUI.delay(1)

        WebUI.click(findTestObject('Object Repository/Screenshots/Education Goer/input_Spouse an Educator'))
    }
    
	WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : tab], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.scrollToPosition(0, 0)
	
	WebUI.delay(1)
}

WebUI.closeBrowser()

