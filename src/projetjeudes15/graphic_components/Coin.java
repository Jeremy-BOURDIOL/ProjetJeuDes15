/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.graphic_components;

import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import static javax.swing.JLayeredPane.DEFAULT_LAYER;
import static javax.swing.JLayeredPane.PALETTE_LAYER;
import javax.swing.SwingConstants;

/**
 *
 * @author bourdije
 */
public class Coin extends JLayeredPane {
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = 
                                Logger.getLogger(Coin.class.getName());
    
    private static final Color BACKGROUND_COLOR = Color.RED;
    private static final Color TEXT_COLOR = Color.WHITE;
    PropertyChangeSupport support = new PropertyChangeSupport(this);
    
    /** Internal Shape. */
    private Shape shp;
    /** Internal lablel. */
    private JLabel lbl;
    
    /**
     * Default constructor.
     */
    public Coin() {
        setPreferredSize(new Dimension(50,50));
        shp = new Shape();
        shp.setColor(BACKGROUND_COLOR);
        add(shp, DEFAULT_LAYER);
        lbl = new JLabel("Text");
        lbl.setForeground(TEXT_COLOR);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setVerticalAlignment(SwingConstants.CENTER);
        add(lbl, PALETTE_LAYER);
        addPropertyChangers();
    }
    /**
     * Set window bounds.
     * 
     * @param x x index
     * @param y y index
     * @param width widget's width
     * @param height widget's height
     */
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        shp.setBounds(0, 0, width, height);
        lbl.setBounds(0, 0, width, height);
    }
    /**
     * Get shape color.
     * @return the shape color
     */
    public Color getBackgroundColor() {
        return shp.getColor();
    }
    /**
     * Set shape color.
     * @param c color to apply
     */
    public void setBackgroundColor(Color c) {
        shp.setColor(c);
    }
    /**
     * Get the text color.
     * @return the current color of the text
     */
    public Color getTextColor() {
        return lbl.getForeground();
    }
    /**
     * Set the color of the text.
     * @param c the color to apply
     */
    public void setTextColor(Color c) {
        lbl.setForeground(c);
    }
    /**
     * Get the text currently displayed
     * @return the text displayed
     */
    public String getText() {
        return lbl.getText();
    }
    /**
     * Set the text of the label
     * @param txt The text tio display
     */
    public void setText(String txt) {
        lbl.setText(txt);
    }
    
    public int getShapeType() {
        return shp.getShape();
    }

    public void setShapeType(int shapeID) {
        shp.setShape(shapeID);
    } 
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        lbl.addPropertyChangeListener(listener);
        shp.addPropertyChangeListener(listener);
    }
    
    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        lbl.removePropertyChangeListener(listener);
        shp.removePropertyChangeListener(listener);
    }

    private void addPropertyChangers() {
        lbl.addPropertyChangeListener("text", new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                firePropertyChange("TEXT", evt.getOldValue(), evt.getNewValue());
            }
        });
        
        lbl.addPropertyChangeListener("foreground", new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                firePropertyChange("TEXT_COLOR", evt.getOldValue(), evt.getNewValue());
            }
        });
        
        shp.addPropertyChangeListener("color", new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                firePropertyChange("SHAPE_COLOR", evt.getOldValue(), evt.getNewValue());
            }
        });
    }
    
    @Override
    public boolean contains(int x, int y) {
        return shp.contains(x, y);
    }
}
