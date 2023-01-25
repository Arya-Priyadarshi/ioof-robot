package com.ioof.robot;


import com.ioof.robot.exception.RobotSimulatorException;
import com.ioof.robot.move.Robot;
import com.ioof.robot.move.RobotSimulator;
import com.ioof.robot.move.TableTop;
import org.junit.Assert;
import org.junit.Test;

public class RobotSimulatorTest {

    private static final int WIDTH = 4;
    private static final int HEIGHT = 4;

    @Test
    public void testMoveCommand() throws RobotSimulatorException {
        RobotSimulator simulator = new RobotSimulator(
                new TableTop(WIDTH,HEIGHT),
                new Robot());

        simulator.processCommand("PLACE 0,2,NORTH");
        simulator.processCommand("MOVE");

        Assert.assertEquals("0,3,NORTH", simulator.processCommand("REPORT"));
    }

    @Test
    public void testTableTopLimit() throws RobotSimulatorException {
        RobotSimulator simulator = new RobotSimulator(
                new TableTop(WIDTH,HEIGHT),
                new Robot());
        simulator.processCommand("PLACE 0,4,NORTH");
        //extra move
        simulator.processCommand("MOVE");

        Assert.assertEquals("0,4,NORTH", simulator.processCommand("REPORT"));

    }

    @Test
    public void testLeftCommand() throws RobotSimulatorException {
        RobotSimulator simulator = new RobotSimulator(
                new TableTop(WIDTH,HEIGHT),
                new Robot());
        simulator.processCommand("PLACE 0,4,NORTH");

        simulator.processCommand("LEFT");
        Assert.assertEquals("0,4,WEST", simulator.processCommand("REPORT"));

        simulator.processCommand("MOVE");
        Assert.assertEquals("0,4,WEST", simulator.processCommand("REPORT"));

    }

    @Test
    public void testRightCommand() throws RobotSimulatorException {
        RobotSimulator simulator = new RobotSimulator(
                new TableTop(WIDTH,HEIGHT),
                new Robot());
        simulator.processCommand("PLACE 4,0,EAST");

        simulator.processCommand("RIGHT");
        Assert.assertEquals("4,0,SOUTH", simulator.processCommand("REPORT"));

        simulator.processCommand("MOVE");
        Assert.assertEquals("4,0,SOUTH", simulator.processCommand("REPORT"));

    }

    @Test (expected = RobotSimulatorException.class)
    public void testInvalidPlacement() throws RobotSimulatorException {
        RobotSimulator simulator = new RobotSimulator(
                new TableTop(WIDTH,HEIGHT),
                new Robot());
        simulator.processCommand("PLACE 5,0,EAST");
    }

    @Test (expected = RobotSimulatorException.class)
    public void testInvalidCommand() throws RobotSimulatorException {
        RobotSimulator simulator = new RobotSimulator(
                new TableTop(WIDTH,HEIGHT),
                new Robot());
        simulator.processCommand("PLACE 4,0,EAST");
        simulator.processCommand("ADFDF");
    }
}
