package feedback;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Utils {
    public static Supplier<Feedback> feedbackSupplier = () -> {
        Random random = new Random();
        List<String> comments = List.of("Ottimo prodotto!", "Interessante!", "Wow!");
        String productID = "p" + (random.nextInt(10) + 1);
        String userID = "u" + (random.nextInt(10) + 1);
        int rating = random.nextInt(5) + 1;

        String comment = comments.get(random.nextInt(comments.size()));
        return new Feedback(productID, userID, rating, comment);
    };

    public static Consumer<Feedback> feedbackConsumer = feedback -> {
        String fb = "L'utente " + feedback.getUsedID() + " ha valutato il prodotto" + feedback.getProductID() +
                " con un rating di " + feedback.getRating() + " - " + feedback.getComment();

        System.out.println(fb);
    };

    public static Function<Feedback, String> toUpper = feedback -> feedback.getComment().toUpperCase();
    public static Predicate<Feedback> selector = feedback -> feedback.getRating() >= 4;
}
