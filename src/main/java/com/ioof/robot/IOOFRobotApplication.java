package com.ioof.robot;

import com.ioof.robot.exception.RobotSimulatorException;
import com.ioof.robot.move.Robot;
import com.ioof.robot.move.RobotSimulator;
import com.ioof.robot.move.TableTop;

import java.io.Console;

/**
 *   IOOFRobotApplication class to kick off the Robot Challenge simulator
 */
public class IOOFRobotApplication {
    public static void main(String[] args) {

        Console console = System.console();

        /**
         *  handle console unavailability - if run through IDE
         */
        if(console == null) {
            System.err.println("IOOFRobot Console not available!");
            System.exit(0);
        }

        /**
         * Instructions
         */
        System.out.println("#####   Welcome, I am a IOOF Robot ######");
        System.out.println("IOOFRobot commands are ");
        System.out.println("\t1 - PLACE X,Y,FACING_DIRECTION (NORTH|SOUTH|EAST|WEST) (To place IOOF Robot on table).");
        System.out.println("\t2 - MOVE, LEFT, RIGHT (To roam on the table)");
        System.out.println("\t3 - REPORT (IOOF Robot's current location)");
        System.out.println("\t4 - QUIT (To finish roaming)");

        /**
         * flag to check if robot is active or not
         */
        boolean isAlive = true;

        /**
         * setup table top with units and create robot simulator
         * instance to receive commands
         */
        TableTop surface = new TableTop(4,4);
        RobotSimulator simulator = new RobotSimulator(surface, new Robot());

        while (isAlive) {
            String command = console.readLine(">> ");
            if ("QUIT".equalsIgnoreCase(command)) {
                isAlive = false;
            } else {
                try {
                    /**
                     * start processing commands
                     */
                    String result = simulator.processCommand(command);
                    if(null != result) {
                        System.out.println("Output: " + result);
                    }
                } catch (RobotSimulatorException e) {
                    /**
                     * catch all thrown exception and display message to console
                     */
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}