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

baseName = (filePath + 'Quickstart_')

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://quickstart.missionnext.org/signup/candidate')

WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : page], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('_functions/Get Select Elements'), [('varBaseName') : baseName, ('varPage') : page], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://quickstart.missionnext.org/quickstart-home/login-here/')

println(username)

println(password)

WebUI.setText(findTestObject('Screenshots/Quickstart Goer/input_Username'), username)

WebUI.setEncryptedText(findTestObject('Screenshots/Quickstart Goer/input_Password'), password)

WebUI.click(findTestObject('Screenshots/Quickstart Goer/button_Log In'))

WebUI.waitForPageLoad(10)

WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : 'Dashboard'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Screenshots/Quickstart Goer/a_My Profile'))

tabs = ['Name Preferences', 'Contact Info', 'Ministry Positions']

for (def tab : tabs) {
    WebUI.click(findTestObject('Screenshots/Quickstart Goer/a_' + tab))

    WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : tab], 
        FailureHandling.STOP_ON_FAILURE)

	WebUI.callTestCase(findTestCase('_functions/Get Select Elements'), [('varBaseName') : baseName, ('varPage') : tab], FailureHandling.STOP_ON_FAILURE)

    WebUI.scrollToPosition(0, 0)

    WebUI.delay(1)
}

links = ['My Opportunities']

for (def link : links) {
	
	WebUI.click(findTestObject('Screenshots/Quickstart Goer/a_' + link))
	
	WebUI.switchToWindowIndex(1)

    WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : link], 
        FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('_functions/Get Select Elements'), [('varBaseName') : baseName, ('varPage') : link], FailureHandling.STOP_ON_FAILURE)

	WebUI.closeWindowIndex(1)

}

WebUI.closeBrowser()


