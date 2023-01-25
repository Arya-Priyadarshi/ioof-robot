package com.ioof.robot.move;

/**
 * Table top surface bean
 */
public class TableTop {

    /**
     * Table top width
     */
    private int width;

    /**
     * Table top height
     */
    private int height;

    public TableTop(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * validate current position coordinates with respect to table top
     * surface units
     * @param position
     * @return true if valid otherwise false
     */
    public boolean checkCoordinates(final RobotPosition position) {
        return (position.getXAxis() <= this.width && position.getXAxis() >= 0 )
                && (position.getYAxis() <= this.height && position.getYAxis() >= 0);
    }
}

