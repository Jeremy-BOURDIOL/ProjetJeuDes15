/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.graphic_components;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import projetjeudes15.controlers.CoinSelectedEvent;
import projetjeudes15.controlers.CoinSelecterControler;
import projetjeudes15.models.Coin;
import projetjeudes15.models.PlayerModel;

/**
 *
 * @author Jéjé
 */
public class ListDisplay extends Jeu15AbstracDisplay{
    
    private JPanel mainCoinDisposal;
    private JPanel playersBoards;
    private GridLayout playersLayout;
    
    public ListDisplay() {
        super();
        this.setLayout(new GridLayout(2, 1));
        mainCoinDisposal = new JPanel();
        mainCoinDisposal.setBorder(BorderFactory.createTitledBorder("Plateau"));
        for(int i = 0; i < 9; i++) {
            GraphicalCoin gc = new GraphicalCoin();
            gc.setText(""+i);
            gc.setShapeType(1);
            gc.setBackgroundColor(Color.GREEN);
            mainCoinDisposal.add(gc);
        }
        this.add(mainCoinDisposal);
        playersBoards = new JPanel();
        playersLayout = new GridLayout();
        playersBoards.setLayout(playersLayout);
        this.add(playersBoards);
        addCoinSelecterController(new CoinSelecterControler(this));
    }

    protected void loadModel() {
        //Main disposal part
        mainCoinDisposal.removeAll();
        ArrayList<Coin> elems = getModel().getRemainningCoins();
        for(final Coin c : elems) {
            GraphicalCoin gc = new GraphicalCoin();
            gc.setText(""+c.getValue());
            gc.setShapeType(1);
            if (c.getOwner() != null) {
                gc.setBackgroundColor(c.getOwner().getMyColor());
                gc.setEnabled(false);
                gc.setVisible(false);
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
            mainCoinDisposal.add(gc);
        }
        
        //Player part
        playersBoards.removeAll();
        for(PlayerModel p : getModel().getPlayers()){
            JPanel playerDisposal = new JPanel();
            playerDisposal.setBorder(BorderFactory.createTitledBorder(
                                                                p.getMyName()));
            for(Coin c : p.getMyCoins()) {
                GraphicalCoin gc = new GraphicalCoin();
                gc.setText(""+c.getValue());
                gc.setShapeType(1);
                gc.setBackgroundColor(p.getMyColor());
                playerDisposal.add(gc);
            }
            playersBoards.add(playerDisposal);
        }
        revalidate();
        repaint();
    }
}
