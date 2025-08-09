package contatore;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ContatoreModel model = new ContatoreModel(3, 30, -30);
            ContatoreView view = new ContatoreView(model);
            ContatoreController controller = new ContatoreController(model, view);

            view.setVisible(true);
        });
    }
}
