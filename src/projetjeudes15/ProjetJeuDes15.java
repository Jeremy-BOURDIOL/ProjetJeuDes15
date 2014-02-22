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
        /*
        JFrame grid = new JFrame();
        Jeu15Model model = new Jeu15Model(2);
        GridDisplay g = new GridDisplay();
        g.setModel(model);
        grid.add(g);
        grid.setTitle(model.getPlayers().get(0).getMyName());
        grid.setSize(new Dimension(300, 300));
        grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid.setVisible(true);
        
        JFrame list = new JFrame();
        ListDisplay l = new ListDisplay();
        l.setModel(model);
        list.add(l);
        list.setTitle(model.getPlayers().get(1).getMyName());
        list.setSize(new Dimension(600, 300));
        list.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        list.setVisible(true);
        */
        Jeu15Model model = new Jeu15Model(2);
        for(PlayerModel p : model.getPlayers()) {
            new GameFrame(model, p);
        }
    }
}
