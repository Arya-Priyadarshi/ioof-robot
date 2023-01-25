package com.ioof.robot;

import com.ioof.robot.exception.RobotSimulatorException;
import com.ioof.robot.move.Robot;
import com.ioof.robot.move.RobotPosition;
import com.ioof.robot.move.enums.RobotDirection;
import org.junit.Assert;
import org.junit.Test;

public class RobotTest {

    @Test
    public void testRobotMoveCommand() throws RobotSimulatorException {
        Robot robot = new Robot();
        robot.setNewPosition(new RobotPosition(1,3, RobotDirection.WEST));
        robot.move(new RobotPosition(2,2, RobotDirection.WEST));
        Assert.assertEquals("2,2,WEST", robot.reportPosition());
    }

    @Test
    public void testRobotLeftCommand() throws RobotSimulatorException {
        Robot robot = new Robot();
        robot.setNewPosition(new RobotPosition(1,3, RobotDirection.WEST));
        robot.move(new RobotPosition(2,2, RobotDirection.WEST));
        robot.left();
        Assert.assertEquals("2,2,SOUTH", robot.reportPosition());
    }

    @Test
    public void testRobotRightCommand() throws RobotSimulatorException {
        Robot robot = new Robot();
        robot.setNewPosition(new RobotPosition(1,3, RobotDirection.WEST));
        robot.move(new RobotPosition(2,2, RobotDirection.WEST));
        robot.right();
        Assert.assertEquals("2,2,NORTH", robot.reportPosition());
    }
}
