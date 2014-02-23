/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.graphic_components;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;
import projetjeudes15.models.Jeu15Model;
import projetjeudes15.models.PlayerModel;

/**
 *
 * @author Jéjé
 */
public abstract class Jeu15AbstracDisplay extends JPanel{
    
    private Jeu15Model model;
    private PlayerModel player;
    
    public void setModel(Jeu15Model newModel) {
        model = newModel;
        addPropertyChangers();
        loadModel();
    }
    public Jeu15Model getModel() {
        return model;
    }

    public PlayerModel getPlayer() {
        return player;
    }

    public void setPlayer(PlayerModel player) {
        this.player = player;
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
    
    abstract void loadModel();
}
