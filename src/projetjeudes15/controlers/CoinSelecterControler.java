/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.controlers;

import projetjeudes15.graphic_components.Jeu15AbstracDisplay;

/**
 *
 * @author bourdije
 */
public class CoinSelecterControler {
    
    private Jeu15AbstracDisplay view;
    
    public CoinSelecterControler(Jeu15AbstracDisplay v) {
        view = v;
    }
    
    public void coinSelected (CoinSelectedEvent e) {
        view.getModel().selectPion(e.getSelectedCoin());
    }
    public void undo () {
        view.getModel().undo();
    }
    public void redo () {
        view.getModel().redo();
    }
}
