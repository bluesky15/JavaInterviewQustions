package com.lkb.questions;

import java.awt.*;

public class ParkingSpace {
    Point statingPoint;
    Point endingPoint;
    int cellCount;

    public ParkingSpace(int[] params) {
        this.statingPoint = new Point(params[0], params[1]);
        this.endingPoint = new Point(params[2], params[3]);
        this.cellCount = (int) this.statingPoint.getY() * (int)((this.endingPoint.getY()-this.statingPoint.getY())+1);
    }

    public Point[] getAllSquareBlocks() {
        Point[] allPoints = new Point[cellCount];
        for (int i = 0; i < cellCount; i++) {
            Point allPoint = allPoints[i];

        }
        return null;
    }
}
