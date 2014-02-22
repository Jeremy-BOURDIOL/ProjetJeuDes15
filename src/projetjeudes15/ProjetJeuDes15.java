/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15;

import java.awt.Dimension;
import javax.swing.JFrame;
import projetjeudes15.graphic_components.GridDisplay;
import projetjeudes15.graphic_components.ListDisplay;
import projetjeudes15.models.Jeu15Model;

/**
 *
 * @author bourdije
 */
public class ProjetJeuDes15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame grid = new JFrame();
        Jeu15Model model = new Jeu15Model(2);
        GridDisplay g = new GridDisplay();
        g.setModel(model);
        grid.add(g);
        grid.setVisible(true);
        grid.setSize(new Dimension(300, 300));
        grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JFrame list = new JFrame();
        ListDisplay l = new ListDisplay();
        l.setModel(model);
        list.add(l);
        list.setVisible(true);
        list.setSize(new Dimension(600, 300));
        list.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
