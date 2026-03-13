import java.util.*;

public class Problem5AnalyticsDashboard {

    HashMap<String, Integer> pageViews = new HashMap<>();
    HashMap<String, Set<String>> uniqueVisitors = new HashMap<>();

    public void processEvent(String url, String userId) {

        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueVisitors.putIfAbsent(url, new HashSet<>());
        uniqueVisitors.get(url).add(userId);
    }

    public void getDashboard() {

        for (String url : pageViews.keySet()) {

            System.out.println(url +
                    " views: " + pageViews.get(url) +
                    " unique: " + uniqueVisitors.get(url).size());
        }
    }

    public static void main(String[] args) {

        Problem5AnalyticsDashboard dash = new Problem5AnalyticsDashboard();

        dash.processEvent("/news", "user1");
        dash.processEvent("/news", "user2");

        dash.getDashboard();
    }
}