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
import javax.swing.JFileChooser
import javax.swing.JFrame;
import com.kms.katalon.core.configuration.RunConfiguration
import java.io.File
//import java.io.*

//Get the last stored path for the output files
myFile = new File(RunConfiguration.getProjectDir() + '/Data Files/files_path.txt')

filePath = myFile.text

myPath = ''

//Prompt for new path
JFrame frame = new JFrame();
frame.setAlwaysOnTop(true);
frame.setSize(600, 400);
println(filePath)
JFileChooser fileSelect = new JFileChooser((filePath));
fileSelect.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
fileSelect.setAcceptAllFileFilterUsed(false);
int returnVal = fileSelect.showOpenDialog(frame);
if (returnVal == JFileChooser.APPROVE_OPTION) {
	File file = fileSelect.getSelectedFile()
	myPath = file.getAbsolutePath() + '/'
}
frame.dispose();

if(myPath != '' && myPath != filePath) {
	myFile.write(myPath)
}
