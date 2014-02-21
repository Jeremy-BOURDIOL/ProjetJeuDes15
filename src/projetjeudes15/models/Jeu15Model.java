/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.models;

import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author bourdije
 */
public class Jeu15Model {
    
    private static final Logger LOG = Logger.getLogger(Jeu15Model.class.getName());
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    
    private ArrayList<Coin> remainningCoins;
    private ArrayList<PlayerModel> players;
    
    private Jeu15Model() {
        this(2);
    }
    
    public Jeu15Model(int nbPlayer) {
        remainningCoins = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            remainningCoins.add(new Coin(i));
        }
        players = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < nbPlayer; i++) {
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            players.add(new PlayerModel("Joueur "+i, new Color(r, g, b)));
        }
    }

    public ArrayList<Coin> getRemainningCoins() {
        return remainningCoins;
    }

    public void setRemainningCoins(ArrayList<Coin> remainningCoins) {
        this.remainningCoins = remainningCoins;
    }

    public ArrayList<PlayerModel> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<PlayerModel> players) {
        this.players = players;
    }
    
    /* ---------------------PARTIE EVENEMENT--------------------------------- */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
    
    public void addPropertyChangeListener(String s, 
                                          PropertyChangeListener listener) {
        support.addPropertyChangeListener(s, listener);
    }
    
    public void removePropertyChangeListener(String s, 
                                             PropertyChangeListener listener) {
        support.removePropertyChangeListener(s, listener);
    }
}
