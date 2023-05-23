# IDATG2001 Paths project
This is the final version of the Paths project in the course IDATG2001.
Paths is a non-linear text based story game that can be played through a JavaFX application.



## How to run (IntelliJ)

### Create executable JAR file

    1. Go to the maven tab in IntelliJ
    2. Open Lifecycle
        2.1 clean
        2.2 package
    3.Navigate to root folder of project
    4. Open target folder
    5. Run "Paths-1.0-SNAPSHOT.jar" 

### Run with JavaFX
    1. Go to the maven tab in IntelliJ
    2. Open Plugins
    3. javafx -> javafx::run

### Run from terminal
    1. mvn clean package
    2. mvn javafx::run

## How to run tests
    1. Go to the maven tab in IntelliJ
    2. Open Lifecycle
        2.1 clean
        2.2 test
    This will run all the automated tests.