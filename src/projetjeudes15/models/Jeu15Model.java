/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.models;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author bourdije
 */
public class Jeu15Model {
    
    private static final Logger LOG = Logger.getLogger(Jeu15Model.class.getName());
    private ArrayList<Integer> remainningCoins;
    private ArrayList<PlayerModel> players;
    
    private Jeu15Model() {
        this(2);
    }
    
    public Jeu15Model(int nbPlayer) {
        remainningCoins = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            //players.add();
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
}
