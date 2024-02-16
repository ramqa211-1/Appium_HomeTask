//package com.bluenile.testkit.base;
//
//import org.testng.Assert;
//import java.util.Date;
//
//import static com.bluenile.testkit.pages.desktop.BasePageObject.lambdaForString;
//
//public class AssertMethod {
//
//    public static synchronized void assertContains(String currentTXT, String containsTXT, String... lambdaExpectedTxt) {
//        String message = "The Text: " + containsTXT + " Is Not Appears In: " + currentTXT + " Text.";
//        if (lambdaExpectedTxt.length > 0) {
//            lambdaForString(lambdaExpectedTxt[0]);
//        }
//        Assert.assertTrue(currentTXT.contains(containsTXT), message);
//    }
//
//    public static synchronized void assertNotContains(String currentTXT, String notContainsTXT, String... lambdaExpectedTxt) {
//        String message = "The Text: " + notContainsTXT + " Should Not Appears In: " + currentTXT + " Text.";
//        if (lambdaExpectedTxt.length > 0) {
//            lambdaForString(lambdaExpectedTxt[0]);
//        }
//        Assert.assertFalse(currentTXT.contains(notContainsTXT), message);
//    }
//
//    public static synchronized void assertContainsORContains(String currentTXT, String containTXT, String orContainsTXT,
//                                                             String... errorMessage) {
//        String message = "The Text: " + containTXT + " OR Text: " + orContainsTXT + " Is Not Appears In: " + currentTXT + " Text.";
//        if (errorMessage.length > 0) {
//            message = errorMessage[0];
//        }
//        Assert.assertTrue(currentTXT.contains(containTXT) || currentTXT.contains(orContainsTXT), message);
//    }
//
//    public static synchronized void assertContainORContainsORContains(String currentTXT, String containsTXT, String orContainsTXT,
//                                                                      String orOrContainsTXT, String... errorMessage) {
//        String message = "The Text: " + containsTXT + " OR Text: " + orContainsTXT + "OR Text" + orOrContainsTXT +
//                " Is Not Appears In: " + currentTXT + " Text.";
//        if (errorMessage.length > 0) {
//            message = errorMessage[0];
//        }
//        Assert.assertTrue(currentTXT.contains(containsTXT) || currentTXT.contains(orContainsTXT)
//                || currentTXT.contains(orOrContainsTXT), message);
//    }
//
//    public static synchronized void assertStringContainsANDStringContains(String currentTXT, String containsTXT,
//                                                                          String andContainsTXT, String... errorMessage) {
//        String message = "The Text: " + containsTXT + " AND Text: " + andContainsTXT + " Is Not Appears In: " + currentTXT + " Text.";
//        if (errorMessage.length > 0) {
//            message = errorMessage[0];
//        }
//        Assert.assertTrue(currentTXT.contains(containsTXT) && currentTXT.contains(andContainsTXT), message);
//    }
//
//    public static synchronized void assertStringContainsANDStringContainsAndStringContains(
//            String currentTXT, String containsTXT, String andContainsTXT, String andAndContainsTXT, String... errorMessage) {
//        String message = "The Text: " + containsTXT + " AND Text: " + andContainsTXT +
//                " AND Text: " + andAndContainsTXT + " Is Not Appears In: " + currentTXT + " Text.";
//        if (errorMessage.length > 0) {
//            message = errorMessage[0];
//        }
//        Assert.assertTrue(currentTXT.contains(containsTXT) && currentTXT.contains(andContainsTXT) &&
//                currentTXT.contains(andAndContainsTXT), message);
//    }
//
//    public static synchronized void assertEquals(String actualTXT, String expectedTXT, String... errorMessage) {
//        String message = "The Text: " + expectedTXT + " Is Not Equals To: " + actualTXT + " Text.";
//        if (errorMessage.length > 0) {
//            message = errorMessage[0];
//        }
//        Assert.assertEquals(actualTXT, expectedTXT, message);
//    }
//
//    public static synchronized void assertEquals(int actualNumber, int expectedNumber, String... errorMessage) {
//        String message = "The Number: " + expectedNumber + " Should Be Equal To The: " + actualNumber + " Number.";
//        if (errorMessage.length > 0) {
//            message = errorMessage[0];
//        }
//        Assert.assertEquals(actualNumber, expectedNumber, message);
//    }
//
//    public static synchronized void assertLessThanOrEqual(int currentNumber, int lessOrEqualToNumber, String... errorMessage) {
//        String message = "The Number: " + currentNumber + " Should Be Less Than Or Equals To: " + lessOrEqualToNumber + " Number.";
//        if (errorMessage.length > 0) {
//            message = errorMessage[0];
//        }
//        Assert.assertTrue(currentNumber <= lessOrEqualToNumber, message);
//    }
//
//    public static synchronized void assertGreaterThanOrEqual(int currentNumber, int greaterOrEqualToNumber, String... errorMessage) {
//        String message = "The Number: " + currentNumber + " Should Be Greater Than Or Equals To: " + greaterOrEqualToNumber + " Number.";
//        if (errorMessage.length > 0) {
//            message = errorMessage[0];
//        }
//        Assert.assertTrue(currentNumber >= greaterOrEqualToNumber, message);
//    }
//
//    public static synchronized void assertGreaterThan(int currentNumber, int greaterThanNumber, String... errorMessage) {
//        String message = "The Number: " + greaterThanNumber + " Should Be Greater Than: " + currentNumber + " Number.";
//        if (errorMessage.length > 0) {
//            message = errorMessage[0];
//        }
//        Assert.assertTrue(currentNumber > greaterThanNumber, message);
//    }
//
//    public static synchronized void assertLessThan(int currentNumber, int lessThan, String... errorMessage) {
//        String message = "The Number: " + lessThan + " Should Be Less Than: " + currentNumber + " Number.";
//        if (errorMessage.length > 0) {
//            message = errorMessage[0];
//        }
//        Assert.assertTrue(currentNumber < lessThan, message);
//    }
//
//    public static synchronized void assertNotEqual(String currentTXT, String notEqualToTXT, String... errorMessage) {
//        String message = "The Text: " + notEqualToTXT + " Should Not Be Equals To: " + currentTXT + " Text.";
//        if (errorMessage.length > 0) {
//            message = errorMessage[0];
//        }
//        Assert.assertNotEquals(currentTXT, notEqualToTXT, message);
//    }
//
//    public static synchronized void assertNotEqual(int currentNumber, int notEqualToNumber, String... errorMessage) {
//        String message = "The Numbers: " + notEqualToNumber + " Should Not Be Equals To: " + currentNumber + " Number.";
//        if (errorMessage.length > 0) {
//            message = errorMessage[0];
//        }
//        Assert.assertNotEquals(currentNumber, notEqualToNumber, message);
//    }
//
//    public static synchronized void assertTrue(boolean boolTrue, String... errorMessage) {
//        String message = "Expected: 'TRUE', But Got: 'FALSE'.";
//        if (errorMessage.length > 0) {
//            message = errorMessage[0];
//        }
//        Assert.assertTrue(boolTrue, message);
//    }
//
//    public static synchronized void assertFalse(boolean boolCondition, String... errorMessage) {
//        String message = "Expected: 'FALSE', But Got: 'TRUE'.";
//        if (errorMessage.length > 0) {
//            message = errorMessage[0];
//        }
//        Assert.assertFalse(boolCondition, message);
//    }
//
//    public static synchronized void assertDateLessThanOrEquals(Date itemPageDate, Date galleryDate, String... errorMessage) {
//        String message = "The Item Page Date: " + itemPageDate + " Should Less Than Or Equal To Gallery Date: " + galleryDate + ".";
//        if(errorMessage.length > 0) {
//            message = errorMessage[0];
//        }
//        int condition = itemPageDate.compareTo(galleryDate); // 0 - Item page == gallery, -1 - item page < gallery
//        Assert.assertNotEquals(condition, 1, message);
//    }
//}