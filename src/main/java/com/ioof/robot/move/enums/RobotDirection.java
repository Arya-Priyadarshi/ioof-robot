package com.ioof.robot.move.enums;

/**
 * Hold direction with left and right faces with respect to
 * direction
 */
public enum RobotDirection {

    NORTH ("WEST", "EAST"),
    EAST ("NORTH", "SOUTH"),
    SOUTH ("EAST", "WEST"),
    WEST ("SOUTH", "NORTH");

    private String left;
    private String right;

    private RobotDirection(final String left, final String right) {
        this.left = left;
        this.right = right;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }
}
