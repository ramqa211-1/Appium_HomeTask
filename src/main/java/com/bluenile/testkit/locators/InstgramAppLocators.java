package com.bluenile.testkit.locators;

import org.openqa.selenium.By;

public class InstgramAppLocators {

    public static By profileButtonBottomMenu = By.id("com.instagram.android:id/tab_avatar");
    public static By menuSide = By.xpath("//android.widget.Button[@content-desc=\"Options\"]");
    public static By settingsPrivacyButton = By.xpath("//android.widget.Button[@content-desc=\"Settings and privacy\"]");
    public static By logoutAllAccounts = By.xpath("//android.widget.Button[@content-desc=\"Log out all accounts. Logs out all accounts\"]");
    public static By logOut = By.id("com.instagram.android:id/bb_primary_action_container");
    public static By logInAnotherAccount = By.xpath("//android.widget.Button[@content-desc=\"Log into another account\"]/android.view.ViewGroup");
    public static By emailField = By.xpath("//android.widget.EditText[@text=\"ramivelestal\"]");
    public static By logInButton = By.xpath("//android.widget.Button[@content-desc=\"Log in\"]/android.view.ViewGroup");
    public static By storyHighlightsHeader = By.id("com.instagram.android:id/tray_header");



}
