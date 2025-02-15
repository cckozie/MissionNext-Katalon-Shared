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

//Get the last stored path for the output files
filePath = ''

myFile = new File(RunConfiguration.getProjectDir() + '/Data Files/files_path.txt')

if(myFile.exists()) {
	filePath = myFile.text
}

if (filePath.length() < 5) {
	WebUI.callTestCase(findTestCase('Screenshots/Set Output Direcrory'), [:], FailureHandling.STOP_ON_FAILURE)
	WebUI.delay(5)
	myFile = new File(RunConfiguration.getProjectDir() + '/Data Files/files_path.txt')
	while(!myFile.exists()) {
		WebUI.delay(1)
	}
}

myNewFile = new File(RunConfiguration.getProjectDir() + '/Data Files/files_path.txt')

filePath = myNewFile.text

return filePath

