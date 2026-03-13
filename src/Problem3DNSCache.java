import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, int ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl * 1000;
    }

    boolean isExpired() {
        return System.currentTimeMillis() > expiry;
    }
}

public class Problem3DNSCache {

    private HashMap<String, DNSEntry> cache = new HashMap<>();

    public String resolve(String domain) {

        if (cache.containsKey(domain)) {
            DNSEntry entry = cache.get(domain);

            if (!entry.isExpired()) {
                return "Cache HIT: " + entry.ip;
            }
        }

        String ip = "192.168.1." + new Random().nextInt(255);
        cache.put(domain, new DNSEntry(ip, 5));

        return "Cache MISS: " + ip;
    }

    public static void main(String[] args) {

        Problem3DNSCache dns = new Problem3DNSCache();

        System.out.println(dns.resolve("google.com"));
        System.out.println(dns.resolve("google.com"));
    }
}