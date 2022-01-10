/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package test1.java;

import java.util.*;

public class TurtleSoup {

    /**
     * Draw a square.
     *
     * @param turtle     the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
        turtle.forward(sideLength);
        turtle.turn(90);
        turtle.forward(sideLength);
        turtle.turn(90);
        turtle.forward(sideLength);
        turtle.turn(90);
        turtle.forward(sideLength);
        turtle.turn(90);
        //throw new RuntimeException("implement me!");
    }

    /**
     * Determine inside angles of a regular polygon.
     * <p>
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     *
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     * 通过边获得角度
     */
    public static double calculateRegularPolygonAngle(int sides) {
        return 180 * (sides - 2.0) / sides;
        //throw new RuntimeException("implement me!");
    }

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     * <p>
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     *
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     * 角度推边
     */
    public static int calculatePolygonSidesFromAngle(double angle) {
        return (int) Math.round(360.0 / (180.0 - angle));
        //throw new RuntimeException("implement me!");
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * <p>
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     *
     * @param turtle     the turtle context
     * @param sides      number of sides of the polygon to draw
     * @param sideLength length of each side
     *                   画正多边形，输入边数，边长
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
        double angle = 180.0 - calculateRegularPolygonAngle(sides);
        for (int i = 0; i < sides; i++) {
            turtle.forward(sideLength);
            turtle.turn(angle);
        }
        //throw new RuntimeException("implement me!");
    }

    /**
     * Given the current direction, current location, and a target location, calculate the Bearing
     * towards the target point.
     * <p>
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentBearing. The angle must be expressed in
     * degrees, where 0 <= angle < 360.
     * <p>
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     *
     * @param currentBearing current direction as clockwise from north 当前偏移的度数
     * @param currentX       current location x-coordinate
     * @param currentY       current location y-coordinate
     * @param targetX        target point x-coordinate
     * @param targetY        target point y-coordinate
     * @return adjustment to Bearing (right turn amount) to get to target point,
     * must be 0 <= angle < 360
     * 计算点到点的角度
     * 一弧度等于57度左右
     * 180/3.14=57.7左右
     */
    public static double calculateBearingToPoint(double currentBearing, int currentX, int currentY, int targetX, int targetY) {
        double angle = Math.atan2(targetX - currentX, targetY - currentY) * 180 / Math.PI;
        double turnAngle = angle - currentBearing;
        if (turnAngle < 0)
            turnAngle += 360;
        return turnAngle;
        //throw new RuntimeException("implement me!");
    }


    /**
     * Given a sequence of points, calculate the Bearing adjustments needed to get from each point
     * 给定一系列点，计算从每个点获得所需的轴承调整
     * to the next.
     * <p>
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateBearingToPoint() to implement this function.
     *
     * @param xCoords list of x-coordinates (must be same length as yCoords)x坐标列表（必须与yCoords长度相同）
     * @param yCoords list of y-coordinates (must be same length as xCoords)y 坐标列表（必须与 xCoords 长度相同）
     * @return list of Bearing adjustments between points, of size 0 if (# of points) == 0,
     * otherwise of size (# of points) - 1
     * 计算多个点的斜率
     */
    public static List<Double> calculateBearings(List<Integer> xCoords, List<Integer> yCoords) {
        int xListLength = xCoords.size();
        int yListLength = yCoords.size();
        List<Double> list = new ArrayList<>();
        if (0 == Integer.compare(xListLength, yListLength) && xListLength > 1) {
            double currentBearing = 0;
            for (int i = 0; i < xListLength - 1; ++i) {
                double adjustmentsBearing = calculateBearingToPoint(currentBearing, xCoords.get(i), yCoords.get(i),
                        xCoords.get(i + 1), yCoords.get(i + 1));
                list.add(adjustmentsBearing);
                currentBearing = adjustmentsBearing - currentBearing;
            }
        }
        return list;
        //throw new RuntimeException("implement me!");
    }

    /**
     * Given a set of points, compute the convex hull, the smallest convex set that contains all the points
     * in a set of input points. The gift-wrapping algorithm is one simple approach to this problem, and
     * there are other algorithms too.
     * *给定一组点，计算凸包，即包含一组输入点中所有点*的最小凸集。礼品包装算法是解决这个问题的一种简单方法，还有其他算法。
     *
     * @param points a set of points with xCoords and yCoords. It might be empty, contain only 1 point, two points or more.
     * @return minimal subset of the input points that form the vertices of the perimeter of the convex hull
     */
    public static Set<Point> convexHull(Set<Point> points) {
        Iterator<Point> it = points.iterator() ;
        HashSet<Point> HullHashSet = new HashSet<>();
        if(points.isEmpty())  {					//点集为空，返回空集
            return HullHashSet ;
        }
        Point first_point = it.next();			//找到最左点
        while(it.hasNext()) {
            Point pr = it.next() ;
            first_point=pr.x()<first_point.x()?pr:first_point;
        }

        HullHashSet.add(first_point);			//凸包中加入最左点
        points.remove(first_point);				//剩余点集中删除最左点

        Point this_point = first_point;			//当前点
        Point next_point;						//下一个点
        Point add_point = this_point;			//加入凸包中的点
        double min_angle;						//最小转动角度
        double next_angle;						//当前转动角度

        do {
            it = points.iterator();
            min_angle = 360;
            while(it.hasNext()) {
                next_point = it.next();
                next_angle = calculateBearingToPoint(0 , (int)this_point.x() , (int)this_point.y() , (int)next_point.x() ,(int) next_point.y() );
                if(next_angle < min_angle) {	//选取角度最小的点
                    add_point = next_point;
                    min_angle = next_angle;
                }
                else if( next_angle == min_angle ) { //若角度相同，选取距离最远的点
                    if(Math.pow((this_point.x()-next_point.x()), 2) + Math.pow((this_point.y()-next_point.y()), 2) >
                            Math.pow((this_point.x()-add_point.x()), 2) + Math.pow((this_point.y()-add_point.y()), 2)) {
                        add_point = next_point ;
                    }
                }
            }
            this_point = add_point;
            HullHashSet.add(add_point);	//加入凸包
            points.remove(add_point);	//从剩余点集中删除
            points.add(first_point);		//加入初始点，否则没有循环结束条件
        }while(add_point != first_point);
        points.addAll(HullHashSet);
        return HullHashSet ;
    }

    /**
     * Draw your personal, custom art.
     * <p>
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     *
     * @param turtle the turtle context
     */
    public static void drawPersonalArt(Turtle turtle) {
        double angle = 36.0;
        turtle.turn(90);
        for (int i = 0; i < 5; i++) {
            turtle.forward(100);
            turtle.turn(180.0-angle);
        }

    }

    /**
     * Main method.
     * <p>
     * This is the method that runs when you run "java TurtleSoup".
     *
     * @param args unused
     */
    public static void main(String args[]) {
        DrawableTurtle turtle = new DrawableTurtle();
       // drawRegularPolygon(turtle, 6, 50);
        drawPersonalArt(turtle);
        //drawSquare(turtle, 40);
        // draw the window
        turtle.draw();
    }

}
