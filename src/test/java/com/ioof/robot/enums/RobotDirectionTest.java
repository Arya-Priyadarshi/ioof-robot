package com.ioof.robot.enums;

import com.ioof.robot.move.enums.RobotDirection;
import org.junit.Assert;
import org.junit.Test;

public class RobotDirectionTest {

    @Test
    public void testDirection() {
        RobotDirection direction = RobotDirection.EAST;

        Assert.assertEquals(direction.getLeft(), RobotDirection.NORTH.name());
        Assert.assertEquals(direction.getRight(), RobotDirection.SOUTH.name());

        direction = RobotDirection.NORTH;

        Assert.assertEquals(direction.getLeft(), RobotDirection.WEST.name());
        Assert.assertEquals(direction.getRight(), RobotDirection.EAST.name());

        direction = RobotDirection.WEST;

        Assert.assertEquals(direction.getLeft(), RobotDirection.SOUTH.name());
        Assert.assertEquals(direction.getRight(), RobotDirection.NORTH.name());

        direction = RobotDirection.SOUTH;

        Assert.assertEquals(direction.getLeft(), RobotDirection.EAST.name());
        Assert.assertEquals(direction.getRight(), RobotDirection.WEST.name());
    }
}
