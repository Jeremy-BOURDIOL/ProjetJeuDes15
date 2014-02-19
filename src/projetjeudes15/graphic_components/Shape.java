/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.graphic_components;

import java.awt.Color;
import java.awt.Graphics;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JComponent;

/**
 *
 * @author bourdije
 */
public class Shape extends JComponent {
    
    private Color myColor;
    public final static int OVALE = 1;
    public final static int RECTANGLE = 2;
    private int myShape;
    
    PropertyChangeSupport support = new PropertyChangeSupport(this);
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
    
    public Shape() {
        this(Shape.OVALE, Color.red);
    }
    
    public Shape(int theShape, Color theColor) {
        super();
        setShape(theShape);
        setColor(theColor);
    }
    
    public int getShape() {
        return myShape;
    }
    
    public final Color getColor() {
        return myColor;
    }
    
    public void setColor(Color theColor) {
        Color oldColor = myColor;
        myColor = theColor;
        repaint();
        support.firePropertyChange("color", oldColor, myColor);
    }
    
    public void setShape(int theShape) {
        int oldShape = myShape;
        myShape = (theShape == OVALE || theShape == RECTANGLE)
            ? theShape : OVALE;
        repaint();
        //Avant JDK 1.3 :
        // support.firePropertyChange("shape", new Integer(oldShape),
        //new Integer(myShape));
        support.firePropertyChange("shape", oldShape, myShape);
    }
    
    @Override
    public void paint(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(myColor);
        switch (myShape) {
            case OVALE:
                g.fillOval(0, 0, getWidth(), getHeight());
                break;
            case RECTANGLE:
                g.fillRect(0, 0, getWidth(), getHeight());
                break;
            default:
                g.fillOval(0, 0, getWidth(), getHeight());
        }
        g.setColor(oldColor);
        contains(WIDTH, WIDTH);
    }
    
    @Override
    public boolean contains(int x, int y) {
        double a = getWidth()/2;
        double b = getHeight()/2;
        double dx = (x-a);
        double dy = (y-b);
        return (((dx*dx)/(a*a) + (dy*dy)/(b*b)) <= 1.0);
    }
}
