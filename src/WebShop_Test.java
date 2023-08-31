import Utility.BaseDriver;
import Utility.Func;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
        eMail.sendKeys("tester.selenıum10@gmail.com");
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
    @Test
    public void Test5()
    {
        driver=new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");


        WebElement btnLogin=driver.findElement(By.cssSelector("[class='ico-login']"));
        btnLogin.click();


        WebElement email=driver.findElement(By.id("Email"));
        email.sendKeys("tester.selenıum10@gmail.com");


        WebElement password=driver.findElement(By.id("Password"));
        password.sendKeys("testers12332");


        WebElement btnLogin2=driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        btnLogin2.click();

        Func.Wait(1);
        WebElement electronics=driver.findElement(By.xpath("(//*[@href='/electronics'])[1]"));
        WebElement cellPhones=driver.findElement(By.xpath("(//*[@href='/cell-phones'])[1]"));

        Actions aksiyonDriver=new Actions(driver);

        Func.Wait(1);
        aksiyonDriver.moveToElement(electronics).build().perform();
        Func.Wait(1);
        aksiyonDriver.moveToElement(cellPhones).build().perform();
        Func.Wait(1);
        cellPhones.click();
        Func.Wait(1);

        WebElement AddToChart=driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]"));
        AddToChart.click();

        Func.Wait(1);
        WebElement sepetim=driver.findElement(By.xpath("(//*[@class='cart-label'])[1]"));
        sepetim.click();

        Func.Wait(2);
        WebElement product=driver.findElement(By.xpath("//a[@class='product-name']"));
        Assert.assertTrue("Smartphone yazısı sepetimde bulunamadı!", product.getText().contains("Smartphone") );

        Func.Wait(1);
        WebElement btnAgree=driver.findElement(By.id("termsofservice"));
        btnAgree.click();

        Func.Wait(1);
        WebElement checkout=driver.findElement(By.id("checkout"));
        checkout.click();

        Func.Wait(2);
        WebElement webMenu=driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select country=new Select(webMenu);
        country.selectByVisibleText("United States");

        Func.Wait(2);
        WebElement webMenu2=driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
        Select state=new Select(webMenu2);
        state.selectByVisibleText("Alabama");

        Func.Wait(2);
        WebElement city=driver.findElement(By.id("BillingNewAddress_City"));
        city.sendKeys("Missouri");

        Func.Wait(1);
        WebElement adress1=driver.findElement(By.id("BillingNewAddress_Address1"));
        adress1.sendKeys("Tecno");

        Func.Wait(1);
        WebElement zipcode=driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        zipcode.sendKeys("4444444");

        Func.Wait(1);
        WebElement phoneNumber=driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        phoneNumber.sendKeys("+1 99988877766");

        Func.Wait(1);
        WebElement btnContinue=driver.findElement(By.xpath("(//*[@class='button-1 new-address-next-step-button'])[1]"));
        btnContinue.click();

        Func.Wait(2);
        WebElement InStorePickup=driver.findElement(By.id("PickUpInStore"));
        InStorePickup.click();

        Func.Wait(1);
        WebElement shippingAddress=driver.findElement(By.xpath("//label[text()='Select a shipping address from your address book or enter a new address.']"));
        Assert.assertTrue("Kargolama adresi kaybolmadı!", shippingAddress.isEnabled());


        Func.Wait(1);
        WebElement btnContinue2=driver.findElement(By.xpath("(//*[@class='button-1 new-address-next-step-button'])[2]"));
        btnContinue2.click();

        Func.Wait(1);
        WebElement paymentMethod=driver.findElement(By.id("paymentmethod_0"));
        paymentMethod.click();


        Func.Wait(1);
        WebElement btnContinue3=driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']"));
        btnContinue3.click();

        Func.Wait(1);
        WebElement odemeYontemi=driver.findElement(By.xpath("//p[text()='You will pay by COD']"));
        Assert.assertTrue(" ödeme yöntemi doğrulanmadı!",odemeYontemi.getText().equals("You will pay by COD") );

        Func.Wait(1);
        WebElement btnContinue4=driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']"));
        btnContinue4.click();

        Func.Wait(1);
        List<WebElement> ucretler=driver.findElements(By.xpath("//span[@class='product-subtotal']"));
        Func.Wait(1);
        double toplam=0;
        for (WebElement e:ucretler){
            System.out.println(e.getText());
            toplam=toplam+Double.parseDouble(e.getText().replaceAll("[^0-9,.]",""));
        }
        System.out.println("toplam = " + toplam);

        Func.Wait(1);
        WebElement subtotalElement=driver.findElement(By.xpath("//span[@class='product-price']"));
        Double subtotal= Double.parseDouble( subtotalElement.getText().replaceAll("[^0-9,.]","")   );

        Func.Wait(1);
        WebElement additionalFee=driver.findElement(By.xpath("(//span[@class='product-price'])[3]"));
        Double fee= Double.parseDouble( additionalFee.getText().replaceAll("[^0-9,.]","")   );
        System.out.println("Payment method additional fee = " + fee);

        double total=subtotal+fee;
        System.out.println("total = " + total);
        Func.Wait(1);
        Assert.assertTrue("Değerler eşit değil", toplam+fee== total);

        Func.Wait(2);
        WebElement btnConfirm=driver.findElement(By.xpath("//*[@class='button-1 confirm-order-next-step-button']"));
        btnConfirm.click();

        Func.Wait(2);
        WebElement orderComplated=driver.findElement(By.xpath("//*[@class='title']"));
        Assert.assertTrue(" Sipariş tamamlanamadı !",orderComplated.getText().equals("Your order has been successfully processed!") );


        WaitAndClose();
    }
    @Test
    public void Test6() {

        // 1. Anasayfada giriş yapma
        driver.get("https://demowebshop.tricentis.com/");
        Func.Wait(2);
        WebElement loginLink = driver.findElement(By.className("ico-login"));
        loginLink.click();


        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys("soles26832@vikinoko.com");

        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("Test123test");

        WebElement loginButton = driver.findElement(By.cssSelector("input.button-1.login-button"));
        loginButton.click();
        Func.Wait(2);

        // 2. Hesabım sayfasına erişme
        WebElement myAccountLink = driver.findElement(By.linkText("soles26832@vikinoko.com"));
        Assert.assertTrue(myAccountLink.isDisplayed());
        myAccountLink.click();
        Func.Wait(2);

        // 3. Siparişler bağlantısına tıklama
        WebElement ordersLink = driver.findElement(By.linkText("Orders"));
        Assert.assertTrue(ordersLink.isDisplayed());
        ordersLink.click();
        Func.Wait(2);

        // 4. Sipariş geçmişi görüntüleme
        try {
            WebElement latestOrder = driver.findElement(By.cssSelector("input[value='Details']"));
            latestOrder.click();
            Func.Wait(2);
            WebElement productName = driver.findElement(By.xpath("//a[@href='/141-inch-laptop']"));
            System.out.println("Last Order: " + productName.getText());

        } catch (Exception e) {
            System.out.println("Last order not found!");
        }

        // Fatura linkine tıklayarak faturayı indirme:
        WebElement PDFInvoice = driver.findElement(By.cssSelector(".button-2.pdf-order-button"));
        PDFInvoice.click();
        Func.Wait(2);
        System.out.println("Your order invoice has been downloaded to your computer!");

        WaitAndClose();
    }
}




