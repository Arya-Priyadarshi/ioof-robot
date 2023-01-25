package com.ioof.robot.move;

import com.ioof.robot.exception.RobotSimulatorException;
import com.ioof.robot.move.enums.RobotDirection;

/**
 * Hold Robot's current coordinates and direction
 */
public class RobotPosition {

    private int xAxis;

    private int yAxis;

    private RobotDirection currentDirection;

    public RobotPosition(final int xAxis, final int yAxis, final RobotDirection currentDirection) {
        this.currentDirection = currentDirection;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public RobotDirection getCurrentDirection() throws RobotSimulatorException {
        if(null == this.currentDirection) {
            throw new RobotSimulatorException("Robot is not active!");
        }
        return currentDirection;
    }

    public void setCurrentDirection(RobotDirection currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void newCoordinates(final int x, final int y) {
        this.xAxis += x;
        this.yAxis += y;
    }
}
