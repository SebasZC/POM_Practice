package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(how = How.NAME, using = "userName")
    private WebElement txtUser;
    @FindBy(how = How.NAME, using = "password")
    private WebElement txtPassword;
    @FindBy(how = How.NAME, using = "submit")
    private WebElement btnSubmit;
    @FindBy(how = How.XPATH,using = "//span")
    private WebElement lblMessageError;
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        if(!driver.getTitle().equals("Welcome: Mercury Tours")){
            throw new IllegalStateException("This is not the correct page, " +
                    " current page is: " + driver.getCurrentUrl());
        }
        //Initialization webElements
        PageFactory.initElements(driver, this);
    }

    public void LogIn(String user, String password){
        txtUser.sendKeys(user);
        txtPassword.sendKeys(password);
        btnSubmit.click();
    }

    public String getErrorMessage(){
        return lblMessageError.getText();
    }
}
