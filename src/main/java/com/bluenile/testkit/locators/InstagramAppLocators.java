package com.bluenile.testkit.locators;

import org.openqa.selenium.By;

public class InstagramAppLocators {
    public static By profileButtonBottomMenu = By.id("com.instagram.android:id/tab_avatar");
    public static By menuSide = By.xpath("//android.widget.Button[@content-desc=\"Options\"]");
    public static By settingsPrivacyButton = By.xpath("//android.widget.Button[@content-desc=\"Settings and privacy\"]");
    public static By logoutAllAccounts = By.xpath("//android.widget.Button[@content-desc=\"Log out all accounts. Logs out all accounts\"]");
    public static By logOut = By.id("com.instagram.android:id/bb_primary_action_container");
    public static By logInAnotherAccount = By.xpath("//android.widget.Button[@content-desc=\"Log into another account\"]/android.view.ViewGroup");
    public static By emailField = By.xpath("//android.widget.EditText[@text=\"ramivelestal\"]");
    public static By passWordField = By.xpath("//android.widget.FrameLayout[@resource-id=\"com.instagram.android:id/layout_container_main\"]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]");
    public static By logInButton = By.xpath("//android.widget.Button[@content-desc=\"Log in\"]/android.view.ViewGroup");
    public static By storyHighlightsHeader = By.id("com.instagram.android:id/tray_header");
    public static By errorMessageLogin = By.xpath("//android.widget.LinearLayout[@resource-id=\"android:id/parentPanel\"]");
}
