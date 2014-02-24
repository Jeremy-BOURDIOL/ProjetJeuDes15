/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.models;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author bourdije
 */
public class PlayerModel {
    
    private static final Logger LOG = Logger.getLogger(PlayerModel.class.getName());
    private ArrayList<Coin> myCoins;
    private String myName;
    private Color myColor;
    
    public PlayerModel(String playerName, Color playerColor) {
        myCoins = new ArrayList<>();
        myName = playerName;
        myColor = playerColor;
    }

    public ArrayList<Coin> getMyCoins() {
        return myCoins;
    }

    public void setMyCoins(ArrayList<Coin> myCoins) {
        this.myCoins = myCoins;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String name) {
        this.myName = name;
    }

    public Color getMyColor() {
        return myColor;
    }

    public void setMyColor(Color myColor) {
        this.myColor = myColor;
    }

    void addACoin(Coin co) {
        myCoins.add(co);
    }

    void removeACoin(Coin co) {
        myCoins.remove(co);
    }

    public int computeScore() {
        int score = 0;
        for(Coin c : myCoins) {
            score += c.getValue();
        }
        return Math.abs(score-15);
    }
    
}
