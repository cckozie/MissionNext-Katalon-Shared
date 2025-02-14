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
import javax.swing.JFileChooser as JFileChooser


WebUI.callTestCase(findTestCase('Screenshots/Set Output Direcrory'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Screenshots/Screenshot Journey Candidate'), [('username') : 'journeygoer', ('password') : '/nK6CFRRtKWw0ZraeJTNLl4bTNnkuDBl'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Screenshots/Screenshot Journey Partner'), [('username') : 'journeysender', ('password') : 'itMzMsgfgQES6zgv0qx7M+dDgGsBTCK3lpXlFXnGUZs='], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Screenshots/Screenshot Education Candidate'), [('username') : 'educationgoer', ('password') : 'gHe6FL13cR4M63sn3ZdrY4/KGeFIevaF0VJKdXFkcuo='], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Screenshots/Screenshot Education Partner'), [('username') : 'educationpartner', ('password') : 'gHe6FL13cR6NdLboeW5318EiU5tl+s1pcQlqBBWI0+I='], 
    FailureHandling.STOP_ON_FAILURE)

