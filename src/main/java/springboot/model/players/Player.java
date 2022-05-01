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

    private int getFreshID() {
        IDs++;
        return IDs;
    }

    public void setRobot(String robot) {
        this.robot = robot;
    }

    public String getRobot() {
        return robot;
    }

    public void drawCardHand(CardDeck deck) {
        this.hand = new CardHand(deck.drawCards(9));
    }

    public Player(String name) {
        this.playerID = getFreshID();
        this.playerName = name;
        this.collectedCP = new HashSet<>();
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPosition(int x, int y) {
        this.position = new Position(x, y);
    }

    public void setPosition(Position pos) {
        this.position = pos;
    }

    public Position getPosition() {
        return position;
    }

    public int[] getCoordinates() { return new int[] { position.x, position.y}; };

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public CardHand getHand() {
        return hand;
    }

    // Assign cards to each player
    public void setHand(ArrayList<Card> hand) {
        this.hand.setHand(hand);
    }


    public void playCard(Card card, Board board) {
        if (this.direction == null) {
            System.out.println("Ghost!"+card.getName()+this.getPlayerName());

        } else {
            Object[] res = card.applyAction(this.position, this.direction);

            if (board.checkPositionInBounds((Position) res[0])) {
                board.getTile(this.getCoordinates()).setRobotOnTop(false,this.direction);
                board.getTile(this.getCoordinates()).setRobotIcon(null);
                this.setPosition((Position) res[0]);
                int[] temp = new int[]{((Position) res[0]).x, ((Position) res[0]).y};
                this.setDirection((Direction) res[1]);
                board.getTile(temp).setRobotOnTop(true, this.direction);
                board.getTile(temp).setRobotIcon(this.robot);
            }
        }
    }

    //Returns size of hand
    public int getHandSize() {
        return hand.size();
    }

    public void skipCard(int round) {
        ArrayList<Card> current = this.hand.getHand();
        current.set(round, null);
        this.setHand(current);
    }
    //Creates chosen and restore depending on input
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

    public void updateLives(int effect) {
        this.lives = lives + effect;
    }

    public int getLives() {
        return lives;
    }

    public boolean hasCP(CheckPoint cp) {
        return (collectedCP.contains(cp)) ;
    }

    public void addCheckPoint(CheckPoint cp) {
        if (collectedCP == null) {
            collectedCP = new HashSet<>();
        }
        if (!hasCP(cp)) collectedCP.add(cp);
    }

    public boolean hasAllCP(Set<CheckPoint> set){
       return collectedCP.equals(set);
    }

    public Set<CheckPoint> getCollectedCP() {
        return collectedCP;
    }

    public void hitObstacle(Board board, int number) {
        Obstacle obstacle = board.getTile(this.getCoordinates()).getType().getObstacle();
        board.getTile(this.getCoordinates()).setRobotOnTop(false,this.direction);
        board.getTile(this.getCoordinates()).setRobotIcon(null);
        obstacle.applyDamage(this, number);
        board.getTile(this.getCoordinates()).setRobotOnTop(true,this.direction);
        board.getTile(this.getCoordinates()).setRobotIcon(this.robot);
    }

    public void hitObstacle(Obstacle obstacle, int number) {
        obstacle.applyDamage(this, number);
    }

    public void pushPlayer(Player player2){
        Card card = CardFactory.getCard(CardType.MOVE, 1);

        Position pos = (Position) card.applyAction(player2.getPosition(), getDirection())[0];

        player2.setPosition(pos);
    }

}


