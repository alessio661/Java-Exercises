package dizionario;

public interface Dizionario<Key, Element> {
    Element search(Key key) throws ElementNotFoundException;
    void add(Key key, Element element) throws ElementAlreadyContainedException;
    Element delete(Key key) throws ElementNotFoundException;
    int size();
}


