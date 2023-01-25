package com.ioof.robot.move.enums;

import com.ioof.robot.exception.RobotSimulatorException;

/**
 * Hold all valid commands for robot
 */
public enum RobotCommand {
    PLACE,
    MOVE,
    RIGHT,
    LEFT,
    REPORT,
    QUIT;

    /**
     * validate passed commands and throw exception if not a valid
     * @param command
     * @return
     * @throws RobotSimulatorException
     */
    public static RobotCommand validateCommand(final String command) throws RobotSimulatorException {
        try {
            return RobotCommand.valueOf(command);
        } catch(IllegalArgumentException e) {
            throw new RobotSimulatorException("Alien command to me!");
        }
    }
}
