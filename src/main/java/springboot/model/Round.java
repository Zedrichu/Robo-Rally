package springboot.model;

import springboot.model.cards.CardDeck;
import springboot.model.players.Player;
import java.util.Set;

/**
 * Model class denoting the round to be played currently (sub-part of the game).
 */
public class Round {
    private int roundNumber;
    private Set<Player> players;

    /**
     * Round class constructor
     * @param players - set of players corresponding to the round
     */
    public Round(Set<Player> players){
        this.players = players;
        this.roundNumber = 1;
    }

    /**
     * Players Getter
     * @return Set of Player objects
     */
    public Set<Player> getPlayers() {
        return players;
    }

    /**
     * Players Setter
     * @param players - set of player objects
     */
    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    /**
     * Method checking if a player in the round has no cards.
     * @return boolean value, true - if out of cards, false - otherwise
     */
    public boolean checkNoCardsInHand() {
        for (Player player : players) {
            if (player.getHand() == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method checking if all players in round have played their turn.
     * @return boolean value, true - if all have played
     */
    public boolean haveAllPlayed() {
        boolean res=true;
        for (Player plr : players) {
            if (plr.getHandSize() != 5-roundNumber) {
                res = false;
                break;
            }
        }
        return res;
    }

    /**
     * Method drawing cards for each player registered in the round.
     * @param deck - CardDeck object
     */
    public void drawCardsAll(CardDeck deck) {
        for (Player player : players) {
            player.drawCardHand(deck);
        }
    }

    /**
     * Round number Setter
     */
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    /**
     * Method to increment the number of the round.
     */
    public void incrementRoundNumber(){
        this.roundNumber = roundNumber+1;
    }

    /**
     * Method to reset the round
     */
    public void resetRound(){
        this.roundNumber=1;
    }

    /**
     * Round number Getter
     */
    public int getRoundNumber() {
        return roundNumber;
    }

}
