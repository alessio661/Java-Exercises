package funzione;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
public interface Funzione {
    Integer[] apply(List<Integer> list, int k);
}

class FunzioneMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 1, 6, 7, 2, 9);

        Funzione f1 = ((l, k) -> l.subList(0, k).toArray(new Integer[0]));
        Funzione f2 = ((l, k) -> {
            List<Integer> lista = new ArrayList<>();
            for (Integer i : l)
                if (i > k) lista.add(i);

            return lista.toArray(new Integer[0]);
        });

        System.out.println(Arrays.toString(f1.apply(list, 4)));
        System.out.println(Arrays.toString(f2.apply(list, 4)));
    }
}
