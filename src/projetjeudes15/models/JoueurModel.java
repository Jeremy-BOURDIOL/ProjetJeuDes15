/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.models;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author bourdije
 */
public class JoueurModel {
    
    private static final Logger LOG = Logger.getLogger(JoueurModel.class.getName());
    private ArrayList<Integer> remainningCoins;
    
    private JoueurModel() {
        remainningCoins = new ArrayList<>();
    }
    

}
