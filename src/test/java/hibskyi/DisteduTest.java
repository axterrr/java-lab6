package hibskyi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class DisteduTest {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void testRedirectionToLoginPage() {
        driver.get("https://distedu.ukma.edu.ua");
        String shouldBeRedirectedTo = "https://distedu.ukma.edu.ua/login/index.php";
        assertThat(driver.getCurrentUrl()).isEqualTo(shouldBeRedirectedTo);
    }

    @Test
    void testLogoPresence() {
        driver.get("https://distedu.ukma.edu.ua/login/index.php");
        WebElement logo = driver.findElement(By.className("rui-login-logo"));
        assertThat(logo.isDisplayed()).isTrue();
    }

    @Test
    void testLoginWithOffice365Possibility() {
        driver.get("https://distedu.ukma.edu.ua/login/index.php");
        WebElement loginButton = driver.findElement(By.className("login-identityprovider-btn"));
        assertThat(loginButton.getText()).contains("Вхід через Office 365");
        assertThat(loginButton.getAttribute("href")).isEqualTo("https://distedu.ukma.edu.ua/auth/oidc/");
        assertThat(loginButton.isDisplayed()).isTrue();
    }
}
