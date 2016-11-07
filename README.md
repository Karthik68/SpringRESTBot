Toy Robot Simulator - REST BASED CLIENT
===================

Description
-----------

- The application is a simulation of a toy robot moving on a square tabletop,
  of dimensions 5 units x 5 units.
- There are no other obstructions on the table surface.
- The robot is free to roam around the surface of the table, but must be
  prevented from falling to destruction. Any movement that would result in the
  robot falling from the table must be prevented, however further valid
  movement commands must still be allowed.

Create an application that can read in commands of the following form:

    PLACE X,Y,F
    MOVE
    LEFT
    RIGHT
    REPORT

- PLACE will put the toy robot on the table in position X,Y and facing NORTH,
  SOUTH, EAST or WEST.
- The origin (0,0) can be considered to be the SOUTH WEST most corner.
- The first valid command to the robot is a PLACE command, after that, any
  sequence of commands may be issued, in any order, including another PLACE
  command. The application should discard all commands in the sequence until
  a valid PLACE command has been executed.
- MOVE will move the toy robot one unit forward in the direction it is
  currently facing.
- LEFT and RIGHT will rotate the robot 90 degrees in the specified direction
  without changing the position of the robot.
- REPORT will announce the X,Y and F of the robot. This can be in any form,
  but standard output is sufficient.

- A robot that is not on the table can choose the ignore the MOVE, LEFT, RIGHT
  and REPORT commands.
- Input can be from a file, or from standard input, as the developer chooses.
- Provide test data to exercise the application.

Constraints
-----------

- The toy robot must not fall off the table during movement. This also
  includes the initial placement of the toy robot.
- Any move that would cause the robot to fall must be ignored.

Example Input and Output
------------------------
I) Program Argument Input & Console Output:
===================

   Run com.bot.spring.rest.SpringRestBotApplication main class with run configuration program arguments as below

### Example a
restCmd1-PLACE:0,0,NORTH
restCmd2-MOVE
restCmd3-REPORT

Expected output:

    0,1,NORTH

### Example b
restCmd1-PLACE 0,0,NORTH
restCmd2-LEFT
restCmd3-REPORT

Expected output:

    0,0,WEST

### Example c
restCmd1-PLACE 1,2,EAST
restCmd2-MOVE
restCmd3-MOVE
restCmd4-LEFT
restCmd5-MOVE
restCmd6-REPORT

Expected output

    3,3,NORTH

II) Program Argument Input & Console Output:
===================

   Run com.bot.spring.rest.SpringRestBotApplication main class with run configuration program arguments as below

### Example a
file-Input.txt

Expected output (Based on Commands Added in Input.txt):

    0,1,NORTH
    
III) Java Console Input & Output:
===================
### Example a

    PLACE 0,0,NORTH
    MOVE
    REPORT

Expected output:

    0,1,NORTH

### Example b

    PLACE 0,0,NORTH
    LEFT
    REPORT

Expected output:

    0,0,WEST

### Example c

    PLACE 1,2,EAST
    MOVE
    MOVE
    LEFT
    MOVE
    REPORT

Expected output

    3,3,NORTH
