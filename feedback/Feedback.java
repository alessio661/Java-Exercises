package feedback;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public class Feedback {
    private String productID;
    private String usedID;
    private int rating;
    private String comment;
}

class FeedbackAnalyzer {
    public static void main(String[] args) {
        List<Feedback> feedbacks = Stream.generate(Utils.feedbackSupplier).limit(100).toList();
        feedbacks.forEach(Utils.feedbackConsumer);

        Map<String, Double> avgRating = feedbacks.stream()
                .collect(Collectors.groupingBy(
                        Feedback::getProductID,
                        Collectors.averagingInt(Feedback::getRating)
                ));

        List<String> topProducts = avgRating.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();

        for (String productID : topProducts) {
            double media = avgRating.get(productID);
            List<String> comments = feedbacks.stream()
                    .filter(f -> f.getProductID().equals(productID))
                    .map(Feedback::getComment)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .limit(3)
                    .toList();

            System.out.println("Prodotto" + productID + " - Media voti -: " + media);
            comments.forEach(c -> System.out.println(" - " + c));
        }
    }
    public String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach(s -> sb.append(s).append(" "));

        return sb.toString();
    }
}
