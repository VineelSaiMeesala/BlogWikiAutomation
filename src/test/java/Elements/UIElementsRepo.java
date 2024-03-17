package Elements;

import org.bouncycastle.oer.Switch;
import org.openqa.selenium.Alert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void LoginButton(){
        try {
            System.out.println('\n'+"Sleeping for Element...");
            WebElement LoginBtns = wait.until(ExpectedConditions.visibilityOf(LoginBtn));
            LoginBtns.click();
            System.out.println('\n'+"Clicked LoginBtn");
        } catch (StaleElementReferenceException e) {
            System.out.println('\n'+"Sleeping for Element...");
            WebElement LoginBtns = wait.until(ExpectedConditions.visibilityOf(LoginBtn));
            LoginBtns.click();
            System.out.println('\n'+"Clicked LoginBtn (Retry)");
        }
    }
    public void HomeClick(){
        try {
            System.out.println('\n'+"Sleeping for Element...");
            WebElement HomeClicker = wait.until(ExpectedConditions.visibilityOf(HomeLink));
            HomeClicker.click();
            System.out.println('\n'+"Clicked Home");
        } catch (StaleElementReferenceException e) {
            System.out.println('\n'+"Sleeping for Element...");
            WebElement HomeClicker = wait.until(ExpectedConditions.visibilityOf(HomeLink));
            HomeClicker.click();
            System.out.println('\n'+"Clicked Home (Retry)");
        }
    }
    public void NewsClick(){
        try {
            System.out.println('\n'+"Sleeping for Element...");
            WebElement NewsClicker = wait.until(ExpectedConditions.visibilityOf(NewsLink));
            NewsClicker.click();
            System.out.println('\n'+"Clicked News");
        } catch (StaleElementReferenceException e) {
            System.out.println('\n'+"Sleeping for Element...");
            WebElement NewsClicker = wait.until(ExpectedConditions.visibilityOf(NewsLink));
            NewsClicker.click();
            System.out.println('\n'+"Clicked News (Retry)");
        }
    }
    public void TechClick(){
        try {
            System.out.println('\n'+"Sleeping for Element...");
            WebElement TechClicker = wait.until(ExpectedConditions.visibilityOf(TechLink));
            TechClicker.click();
            System.out.println('\n'+"Clicked Tech");
        } catch (StaleElementReferenceException e) {
            System.out.println('\n'+"Sleeping for Element...");
            WebElement TechClicker = wait.until(ExpectedConditions.visibilityOf(TechLink));
            TechClicker.click();
            System.out.println('\n'+"Clicked Tech (Retry)");
        }
    }
    public void Signup(){
        try {
            System.out.println('\n'+"Sleeping for Element...");
            WebElement SignLinkClicker = wait.until(ExpectedConditions.visibilityOf(SignUpLink));
            SignLinkClicker.click();
            System.out.println('\n'+"Clicked Login");
        } catch (StaleElementReferenceException e) {
            System.out.println('\n'+"Sleeping for Element...");
            WebElement SignLinkClicker = wait.until(ExpectedConditions.visibilityOf(SignUpLink));
            SignLinkClicker.click();
            System.out.println('\n'+"Clicked Login (Retry)");
        }
    }
    public void LoginClick(String BtnType){
        switch(BtnType){
            case "Login":
                try {
                    System.out.println('\n'+"Sleeping for Element...");
                    WebElement LoginClicker = wait.until(ExpectedConditions.visibilityOf(LoginClicked));
                    LoginClicker.click();
                    System.out.println('\n'+"Clicked Login");
                } catch (StaleElementReferenceException e) {
                    System.out.println('\n'+"Sleeping for Element...");
                    WebElement LoginClicker = wait.until(ExpectedConditions.visibilityOf(LoginClicked));
                    LoginClicker.click();
                    System.out.println('\n'+"Clicked Login (Retry)");
                }
                break;
            case "Logout":
                try {
                    System.out.println('\n'+"Sleeping for Element...");
                    WebElement LogoutClicker = wait.until(ExpectedConditions.visibilityOf(Logout));
                    LogoutClicker.click();
                    System.out.println('\n'+"Clicked Logout");
                } catch (StaleElementReferenceException e) {
                    System.out.println('\n'+"Sleeping for Element...");
                    WebElement LogoutClicker = wait.until(ExpectedConditions.visibilityOf(Logout));
                    LogoutClicker.click();
                    System.out.println('\n'+"Clicked Logout (Retry)");
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
    public void AlertAccept(WebDriver driver){
        driver.switchTo().alert().accept();
    }
    public void print(String Message){
        System.out.print('\n'+Message);
    }
}
