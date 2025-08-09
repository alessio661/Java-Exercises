package contatore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class ContatoreView extends JFrame implements Observer {
    private JLabel label = new JLabel("0", SwingConstants.CENTER);

    JButton incrementButton = new JButton("DECREMENTA!");
    JButton decrementButton = new JButton("AUMENTA!");
    JButton resetButton = new JButton("RESET");

    public ContatoreView(ContatoreModel model) {
        super("Contatore");
        setSize(300, 200);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel buttons = new JPanel();
        addAll(buttons, incrementButton, decrementButton, resetButton);

        add(buttons, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> model.increment();
                    case KeyEvent.VK_DOWN -> model.decrement();
                    case KeyEvent.VK_SPACE -> model.reset();
                }
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void update(Observable o, Object arg) {
        ContatoreModel model = (ContatoreModel) o;
        label.setText(model.getValue() < 0 ? String.valueOf(model.getValue()).replace("-", "")
                : String.valueOf(model.getValue()));

        incrementButton.setEnabled(model.getValue() < model.getMaxLimit());
        decrementButton.setEnabled(model.getValue() > model.getMinLimit());
        resetButton.setEnabled(model.getValue() != 0);
    }

    public void addAll(JPanel panel, Component... components) {
        Arrays.stream(components).forEach(panel::add);
    }
}
