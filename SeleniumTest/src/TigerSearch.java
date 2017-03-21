import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class TigerSearch {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver");
    driver = new FirefoxDriver(DesiredCapabilities.firefox());
    baseUrl = "https://tigercenter.rit.edu/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testClass1() throws Exception {
    test("Golisano Col Comp&Info Science", "SWEN - Software Engineering", "McKeown");
  }
  
  @Test
  public void testClass2() throws Exception {
    test("Golisano Col Comp&Info Science", "SWEN - Software Engineering", "Thomas Reichlmayr");
  }
  
  @Test
  public void testClass3() throws Exception {
    test("College of Liberal Arts", "COMM - Communication", "Keri Barone");
  }
  
  @Test
  public void testClass4() throws Exception {
    test("College of Liberal Arts", "COMM - Communication", "Lori Marra");
  }
  
  public void test(String college, String major, String instructor) throws Exception {
    driver.get(baseUrl + "tigerCenterHome/#/landing");
    // click class search start searching button
    driver.findElement(By.xpath("//button[@type='button']")).click();
    Thread.sleep(3000);
    // change semester to 2017-2018 fall
    new Select(driver.findElement(By.id("term"))).selectByVisibleText("2017-18 Fall (2171)");
    Thread.sleep(3000);
    // click advanced search
    driver.findElement(By.linkText("Advanced Search")).click();
    Thread.sleep(3000);
    // select campus, college, major, and instructor
    new Select(driver.findElement(By.name("campus"))).selectByVisibleText("RIT Main");
    Thread.sleep(3000);
    new Select(driver.findElement(By.id("college"))).selectByVisibleText(college);
    Thread.sleep(3000);
    new Select(driver.findElement(By.id("majors"))).selectByVisibleText(major);
    Thread.sleep(3000);
    driver.findElement(By.id("instructorBox")).sendKeys(instructor);
    Thread.sleep(3000);
    // click submit button
    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    Thread.sleep(3000);
    // click first class in result list
    driver.findElement(By.cssSelector("span.courseID.ng-binding")).click();
    Thread.sleep(3000);
    // output class name
    System.out.println(driver.findElement(By.xpath("//*[@id=\"classDetailsHeader\"]")).getText().split(" - ")[1]);
    // output class days, time, instructor, and location
    WebElement classDetailsTable = driver.findElement(By.id("classDetailsInfo"));
    List<WebElement> classDetails = classDetailsTable.findElements(By.cssSelector("tr"));
    for (WebElement row : classDetails) {
      String text = row.getText();
      if (text.startsWith("Days") || text.startsWith("Time") || text.startsWith("Instructor") || text.startsWith("Location"))
        System.out.println(text);
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
