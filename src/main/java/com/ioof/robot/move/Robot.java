package com.ioof.robot.move;

import com.ioof.robot.exception.RobotSimulatorException;
import com.ioof.robot.move.enums.RobotDirection;

/**
 * Robot class with behavior MOVE, LEFT, RIGHT or REPORT
 */
public class Robot {

    private RobotPosition currentPosition;

    public Robot() { }

    public RobotPosition getCurrentPosition() throws RobotSimulatorException {

        if(null == this.currentPosition) {
            throw new RobotSimulatorException("Robot is not active!");
        }
        return currentPosition;
    }

    public void setNewPosition(final RobotPosition position) {
        this.currentPosition = position;
    }

    public void move(final RobotPosition nextPosition) {
        this.currentPosition = nextPosition;
    }

    /**
     * will rotate the robot 90 degrees in the specified direction
     * @throws RobotSimulatorException
     */
    public void left() throws RobotSimulatorException {
        if(null == this.currentPosition) {
            throw new RobotSimulatorException("Robot is not active!");
        }
        this.currentPosition.setCurrentDirection(RobotDirection.valueOf(this.currentPosition.getCurrentDirection().getLeft()));
    }

    /**
     * will rotate the robot 90 degrees in the specified direction
     * @throws RobotSimulatorException
     */
    public void right() throws RobotSimulatorException {
        if(null == this.currentPosition) {
            throw new RobotSimulatorException("Robot is not active!");
        }
        this.currentPosition.setCurrentDirection(RobotDirection.valueOf(this.currentPosition.getCurrentDirection().getRight()));
    }

    /**
     * Will display current direction and coordinates.
     * @return
     * @throws RobotSimulatorException
     */
    public String reportPosition() throws RobotSimulatorException {
        StringBuilder report = new StringBuilder();
        report.append(this.getCurrentPosition().getXAxis())
                .append(",")
                .append(this.getCurrentPosition().getYAxis())
                .append(",")
                .append(this.getCurrentPosition().getCurrentDirection().toString());

        return report.toString();
    }

}
