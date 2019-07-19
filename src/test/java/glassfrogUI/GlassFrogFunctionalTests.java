package glassfrogUI;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class GlassFrogFunctionalTests {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
       
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Gradle\\chromedriver.exe");
		driver = new ChromeDriver();               
    }

    @After
    public void tearDown() {
        if (driver != null)
            driver.quit();                         
    }

    @Test
    public void sayHello() throws Exception {
        driver.get("http://localhost:8080/glassfrogUI/");
        driver.findElement(By.id("say-hello-text-input")).sendKeys("Dolly");
        driver.findElement(By.id("say-hello-button")).click();
        assertEquals("Hongo Ostra", driver.getTitle());
        assertEquals("Perfil de Dolly!", driver.findElement(By.tagName("h2")).getText());
    }
}