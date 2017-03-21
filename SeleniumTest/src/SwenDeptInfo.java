import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SwenDeptInfo {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver");
    driver = new FirefoxDriver(DesiredCapabilities.firefox());
    baseUrl = "https://www.rit.edu/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSwenDeptInfo() throws Exception {
    driver.get(baseUrl);
    // click directories link
    driver.findElement(By.linkText("Directories")).click();
    Thread.sleep(3000);
    // click A-Z site index link
    driver.findElement(By.linkText("A-Z Site Index")).click();
    Thread.sleep(3000);
    // click SE, BS link
    driver.findElement(By.linkText("Software Engineering, BS")).click();
    Thread.sleep(3000);
    // click link to SE website
    driver.findElement(By.linkText("http://www.se.rit.edu/")).click();
    Thread.sleep(5000);
    // click contact us link in menu
    driver.findElement(By.xpath("//*[@id=\"block-menu-block-1\"]/div/div/ul/li[11]/a")).click();
    // output contact info
    try {
        System.out.println(driver.findElement(By.xpath("//*[@id=\"node-60\"]/div/div/div/div/p[2]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"node-60\"]/div/div/div/div/p[3]")).getText());
    } catch(Exception e) {
        System.out.println("Contact information not found");
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
