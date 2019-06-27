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
import org.testng.Assert as Assert

WebUI.callTestCase(findTestCase('Common/OpenBrowser'), [('_url') : GlobalVariable._URL], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_The Internet/lnk_Sortable Data Tables'))

WebUI.callTestCase(findTestCase('Common/VerifyHeaderTitle'), [('_headerTitle') : _expectedTitle], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Page_Table/tbl_Table1'), GlobalVariable._waitTime)

_actualHeaderValue = WebUI.getText(findTestObject('Page_Table/tbl_HeaderRow', [('ColumnIndex') : _column3]))

println(_actualHeaderValue)

WebUI.verifyMatch(_actualHeaderValue, _emailColumn, false)

_actualValue32 = WebUI.getText(findTestObject('Object Repository/Page_Table/tbl_Body', [('RowIndex') : _row3, ('ColumnIndex') : _column2]))

println(_actualValue32)

WebUI.verifyMatch(_actualValue32, _value32, false)

WebUI.click(findTestObject('Page_Table/tbl_EmailColumnTable2'))

WebDriver driver = DriverFactory.getWebDriver()

'To locate table'
WebElement Table = driver.findElement(By.xpath('//table[@id=\'table2\']/tbody'))

'To locate rows of table it will Capture all the rows available in the table '
List<WebElement> Rows = Table.findElements(By.tagName('tr'))

'List of email that sorting by Alphabet'
List<WebElement> sortedEmailByAlphabet = Arrays.asList('fbach@yahoo.com', 'jdoe@hotmail.com', 'jsmith@gmail.com', 'tconway@earthlink.net')

'List of email after sorting on table'
List<WebElement> actualEmailList = new ArrayList()

for (def i = 1; i <= Rows.size(); i++) {
    _value = WebUI.getText(findTestObject('Object Repository/Page_Table/tbl_BodyEmailColumnTable2', [('RowIndex') : i.toString()]))

    actualEmailList.add(_value)
}

println(actualEmailList)

Assert.assertEquals(actualEmailList, sortedEmailByAlphabet)

WebUI.closeBrowser()

