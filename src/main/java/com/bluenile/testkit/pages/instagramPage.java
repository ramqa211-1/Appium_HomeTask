package com.bluenile.testkit.pages;
import io.qameta.allure.*;
import io.appium.java_client.android.AndroidElement;

public class instagramPage extends BasePageObject{

    @Step("click on logout button")
    public static void clickOnLogOutButton() {
        AndroidElement logOut = (AndroidElement) driver.findElement(instgramAppLocators.logOut);
        tapElement(logOut);
    }

    @Step("click on Profile Button Bottom Menu")
    public static void clickOnProfileButtonBottomMenu() {
        AndroidElement profileButtonBottomMenu = (AndroidElement) driver.findElement(instgramAppLocators.profileButtonBottomMenu);
        tapElement(profileButtonBottomMenu);
    }

    @Step("click on password Field button and enter text")
    public static void clickOnPasswordFieldAndEnterText(String passwordText) {
        AndroidElement passWordField = (AndroidElement) driver.findElement(instgramAppLocators.passWordField);
        tapElement(passWordField);
        passWordField.sendKeys(passwordText);
    }

    @Step("click on Menu side button")
    public static void clickOnMenuSideButton() {
        AndroidElement menuSide = (AndroidElement) driver.findElement(instgramAppLocators.menuSide);
        tapElement(menuSide);
    }

    @Step("click on settings Privacy Button")
    public static void clickOnSettingsPrivacyButton() {
        AndroidElement settingsPrivacyButton = (AndroidElement) driver.findElement(instgramAppLocators.settingsPrivacyButton);
        tapElement(settingsPrivacyButton);
    }

    @Step("click on Logout All Accounts button")
    public static void clickOnLogoutAllAccounts() {
        AndroidElement logoutAllAccounts = (AndroidElement) driver.findElement(instgramAppLocators.logoutAllAccounts);
        tapElement(logoutAllAccounts);
    }

    @Step("click on log In Another Account button")
    public static void clickOnLogInAnotherAccount() {
        AndroidElement logInAnotherAccount = (AndroidElement) driver.findElement(instgramAppLocators.logInAnotherAccount);
        tapElement(logInAnotherAccount);
    }

    @Step("click on log In button")
    public static void clickOnLogInButton() {
        AndroidElement logInButton = (AndroidElement) driver.findElement(instgramAppLocators.logInButton);
        tapElement(logInButton);
    }
    @Step("click on email Field button and enter text")
    public static void clickOnEmailFieldAndEnterText(String emailText) {
        AndroidElement emailField = (AndroidElement) driver.findElement(instgramAppLocators.emailField);
        tapElement(emailField);
        emailField.sendKeys(emailText);
    }
}