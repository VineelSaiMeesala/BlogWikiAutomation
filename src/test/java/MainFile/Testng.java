/*
@Author:Meesala Vineel Sai
 ==> Please feel free to use my code
*/
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
    @Test(priority = 0)
    public static void TestCaseNaviBar() throws InterruptedException {
        repo.HomeClick();
        repo.NewsClick();
        repo.TechClick();

    }
    @Test(priority = 1)
    public static void TestCaseLogin() throws InterruptedException {
        repo.LoginButton();
        repo.Waiting(1000);
        if(repo.AlertText(mdriver).equals("Not Logged In")){
            repo.print("Alert: "+repo.AlertText(mdriver));
            repo.Waiting(1000);
            repo.AlertAccept(mdriver);
            repo.Login("Devtest@blogwiki.in","123456");
            repo.LoginClick("Login");
            repo.Waiting(2000);
            String ActualText = repo.AlertText(mdriver);
            Assert.assertEquals(ActualText,"Logged In");
            repo.AlertAccept(mdriver);
        } else if (repo.AlertText(mdriver).equals("auth/invalid-credential")) {
            repo.print("Alert: "+repo.AlertText(mdriver));
            TestCaseSignup();
        }else
        {
            repo.LoginClick("Logout");
        }
    }
    @Test(priority = 2)
    public static void TestCaseSignup(){
        repo.Signup();
    }
    @Test(priority = 3)
        public void TestCaseAdminpage(){

    }
    @AfterTest
    public static void BrowserClose() throws InterruptedException {
        repo.Waiting(3000);
        mdriver.quit();
    }
}
