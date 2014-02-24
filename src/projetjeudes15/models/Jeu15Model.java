/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjeudes15.models;

import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;
import projetjeudes15.controlers.command_pattern.SelectCoinCmd;

/**
 *
 * @author bourdije
 */
public class Jeu15Model {
    
    private static final Logger LOG = Logger.getLogger(Jeu15Model.class.getName());
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Jeu15UndoManager undoMngr = new Jeu15UndoManager();
    
    private ArrayList<Coin> remainningCoins;
    private ArrayList<PlayerModel> players;
    private PlayerModel currentPlayer;
    private int nbMvmnt;
    private boolean isFinished = false;
    private boolean thisisaredo = false;
    
    private Jeu15Model() {
        this(2);
    }
    
    public Jeu15Model(int nbPlayer) {
        remainningCoins = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            remainningCoins.add(new Coin(i));
        }
        players = new ArrayList<>();
        Random rand = new Random();
        float r, g, b;
        for(int i = 0; i < nbPlayer; i++) {
            r = rand.nextFloat();
            g = rand.nextFloat();
            b = rand.nextFloat();
            players.add(new PlayerModel("Joueur "+(i+1), new Color(r, g, b)));
        }
        nbMvmnt = 0;
        nextPlayer();
    }

    public void selectPion(Coin c) {
        if(!thisisaredo) {
            SelectCoinCmd tmp = new SelectCoinCmd(this, c);
            undoMngr.addCmd(tmp);
        }
        thisisaredo = false;
        if(!isFinished) {
            for( Coin co : remainningCoins) {
                if(c.getValue() == co.getValue()) {
                    co.setOwner(currentPlayer);
                    currentPlayer.addACoin(co);
                }
            }
            nbMvmnt++;
            nextPlayer();
            support.firePropertyChange("coin_selected", null, null);
            System.out.println("Fin du tour");
            checkWinner();
        }
    }

    private void checkWinner() {
        if (nbMvmnt == 9) {
            int minDelta = 99;
            PlayerModel winner = null;
            for(PlayerModel p : players) {
                int playerScore = p.computeScore();
                if (playerScore == 0) {
                    System.out.println("Send winner");
                    setIsFinished(true);
                    support.firePropertyChange("got_winner", null, p);
                    return;
                }
                else if (playerScore < minDelta) {
                    winner = p;
                    minDelta = playerScore;
                }
            }
            setIsFinished(true);
            support.firePropertyChange("got_winner", null, winner);
        }
        else if (nbMvmnt >= 5) {
            for(PlayerModel p : players) {
                if (p.computeScore() == 0) {
                    System.out.println("Send winner");
                    setIsFinished(true);
                    support.firePropertyChange("got_winner", null, p);
                    return;
                }
            }
        }
    }

    public void resetCoin(Coin c) {
        previousPlayer();
        if(!isFinished) {
            for( Coin co : remainningCoins) {
                if(c.getValue() == co.getValue()) {
                    co.setOwner(null);
                    currentPlayer.removeACoin(co);
                }
            }
            nbMvmnt--;
            support.firePropertyChange("coin_selected", null, null);
        }
    }
    
    public void undo() {
        undoMngr.undo();
    }
    
    public void redo() {
        thisisaredo = true;
        undoMngr.redo();
    }
    
    public void nextPlayer() {
        setCurrentPlayer(players.get(nbMvmnt%players.size()));
    }
        
    public void previousPlayer() {
        setCurrentPlayer(players.get((nbMvmnt-1)%players.size()));
    }
    
    public ArrayList<Coin> getRemainningCoins() {
        return remainningCoins;
    }

    public void setRemainningCoins(ArrayList<Coin> remainningCoins) {
        this.remainningCoins = remainningCoins;
    }

    public ArrayList<PlayerModel> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<PlayerModel> players) {
        this.players = players;
    }

    public PlayerModel getCurrentPlayer() {
        return currentPlayer;
    }
    
    public PlayerModel getPreviousPlayer() {
        if(nbMvmnt >=1 ) {
            return players.get((nbMvmnt-1)%players.size());
        }
        else {
            return null;
        }
    }

    public void setCurrentPlayer(PlayerModel newPlayer) {
        PlayerModel previousPlayer = currentPlayer;
        this.currentPlayer = newPlayer;
        support.firePropertyChange("player_chaged", previousPlayer, newPlayer);
    }

    public boolean isIsFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }
    
    /* ---------------------PARTIE EVENEMENT--------------------------------- */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
    
    public void addPropertyChangeListener(String s, 
                                          PropertyChangeListener listener) {
        support.addPropertyChangeListener(s, listener);
    }
    
    public void removePropertyChangeListener(String s, 
                                             PropertyChangeListener listener) {
        support.removePropertyChangeListener(s, listener);
    }
}
