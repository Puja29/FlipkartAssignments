package flipkarsearch;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import automationframework.Select;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SearchMobiles extends SearchCriteria {
	// static String exePath = "C:\\Sel Drivers\\Gecko\\geckodriver.exe";
	public static WebDriver driver;
//	public static final String RUPEE = "\u20B9";
	public static String s;

    WebDriverWait wait;
    static HSSFWorkbook workbook;
    static HSSFSheet sheet;
    static  HSSFCell cell;
    static File src=new File("C:\\Sel Drivers\\Data\\DemoFile.xlsx");
    static String screenpath = "F:\\Users\\psdemo\\eclipse-workspace\\TestData\\MobileResult.png";
	
	
				public static void main(String[] args) throws Exception {
			//	String str1 = "";
					
					 String exePath = "F:\\Chrome Version 86\\chromedriver.exe";
					 System.setProperty("webdriver.chrome.driver", exePath);
					 driver = new ChromeDriver();
					 WebDriverWait wait = new WebDriverWait(driver, 20);
					 driver.manage().window().maximize();
					Thread.sleep(1000);
			
			
				 		 driver.get("https://www.flipkart.com/");

				 
				 		
				 		 
				 		WebElement cancel = driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
	 					cancel.click();		
	 				
	 						 					
				 		WebElement search = driver.findElement(By.cssSelector("html body div#container div div._3ybBIU div._1tz-RS div._3pNZKl div.Y5-ZPI form._1WMLwI.header-form-search div.col-12-12._2tVp4j div.O8ZS_U input.LM6RPg"));
					 					String str = null;
										search.sendKeys(flipcartSearchCriteria(str));				
					 	
					 	WebElement searchbtn = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button"));
					 					searchbtn.click();						
					 		
			
					 					Thread.sleep(1500);
					 					
					 					 JavascriptExecutor js = (JavascriptExecutor) driver;
					 					 Thread.sleep(1000);
					 						WebElement Element = driver.findElement(By.partialLinkText("Mobiles"));

					 				        //This will scroll the page Horizontally till the element is found		
					 				        js.executeScript("arguments[0].scrollIntoView();", Element);

						WebElement PriceD = driver.findElement(By.cssSelector("#container > div > div.t-0M7P._2doH3V > div._3e7xtJ > div._1HmYoV.hCUpcT > div:nth-child(1) > div > div:nth-child(1) > div > section._1MCcAi.D_NGuZ > div._3Uy12X > div._1YoBfV > select"));
				Select PriceV = new Select(PriceD);
				 PriceV.selectByIndex(3);
		
				 
				WebElement RamV = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#container > div > div.t-0M7P._2doH3V > div._3e7xtJ > div._1HmYoV.hCUpcT > div:nth-child(1) > div > div:nth-child(1) > div > section:nth-child(5) > div._3mk-PQ > div > div:nth-child(4) > div > div > label > div._1GEhLw")));
				RamV.click();
						
				WebElement brandv = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#container > div > div.t-0M7P._2doH3V > div._3e7xtJ > div._1HmYoV.hCUpcT > div:nth-child(1) > div > div:nth-child(1) > div > section:nth-child(6) > div._3mk-PQ > div > div > div > div > label > div._1p7h2j")));
				brandv.click();
				 
			
			WebElement searchresults = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#container > div > div.t-0M7P._2doH3V > div._3e7xtJ > div._1HmYoV.hCUpcT > div:nth-child(2) > div:nth-child(2) > div > div > div > a > div._1-2Iqu.row > div.col.col-7-12")));
				
			String MobileResult= searchresults.getText();
			System.out.println(searchresults.getText()); 					 					 
			
			WebElement mobilePrice = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#container > div > div.t-0M7P._2doH3V > div._3e7xtJ > div._1HmYoV.hCUpcT > div:nth-child(2) > div:nth-child(2) > div > div > div > a > div._1-2Iqu.row > div.col.col-5-12._2o7WAb > div._6BWGkk > div > div._1vC4OE._2rQ-NK")));
				//brandv.click();		
				String MobileP =mobilePrice.getText();
				 System.out.println(mobilePrice.getText()); 
				 takeSnapShot(driver, screenpath);	
				 
				 
				 String filepath="F:\\Users\\psdemo\\eclipse-workspace\\TestData\\FlipkartOutput.xlsx";
				
					File file= new File(filepath);
					FileOutputStream fos=new FileOutputStream(file);
				        //create the blank workbook
					Workbook wb= new XSSFWorkbook();
				        //create the blank excel sheet
					Sheet sh= wb.createSheet("Webkul");
				
					Row rwtitle= sh.createRow(0);
					
					  Cell cname1=rwtitle.createCell(0);
					cname1.setCellValue("Mobile Name");
					
					 Cell cname2=rwtitle.createCell(1);
						cname2.setCellValue("Mobile price");
					
						
						Row rw= sh.createRow(1);
				        Cell cl=rw.createCell(0);
				        //define input type
					cl.setCellType(CellType.STRING);
				        //define the data value
					cl.setCellValue(MobileResult);
				        //write the workbook
					 Cell c2=rw.createCell(1);
						c2.setCellType(CellType.NUMERIC);
						c2.setCellValue(MobileP);
						wb.write(fos);
			 
			 
				    driver.close();

}
}
