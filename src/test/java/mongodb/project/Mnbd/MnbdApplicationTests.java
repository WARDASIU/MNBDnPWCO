package mongodb.project.Mnbd;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MnbdApplicationTests {
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
		driver = new ChromeDriver();
	}

	@Test
	public void test() {
		Assertions.assertEquals(1+1, 2+0);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}