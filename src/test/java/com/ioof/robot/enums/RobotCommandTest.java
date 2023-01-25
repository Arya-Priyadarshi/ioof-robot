package com.ioof.robot.enums;

import com.ioof.robot.exception.RobotSimulatorException;
import com.ioof.robot.move.enums.RobotCommand;
import org.junit.Assert;
import org.junit.Test;

public class RobotCommandTest {

    @Test
    public void testDirection() throws RobotSimulatorException {

        RobotCommand command = RobotCommand.PLACE;
        Assert.assertEquals(command, RobotCommand.validateCommand("PLACE"));

        command = RobotCommand.MOVE;
        Assert.assertEquals(command, RobotCommand.validateCommand("MOVE"));

        command = RobotCommand.QUIT;
        Assert.assertEquals(command, RobotCommand.validateCommand("QUIT"));
    }

    @Test (expected = RobotSimulatorException.class)
    public void testInvalidCommand() throws RobotSimulatorException {
        RobotCommand.validateCommand("ABCD");
    }
}
