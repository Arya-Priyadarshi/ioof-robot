# ioof-robot
The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5 units.

Environment

JAVA 11
Maven
Junit (Unit Testing)


Build & Run
build: mvn clean install - a compiled jar will be available in target folder and use following
commands java -jar ioof-robot-1.0-SNAPSHOT.jar to run from jar file.

Example Input and Output:
-------------------------
a)

PLACE 0,0,NORTH
MOVE
REPORT

Output: 0,1,NORTH
-------------------------
b)

PLACE 0,0,NORTH
LEFT
REPORT

Output: 0,0,WEST
-------------------------
c)

PLACE 1,2,EAST
MOVE
MOVE
LEFT
MOVE
REPORT

Output: 3,3,NORTH
