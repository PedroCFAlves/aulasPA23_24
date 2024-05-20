package pt.isec.pa.exerc29.model;

import pt.isec.pa.exerc29.model.data.Figure;

public class ModelManager  {
    Figure figure;
    private double x1,y1;
    private double x2,y2;
    private double r,g,b;
    public ModelManager() {
        figure = new Figure();
    }

    public double getR(){ return figure.getR();}
    public double getG(){ return figure.getG();}
    public double getB(){ return figure.getB();}

    public void setR(double r){ figure.setR(r);}
    public void setG(double g){ figure.setR(g);}
    public void setB(double b){ figure.setR(b);}

    public double getX1(){return figure.getX1();}
    public double getX2(){return figure.getX2();}
    public double getY1(){return figure.getY1();}
    public double getY2(){return figure.getY2();}
    public void setP1(double x, double y){figure.setP1(x,y);};
    public void setP2(double x, double y){figure.setP2(x,y);}

    public void defineColor() {
        figure.defineColor();
    }
    public void setToFill(boolean altDown){
        figure.setToFill(altDown);
    }

}
