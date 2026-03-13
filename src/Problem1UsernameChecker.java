import java.util.*;

public class Problem1UsernameChecker {

    private HashMap<String, Integer> users = new HashMap<>();
    private HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public void registerUser(String username, int userId) {
        users.put(username, userId);
    }

    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            suggestions.add(username + i);
        }
        suggestions.add(username.replace("_", "."));
        return suggestions;
    }

    public String getMostAttempted() {
        return Collections.max(attempts.entrySet(),
                Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        Problem1UsernameChecker system = new Problem1UsernameChecker();
        system.registerUser("john_doe", 1);

        System.out.println(system.checkAvailability("john_doe"));
        System.out.println(system.suggestAlternatives("john_doe"));
    }
}
