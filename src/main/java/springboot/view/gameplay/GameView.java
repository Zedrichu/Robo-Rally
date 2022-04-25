package springboot.view.gameplay;

import springboot.controller.gameSetup.GameSettingsFacadeController;
import springboot.controller.gameplay.GameController;
import springboot.model.GameSettings;
import springboot.model.board.Board;
import springboot.model.cards.CardDeck;
import springboot.model.players.Player;
import springboot.utils.GridBagUtils;
import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class GameView extends JFrame {
    private GameController gameController;
    private JButton playCards;


    public GameView(GameController gameController) {
        this.gameController = gameController;
    }

    private void initGUI(Board board, CardDeck cardDeck, Set<Player> sps) {
        setMinimumSize(new Dimension(600, 700));
        setResizable(false);
        setTitle("Players pick positions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        JPanel health = new JPanel();
        JLabel healthLabel = new JLabel("Health of players");
        health.add(healthLabel, GridBagUtils.constraint(1, 0, 5));
        //for (Player player : sps) {

       // }
    }
}