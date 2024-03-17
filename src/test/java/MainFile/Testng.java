package MainFile;
import BrowserDriver.BrowserDriver;
import Elements.UIElementsRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.URLREPO;

public class Testng {
     public static String Browsers = System.getProperty("chrome");
    static BrowserDriver driver = new BrowserDriver();
    static UIElementsRepo repo = new UIElementsRepo();
    static WebDriver mdriver = driver.Driverload("chrome");
    static URLREPO LoadURL = new URLREPO();

    @BeforeTest
    public static void BrowserStart() throws InterruptedException {
        repo = PageFactory.initElements(mdriver, UIElementsRepo.class);
        mdriver.get(LoadURL.getQAUrl());
        mdriver.manage().window().maximize();
        repo.Waiting(2000);
        System.out.print('\n'+mdriver.getTitle());
    }
    @Test
    public static void Testcase() throws InterruptedException {
        repo.HomeClick();
        repo.NewsClick();
        repo.TechClick();
        repo.LoginButton();
        repo.Waiting(1000);
        //Login Check
        if(repo.AlertText(mdriver).equals("Not Logged In")){
            repo.Waiting(1000);
            repo.AlertAccept(mdriver);
            repo.Login("Devtest@blogwiki.in","123456");
            repo.LoginClick("Login");
            repo.Waiting(3000);
            String ActualText = repo.AlertText(mdriver);
            Assert.assertEquals(ActualText,"Logged In");
        } else if (repo.AlertText(mdriver).equals("auth/invalid-credential")) {
            repo.Signup();
            repo.Waiting(3000);
        }else
        {
            repo.LoginClick("Logout");
        }
    }
    @AfterTest
    public static void BrowserClose() throws InterruptedException {
        repo.Waiting(3000);
        mdriver.quit();
    }
}
