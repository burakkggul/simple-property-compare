# Simple Property Compare
This project was created to compare two property files and detect the differences between them.

## How to use?
### Prequisites
1. Maven 3.6.3 or higher
2. JRE 1.8 or higher

The first parameter you will give to the application must be your main property file. The second parameter is the main property file and the property file you want to get the difference between.

#### Example Usage
```
java -jar simple-property-compare-1.0.0.jar /home/burak/messages.properties /home/burak/messages-last.properties
