import java.util.*;

class TokenBucket {
    int tokens;
    long lastRefill;

    TokenBucket(int limit) {
        tokens = limit;
        lastRefill = System.currentTimeMillis();
    }
}

public class Problem6RateLimiter {

    HashMap<String, TokenBucket> clients = new HashMap<>();
    int limit = 5;

    public boolean checkRateLimit(String clientId) {

        clients.putIfAbsent(clientId, new TokenBucket(limit));

        TokenBucket bucket = clients.get(clientId);

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Problem6RateLimiter limiter = new Problem6RateLimiter();

        System.out.println(limiter.checkRateLimit("client1"));
        System.out.println(limiter.checkRateLimit("client1"));
    }
}