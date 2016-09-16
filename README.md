#Sokaban Game
Java TDD Tutorial in Object-Oriented Programming Laboratory

###Method (now success)
- Setup Board & Map
- Player can Move
- Push Box
- Win Game

###Usage

Play
```
javac Main.java
java Main
```
or
```
make play
```
Test
```
javac -cp .:junit-4.12.jar GameboardTest.java
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore GameBoardTest
```
Test Shortcut
- test all
```
make test-all
```
- test set board
```
make test
```
- test moving
```
make test-moving
```

download the current `junit-4.XX.jar` from JUnit's [release page](https://github.com/junit-team/junit/releases) and [Hamcrest](http://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar)






