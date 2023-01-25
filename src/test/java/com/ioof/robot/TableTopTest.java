package com.ioof.robot;

import com.ioof.robot.move.RobotPosition;
import com.ioof.robot.move.TableTop;
import com.ioof.robot.move.enums.RobotDirection;
import org.junit.Assert;
import org.junit.Test;


public class TableTopTest {

    @Test
    public void testValidCoordinates() {
        TableTop surface = new TableTop(4,4);
        RobotPosition position = new RobotPosition(0,3, RobotDirection.NORTH);

        Assert.assertTrue(surface.checkCoordinates(position));
    }

    @Test
    public void testInvalidCoordinates() {
        TableTop surface = new TableTop(4,4);
        RobotPosition position = new RobotPosition(-1,0, RobotDirection.NORTH);
        Assert.assertFalse(surface.checkCoordinates(position));
    }


}
