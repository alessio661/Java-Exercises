package contatore;

import lombok.Getter;

import java.util.Observable;

public class ContatoreModel extends Observable {
    @Getter private int value = 0;
    @Getter private int amount;
    @Getter private int maxLimit;
    @Getter private int minLimit;

    public ContatoreModel(int amount, int maxLimit, int minLimit) {
        this.amount = amount;
        this.maxLimit = maxLimit;
        this.minLimit = minLimit;
    }

    public void increment() {
        if (value + amount <= maxLimit) {
            value += amount;
            changed();
        }
    }

    public void decrement() {
        if (value - amount >= minLimit) {
            value -= amount;
            changed();
        }
    }

    public void reset() {
        value = 0;
        changed();
    }

    private void changed() {
        setChanged();
        notifyObservers();
    }

}
