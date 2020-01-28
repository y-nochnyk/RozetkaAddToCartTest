# BookingComSearchTest
Search functionality tests performed for website: https://www.booking.com/
## Prerequisites
* **JDK version >= 11.0.1**
* **Apache Maven version >= 3.6.0**
* **Google Chrome version <= 78.0**
* **FireFox Mozilla version <= 70.0**
* **Internet Explorer version <= 11.0**
## Project structure
* [src/main/resources/Info.txt](https://github.com/y-nochnyk/BookingComSearchTest/blob/master/src/main/resources/Info.txt) - detailed information about all the tests
* [src/main/java/Page.java](https://github.com/y-nochnyk/BookingComSearchTest/blob/master/src/main/java/Page.java) - the class describing all the elements of the website and the methods used for all the tests
* [src/test/java/BookingTest.java](https://github.com/y-nochnyk/BookingComSearchTest/blob/master/src/test/java/BookingTest.java) - all the tests, which may be performed for each of three (Chrome, FireFox, Internet Explorer) browsers using TestNG
## Run 
* **To run tests for Chrome:**
<br>Uncomment line 36 in the file BookingTest.java.
<br>Make sure lines 37 and 38 are commented. Then open terminal and use: 
```
mvn test
```
* **To run tests for Firefox:**
<br>Uncomment line 37 in the file BookingTest.java.
<br>Make sure lines 36 and 38 are commented. Then open terminal and use:
```
mvn test
```
* **To run tests for Internet Explorer:**
<br>Uncomment line 38 in the file BookingTest.java.
<br>Make sure lines 36 and 37 are commented. Then open terminal and use:
```
mvn test
```
