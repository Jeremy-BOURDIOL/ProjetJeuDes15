/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.models;

import java.util.Stack;
import projetjeudes15.controlers.command_pattern.Jeu15Command;

/**
 *
 * @author bourdije
 */
public class Jeu15UndoManager {

    private Stack<Jeu15Command> pileUn;
    private Stack<Jeu15Command> pileRe;
    
    public Jeu15UndoManager() {
        pileUn = new Stack<>();
        pileRe = new Stack<>();
    }
    
    public void undo() {
        if(!pileUn.empty()) {
            Jeu15Command tmp = pileUn.pop();
            tmp.undo();
            pileRe.push(tmp);
        }
    }
    
    public void redo() {
        if(!pileRe.empty()) {
            Jeu15Command tmp = pileRe.pop();
            tmp.execute();
            pileUn.push(tmp);
        }
    }
    
    public void addCmd(Jeu15Command c) {
        System.out.println("Add new command");
        pileUn.push(c);
        pileRe.clear();
    }
    
}
