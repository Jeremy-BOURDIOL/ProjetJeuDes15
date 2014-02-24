/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.graphic_components;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import projetjeudes15.controlers.CoinSelectedEvent;
import projetjeudes15.controlers.CoinSelecterControler;
import projetjeudes15.models.Coin;

/**
 *
 * @author Jéjé
 */
public class GridDisplay extends Jeu15AbstracDisplay{
    
    private GridLayout layout;
    private Integer[] coinsOrder = {8,3,4,1,5,9,6,7,2};
    
    public GridDisplay() {
        super();
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
        addCoinSelecterController(new CoinSelecterControler(this));
    }

    protected void loadModel() {
        this.removeAll();
        ArrayList<Coin> elems = getModel().getRemainningCoins();
        for(int i = 0; i < 9; i++) {
            for(final Coin c : elems) {
                if(c.getValue() == coinsOrder[i]) {
                    GraphicalCoin gc = new GraphicalCoin();
                    gc.setText(""+c.getValue());
                    gc.setShapeType(2);
                    if (c.getOwner() != null) {
                        gc.setBackgroundColor(c.getOwner().getMyColor());
                    }
                    else { 
                        gc.setBackgroundColor(Color.GREEN);
                        gc.addMouseListener(new MouseListener() {

                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if(getModel().getCurrentPlayer().equals(getPlayer())) {
                                    for(CoinSelecterControler s : getControllers()) {
                                        s.coinSelected(new CoinSelectedEvent(this, c));
                                    }
                                }
                            }

                            @Override
                            public void mousePressed(MouseEvent e) {
                            }

                            @Override
                            public void mouseReleased(MouseEvent e) {
                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                            }
                        });
                    }
                    this.add(gc);
                }
            }
        }
        revalidate();
    }
}
