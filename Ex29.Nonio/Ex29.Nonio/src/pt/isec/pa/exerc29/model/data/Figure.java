package pt.isec.pa.exerc29.model.data;

import pt.isec.pa.exerc29.utils.AppLog;

public class Figure {
    private double x1,y1;
    private double x2,y2;
    private double r,g,b; //values 0..1
    private boolean fill;

    public Figure() {
        x1 =  50; y1 =  20;
        x2 = 250; y2 = 150;
        r = 0;
        g = 0.75;
        b = 0.25;
        fill = false;
        AppLog.getInstance().add("new "+toString());
    }

    public void defineColor() {
        r = Math.random();
        g = Math.random();
        b = Math.random();
    }

    public void setToFill(boolean alt){
        fill = alt;
    }
    public void defineColor(double r, double g, double b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /* TODO - Getters */

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setP1(double x, double y){
        this.x1 = x;
        this.y1 = y;
    }
    public void setP2(double x, double y){
        this.x2 = x;
        this.y2 = y;
    }


    @Override
    public String toString() {
        return String.format("Figure { (%.2f,%.2f)-(%.2f,%.2f) color= [%.2f,%.2f,%.2f] }",
                x1,y1,x2,y2,r,g,b);
    }
}
