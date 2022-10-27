package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailPage extends PageBase
{

	public OrderDetailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a.button-2.pdf-invoice-button")
	public WebElement pdfInvoiceLink;
	
	@FindBy(css = "a.button-2.print-order-button")
	public WebElement printInvoiceLink;
	
	public void PrintOrderDetails() 
	{
		clickBtn(printInvoiceLink);
	}
	
	public void DownloadOrderDetails() throws InterruptedException 
	{
		clickBtn(pdfInvoiceLink);
		Thread.sleep(3000);
	}
}
