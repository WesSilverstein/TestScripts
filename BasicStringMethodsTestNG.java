package freshTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class BasicStringMethodsTestNG {

	WebDriver driver;
	String startURL;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		startURL = "http://www.wessilverstein.com";
		driver.get(startURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	
	//priority starts counting at "0"
	
	@Test(priority = 0)
	public void stringLength() {
		String clients = driver.findElement(By.xpath(".//*[@id='content']/div[2]/h3")).getText();
		System.out.println("There are " + clients.length() + " characters in the portfolio heading.");
	}

	@Test(priority = 1)
	public void stringCharAt() {
		String ms = driver.findElement(By.xpath(".//*[@id='content']/div[2]/div/div[1]/ul/li[1]/h1/a")).getText();
		char myLetter = 'i';
		if (ms.charAt(1) == myLetter) {
			System.out.println("As expected, the second letter in Microsoft is " + myLetter);
		} else {
			System.out.println("Bug alert! The word returned was not 'Microsoft' - maybe Apple took over?");
		}
	}

	@Test(priority = 2)
	public void stringConcat() {
		String emailMe = driver.findElement(By.xpath(".//*[@id='menu-item-51']/a")).getText();
		String contactButton = " me via email: wessilverstein@gmail.com";
		System.out.println(emailMe.concat(contactButton));
	}

	@Test(priority = 3)
	public void stringContains() {
		String myTitle = driver.getTitle();
		if (myTitle.contains("Wes")) {
			System.out.println("The title of the site is your name! Good job.");
		} else {
			System.out.println("Bug: the site title is missing your name. Don't you want people to know who you are?");
		}
	}

	@Test(priority = 4)
	public void stringStarts() {
		String intro = driver.findElement(By.id("content")).getText();
		if (intro.startsWith("Hi")) {
			System.out.println("Visitors are greeted appropriately.");
		} else {
			System.out.println("Uhoh, you're not greeting visitors! That's pretty rude.");
		}
	}

	@Test(priority = 5)
	public void stringEnds() {
		String outro = driver.findElement(By.cssSelector(".site-slogan>p")).getText();
		if (outro.endsWith("Bay Area.")) {
			System.out.println("Great! You provided your location.");
		} else {
			System.out.println("Warning -- your location is missing. Where are you?");
		}

	}

	@Test(priority = 6)
	public void stringEquals() {
		String blog = driver.findElement(By.xpath(".//*[@id='menu-item-32']/a")).getText();

		if (blog.equals("BLOG")) {
			System.out.println("Blog heading text looks good.");
		} else {
			System.out.println("Blog heading is missing! Don't tell me you gave up posting.");

		}

	}

	@Test(priority = 7)
	public void stringIndex() {
		String WS = driver.findElement(By.xpath(".//*[@id='page']/footer/div/p/a")).getText();
		if (WS.indexOf('W') == 0) {
			System.out.println("As expected, the first letter of your name is 'W.'");
		} else {
			System.out.println("Your name is spelled wrong. Yikes!");
		}
	}

	@Test(priority = 8)
	public void stringEmpty() {
		String homeButton = driver.findElement(By.xpath(".//*[@id='menu-item-31']/a")).getText();
		if (!homeButton.isEmpty()) {
			System.out.println("Phone Home: ET's mission was a success.");
		} else {
			System.out.println("No home button? Tsk tsk.");
		}
	}

	@Test(priority = 9)
	public void stringReplace() {
		String bio = driver.findElement(By.xpath(".//*[@id='content']/div[1]/p")).getText();
		System.out.println(bio.replaceAll("in the San Francisco Bay Area", "on Planet Earth"));
	}

	@Test(priority = 10)
	public void stringSub() {
		String greeting = driver.findElement(By.xpath(".//*[@id='content']/div[1]/p")).getText();
		System.out.println("Q: What should we call you? " + "A: " + greeting.substring(4, 18));
	}

	@Test(priority = 11)
	public void stringCharArray() {

		String homeButton = driver.findElement(By.xpath(".//*[@id='menu-item-31']/a")).getText();
		char[] homeArray = homeButton.toCharArray();
		for (int i = 0; i < homeArray.length; i++) {
			System.out.println(homeArray[i]);
		}

	}

	@Test(priority = 12)
	public void stringLowerCase() {
		String brHeading = driver.findElement(By.xpath(".//*[@id='menu-item-113']/a")).getText();
		System.out.println(brHeading.toLowerCase());
	}

	@Test(priority = 13)
	public void stringUpperCase() {
		String intelText = driver.findElement(By.xpath(".//*[@id='content']/div[2]/div/div[1]/ul/li[2]/h1")).getText();
		System.out.println(intelText.toUpperCase());
	}

	@Test(priority = 14)
	public void stringTrim() {
		String clientsHeading = driver.findElement(By.xpath(".//*[@id='content']/div[2]/h3")).getText().substring(8,
				10);
		System.out.println("Q: What's an ampersand? A: " + clientsHeading.trim());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
