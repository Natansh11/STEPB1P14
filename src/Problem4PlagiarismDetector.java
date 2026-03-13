import java.util.*;

public class Problem4PlagiarismDetector {

    public static Set<String> generateNGrams(String text, int n) {

        String[] words = text.split(" ");
        Set<String> ngrams = new HashSet<>();

        for (int i = 0; i <= words.length - n; i++) {

            StringBuilder gram = new StringBuilder();

            for (int j = 0; j < n; j++) {
                gram.append(words[i + j]).append(" ");
            }

            ngrams.add(gram.toString().trim());
        }

        return ngrams;
    }

    public static double similarity(String doc1, String doc2) {

        Set<String> grams1 = generateNGrams(doc1, 3);
        Set<String> grams2 = generateNGrams(doc2, 3);

        grams1.retainAll(grams2);

        return (grams1.size() * 100.0) / grams2.size();
    }

    public static void main(String[] args) {

        String d1 = "this is a simple plagiarism detection example";
        String d2 = "this is a plagiarism detection system example";

        System.out.println("Similarity: " + similarity(d1, d2) + "%");
    }
}