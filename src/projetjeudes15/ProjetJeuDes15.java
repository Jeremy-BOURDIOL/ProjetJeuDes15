/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15;

import projetjeudes15.graphic_components.GameFrame;
import projetjeudes15.models.Jeu15Model;
import projetjeudes15.models.PlayerModel;

/**
 *
 * @author bourdije
 */
public class ProjetJeuDes15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jeu15Model model = new Jeu15Model(2);
        for(PlayerModel p : model.getPlayers()) {
            new GameFrame(model, p);
        }
    }
}
