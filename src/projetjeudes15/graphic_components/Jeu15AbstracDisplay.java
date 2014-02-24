/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.graphic_components;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import projetjeudes15.controlers.CoinSelecterControler;
import projetjeudes15.models.Jeu15Model;
import projetjeudes15.models.PlayerModel;

/**
 *
 * @author Jéjé
 */
public abstract class Jeu15AbstracDisplay extends JPanel{
    
    private Jeu15Model model;
    private PlayerModel player;
    private ArrayList<CoinSelecterControler> controlers = new ArrayList<>();
    
    public Jeu15AbstracDisplay() {
        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                            java.awt.event.InputEvent.CTRL_DOWN_MASK),
                    "undoKey");
        this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                            java.awt.event.InputEvent.CTRL_DOWN_MASK),
                    "redoKey");
        this.getActionMap().put("undoKey", askUndo);
        this.getActionMap().put("redoKey", askRedo);
    }
    
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
    
    public void addCoinSelecterController(CoinSelecterControler s) {
        controlers.add(s);
    }
    
    public void removeCoinSelecterController(CoinSelecterControler s) {
        controlers.remove(s);
    }
    
    public ArrayList<CoinSelecterControler> getControllers() {
        return controlers;
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
    
    private Action askUndo = new Action() {

        @Override
        public Object getValue(String key) {
            return null;
        }

        @Override
        public void putValue(String key, Object value) {
        }

        @Override
        public void setEnabled(boolean b) {
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener listener) {
        }

        @Override
        public void removePropertyChangeListener(PropertyChangeListener listener) {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (CoinSelecterControler s : getControllers()) {
                s.undo();
            }
        }
    };
    
    private Action askRedo = new Action() {

        @Override
        public Object getValue(String key) {
            return null;
        }

        @Override
        public void putValue(String key, Object value) {
        }

        @Override
        public void setEnabled(boolean b) {
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener listener) {
        }

        @Override
        public void removePropertyChangeListener(PropertyChangeListener listener) {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (CoinSelecterControler s : getControllers()) {
                s.redo();
            }
        }
    };
}
