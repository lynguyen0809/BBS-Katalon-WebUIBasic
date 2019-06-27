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

'Go to https://the-internet.herokuapp.com/'
WebUI.callTestCase(findTestCase('Common/OpenBrowser'), [('_url') : GlobalVariable._URL], FailureHandling.STOP_ON_FAILURE)

'Select Checkboxes link'
WebUI.click(findTestObject('Page_The Internet/lnk_Checkboxes', [('variable') : '']))

'Verify Checkboxe header title is displayed'
WebUI.callTestCase(findTestCase('Common/VerifyHeaderTitle'), [('_headerTitle') : _expectedTitle], FailureHandling.STOP_ON_FAILURE)

'Check checkbox 1'
WebUI.check(findTestObject('Page_Checkboxes/chx_Checkbox1'))

'Check checkbox 2'
WebUI.uncheck(findTestObject('Page_Checkboxes/chx_Checkbox2'))

'Verify checkbox 1 is checked'
WebUI.verifyElementChecked(findTestObject('Page_Checkboxes/chx_Checkbox1'), GlobalVariable._waitTime)

'Verify checkbox 2 is unchecked'
WebUI.verifyElementNotChecked(findTestObject('Page_Checkboxes/chx_Checkbox2'), GlobalVariable._waitTime)

'Close browser'
WebUI.closeBrowser()

