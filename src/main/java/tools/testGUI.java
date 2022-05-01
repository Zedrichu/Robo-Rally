package tools;

import springboot.model.obstacles.CheckPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashSet;
import java.util.Objects;

class testGUI {
    public static void main(String[] args) {

        //Controller control = new Controller();
        CheckPoint cp = new CheckPoint();
        CheckPoint cp2 = new CheckPoint();
        CheckPoint cpx = new CheckPoint();
        HashSet<CheckPoint> set1 = new HashSet<>();
        HashSet<CheckPoint> set2 = new HashSet<>();
        set1.add(cp);
        set2.add(cp);
        HashSet<Integer> setId1 = new HashSet<>();
        HashSet<Integer> setId2 = new HashSet<>();
        setId1.add(cp.getID());
        setId2.add(cp.getID());
        System.out.println(set1.equals(set2));
        System.out.println(Objects.equals(set1,set2));
        System.out.println(setId1.equals(setId2));

    }
}

class Controller {
    private int i;
    private PropertyChangeSupport support;
    private JFrame view;

    Controller() {
        support = new PropertyChangeSupport(this);
        i = 0;
        Red red = new Red(this);
        Blue blue = new Blue(this);
        this.view = red;
        this.view.setVisible(true);
        support.addPropertyChangeListener(red);
        support.addPropertyChangeListener(blue);
    }

    public int getI() {
        return i;
    }

    public void setView(JFrame view) {
        this.view.setVisible(false);
        this.view = view;
        this.view.setVisible(true);
    }

    public void increment() {
        support.firePropertyChange("text", this.i, this.i+1);
        this.i++;
        System.out.println("Increment pressed"+this.i);
    }
}


class Red extends JFrame implements PropertyChangeListener {
    JButton button;
    Controller controller;

    Red( Controller controller) {
        this.controller = controller;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(200,200));
        button = new JButton("text"+controller.getI());
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.increment();
            }
        });
        add(button);
        pack();
        setLocationRelativeTo(null);
        setLocation(200,500);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ( (int) evt.getNewValue() % 2 == 0) {
            button.setText("Red"+controller.getI());
            controller.setView(this);
            revalidate();
        }
    }
}


class Blue extends JFrame implements PropertyChangeListener {
    JButton button;
    Controller controller;

    Blue( Controller controller) {
        this.controller = controller;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(200,200));
        button = new JButton("text"+controller.getI());
        button.setBackground(Color.BLUE);
        button.setForeground(Color.white);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.increment();
            }
        });
        add(button);
        pack();
        setLocationRelativeTo(null);
        setLocation(200,300);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ((int) evt.getNewValue() % 2 == 1){
            button.setText("Blue" + controller.getI());
            controller.setView(this);
            revalidate();
        }
    }
}