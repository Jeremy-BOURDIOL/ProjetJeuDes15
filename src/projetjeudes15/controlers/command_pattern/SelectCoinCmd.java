/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.controlers.command_pattern;

import projetjeudes15.models.Coin;
import projetjeudes15.models.Jeu15Model;

/**
 *
 * @author bourdije
 */
public class SelectCoinCmd implements Jeu15Command{

    private Jeu15Model model;
    private Coin toSet;
    
    public SelectCoinCmd(Jeu15Model context, Coin c) {
        model = context;
        toSet = c;
    }
    
    @Override
    public void execute() {
        model.selectPion(toSet);
    }

    @Override
    public void undo() {
        model.resetCoin(toSet);
    }
    
}
