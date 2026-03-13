import java.util.*;

public class Problem2InventoryManager {

    private HashMap<String, Integer> stock = new HashMap<>();
    private HashMap<String, Queue<Integer>> waitingList = new HashMap<>();

    public void addProduct(String productId, int quantity) {
        stock.put(productId, quantity);
        waitingList.put(productId, new LinkedList<>());
    }

    public synchronized String purchaseItem(String productId, int userId) {

        int quantity = stock.getOrDefault(productId, 0);

        if (quantity > 0) {
            stock.put(productId, quantity - 1);
            return "Success, remaining stock: " + (quantity - 1);
        } else {
            waitingList.get(productId).add(userId);
            return "Added to waiting list position " +
                    waitingList.get(productId).size();
        }
    }

    public int checkStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }

    public static void main(String[] args) {
        Problem2InventoryManager inv = new Problem2InventoryManager();
        inv.addProduct("IPHONE15", 2);

        System.out.println(inv.purchaseItem("IPHONE15", 1));
        System.out.println(inv.purchaseItem("IPHONE15", 2));
        System.out.println(inv.purchaseItem("IPHONE15", 3));
    }
}