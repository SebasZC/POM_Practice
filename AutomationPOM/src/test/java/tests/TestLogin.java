package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageFactory.HomeLogin;
import pageFactory.LoginPage;

public class TestLogin {
    WebDriver driver;
    String PATH_DRIVER = "./src/main/resources/driver/chromedriver.exe";
    String TYPE_DRIVER = "webdriver.chrome.driver";
    String END_POINT = "https://demo.guru99.com/test/newtours/";
    LoginPage login;
    HomeLogin home;

    @Before
    public void setUp(){
        System.setProperty(TYPE_DRIVER,PATH_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(END_POINT);
        login = new LoginPage(driver);
    }

    @Test
    public void testLogIn(){
        login.LogIn("zapatasebas@gmail.com","Sebas001");
        home = new HomeLogin(driver);
        Assert.assertEquals("Login Successfully", home.getSuccessfulMessage());
    }

    @Test
    public void testFailedLogIn(){
        login.LogIn("zapatasebas@gmail.com","Failed");
        Assert.assertTrue(login.getErrorMessage().contains("Enter your userName and password correct"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
