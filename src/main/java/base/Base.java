package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.safari.SafariDriver;

public class Base {

	public WebDriver driver;

	public  WebDriver initializeDriver() throws IOException {


		String browserName = ConfigReader.getProperty("browser");
		System.out.println(browserName);
		ChromeOptions options = new ChromeOptions();;
		options.addArguments("--disable-notifications");
		//options.AddUserProfilePreference("profile.default_content_setting_values.cookies", 2);


		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			// firefox code

		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else if (browserName.equals("safari")) {
			WebDriverManager.safaridriver().setup();

			driver = new SafariDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

}
//prop = new Properties();
// System.getProperties("user.dir")
//FileInputStream fis = new FileInputStream(
//System.getProperty("user.dir") + "\\src\\main\\resources\\data.properties");

//prop.load(fis);
// mvn test -Dbrowser=chrome
//String browserName = System.getProperty("browser");
