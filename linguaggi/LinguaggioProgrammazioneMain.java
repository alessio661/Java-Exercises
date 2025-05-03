package linguaggi;

public class LinguaggioProgrammazioneMain {
    public static void main(String[] args) {
        for (LinguaggioProgrammazione lang : LinguaggioProgrammazione.values()) {
            System.out.println(lang.getNome() + " " + lang.getAnno());
            System.out.println("Paradigmi: " + String.join(",", lang.getParadigmi()));
        }

        for (LinguaggioProgrammazione lang : LinguaggioProgrammazione.filter("Object-Oriented"))
            System.out.println("Linguaggio: " + lang.getNome());

    }
}
