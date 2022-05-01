package springboot.model;

import springboot.model.cards.CardDeck;
import springboot.model.players.Player;
import java.util.Set;

public class Round {
    private int roundNumber;
    private Set<Player> players;


    public Round(Set<Player> players){
        this.players = players;
        this.roundNumber = 1;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    //Checks that all players have no cards in hand
    public boolean checkNoCardsInHand() {
        for (Player player : players) {
            if (player.getHand() == null) {
                return false;
            }
        }
        return true;
    }

    //Checks that all Players have played
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

    public void drawCardsAll(CardDeck deck) {
        for (Player player : players) {
            player.drawCardHand(deck);
        }
    }

    //Setters
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    //Increment round number
    public void incrementRoundNumber(){
        this.roundNumber = roundNumber+1;
    }

    //Reset Round
    public void resetRound(){
        this.roundNumber=1;
    }

    //Getters
    public int getRoundNumber() {
        return roundNumber;
    }

}
