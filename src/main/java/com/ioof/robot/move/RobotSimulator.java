package com.ioof.robot.move;

import com.ioof.robot.exception.RobotSimulatorException;
import com.ioof.robot.move.enums.RobotCommand;
import com.ioof.robot.move.enums.RobotDirection;

/**
 * Hold robot and table top instance. Receive commands and process
 * according to current robot position.
 */
public class RobotSimulator {

    private TableTop surface;

    private Robot robot;

    /**
     * Constructor
     * @param surface
     * @param robot
     */
    public RobotSimulator(final TableTop surface, final Robot robot) {
        this.surface = surface;
        this.robot = robot;
    }

    /**
     * Replace robot current position
     * @param position
     * @throws RobotSimulatorException
     */
    public void placeRobot(final RobotPosition position) throws RobotSimulatorException {

        if(!this.surface.checkCoordinates(position)) {
            throw new RobotSimulatorException("Invalid coordinates!");
        }

        this.robot.setNewPosition(position);
    }

    /**
     * Core method to process all user commands, validate and process.
     * @param input
     * @return
     * @throws RobotSimulatorException
     */
    public String processCommand(final String input) throws RobotSimulatorException {
        String result = null;
        String[] commands = input.split(" ");
        if(commands.length > 0) {

            RobotCommand command = RobotCommand.validateCommand(commands[0]);

            switch (command) {
                case PLACE:
                    this.placeRobot(this.getPosition(command, commands));
                    break;
                case MOVE:
                    RobotPosition nextPosition = this.getNextPosition();
                    /**
                     * move only if new position is a valid position
                     * according to table top units.
                     */
                    if(this.surface.checkCoordinates(nextPosition)) {
                        this.robot.move(nextPosition);
                    }
                    break;
                case REPORT:
                    result = this.robot.reportPosition();
                    break;
                case RIGHT:
                    this.robot.right();
                    break;
                case LEFT:
                    this.robot.left();
                    break;
                default:
                    throw new RobotSimulatorException("Alien command to me!");
            }
        } else {
            throw new RobotSimulatorException("Alien command to me!");
        }

        return result;
    }

    /**
     * Get position & direction if passed command is PLACE
     * @param command
     * @param input
     * @return
     * @throws RobotSimulatorException
     */
    private RobotPosition getPosition(final RobotCommand command, final String[] input) throws RobotSimulatorException {
        String[] commands;
        int xAxis = 0;
        int yAxis = 0;
        RobotPosition position = null;
        if (command == RobotCommand.PLACE) {
            try {
                commands = input[1].split(",");

                xAxis = Integer.parseInt(commands[0]);
                yAxis = Integer.parseInt(commands[1]);
                RobotDirection direction = RobotDirection.valueOf(commands[2]);
                position = new RobotPosition(xAxis, yAxis, direction);

            } catch (Exception e) {
                throw new RobotSimulatorException("Alien command to me!");
            }
        }

        return position;
    }

    /**
     * Build a new position instance in case of MOVE command
     * @return
     * @throws RobotSimulatorException
     */
    private RobotPosition getNextPosition() throws RobotSimulatorException {
        RobotPosition nextPosition = new RobotPosition(this.robot.getCurrentPosition().getXAxis(),
                this.robot.getCurrentPosition().getYAxis(),
                this.robot.getCurrentPosition().getCurrentDirection());
        switch (this.robot.getCurrentPosition().getCurrentDirection()) {
            case NORTH:
                nextPosition.newCoordinates(0, 1);
                break;
            case EAST:
                nextPosition.newCoordinates(1, 0);
                break;
            case SOUTH:
                nextPosition.newCoordinates(0, -1);
                break;
            case WEST:
                nextPosition.newCoordinates(-1, 0);
                break;
        }

        return nextPosition;
    }
}
