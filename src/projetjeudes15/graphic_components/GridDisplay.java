/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.graphic_components;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import projetjeudes15.models.Coin;
import projetjeudes15.models.Jeu15Model;

/**
 *
 * @author Jéjé
 */
public class GridDisplay extends JPanel{
    
    private GridLayout layout;
    private Integer[] coinsOrder = {8,3,4,1,5,9,6,7,2};
    private Jeu15Model model;
    
    
    public GridDisplay() {
        layout = new GridLayout(3,3);
        layout.setHgap(3);
        layout.setVgap(3);
        this.setLayout(layout);
        for(int i = 0; i < 9; i++) {
            GraphicalCoin gc = new GraphicalCoin();
            gc.setText(""+coinsOrder[i]);
            gc.setShapeType(2);
            gc.setBackgroundColor(Color.GREEN);
            this.add(gc);
        }
    }
    
    public void setModel(Jeu15Model newModel) {
        model = newModel;
        loadModel();
    }
    public Jeu15Model getModel() {
        return model;
    }

    private void loadModel() {
        this.removeAll();
        ArrayList<Coin> elems = model.getRemainningCoins();
        for(int i = 0; i < 9; i++) {
            for(Coin c : elems) {
                if(c.getValue() == coinsOrder[i]) {
                    GraphicalCoin gc = new GraphicalCoin();
                    gc.setText(""+c.getValue());
                    gc.setShapeType(2);
                    if (c.getOwner() != null) {
                        gc.setBackgroundColor(c.getOwner().getMyColor());
                    }
                    else { 
                        gc.setBackgroundColor(Color.GREEN);
                    }
                    this.add(gc);
                }
            }
        }
    }
}
