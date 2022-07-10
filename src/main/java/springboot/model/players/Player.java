package springboot.model.players;


import springboot.model.Position;
import springboot.model.cards.*;
import springboot.model.Direction;
import springboot.model.obstacles.CheckPoint;
import springboot.model.board.Board;
import springboot.model.obstacles.Obstacle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Player {

    private static int IDs = 0;
    final private int playerID;
    final private String playerName;
    private Position position;
    private Direction direction;
    private String robot = "tiles/robot.png";
    public CardHand hand;
    private int lives = 10;
    Set<CheckPoint> collectedCP;

    /**
     * Identifier Getter
     */
    private int getFreshID() {
        IDs++;
        return IDs;
    }

    /**
     * Robot image path Setter
     * @param robot - path to robot image
     */
    public void setRobot(String robot) {
        this.robot = robot;
    }

    /**
     * Robot image path Getter
     */
    public String getRobot() {
        return robot;
    }

    /**
     * Method to draw a card hand from the given card deck
     * @param deck - CardDeck object
     */
    public void drawCardHand(CardDeck deck) {
        this.hand = new CardHand(deck.drawCards(9));
    }

    /**
     * Player constructor based on given name
     */
    public Player(String name) {
        this.playerID = getFreshID();
        this.playerName = name;
        this.collectedCP = new HashSet<>();
        this.robot = "robots/robot"+playerID+".png";
    }

    /**
     * Live Setter
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * Player name Getter
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Position Setter
     */
    public void setPosition(int x, int y) {
        this.position = new Position(x, y);
    }

    /**
     * Overloaded Position Setter
     * @param pos
     */
    public void setPosition(Position pos) {
        this.position = pos;
    }

    /**
     * Position Getter
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Coordinates Getter
     * @return tuple of coordinates
     */
    public int[] getCoordinates() { return new int[] { position.x, position.y}; };

    /**
     * Direction Getter
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Direction Setter
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Card hand Getter
     */
    public CardHand getHand() {
        return hand;
    }

    /**
     * Card hand Setter
     */
    public void setHand(ArrayList<Card> hand) {
        this.hand.setHand(hand);
    }

    /**
     * Method to simulate the execution of given card on given board
     * @param card - Card object
     * @param board - Board object
     */
    public void playCard(Card card, Board board) {
        if (this.direction == null) {
            //System.out.println("Ghost!"+card.getName()+this.getPlayerName());
        } else {
            // Apply card action and obtain updated position and direction
            Object[] res = card.applyAction(this.position, this.direction);

            // Check that the position given is within board bounds
            if (board.checkPositionInBounds((Position) res[0])) {
                this.setPosition((Position) res[0]);
                this.setDirection((Direction) res[1]);
            }
        }
    }

    /**
     * Size of hand Getter
     */
    public int getHandSize() {
        return hand.size();
    }

    /**
     * Method used to skip a certain card in the hand.
     * @param index - index of card to be skipped
     */
    public void skipCard(int index) {
        ArrayList<Card> current = this.hand.getHand();
        current.set(index, null);
        this.setHand(current);
    }

    //Creates chosen and restore depending on input

    /**
     * Method to choose the cards from the ones drawn and restore some of them to the deck.
     * @param x - amount of cards to be chosen
     * @param selects - ArrayList<Integer>, array of card selections in order
     * @param deck - CardDeck object
     */
    public void chooseCards(int x, ArrayList<Integer> selects, CardDeck deck) {
        ArrayList<Card> current = hand.getHand();
        ArrayList<Card> chosen = new ArrayList<>(x);
        ArrayList<Card> restore = new ArrayList<>(selects.size()-x);

        for (int j=0; j<selects.size(); j++) {
            if (selects.get(j) == 0) {
                restore.add(current.get(j));
            }
        }

        for (int i = 1; i <= x; i++) {
            for (int j=0; j < selects.size(); j++){
                if (selects.get(j) == i) {
                    chosen.add(current.get(j));
                    break;
                }
            }
        }
        // send current cards back to deck
        deck.restoreCards(restore);
        this.setHand(chosen);
    }

    /**
     * Method to update the lives based on given effect
     * @param effect - damage to be taken by player
     */
    public void updateLives(int effect) {
        this.lives = lives + effect;
    }

    /**
     * Lives Getter
     */
    public int getLives() {
        return lives;
    }

    /**
     * Method to check if the player has collected a certain check-point.
     * @param cp - CheckPoint object
     * @return boolean value, true - if player has the check-point
     */
    public boolean hasCP(CheckPoint cp) {
        return (collectedCP.contains(cp)) ;
    }

    /**
     * Method to add a check-point to the collected set.
     * @param cp - CheckPoint object
     */
    public void addCheckPoint(CheckPoint cp) {
        if (collectedCP == null) {
            collectedCP = new HashSet<>();
        }
        if (!hasCP(cp)) collectedCP.add(cp);
    }

    /**
     * Method to check if the player has collected all check-points in the set given.
     * @param set - set of checkpoints to be verified against
     * @return boolean value, true - if player collected all check-points
     */
    public boolean hasAllCP(Set<CheckPoint> set){
       return this.collectedCP.equals(set);
    }

    /**
     * Collected check-points Getter
     * @return Set of CheckPoint objects
     */
    public Set<CheckPoint> getCollectedCP() {
        return collectedCP;
    }

    /**
     * Method to hit a certain obstacle on the board
     * @param board - Board object
     * @param number - number of current round
     */
    public void hitObstacle(Board board, int number) {
        Obstacle obstacle = board.getTile(this.getCoordinates()).getType().getObstacle();
        obstacle.applyDamage(this, number);
    }

    /**
     * Method to push players from the tile upon collision
     * @param player2 - Player object to be pushed
     */
    public void pushPlayer(Player player2){
        Card card = CardFactory.getCard(CardType.MOVE, 1);
        Position pos = (Position) card.applyAction(player2.getPosition(), getDirection())[0];
        player2.setPosition(pos);
    }
}


