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
import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import com.kms.katalon.core.configuration.RunConfiguration
import java.io.File

myFile = new File(RunConfiguration.getProjectDir() + '/Data Files/files_path.txt')

if(myFile.exists()) {
	println('exists')
} else {
	myFile.write('')
}
filePath = ''

Runnable r = new Runnable() {

	@Override
	public void run() {
		
		//Get the last stored path for the output files
		myFile = new File(RunConfiguration.getProjectDir() + '/Data Files/files_path.txt')
		filePath = myFile.text
		myPath = ''
		
		//Delete the file containing the path so that the calling program will wait for return
		myFile.delete()
		
		first = false
		//Launch file chooser
		JFileChooser jfc = new JFileChooser(filePath);
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if( jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION ){
			File file = jfc.getSelectedFile();
			myPath = file.getAbsolutePath() + '/'
			//Write new path to data file
			if(myPath != '' && myPath != filePath) {
				filePath = myPath
				myFile.write(filePath)
			}
		} else {
			//Write old path to data file
			println('cancel')
			myFile.write(filePath)
		}
	}
}
SwingUtilities.invokeLater(r);
