package funzione2;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@FunctionalInterface
public interface Func {
    List<Integer> operation(List<Integer> list);
}

class FuncMain {
    public static @NotNull Func compound(Func... funcs) {
        return list -> {
            List<Integer> result = new LinkedList<>(list);
            for (Func f : funcs)
                result = f.operation(result);

            return result;
        };
    }

    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>(Arrays.asList(4, 9, 4, 21, 18, 4));

        Func f1 = list -> list.stream().filter(n -> n % 2 != 0).toList();
        Func f2 = list -> list.stream().map(n -> n * 3).toList();
        Func f3 = list -> list.stream().filter(n -> n > 10).toList();
        Func f4 = list -> {
            List<Integer> copy = new LinkedList<>(list);
            copy.sort(Comparator.reverseOrder());
            return copy;
        };

        Func insieme = compound(f1, f2, f3, f4);

        System.out.println(insieme.operation(numbers));
    }


}
