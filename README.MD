# BookingComSearchTest
<br>Add to cart functionality test with using Page Object pattern. </br>
Performed for the website: https://rozetka.com.ua/
## Prerequisites
* **JDK version >= 11.0.1**
* **Apache Maven version >= 3.6.0**
* **Google Chrome version <= 79.0**
* **FireFox Mozilla version <= 70.0**
## Project structure
* [src/main/java/Page.java](https://github.com/y-nochnyk/RozetkaAddToCartTest/blob/master/src/main/java/Page.java) - the class specifying all the web-elements and the methods used for all the tests
* [src/test/java/AddToCartTest.java](https://github.com/y-nochnyk/RozetkaAddToCartTest/blob/master/src/test/java/AddToCartTest.java) - all the tests, which may be performed for each of two (Chrome, FireFox) web-browsers using TestNG
## Run 
* **To run tests for Chrome:**
<br>Uncomment line 40 in the file AddToCartTest.java.
<br>Make sure line 39 is commented. Then open terminal and use: 
```
mvn test
```
* **To run tests for Firefox:**
<br>Uncomment line 39 in the file AddToCartTest.java.
<br>Make sure line 40 is commented. Then open terminal and use:
```
mvn test
```
