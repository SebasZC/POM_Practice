package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomeLogin {
    //private By lblLoginSuccessful = By.xpath("//h3");
    @FindBy(how = How.XPATH,using = "//h3")
    private WebElement lblLoginSuccessful;
    private WebDriver driver;

    public HomeLogin (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getSuccessfulMessage(){
        return lblLoginSuccessful.getText();
    }
}
