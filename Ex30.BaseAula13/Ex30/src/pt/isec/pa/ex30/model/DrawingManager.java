package pt.isec.pa.ex30.model;

import pt.isec.pa.ex30.model.data.Drawing;
import pt.isec.pa.ex30.model.data.Figure;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.util.List;

public class DrawingManager {
    public static final String PROP_TOOLS = "_tools_";
    public static final String PROP_FIGURES = "_figures_";

    private Drawing drawing;
    private PropertyChangeSupport pcs;

    /*public DrawingManager(Drawing drawing) {
        this.drawing = drawing;
    }*/

    public DrawingManager() {
        this.drawing = new Drawing();
        pcs = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(String property, PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(property,listener);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public double getR() {
        return drawing.getR();
    }
    public double getG() {
        return drawing.getG();
    }
    public double getB() {
        return drawing.getB();
    }

    public void setRGB(double r,double g, double b) {
        drawing.setRGB(r, g, b);
        pcs.firePropertyChange(PROP_TOOLS,null,null);
    }

    public Figure.FigureType getCurrentType() {
        return drawing.getCurrentType();
    }

    public void setCurrentType(Figure.FigureType currentType) {
        //Figure.FigureType old = drawing.getCurrentType();
        drawing.setCurrentType(currentType);
       // pcs.firePropertyChange(PROP_TOOLS,old,currentType);
        pcs.firePropertyChange(PROP_TOOLS,null,null);
    }

    public void createFigure(double x, double y) {
        drawing.createFigure(x,y);
        pcs.firePropertyChange(PROP_FIGURES,null,null);
    }

    public void updateCurrentFigure(double x, double y) {
        drawing.updateCurrentFigure(x, y);
        pcs.firePropertyChange(PROP_FIGURES,null,null);
    }

    public void finishCurrentFigure(double x,double y) {
        drawing.finishCurrentFigure(x, y);
        pcs.firePropertyChange(PROP_FIGURES,null,null);
    }

    public Figure getCurrentFigure() {
        return drawing.getCurrentFigure();
    }

    public List<Figure> getList() {
        return drawing.getList();
    }

    public void clearAll() {
        drawing.clearAll();
        pcs.firePropertyChange(PROP_FIGURES,null,null);
    }

    public void removeLast() {
        drawing.removeLast();
        pcs.firePropertyChange(PROP_FIGURES,null,null);
    }

    public void remove(int selectedIndex) {
        drawing.remove(selectedIndex);
        pcs.firePropertyChange(PROP_FIGURES,null,null);
    }

    public boolean save(File file) {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream(file) )
        ) {
            oos.writeObject(drawing);
        } catch (Exception e) {
            System.err.println("Error writing drawing");
            return false;
        }
        return true;
    }

    public boolean load(File file) {
        try (
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream(file) )
        ) {
            drawing = (Drawing) ois.readObject();
        } catch (Exception e) {
            System.err.println("Error loading drawing");
            return false;
        }
        pcs.firePropertyChange(PROP_FIGURES,null,null);
        pcs.firePropertyChange(PROP_TOOLS,null,null);
        return true;
    }

    public void setFigureRGB(int selectedIndex, double r, double g, double b){
        drawing.setFigureRGB(selectedIndex,r,g,b);
        pcs.firePropertyChange(PROP_FIGURES,null,null);
    }



}

