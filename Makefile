.PHONY : test play


play: Main.class
	java Main
	
test-all: GameBoardTest.class GameBoardMovementTest.class
	java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore GameBoardTest
	java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore GameBoardMovementTest

test: GameBoardTest.class
	java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore GameBoardTest

test-move: GameBoardMovementTest.class
	java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore GameBoardMovementTest
	
GameBoardTest.class: GameBoardTest.java
	javac -cp .:junit-4.12.jar GameboardTest.java

GameboardMovementTest.class: GameboardMovementTest.java
	javac -cp .:junit-4.12.jar GameboardMovementTest.java

Main.class: Main.java
	javac Main.java