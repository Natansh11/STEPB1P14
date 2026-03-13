import java.util.*;

public class Problem10MultiLevelCache {

    HashMap<String, String> L1 = new HashMap<>();
    HashMap<String, String> L2 = new HashMap<>();

    public String getVideo(String videoId) {

        if (L1.containsKey(videoId)) {
            return "L1 HIT";
        }

        if (L2.containsKey(videoId)) {
            L1.put(videoId, L2.get(videoId));
            return "L2 HIT → Promoted to L1";
        }

        L2.put(videoId, "VideoData");

        return "Database HIT → Stored in L2";
    }

    public static void main(String[] args) {

        Problem10MultiLevelCache cache = new Problem10MultiLevelCache();

        System.out.println(cache.getVideo("video123"));
        System.out.println(cache.getVideo("video123"));
    }
}