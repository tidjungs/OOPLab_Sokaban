#Sokaban Game
Java TDD Tutorial in Object-Oriented Programming Laboratory

###Method (now success)
- Setup Board & Map
- Player can Move

###Usage

Play
```
javac Main.java
java Main
```

Test
```
javac -cp .:junit-4.12.jar GameboardTest.java
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore GameBoardTest
```
Another way to run Test
```
//test set board
javac -cp .:junit-4.12.jar GameboardTest.java
npm run test

//test moving
javac -cp .:junit-4.12.jar GameboardMovementTest.java
npm run test-move
```

download the current `junit-4.XX.jar` from JUnit's [release page](https://github.com/junit-team/junit/releases) and [Hamcrest](http://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar)






