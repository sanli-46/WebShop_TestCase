import Utility.BaseDriver;
import Utility.Func;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebShop_Test extends BaseDriver {
    @Test
    public void Test1() {

        driver.get("https://demowebshop.tricentis.com/");

        WebElement register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        Func.Wait(1);

        WebElement gender = driver.findElement(By.xpath("//input[@id='gender-male']"));
        gender.click();
        Func.Wait(1);

        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Tester");
        Func.Wait(1);

        WebElement secName = driver.findElement(By.xpath("//input[@id='LastName']"));
        secName.sendKeys("Selenium");
        Func.Wait(1);

        WebElement eMail = driver.findElement(By.xpath("//input[@id='Email']"));
        eMail.sendKeys("tester.selenıum4@gmail.com");
        Func.Wait(1);

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("testers12332");
        Func.Wait(1);

        WebElement confPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confPassword.sendKeys("testers12332");
        Func.Wait(1);

        WebElement regButton = driver.findElement(By.xpath("//input[@id='register-button']"));
        regButton.click();
        Func.Wait(1);

        WebElement regist = driver.findElement(By.xpath("//div[@class='result']"));
        Assert.assertTrue("Hesap Oluşturulamadı !!!", regist.getText().contains("Your registration complete"));

        WebElement contButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        contButton.click();

        WaitAndClose();

    }

    @Test
    public void Test2() {
        driver=new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        WebElement Register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        Register.click();

        WebElement Gender = driver.findElement(By.xpath("//input[@id='gender-male']"));
        Gender.click();

        WebElement FirstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        FirstName.sendKeys("Ali");

        WebElement LastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        LastName.sendKeys("Tester");

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='Email']"));
        emailInput.sendKeys("soles26832@vikinoko.com");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='Password']"));
        passwordInput.sendKeys("Test123test");

        WebElement ConfirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        ConfirmPassword.sendKeys("Test123test");


        WebElement Register1 = driver.findElement(By.xpath("//input[@id='register-button']"));
        Register1.click();
        Func.Wait(2);

        try {
            WebElement errorMessage = driver.findElement(By.xpath("//li[text()='The specified email already exists']"));
            Assert.assertTrue("Expected error message is not displayed.", errorMessage.isDisplayed());

            System.out.println("The specified email already exists");
            System.out.println("Aynı mail adresi ile giriş yaptınız, lütfen tekrar deneyiniz.");

        } catch (Exception e) {
            Assert.fail("Error.. message 'The specified email already exists' not found on the page.");
        }
        WaitAndClose();

    }
    @Test
    public void Test3() {
        driver=new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        // Login Kontrol
        WebElement loginBtn = driver.findElement(By.xpath("//a[text()='Log in']"));
        loginBtn.click();

        WebElement eMail = driver.findElement(By.id("Email"));
        eMail.sendKeys("hignevagna@gufum.com");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Can123Can");
        WebElement subMitBtn = driver.findElement(By.xpath("//input[@value='Log in']"));
        subMitBtn.click();
        WebElement loginControl = driver.findElement(By.xpath("//a[text()='hignevagna@gufum.com']"));
        Assert.assertEquals("hignevagna@gufum.com", loginControl.getText());

        //Logout Kontrol
        WebElement logoutBtn= driver.findElement(By.xpath("//a[text()='Log out']"));
        logoutBtn.click();
        WebElement loginBtn2 = driver.findElement(By.xpath("//a[text()='Log in']"));
        loginBtn2.click();
        WaitAndClose();

    }

    @Test
    public void Test4() {
        driver=new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        //Faild Login kontrol
        WebElement loginBtn = driver.findElement(By.xpath("//a[text()='Log in']"));
        loginBtn.click();

        WebElement eMail = driver.findElement(By.id("Email"));
        eMail.sendKeys("");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("");
        WebElement subMitBtn = driver.findElement(By.xpath("//input[@value='Log in']"));
        subMitBtn.click();
        WebElement loginControl = driver.findElement(By.xpath(" //span[text()='Login was unsuccessful. Please correct the errors and try again.']"));
        Assert.assertEquals("Login was unsuccessful. Please correct the errors and try again.", loginControl.getText());

        WebElement eMail2 = driver.findElement(By.id("Email"));
        eMail2.sendKeys("hignevagna@gufum.com");
        WebElement password2 = driver.findElement(By.id("Password"));
        password2.sendKeys("");
        WebElement subMitBtn2 = driver.findElement(By.xpath("//input[@value='Log in']"));
        subMitBtn2.click();
        WebElement loginControl2 = driver.findElement(By.xpath(" //span[text()='Login was unsuccessful. Please correct the errors and try again.']"));
        Assert.assertEquals("Login was unsuccessful. Please correct the errors and try again.", loginControl2.getText());

        WebElement eMail3 = driver.findElement(By.id("Email"));
        eMail3.clear();
        WebElement password3 = driver.findElement(By.id("Password"));
        password3.sendKeys("Can123Can");
        WebElement subMitBtn3 = driver.findElement(By.xpath("//input[@value='Log in']"));
        subMitBtn3.click();
        WebElement loginControl3 = driver.findElement(By.xpath(" //span[text()='Login was unsuccessful. Please correct the errors and try again.']"));
        Assert.assertEquals("Login was unsuccessful. Please correct the errors and try again.", loginControl3.getText());

        WaitAndClose();

    }
}
