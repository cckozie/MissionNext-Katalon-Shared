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

ignoreList = ['Populate from']  //Ignore the Populate from (existing job) select list

page = 'Register'

filePath = WebUI.callTestCase(findTestCase('_functions/Get Output Directory'), [:], FailureHandling.STOP_ON_FAILURE)

baseName = filePath + 'Journey Sender_'

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://journey.missionnext.org/signup/organization')

WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : page], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('_functions/Get Select Elements'), [('varBaseName') : baseName, ('varPage') : page], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://journey.missionnext.org/journey-home/login-here/')

WebUI.setText(findTestObject('Screenshots/Journey Sender/input_Username'), 'cktest17jp')

WebUI.setEncryptedText(findTestObject('Screenshots/Journey Sender/input_Password'), '8DY9ST8qsuU3b2Raq+e+VQ==')

WebUI.click(findTestObject('Screenshots/Journey Sender/button_Log In'))

WebUI.click(findTestObject('Object Repository/Screenshots/Journey Sender/a_My Profile'))

WebUI.waitForPageLoad(10)

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
	
	WebUI.callTestCase(findTestCase('_functions/Get Select Elements'), [('varBaseName') : baseName, ('varPage') : tab], FailureHandling.STOP_ON_FAILURE)

	WebUI.scrollToPosition(0, 0)
	
	WebUI.delay(1)
	
}

WebUI.click(findTestObject('Object Repository/Screenshots/Journey Sender/a_Job Matches'))

WebUI.switchToWindowTitle('MissionNext: Jobs Section')

WebUI.click(findTestObject('Object Repository/Screenshots/Journey Sender/Jobs/button_Add Job'))

WebUI.switchToWindowIndex(2)

WebUI.click(findTestObject('Object Repository/Screenshots/Journey Sender/Jobs/checkbox_Need to See Specific IT Jobs'))

baseName = baseName + 'Job_'

tabs = ['Job Category', 'IT Job Category', 'Programming Languages', 'Job Classification', 'Assignment Detail', 'Job Description', 'Logistics',
	 'Contact Details', 'Other Criteria']

categories = ['BUSINESS AS MISSION', 'CHURCH DEVELOPMENT', 'COMMUNICATIONS', 'COMMUNITY DEVELOPMENT', 'CONSTRUCT/MAINTAIN', 'DISCIPLESHIP', 
	'DISCIPLE YOUTH', 'EDUCATION', 'ESL/TESOL', 'ENGINEERING', 'EVANGELISM', 'EVANGELISM SUPPORT', 'HEALTH CARE', 'INFORMATION TECHNOLOGY', 
	'JUSTICE/ADVOCACY', 'RELIEF AND DEVELOPMENT', 'RESOURCE MANAGEMENT', 'SUPPORT HELPS', 'SUPPORT PROFESSIONAL']

itCategories = ['TECHNICAL', 'IT ENGINEERING/ANALYST', 'ADMINISTRATOR',	'IT COMMUNICATIONS', 'CONTENT',	'DESIGNERS', 'DATABASE', 'MANAGEMENT',
	'SOCIAL MEDIA/MARKETING', 'WEB']

for (def tab : tabs) {
	
	WebUI.click(findTestObject('Screenshots/Journey Sender/Jobs/a_' + tab))
		
	WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : tab], FailureHandling.STOP_ON_FAILURE)
	
	WebUI.callTestCase(findTestCase('_functions/Get Select Elements'), [('varBaseName') : baseName, ('varPage') : tab, ('varIgnoreList') : ignoreList], FailureHandling.STOP_ON_FAILURE)

	if(tab == 'Job Category') {
		
		for(category in categories) {
			
			WebUI.selectOptionByValue(findTestObject('Object Repository/Screenshots/Journey Sender/Jobs/select_Journey Job Category'), category, false)
			
			category = category.replace('/', '\\')
			
			WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : tab + '_' + category], FailureHandling.STOP_ON_FAILURE)
		}
	
	}

	if(tab == 'IT Job Category') {
		
		for(itCategory in itCategories) {
			
			WebUI.selectOptionByValue(findTestObject('Object Repository/Screenshots/Journey Sender/Jobs/select_IT Job Category'), itCategory, false)
			
			itCategory = itCategory.replace('/', '\\')
			
			WebUI.callTestCase(findTestCase('_functions/Get Screenshot and Tooltip Text'), [('varFileBase') : baseName, ('varPage') : tab + '_' + itCategory], FailureHandling.STOP_ON_FAILURE)
		}
		
	}
	
	WebUI.scrollToPosition(0, 0)
}

//WebUI.closeBrowser()
