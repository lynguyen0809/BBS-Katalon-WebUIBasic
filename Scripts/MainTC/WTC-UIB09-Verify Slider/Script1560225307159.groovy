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
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Common/OpenBrowser'), [('_url') : GlobalVariable._URL], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_The Internet/lnk_Horizontal Slider'))

WebUI.callTestCase(findTestCase('Common/VerifyHeaderTitle'), [('_headerTitle') : _expectedTitle], FailureHandling.STOP_ON_FAILURE)

'Set slider to 1 and verify the current slider value is 1'
WebUI.callTestCase(findTestCase('Common/MoveSliderAndVerifyValue'), [('_expectedValue') : _sliderValue1], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/ResetSliderValue'), [:], FailureHandling.STOP_ON_FAILURE)

'Set slider to 2.5 and verify the current slider value is 2.5'
WebUI.callTestCase(findTestCase('Common/MoveSliderAndVerifyValue'), [('_expectedValue') : _sliderValue2], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/ResetSliderValue'), [:], FailureHandling.STOP_ON_FAILURE)

'Set slider to 4.5 and verify the current slider value is 4.5'
WebUI.callTestCase(findTestCase('Common/MoveSliderAndVerifyValue'), [('_expectedValue') : _sliderValue3], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/ResetSliderValue'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

