package testSuites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeURLs {
	static WebDriver fox;
	String baseUrl;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "/Users/wessilverstein/Desktop/CodingFiles/Drivers/geckodriver");
		fox = new FirefoxDriver();
		baseUrl = "http://www.wessilverstein.com/";
		fox.get(baseUrl);
	}

	// check whether Wes picture loads:

	@Test(priority = 1)
	public void checkPicture() {
		WebElement myPic = fox.findElement(By.xpath(".//*[@id='site-head']/section[2]/div/a/img"));
		Assert.assertTrue(myPic.isDisplayed());
		Reporter.log("Tested if Wes image displays", true);

	}

	// check whether introduction text loads:

	@Test(priority = 2)
	public void checkIntro() {
		String myIntro = fox.findElement(By.id("content")).getText();
		Assert.assertTrue(
				myIntro.contains("Hi! My name is Wes and I'm a QA Engineer located in the San Francisco Bay Area."));
		Reporter.log("Tested homepage intro text", true);

	}

	// check whether Clients & Portfolio heading appears:

	@Test(priority = 3)
	public void checkClientsHeading() {
		String clientsHead = fox.findElement(By.id("content")).getText();
		Assert.assertTrue(clientsHead.contains("CLIENTS & PORTFOLIO"));
		Reporter.log("Tested Clients & Portfolio heading", true);

	}

	// check whether Clients forward arrow works:

	@Test(priority = 4)
	public void checkClientsFwd() {
		fox.findElement(By.xpath(".//*[@id='content']/div[2]/div/div[3]")).click();
		String boldium = fox.findElement(By.xpath(".//*[@id='content']/div[2]/div/div[1]/ul/li[5]/h1/a")).getText();
		Assert.assertTrue(boldium.contains("Boldium"));
		Reporter.log("Tested clients forward arrow", true);
	}

	// check whether Clients back arrow works:

	@Test(priority = 5)
	public void checkClientsBack() {
		fox.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		fox.findElement(By.xpath(".//*[@id='content']/div[2]/div/div[2]")).click();
		fox.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String intel = fox.findElement(By.xpath(".//*[@id='content']/div[2]/div/div[1]/ul/li[3]/h1/a")).getText();
		Assert.assertTrue(intel.contains("Intel"));
		Reporter.log("Tested clients back arrow", true);
	}

	// check whether Clients & Portfolio (top nav) link works:

	@Test(priority = 6)
	public void checkClientsTop() {
		fox.findElement(By.id("menu-item-35")).click();
		fox.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String cqText = fox.findElement(By.xpath(".//*[@id='content']/div/ul/li[6]/h1")).getText();
		Assert.assertTrue(cqText.contains("CampusQuad"));
		Reporter.log("Tested Clients & Portfolio top nav link", true);
	}

	// check whether Home link works:

	@Test(priority = 7)
	public void checkHome() {
		String homeURL = fox.findElement(By.xpath(".//*[@id='menu-item-31']/a")).getAttribute("href");
		Assert.assertTrue(homeURL.equalsIgnoreCase("http://www.wessilverstein.com/"));
		Reporter.log("Tested Home link", true);
	}

	// check whether Bug Reports link works:

	@Test(priority = 8)
	public void BugReports() {
		fox.findElement(By.id("menu-item-113")).click();
		fox.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String bugRep = fox.findElement(By.xpath(".//*[@id='post-75']/div")).getText();
		Assert.assertTrue(bugRep.contains("Curious about my bug reports?"));
		Reporter.log("Tested Bug Reports link", true);
	}

	// check whether Test Cases link works:

	@Test(priority = 9)
	public void TestCase() {
		String tcURL = fox.findElement(By.xpath(".//*[@id='menu-item-157']/a")).getAttribute("href");
		Assert.assertTrue(tcURL.equalsIgnoreCase("http://www.wessilverstein.com/test-cases/"));
		Reporter.log("Tested Test Cases link", true);
	}

	// check whether Blog link works:

	@Test(priority = 10)
	public void checkBlog() {
		fox.findElement(By.cssSelector("#menu-item-32>a")).click();
		fox.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String blogText = fox.findElement(By.xpath(".//*[@id='content']/div/ul/li[1]/div[2]/div[1]/h2/a")).getText();
		Assert.assertTrue(blogText.contains("How to Install FirePath"));
		Reporter.log("Tested Blog link", true);

	}

	// check whether Hire Me link works:

	@Test(priority = 11)
	public void checkHireMe() {
		String hireURL = fox.findElement(By.linkText("Hire Me")).getAttribute("href");
		Assert.assertTrue(hireURL.equalsIgnoreCase("http://www.wessilverstein.com/hire-me/"));
		Reporter.log("Tested Hire Me link", true);
	}

	// check whether Email Me link works:

	@Test(priority = 12)
	public void checkEmail() {
		String email = fox.findElement(By.id("email-link")).getAttribute("href");
		Assert.assertTrue(email.contains("mailto:wessilverstein@gmail.com"));
		Reporter.log("Tested Email Me link", true);
	}

	// check whether home footer link works:

	@Test(priority = 13)
	public void checkFooterLink() {
		fox.findElement(By.xpath(".//*[@id='page']/footer/div/p/a")).click();
		fox.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String homeText = fox.findElement(By.xpath(".//*[@id='content']/div[1]/p")).getText();
		Assert.assertTrue(homeText.contains("name is Wes"));
		Reporter.log("Tested footer home link", true);
	}

	// check Home link text:

	@Test(priority = 14)
	public void checkHomeText() {
		String homeLink = fox.findElement(By.cssSelector("#menu-item-31>a")).getText();
		Assert.assertTrue(homeLink.equalsIgnoreCase("Home"));
		Reporter.log("Tested home link text", true);
	}

	// check whether LinkedIn link works:

	@Test(priority = 15)
	public void checkLinkedIn() {
		fox.findElement(By.xpath(".//*[@id='linkedin-link']/div")).click();
		fox.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		for (String winHandle : fox.getWindowHandles()) {
			fox.switchTo().window(winHandle);
		}
		try {
			String liPage = fox.findElement(By.id("topcard")).getText();
			Assert.assertTrue(liPage.contains("Senior"));
			Reporter.log("Tested LinkedIn link", true);
		} catch (Exception e) {
			String liJoin = fox.findElement(By.id("uno-reg-join")).getText();
			Assert.assertTrue(liJoin.contains("Make the most"));
			Reporter.log("Tested LinkedIn link to Join page", true);
		}
	}

	@AfterClass
	public void afterClass() {
		fox.quit();

	}
}
