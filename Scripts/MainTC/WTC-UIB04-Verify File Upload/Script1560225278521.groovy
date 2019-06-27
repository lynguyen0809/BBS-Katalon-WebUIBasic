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

WebUI.click(findTestObject('Page_The Internet/lnk_File Upload'))

WebUI.callTestCase(findTestCase('Common/VerifyHeaderTitle'), [('_headerTitle') : _headerTitle], FailureHandling.STOP_ON_FAILURE)

WebUI.uploadFile(findTestObject('Page_FileUpload/btn_ChooseFile'), _imgPath)

WebUI.click(findTestObject('Page_FileUpload/btn_Upload'))

WebUI.callTestCase(findTestCase('Common/VerifyHeaderTitle'), [('_headerTitle') : _headerResult], FailureHandling.STOP_ON_FAILURE)

_uploadedImage = WebUI.getText(findTestObject('Page_FileUpload/lbl_UploadedResult'))

WebUI.verifyMatch(_uploadedImage, _imgName, false)

WebUI.closeBrowser()

