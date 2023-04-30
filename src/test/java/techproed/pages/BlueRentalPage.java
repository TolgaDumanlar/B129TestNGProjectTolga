package techproed.pages;

import io.netty.buffer.ByteBuf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalPage {


        public BlueRentalPage(){
                PageFactory.initElements(Driver.getDriver(),this);
        }
        @FindBy(xpath = "(//*[@role='button'])[1]")
        public WebElement login;
        @FindBy(xpath = "//*[@id='formBasicEmail']")
        public WebElement email;

        @FindBy(xpath = "//*[@id='formBasicPassword']")
        public WebElement pass;
        @FindBy(id = "dropdown-basic-button")
        public WebElement verify;
        @FindBy( xpath = "//*[@class='invalid-feedback']")
        public WebElement hataMesaji;
        @FindBy(id = "dropdown-basic-button")
        public WebElement logOutDdm;
        @FindBy(xpath = "(//*[@class='dropdown-item'])[3]")
        public WebElement logOut;
        @FindBy(xpath = "//*[@class='ajs-button ajs-ok']")
        public WebElement areYouSure;
}
