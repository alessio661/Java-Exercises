package contatore;

public class ContatoreController {
    public ContatoreController(ContatoreModel model, ContatoreView view) {
        model.addObserver(view);

        view.decrementButton.addActionListener(click -> model.decrement());
        view.incrementButton.addActionListener(click -> model.increment());
        view.resetButton.addActionListener(click -> model.reset());
    }
}
