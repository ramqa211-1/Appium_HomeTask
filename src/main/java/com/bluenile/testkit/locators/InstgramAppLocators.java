package com.bluenile.testkit.locators;

import org.openqa.selenium.By;

public class InstgramAppLocators {


    public static By searchField = By.id("search-input");
    public static By mirrorGlassIconButton = By.id("search-icon-legacy");
    public static By filterButton = By.cssSelector("[aria-label='Search filters']");
    public static By videoButton = By.xpath("//*[text()='Video']");
    public static By ViewCountButton = By.xpath("//*[text()='View count']");
    public static By specificVideoLink = By.cssSelector("[href*='watch?v=ybXrrTX3LuI']");
    public static By userChannelName = By.xpath("//a[contains(@href, '@nikki7993') and @dir='auto']");
    public static By skidAdButton = By.id("ad-text:m");
    public static By showMoreButton = By.id("expand");
    public static By artistName =  By.xpath("//a[@href='/channel/UCgVq3HlmkLoh9CFt9i7Syug' and @dir='auto']");



}
