import java.util.*;

public class Problem7Autocomplete {

    HashMap<String, Integer> queries = new HashMap<>();

    public void addQuery(String query) {
        queries.put(query, queries.getOrDefault(query, 0) + 1);
    }

    public List<String> search(String prefix) {

        List<String> result = new ArrayList<>();

        for (String q : queries.keySet()) {
            if (q.startsWith(prefix)) {
                result.add(q);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Problem7Autocomplete auto = new Problem7Autocomplete();

        auto.addQuery("java tutorial");
        auto.addQuery("javascript guide");

        System.out.println(auto.search("jav"));
    }
}
