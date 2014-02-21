/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.graphic_components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import projetjeudes15.models.Coin;
import projetjeudes15.models.Jeu15Model;
import projetjeudes15.models.PlayerModel;

/**
 *
 * @author Jéjé
 */
public class ListDisplay extends JPanel{
    
    private Jeu15Model model;
    private JPanel mainCoinDisposal;
    private JPanel playersBoards;
    private GridLayout playersLayout;
    
    public ListDisplay() {
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
    }
    
    public void setModel(Jeu15Model newModel) {
        System.out.println("Got a new Model");
        model = newModel;
        addPropertyChangers();
        loadModel();
    }
    public Jeu15Model getModel() {
        return model;
    }

    private void loadModel() {
        System.out.println("Loading");
        
        //Main disposal part
        mainCoinDisposal.removeAll();
        ArrayList<Coin> elems = model.getRemainningCoins();
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
                        System.out.println("Click coin "+c.getValue());
                        model.selectPion(c);
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
        for(PlayerModel p : model.getPlayers()){
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
    }
        
    private void addPropertyChangers() {
        model.addPropertyChangeListener("coin_selected", 
                                        new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                loadModel();
            }
        });
    }
}
