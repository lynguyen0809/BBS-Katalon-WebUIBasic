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
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor

WebUI.callTestCase(findTestCase('Common/OpenBrowser'), [('_url') : GlobalVariable._URL], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_The Internet/lnk_WYSIWYG Editor'))

WebUI.verifyElementPresent(findTestObject('Page_Editor/lbl_An iFrame containing the TinyMCE WYSIWYG Editor'), 0)

WebUI.switchToFrame(findTestObject('Page_Editor/ifr_TinyMCE'), GlobalVariable._waitTime)

'Verify default Content'
WebUI.callTestCase(findTestCase('Common/VerifyContent'), [('_expectedContent') : _defaultContent], FailureHandling.STOP_ON_FAILURE)

WebUI.clearText(findTestObject('Page_Editor/txt_TextArea'))

WebUI.setText(findTestObject('Page_Editor/txt_TextArea'), _inputContent)

//WebDriver driver = DriverFactory.getWebDriver()
//WebElement wb = driver.findElement(By.xpath("//*[@id='tinymce']"));
//JavascriptExecutor jse = (JavascriptExecutor)driver;
//jse.executeScript("document.getElementById('mce_0_ifr').contentWindow.document.write('content');");

'Verify inputed Content'
WebUI.callTestCase(findTestCase('Common/VerifyContent'), [('_expectedContent') : _inputContent], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

