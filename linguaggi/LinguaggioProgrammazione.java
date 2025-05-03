package linguaggi;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum LinguaggioProgrammazione {
    JAVA("Java", 1995, "Object-Oriented", "Concurrent"),
    PYTHON("Python", 1991, "Object-Oriented", "Imperative", "Functional"),
    HASKELL("Haskell", 1990, "Functional", "Lazy"),
    C("C", 1972, "Procedural"),
    JAVASCRIPT("JavaScript", 1995, "Event-Driven", "Functional", "Object-Oriented");

    private final String nome;
    private final int anno;
    private final String[] paradigmi;

    LinguaggioProgrammazione(String nome, int anno, String... paradigmi) {
        this.nome = nome;
        this.anno = anno;
        this.paradigmi = paradigmi;
    }

    public boolean supports(String paradigma) {
        for (String p : paradigmi)
            if (p.equalsIgnoreCase(paradigma))
                return true;
        return false;
    }

    public static List<LinguaggioProgrammazione> filter(String paradigma) {
        return Arrays.stream(values())
                .filter(lang -> lang.supports(paradigma))
                .toList();
    }

}
