import Utility.BaseDriver;
import Utility.Func;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        eMail.sendKeys("tester.selenıum12@gmail.com");
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
        driver = new ChromeDriver();
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
        driver = new ChromeDriver();
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
        WebElement logoutBtn = driver.findElement(By.xpath("//a[text()='Log out']"));
        logoutBtn.click();
        WebElement loginBtn2 = driver.findElement(By.xpath("//a[text()='Log in']"));
        loginBtn2.click();
        WaitAndClose();

    }

    @Test
    public void Test4() {
        driver = new ChromeDriver();
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
    public void Test5() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");


        WebElement btnLogin = driver.findElement(By.cssSelector("[class='ico-login']"));
        btnLogin.click();


        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("tester.selenıum12@gmail.com");


        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("testers12332");


        WebElement btnLogin2 = driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        btnLogin2.click();

        Func.Wait(1);
        WebElement electronics = driver.findElement(By.xpath("(//*[@href='/electronics'])[1]"));
        WebElement cellPhones = driver.findElement(By.xpath("(//*[@href='/cell-phones'])[1]"));

        Actions aksiyonDriver = new Actions(driver);

        Func.Wait(1);
        aksiyonDriver.moveToElement(electronics).build().perform();
        Func.Wait(1);
        aksiyonDriver.moveToElement(cellPhones).build().perform();
        Func.Wait(1);
        cellPhones.click();
        Func.Wait(1);

        WebElement AddToChart = driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]"));
        AddToChart.click();

        Func.Wait(1);
        WebElement sepetim = driver.findElement(By.xpath("(//*[@class='cart-label'])[1]"));
        sepetim.click();

        Func.Wait(2);
        WebElement product = driver.findElement(By.xpath("//a[@class='product-name']"));
        Assert.assertTrue("Smartphone yazısı sepetimde bulunamadı!", product.getText().contains("Smartphone"));

        Func.Wait(1);
        WebElement btnAgree = driver.findElement(By.id("termsofservice"));
        btnAgree.click();

        Func.Wait(1);
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        Func.Wait(2);
        WebElement webMenu = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select country = new Select(webMenu);
        country.selectByVisibleText("United States");

        Func.Wait(2);
        WebElement webMenu2 = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
        Select state = new Select(webMenu2);
        state.selectByVisibleText("Alabama");

        Func.Wait(2);
        WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
        city.sendKeys("Missouri");

        Func.Wait(1);
        WebElement adress1 = driver.findElement(By.id("BillingNewAddress_Address1"));
        adress1.sendKeys("Tecno");

        Func.Wait(1);
        WebElement zipcode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        zipcode.sendKeys("4444444");

        Func.Wait(1);
        WebElement phoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        phoneNumber.sendKeys("+1 99988877766");

        Func.Wait(1);
        WebElement btnContinue = driver.findElement(By.xpath("(//*[@class='button-1 new-address-next-step-button'])[1]"));
        btnContinue.click();

        Func.Wait(2);
        WebElement InStorePickup = driver.findElement(By.id("PickUpInStore"));
        InStorePickup.click();

        Func.Wait(1);
        WebElement shippingAddress = driver.findElement(By.xpath("//label[text()='Select a shipping address from your address book or enter a new address.']"));
        Assert.assertTrue("Kargolama adresi kaybolmadı!", shippingAddress.isEnabled());


        Func.Wait(1);
        WebElement btnContinue2 = driver.findElement(By.xpath("(//*[@class='button-1 new-address-next-step-button'])[2]"));
        btnContinue2.click();

        Func.Wait(1);
        WebElement paymentMethod = driver.findElement(By.id("paymentmethod_0"));
        paymentMethod.click();


        Func.Wait(1);
        WebElement btnContinue3 = driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']"));
        btnContinue3.click();

        Func.Wait(1);
        WebElement odemeYontemi = driver.findElement(By.xpath("//p[text()='You will pay by COD']"));
        Assert.assertTrue(" ödeme yöntemi doğrulanmadı!", odemeYontemi.getText().equals("You will pay by COD"));

        Func.Wait(1);
        WebElement btnContinue4 = driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']"));
        btnContinue4.click();

        Func.Wait(1);
        List<WebElement> ucretler = driver.findElements(By.xpath("//span[@class='product-subtotal']"));
        Func.Wait(1);
        double toplam = 0;
        for (WebElement e : ucretler) {
            System.out.println(e.getText());
            toplam = toplam + Double.parseDouble(e.getText().replaceAll("[^0-9,.]", ""));
        }
        System.out.println("toplam = " + toplam);

        Func.Wait(1);
        WebElement subtotalElement = driver.findElement(By.xpath("//span[@class='product-price']"));
        Double subtotal = Double.parseDouble(subtotalElement.getText().replaceAll("[^0-9,.]", ""));

        Func.Wait(1);
        WebElement additionalFee = driver.findElement(By.xpath("(//span[@class='product-price'])[3]"));
        Double fee = Double.parseDouble(additionalFee.getText().replaceAll("[^0-9,.]", ""));
        System.out.println("Payment method additional fee = " + fee);

        double total = subtotal + fee;
        System.out.println("total = " + total);
        Func.Wait(1);
        Assert.assertTrue("Değerler eşit değil", toplam + fee == total);

        Func.Wait(2);
        WebElement btnConfirm = driver.findElement(By.xpath("//*[@class='button-1 confirm-order-next-step-button']"));
        btnConfirm.click();

        Func.Wait(2);
        WebElement orderComplated = driver.findElement(By.xpath("//*[@class='title']"));
        Assert.assertTrue(" Sipariş tamamlanamadı !", orderComplated.getText().equals("Your order has been successfully processed!"));


        WaitAndClose();
    }

    @Test
    public void Test6() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        WebElement community = driver.findElement(By.xpath("//input[@id='pollanswers-1']"));
        community.click();

        WebElement button = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        button.click();

        WebElement msj = driver.findElement(By.xpath("//div[@id='block-poll-vote-error-1']"));

        Assert.assertTrue("mesaj bulundu", msj.isDisplayed());


        WebElement giris = driver.findElement(By.xpath("//a[@class='ico-login']"));
        giris.click();

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("tester.selenıum12@gmail.com");

        WebElement sifre = driver.findElement(By.xpath("//input[@id='Password']"));
        sifre.sendKeys("testers12332");


        WebElement but = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        but.click();


        WaitAndClose();
    }

    @Test
    public void Test7() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");


        WebElement giris = driver.findElement(By.xpath("//a[@class='ico-login']"));
        giris.click();

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("tester.selenıum12@gmail.com");

        WebElement sifre = driver.findElement(By.xpath("//input[@id='Password']"));
        sifre.sendKeys("testers12332");


        WebElement but = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        but.click();


        WebElement computers = driver.findElement(By.linkText("Computers"));
        computers.click();
        Func.Wait(2);

        WebElement masaustu = driver.findElement(By.xpath("//a[@title='Show products in category Desktops']"));
        masaustu.click();
        Func.Wait(2);

        WebElement addtoCart = driver.findElement(By.xpath("//input[@value='Add to cart']"));
        addtoCart.click();
        Func.Wait(2);

        WebElement sepet = driver.findElement(By.xpath("//input[@id='add-to-cart-button-72']"));
        sepet.click();
        Func.Wait(2);

        WebElement sepetac = driver.findElement(By.xpath("//span[@class='cart-label']"));
        sepetac.click();
        Func.Wait(2);

        WebElement sepetkontrol = driver.findElement(By.cssSelector("td[class='product-picture'] img"));
        Assert.assertTrue("sepet doğrulandı", sepetkontrol.isDisplayed());
        Func.Wait(2);

        WebElement apply = driver.findElement(By.xpath("//input[@name='discountcouponcode']"));
        apply.sendKeys("12345");
        Func.Wait(2);

        WebElement applybutton = driver.findElement(By.xpath("//input[@name='applydiscountcouponcode']"));
        applybutton.click();

        WebElement applydoğrulama = driver.findElement(By.cssSelector("div[class='message']"));
        Assert.assertTrue("kupon eklendi", applydoğrulama.isDisplayed());

        WebElement addgiftCard = driver.findElement(By.xpath("//input[@name='giftcardcouponcode']"));
        addgiftCard.sendKeys("12345");

        WebElement addgiftCardbutton = driver.findElement(By.xpath("//input[@name='applygiftcardcouponcode']"));
        addgiftCardbutton.click();
        Func.Wait(2);

        WebElement addgiftCardDoğrulama = driver.findElement(By.cssSelector("div[class='message']"));
        Assert.assertTrue("hediye kartı eklendi", addgiftCardDoğrulama.isDisplayed());
        Func.Wait(2);

        WebElement hizmetsartlari = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        hizmetsartlari.click();
        Func.Wait(2);

        WebElement Checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        Checkout.click();
        Func.Wait(2);

        WebElement gecis = driver.findElement(By.xpath("//input[@class='button-1 new-address-next-step-button'][@onclick='Billing.save()']"));
        gecis.click();
        Func.Wait(2);

        Func.Wait(2);

        WebElement isaret = driver.findElement(By.xpath("//input[@name='PickUpInStore']"));
        isaret.click();
        Func.Wait(2);

        WebElement contine2 = driver.findElement(By.cssSelector("div[id='shipping-buttons-container'] input"));
        contine2.click();
        Func.Wait(2);

        WebElement kartsecim = driver.findElement(By.xpath("//input[@id='paymentmethod_0']"));
        kartsecim.click();
        Func.Wait(2);

        WebElement contine3 = driver.findElement(By.cssSelector("input[class='button-1 payment-method-next-step-button']"));
        contine3.click();
        Func.Wait(2);

        WebElement contine4 = driver.findElement(By.cssSelector("input[class='button-1 payment-info-next-step-button']"));
        contine4.click();
        Func.Wait(2);

        WebElement contine5 = driver.findElement(By.cssSelector("input[class='button-1 confirm-order-next-step-button']"));
        contine5.click();
        Func.Wait(2);

        WebElement yazi = driver.findElement(By.cssSelector("div[class='title'] strong"));
        Assert.assertTrue("yazı gözüktü", yazi.isDisplayed());

        WaitAndClose();


    }
}


