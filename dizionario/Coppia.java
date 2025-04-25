package dizionario;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Coppia<K, E> {
    private final K key;
    private final E element;
}
