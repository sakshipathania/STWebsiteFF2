package TestRunner.loginSteps;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.FbandGP_Object;
import ObjectRepository.SignupObject;
import TestRunner.SetupClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import webApp.PerformAction;

public class Facebook_signin_Unpaid_stepDefinition extends SetupClass {
	PerformAction wait = new PerformAction();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Random rad = new Random();

	// Open web site URl
	@Given("^Go to the application URL\\.$")
	public void navigates_to_website_url() throws InterruptedException {
		// Maximize Windows
		driver.get("https://www.slideteam.net");
		Thread.sleep(2000);
		try {
			WebElement sign = driver.findElement(SignupObject.close_add);
			sign.click();
			Thread.sleep(2000);
			log.info("It's opening the website URL");
		} catch (NoSuchElementException popup) {
		}

		try {
			WebElement logout = driver.findElement(By.cssSelector(".signin-link[title='Sign Out']"));
			if (logout.isEnabled()) {
				logout.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException Ext) {

		}
	}

	@Then("^navigate to complete deck from account dashboard page$")
         public void navigate_to_complete_deck_from_account_dashboard_page() throws InterruptedException  {
    
	 driver.get("https://www.slideteam.net/complete-powerpoint-decks-presentations/all-powerpoint-complete-decks.html");
	 Thread.sleep(3000);
	 
	 WebElement select_product= driver.findElement(By.cssSelector("li.product:nth-child(1) > div:nth-child(1) > div:nth-child(2) > strong:nth-child(1) > span:nth-child(1) > a:nth-child(1)"));
	  Thread.sleep(2000);   
	 select_product.click();
	   Thread.sleep(2000);
	    
            }


	@Then("^Click on download presentation link\\.$")
	public void click_on_Download_this_presentation_link() throws InterruptedException {
		WebElement download= driver.findElement(By.xpath("//*[@id='clicking']"));
		//wait.implictywait(driver);
		Thread.sleep(1000);
		download.click();
		Thread.sleep(2000);
	}

	@Then("^Click on fblink\\.$")
	public void fb_link() throws InterruptedException {
		WebElement FbLink = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[1]"));
		wait.implictywait(driver);
		FbLink.click();
		Thread.sleep(2000);
	}

	@Then("^Facebook user enter a email as\\.$")
	public void enter_user_mail() throws InterruptedException {
		Thread.sleep(1000);
		try {
		WebElement Fbemail = driver.findElement(By.xpath("//*[@id='email']"));
		//wait.implictywait(driver);
		Thread.sleep(1000);
	        Fbemail.click();
		//wait.implictywait(driver);
		Thread.sleep(1000);
		Fbemail.clear();
		//wait.implictywait(driver);
		Thread.sleep(1000);
		Fbemail.sendKeys("amw.vrushali@gmail.com");
		//wait.implictywait(driver);
		Thread.sleep(1000);
		} catch (NoSuchElementException alreadylogged) {

		}
	}
	

	@Then("^Facebook user enter password\\.$")
	public void enter_user_password() throws Throwable {
		try {
		WebElement Fpass= driver.findElement(By.xpath("//*[@id='pass']"));
		//wait.implictywait(driver);
		Thread.sleep(1000);
		Fpass.click();
		//wait.implictywait(driver);
		Thread.sleep(1000);
		Fpass.clear();
		//wait.implictywait(driver);
		Thread.sleep(1000);
		Fpass.sendKeys("vrushali@786");
		Thread.sleep(1000);
		//wait.implictywait(driver);
	} catch (NoSuchElementException alreadpass) {

	}

	}

	@Then("^Login the application\\.$")
	public void click_on_Login_button() throws Throwable {
		try {
		WebElement Appl= driver.findElement(By.xpath("//*[@id='loginbutton']"));
		//wait.implictywait(driver);
			Thread.sleep(1000);
		Appl.click();
		//wait.implictywait(driver);
		Thread.sleep(10000);
	} catch (NoSuchElementException alredylogin) {

	}

		try {
			WebElement FP= driver.findElement(FbandGP_Object.continue_as_QA);
			FP.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException qalink) {

		}
	}

	@Then("^See that user is redirected to price page\\.$")
	public void after_signup_redirect_to_price_page() throws Throwable {

		String actualTitle = driver.getTitle();
		//wait.implictywait(driver);
		Thread.sleep(1000);
		String expectedTitle = "Pricing";
		//wait.implictywait(driver);
		Thread.sleep(1000);
		Assert.assertEquals(expectedTitle, actualTitle);
		//wait.implictywait(driver);
		Thread.sleep(1000);
	}

	@Then("^Subscribe the product\\.$")
	public void select_any_of_price_subscription() throws Throwable {
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(1000);
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),' Join now ')]"));
		int randomValue = rad.nextInt(list.size()); // Getting a random value that is between 0 and (list's size)-1
		Thread.sleep(1000);
		list.get(randomValue).click();
		Thread.sleep(2000);
	}

	@Then("^Verify the payment section information\\.$")
	public void verify_the_payment_option_field() throws Throwable {
		String payment_text = driver.findElement(SignupObject.payment).getText();
		String ExpectTitle = "PAYMENT INFORMATION";
		System.out.println(payment_text);
		Assert.assertEquals(ExpectTitle, payment_text);
		Thread.sleep(1000);
	}

	@Then("^Verify the by default payment option as paypal\\.$")
	public void see_default_payment_option_as_paypal() throws Throwable {
		WebElement Pay_pal = driver.findElement(SignupObject.paypay_radio_button);
		if (!driver.findElement(SignupObject.paypay_radio_button).isSelected())
		// to check the check box is already selected or not
		{
			driver.findElement(SignupObject.paypay_radio_button).click();
			//wait.implictywait(driver);
			Thread.sleep(1000);
		}

		String paypal_text = driver.findElement(SignupObject.verify_paypal_text).getText();
		String ExpectTitle = "You will be redirected to the PayPal website when you place an order.";
		Assert.assertEquals(ExpectTitle, paypal_text);
		Thread.sleep(1000);
	}

	@Then("^Enter the coupon as showing\\.$")
	public void enter_coupon() {
		WebElement cou_pon= driver.findElement(SignupObject.Enter_Coupon);
		//wait.implictywait(driver);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", cou_pon);
		//wait.implictywait(driver);
		Thread.sleep(1000);
		cou_pon.clear();
		//wait.implictywait(driver);
		Thread.sleep(1000);
		cou_pon.sendKeys("5OFF");
		Thread.sleep(1000);
		//wait.implictywait(driver);
	}

	@Then("^Apply coupon the code\\.$")
	public void apply_the_cuopon_code() throws Throwable {
		WebElement Coupon_code = driver.findElement(SignupObject.Apply_Coupon);
		js.executeScript("arguments[0].click();", Coupon_code);
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);

	}

	@Then("^Verify the apply code is applied\\.$")
	public void verify_the_applied_coupon_code_offer() throws Throwable {
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		String applied_code = driver.findElement(SignupObject.verify_apply_code).getText();
		System.out.println(applied_code);
		String ExpectTitle = "Discount (5OFF)";
		Assert.assertEquals(ExpectTitle, applied_code);
		Thread.sleep(1000);
	}

	@Then("^Go to payement page\\.$")
	public void click_on_place_order_CTA() throws Throwable {
		WebElement Pay_ment = driver.findElement(SignupObject.place_cta);
		//wait.implictywait(driver);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", Pay_ment);
		Thread.sleep(5000);
	}

	@Then("^Verify the payment page is payapal\\.$")
	public void verify_the_paypal_payement_page() throws Throwable {
		Thread.sleep(4000);
		 try {
			 String actualTitle1 = driver.getTitle();
			 Thread.sleep(1000);
				//wait.implictywait(driver);
				System.out.println(actualTitle1);
				String expectedTitle1 = "Billing Information - PayPal";
			 Thread.sleep(1000);
				//wait.implictywait(driver);
				String expectedTitle2="PayPal Checkout";
				//wait.implictywait(driver);
			 Thread.sleep(1000);
				
			    if(actualTitle1.equals(expectedTitle1)) {
				Assert.assertEquals(expectedTitle1, actualTitle1);
				//wait.implictywait(driver);
				Thread.sleep(3000);
				System.out.println("title does not matched");
	}
		 else {
				Assert.assertEquals(expectedTitle2, actualTitle1);
				//wait.implictywait(driver);
			 Thread.sleep(1000);
				System.out.println(actualTitle1);
				Thread.sleep(3000);
				System.out.println("title matched");
		    }
		 }
		 catch (NoSuchElementException checkPaypapayement){
	
		 }
	}

	

	@Then("^Select the payment option as CARD\\.$")
	public void select_payment_option_as_Card() throws Throwable {
		WebElement Payment_option= driver.findElement(SignupObject.card_radio_button);
		Payment_option.click();
		Thread.sleep(1000);
		String card_text = driver.findElement(SignupObject.verify_2checkout).getText();
		System.out.println(card_text);
		String ExpectTitle = "2Checkout (Visa, Amex, Discover, JCB, Diners Club, Debit Card, PayPal)";

		Assert.assertEquals(ExpectTitle, card_text);
		Thread.sleep(1000);

	}

	@Then("^Verify the payment page is card chekout\\.$")
	public void card_page() throws InterruptedException {
		Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		Thread.sleep(1000);
		//wait.implictywait(driver);
		String expectedTitle = "2Checkout";
		//wait.implictywait(driver);
		Thread.sleep(1000);
		Assert.assertEquals(expectedTitle, actualTitle);
		//wait.implictywait(driver);
		Thread.sleep(1000);
		System.out.println(actualTitle);
		Thread.sleep(3000);
	}

}
