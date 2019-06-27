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

WebUI.callTestCase(findTestCase('Common/OpenBrowser'), [('_url') : GlobalVariable._URL], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_The Internet/lnk_JavaScript Alerts'))

WebUI.callTestCase(findTestCase('Common/VerifyHeaderTitle'), [('_headerTitle') : _expectedTitle], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Alert/btn_Click for JS Alert'))

WebUI.verifyAlertPresent(3)

_currAlertMsg = WebUI.getAlertText()

WebUI.verifyMatch(_currAlertMsg, _expectedAlertMsg, false)

WebUI.acceptAlert()

WebUI.callTestCase(findTestCase('Common/VerifyResultMsg'), [('_expectedResultMsg') : _msgOKAlert], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Alert/btn_Click for JS Confirm'))

WebUI.dismissAlert()

WebUI.callTestCase(findTestCase('Common/VerifyResultMsg'), [('_expectedResultMsg') : _msgCancelAlert], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Alert/btn_Click for JS Prompt'))

WebUI.setAlertText(_enteredText)

WebUI.acceptAlert()

WebUI.callTestCase(findTestCase('Common/VerifyResultMsg'), [('_expectedResultMsg') : _msgEnteredAlert], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

