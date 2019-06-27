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

'Select Drag and Drop link'
WebUI.click(findTestObject('Page_The Internet/lnk_Drag and Drop'))

'Verify Drag and Drop header title is displayed'
WebUI.callTestCase(findTestCase('Common/VerifyHeaderTitle'), [('_headerTitle') : _expectedTitle], FailureHandling.STOP_ON_FAILURE)

'Drag and Drop column A to column B'
CustomKeywords.'html5.dnd.DragAndDropHelper.dragAndDrop'(findTestObject('Page_DragAndDrop/column_A'), findTestObject('Page_DragAndDrop/column_B'))

'Verify Column A changed to column B'
_columnA = WebUI.getText(findTestObject('Page_DragAndDrop/column_A'))

WebUI.verifyEqual(_columnA, 'B')

'Verify Column B changed to column A'
_columnB = WebUI.getText(findTestObject('Page_DragAndDrop/column_B'))

WebUI.verifyEqual(_columnB, 'A')

'Close browser'
WebUI.closeBrowser()

