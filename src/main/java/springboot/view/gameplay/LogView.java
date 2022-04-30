package springboot.view.gameplay;
import java.awt.*;
import springboot.utils.GridBagUtils;
import javax.swing.JScrollPane;
import java.util.logging.ErrorManager;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.*;

public class LogView extends JPanel {
    private JTextArea logArea;
    private JScrollPane scrollPane;

    public LogView() {
        super();
        initGUI();
    }

    private void initGUI(){
        setLayout(new GridBagLayout());
        setMinimumSize(new Dimension(400, 300));
        setBackground(Color.DARK_GRAY);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createRaisedBevelBorder()));

        //JLabel and JPanel for log
        JLabel logLabel = new JLabel("Game Log");
        logLabel.setForeground(Color.decode("#DC47DA"));
        logLabel.setFont(new Font("MONOSPACED", Font.BOLD, 20));
        add(logLabel,GridBagUtils.constraint(0,0,5));

        JTextArea logArea = new JTextArea();
        logArea.setMinimumSize(new Dimension(400, 300));
        logArea.setBackground(Color.GRAY);
        JScrollPane scrollPane = new JScrollPane(logArea);
        scrollPane.setBackground(Color.GRAY);
        scrollPane.setMinimumSize(new Dimension(400, 300));
        add(scrollPane,GridBagUtils.constraint(0,1,5));



        setVisible(true);
    }

    public void appendLog(String log) {
        logArea.append(log + "\n");
        this.revalidate();
    }

}


