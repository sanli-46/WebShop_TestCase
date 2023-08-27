import Utility.BaseDriver;
import Utility.Func;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebShop_Test extends BaseDriver {
    @Test
    public void Test1(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement register=driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        Func.Wait(1);

        WebElement gender=driver.findElement(By.xpath("//input[@id='gender-male']"));
        gender.click();
        Func.Wait(1);

        WebElement firstName= driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Tester");
        Func.Wait(1);

        WebElement secName= driver.findElement(By.xpath("//input[@id='LastName']"));
        secName.sendKeys("Selenium");
        Func.Wait(1);

        WebElement eMail= driver.findElement(By.xpath("//input[@id='Email']"));
        eMail.sendKeys("tester.selenıum2@gmail.com");
        Func.Wait(1);

        WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("testers12332");
        Func.Wait(1);

        WebElement confPassword= driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confPassword.sendKeys("testers12332");
        Func.Wait(1);

        WebElement regButton= driver.findElement(By.xpath("//input[@id='register-button']"));
        regButton.click();
        Func.Wait(1);

        WebElement regist=driver.findElement(By.xpath("//div[@class='result']"));
        Assert.assertTrue("",regist.getText().contains("Your registration complete"));

        WebElement contButton=driver.findElement(By.xpath("//input[@value='Continue']"));
        contButton.click();

        WaitAndClose();



    }
}
