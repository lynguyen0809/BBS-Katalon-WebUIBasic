import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.testng.Assert as Assert
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.callTestCase(findTestCase('Common/OpenBrowser'), [('_url') : GlobalVariable._URL], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_The Internet/lnk_JQuery UI Menus'))

WebUI.callTestCase(findTestCase('Common/VerifyHeaderTitle'), [('_headerTitle') : _expectedTitle], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Page_JQueryMenu/opt_Enabled'))

WebUI.click(findTestObject('Page_JQueryMenu/opt_Enabled'))

WebUI.waitForElementVisible(findTestObject('Page_JQueryMenu/opt_Back to JQuery UI'), GlobalVariable._waitTime)

WebUI.click(findTestObject('Page_JQueryMenu/opt_Back to JQuery UI'))

WebUI.callTestCase(findTestCase('Common/VerifyHeaderTitle'), [('_headerTitle') : _UIHeaderTitle], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_JQueryMenu/lnk_Menu'))

WebUI.click(findTestObject('Page_JQueryMenu/opt_Enabled'))

WebUI.waitForElementVisible(findTestObject('Page_JQueryMenu/opt_Downloads'), GlobalVariable._waitTime)

WebUI.click(findTestObject('Page_JQueryMenu/opt_Downloads'))

WebUI.waitForElementVisible(findTestObject('Page_JQueryMenu/opt_CSV'), GlobalVariable._waitTime)

WebUI.click(findTestObject('Page_JQueryMenu/opt_CSV'))

WebUI.delay(GlobalVariable._waitTime)

'Define Custom Path where file needs to be downloaded'
String home = System.getProperty('user.home')

String downloadPath = new File(home + '/Downloads/')

CustomKeywords.'html5.dnd.VerifyDowloadFile.isFileDownloaded'(downloadPath, 'menu.csv')

