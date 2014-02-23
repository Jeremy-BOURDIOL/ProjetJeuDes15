/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.controlers;

import projetjeudes15.models.Coin;

/**
 *
 * @author bourdije
 */
public class CoinSelectedEvent extends java.util.EventObject {
            
    private Coin selectedCoin;
    
    public CoinSelectedEvent(Object source, Coin c) {
        super(source);
        selectedCoin = c;
    }
    
    public Coin getSelectedCoin() {
        return selectedCoin;
    }
}
