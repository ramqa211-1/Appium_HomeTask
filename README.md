I wrote my code using the Java programming language within a Maven framework, incorporating TestNG for test management. The tools I utilized for debugging and building my tests on real Android devices include the Appium server and Appium inspector.

To execute my tests, I can run them locally either from the test class itself, named 'maccabiAppTaskTest,' or from the XML file named 'maccabiTask.xml.'

To run my tests successfully, the following dependencies need to be installed:
- Maven
- Java 17
- An integrated development environment (IDE) such as IntelliJ or Eclipse.

For reporting purposes, I use the 'Allure' reporting tool. After running the tests from the XML file, I open the command prompt (CMD) and execute the 'allure serve' command. This action generates an HTML page containing the test report, which is automatically opened for review.
