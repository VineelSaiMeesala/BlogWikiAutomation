package Elements;

import org.bouncycastle.oer.Switch;
import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class UIElementsRepo {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @FindBy(xpath = "//*[@id=\"Login\"]/a") WebElement LoginBtn;
    @FindBy(xpath = "//*[@id=\"menu\"]/span[1]/a") WebElement HomeLink;
    @FindBy(xpath = "//*[@id=\"menu\"]/span[2]/a") WebElement NewsLink;
    @FindBy(xpath = "//*[@id=\"menu\"]/span[3]/a") WebElement TechLink;
    @FindBy(xpath = "//input[@class=\"Emailfield\"]") WebElement UserName;
    @FindBy(xpath = "//input[@class=\"Passwordfield\"]") WebElement Password;
    @FindBy(xpath = "//button[@class=\"loginBtn \"]") WebElement LoginClicked;
    @FindBy(xpath = "//button[@class=\"loginBtn disabled\"]") WebElement DisabedLogin;
    @FindBy(xpath = "//button[@class=\"loginBtn\"]") WebElement Logout;
    @FindBy(xpath = "//a[@class=\"LoginSignuplink\"]") WebElement SignUpLink;
    @FindBy(xpath = "//div[@class='MainWrapper']/h2[@class='loginHead']") WebElement Heading;
    @FindBy(xpath = "//div[@class='ErrorMessagetest']/") WebElement AdminError;

    public void AlertAccept(WebDriver driver){
        driver.switchTo().alert().accept();
    }

    public void print(String Message){
        System.out.print('\n'+Message);
    }
    public void LoginButton(){
        try {
            print('\n'+"Sleeping for Element...");
            WebElement LoginBtns = wait.until(ExpectedConditions.visibilityOf(LoginBtn));
            LoginBtns.click();
            print('\n'+"Clicked LoginBtn");
        } catch (StaleElementReferenceException e) {
            print('\n'+"Sleeping for Element...");
            WebElement LoginBtns = wait.until(ExpectedConditions.visibilityOf(LoginBtn));
            LoginBtns.click();
            print('\n'+"Clicked LoginBtn (Retry)");
        }
    }
    public void HomeClick(){
        try {
            print('\n'+"Sleeping for Element...");
            WebElement HomeClicker = wait.until(ExpectedConditions.visibilityOf(HomeLink));
            HomeClicker.click();
            print('\n'+"Clicked Home");
        } catch (StaleElementReferenceException e) {
            print('\n'+"Sleeping for Element...");
            WebElement HomeClicker = wait.until(ExpectedConditions.visibilityOf(HomeLink));
            HomeClicker.click();
            print('\n'+"Clicked Home (Retry)");
        }
    }
    public void NewsClick(){
        try {
            print('\n'+"Sleeping for Element...");
            WebElement NewsClicker = wait.until(ExpectedConditions.visibilityOf(NewsLink));
            NewsClicker.click();
            print('\n'+"Clicked News");
        } catch (StaleElementReferenceException e) {
            print('\n'+"Sleeping for Element...");
            WebElement NewsClicker = wait.until(ExpectedConditions.visibilityOf(NewsLink));
            NewsClicker.click();
            print('\n'+"Clicked News (Retry)");
        }
    }
    public void TechClick(){
        try {
            print('\n'+"Sleeping for Element...");
            WebElement TechClicker = wait.until(ExpectedConditions.visibilityOf(TechLink));
            TechClicker.click();
            print('\n'+"Clicked Tech");
        } catch (StaleElementReferenceException e) {
            print('\n'+"Sleeping for Element...");
            WebElement TechClicker = wait.until(ExpectedConditions.visibilityOf(TechLink));
            TechClicker.click();
            print('\n'+"Clicked Tech (Retry)");
        }
    }
    public void Signup(){
        try {
            print('\n'+"Sleeping for Element...");
            WebElement SignLinkClicker = wait.until(ExpectedConditions.visibilityOf(SignUpLink));
            SignLinkClicker.click();
            print('\n'+"Clicked Signup");
            Assert.assertEquals(Heading.getText(),"SIGNUP");
            print("PageLoaded: "+Heading.getText());

        } catch (StaleElementReferenceException e) {
            print('\n'+"Sleeping for Element...");
            WebElement SignLinkClicker = wait.until(ExpectedConditions.visibilityOf(SignUpLink));
            SignLinkClicker.click();
            print('\n'+"Clicked Signup (Retry)");
            Assert.assertEquals(Heading.getText(),"SIGNUP");
            print("PageLoaded: "+Heading.getText());
        }
    }
    public void LoginClick(String BtnType){
        switch(BtnType){
            case "Login":
                try {
                    print('\n'+"Sleeping for Element...");
                    WebElement LoginClicker = wait.until(ExpectedConditions.visibilityOf(LoginClicked));
                    LoginClicker.click();
                    print('\n'+"Clicked Login");
                    Assert.assertEquals(Heading.getText(),"LOGIN");
                    print("PageLoaded: "+Heading.getText());
                } catch (StaleElementReferenceException e) {
                    print('\n'+"Sleeping for Element...");
                    WebElement LoginClicker = wait.until(ExpectedConditions.visibilityOf(LoginClicked));
                    LoginClicker.click();
                    print('\n'+"Clicked Login (Retry)");
                    Assert.assertEquals(Heading.getText(),"LOGIN");
                    print("PageLoaded: "+Heading.getText());
                }
                break;
            case "Logout":
                try {
                    print('\n'+"Sleeping for Element...");
                    WebElement LogoutClicker = wait.until(ExpectedConditions.visibilityOf(Logout));
                    LogoutClicker.click();
                    print('\n'+"Clicked Logout");
                } catch (StaleElementReferenceException e) {
                    print('\n'+"Sleeping for Element...");
                    WebElement LogoutClicker = wait.until(ExpectedConditions.visibilityOf(Logout));
                    LogoutClicker.click();
                    print('\n'+"Clicked Logout (Retry)");
                }
                break;
        }
    }public WebElement DisLogin(){
        return DisabedLogin;
    }
    public void Waiting(int Number) throws InterruptedException {
        System.out.print('\n'+"Sleeping for Element: "+Number+"ms");
        Thread.sleep(Number);
    }
    public void Login(String User,String Pass){
        UserName.sendKeys(User);
        Password.sendKeys(Pass);
    }
    public String AlertText(WebDriver drivers){
        Alert alert = drivers.switchTo().alert();
        return alert.getText();
    }

}
