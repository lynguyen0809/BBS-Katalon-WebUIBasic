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

'Select Dropdown link'
WebUI.click(findTestObject('Page_The Internet/lnk_Dropdown'))

'Verify Dropdown List header title is displayed'
WebUI.verifyElementPresent(findTestObject('Page_Dropdown/lbl_HeaderTitle'), 2)

'Select item by label Option 2'
WebUI.selectOptionByLabel(findTestObject('Page_Dropdown/lst_DropdownList'), _lblOption2, false)

'Verify The current item is Option 2'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_Dropdown/lst_DropdownList'), _lblOption2, false, 0)

'Select item by index 1'
WebUI.selectOptionByIndex(findTestObject('Page_Dropdown/lst_DropdownList'), _index1)

'Verify The current item is Option 1'
WebUI.verifyOptionSelectedByIndex(findTestObject('Page_Dropdown/lst_DropdownList'), _index1, 0)

'Select item by index 2'
WebUI.selectOptionByIndex(findTestObject('Page_Dropdown/lst_DropdownList'), _index2)

'Verify The current item is Option 2'
WebUI.verifyOptionSelectedByIndex(findTestObject('Page_Dropdown/lst_DropdownList'), _index2, 0)

'Close browser'
WebUI.closeBrowser()

