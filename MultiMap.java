package multimappa;

import lombok.Getter;

import java.util.*;

@Getter
public class MultiMap<K, V> {
    private final Map<K, V> multimap;

    public MultiMap() {
        this.multimap = new HashMap<>();
    }

    public V get(K key) throws NullPointerException {
        return this.multimap.getOrDefault(key, null);
    }

    public void put(K key, V value) {
        this.multimap.put(key, value);
    }

    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (Map.Entry<K, V> entries : multimap.entrySet())
            set.add(entries.getKey());

        return set;
    }

    public List<V> values() {
        List<V> vList = new LinkedList<>();
        for (K key : multimap.keySet())
            vList.add(get(key));

        return vList;
    }

    public List<V> values(Comparator<Object> comparator) {
        List<V> vList = new LinkedList<>();
        for (K key : multimap.keySet())
            vList.add(get(key));
        vList.sort(comparator);

        return vList;
    }

    public Set<V> valueSet() {
        return new HashSet<>(values());
    }
}

