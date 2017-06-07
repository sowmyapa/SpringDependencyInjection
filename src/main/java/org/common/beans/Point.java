package org.common.beans;

/**
 * Created by sowmyaparameshwara on 5/23/17.
 */
public class Point {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString(){
        return "("+x+","+y+")";
    }

    public void myInit(){
        System.out.println("Point init method call");
    }

    public void cleanUp(){
        System.out.println("Point destroy method call");

    }
}
