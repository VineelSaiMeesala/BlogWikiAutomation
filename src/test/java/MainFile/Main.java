package MainFile;
import Brwoser.BrwoserDriver;
import Elements.UIElementsRepo;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.URLREPO;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    static BrwoserDriver driver = new BrwoserDriver();
    static UIElementsRepo repo = new UIElementsRepo();
    static WebDriver mdriver = driver.Driverload("chrome");
    static URLREPO LoadURL = new URLREPO();
    static WebDriverWait wait = new WebDriverWait(mdriver,  Duration.ofSeconds(10));
    public static void main(String[] args) throws InterruptedException {
        repo = PageFactory.initElements(mdriver, UIElementsRepo.class);
        mdriver.get(LoadURL.getQAUrl());
        mdriver.manage().window().maximize();
        repo.Waiting(2000);
        System.out.print('\n'+mdriver.getTitle());
        repo.HomeClick();
        repo.NewsClick();
        repo.TechClick();
        repo.LoginButton();
        repo.Waiting(1000);
        //Login Check
        if(repo.AlertText(mdriver).equals("Not Logged In")){
            repo.Waiting(1000);
            repo.AlertAccept(mdriver);
            repo.Login("Devtest@blogwiki.in","12356");
            repo.LoginClick("Login");
            repo.Waiting(2000);
            repo.print(repo.AlertText(mdriver));
        } else if (repo.AlertText(mdriver).equals("auth/invalid-credential")) {
            repo.Signup();
            repo.Waiting(3000);
        }else
        {
            repo.LoginClick("Logout");
        }
        //
        mdriver.quit();
    }
}
