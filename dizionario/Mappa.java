package dizionario;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Mappa<K, V> implements Dizionario<K, V> {
    private final List<Coppia<K, V>> map;

    public Mappa() {
        this.map = new ArrayList<>();
    }

    @Override
    public V search(K k) throws ElementNotFoundException {
        for (Coppia<K, V> coppia : map)
            if (coppia.getKey().equals(k))
                return coppia.getElement();
        throw new ElementNotFoundException("Chiave non trovata: " + k);
    }

    @Override
    public void add(K k, V v) throws ElementAlreadyContainedException {
        for (Coppia<K, V> coppia : map)
            if (coppia.getKey().equals(k))
                throw new ElementAlreadyContainedException("Chiave già presente: " + k);
        map.add(new Coppia<>(k, v));
    }

    @Override
    public V delete(K k) throws ElementNotFoundException {
        while (map.iterator().hasNext()) {
            Coppia<K, V> coppia = map.iterator().next();
            if (coppia.getKey().equals(k)) {
                V value = coppia.getElement();
                map.iterator().remove();
                return value;
            }
        }
        throw new ElementNotFoundException("Chiave non presente: " + k);
    }

    @Override
    public int size() {
        return map.size();
    }
}
