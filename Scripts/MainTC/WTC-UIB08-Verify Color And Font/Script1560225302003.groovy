import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.testng.Assert

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
import org.openqa.selenium.WebElement as WebElement

'Go to https://the-internet.herokuapp.com/'
WebUI.callTestCase(findTestCase('Common/OpenBrowser'), [('_url') : GlobalVariable._URL], FailureHandling.STOP_ON_FAILURE)

'Select Challenging DOM link'
WebUI.click(findTestObject('Page_The Internet/lnk_Challenging DOM'))

'Verify Challenging DOM header title is displayed'
WebUI.callTestCase(findTestCase('Common/VerifyHeaderTitle'), [('_headerTitle') : _expectedTitle], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Page_ChallengingDOM/btn_button1'), 0)

_fontSize = WebUI.getCSSValue(findTestObject('Page_ChallengingDOM/btn_button1'), 'font-size')

'Verify font size is 16px'
WebUI.verifyMatch(_fontSize, _expFontsize, false)

WebUI.verifyElementPresent(findTestObject('Page_ChallengingDOM/btn_button2'), 0)

'List of expected Background color in browsers'
List<WebElement> expectedBackgroundColor = Arrays.asList('rgb(198, 15, 19)', 'rgba(198, 15, 19, 1)', '#c60f13')

'Verify background color'
for(def i=0; i<= expectedBackgroundColor.size(); i++){
	
	_backgroundColor = WebUI.getCSSValue(findTestObject('Page_ChallengingDOM/btn_button2'), 'background-color')
	
	if(_backgroundColor == expectedBackgroundColor[i]){
		Assert.assertEquals(_backgroundColor, expectedBackgroundColor[i])
	}
}

WebUI.verifyElementPresent(findTestObject('Page_ChallengingDOM/btn_button3'), 0)

'List of expected border color values'
List<WebElement> expectedBorderColor = Arrays.asList('rgb(69, 122, 26)', '#457a1a')

'Verify border color'
for(def i=0; i<= expectedBorderColor.size(); i++){
	
	_borderColor = WebUI.getCSSValue(findTestObject('Page_ChallengingDOM/btn_button3'), 'border-color')
	
	if(_borderColor == expectedBorderColor[i]){
		Assert.assertEquals(_borderColor, expectedBorderColor[i])
	}
}

WebUI.closeBrowser()

