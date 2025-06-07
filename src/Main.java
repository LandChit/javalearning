import Helpers.CartDetails;
import Helpers.ProductDetails;

// why did the IDE auto import this lol
import java.util.*;

public class Main {
    public static String state = "l";
    public static boolean running = true;
    public static void clearConsole() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            // Handle exceptions
        }
    }

    static Map<String, ProductDetails> products_list = new HashMap<>();
    static Map<String, CartDetails> cart = new HashMap<>();

    public static void add_to_cart(int product_id, double price, String name,  String image, String description){
        ProductDetails current = new ProductDetails(price,name, image, description);
        products_list.put(String.valueOf(product_id), current);
    }
    public static void remove_from_pl(String product_id){
        products_list.remove(product_id);
    }
    public static void clear_pl(){
        products_list.clear();
    }
    public static void print_pl(){
        Set<String> products_keys = products_list.keySet();

        for (String product_id : products_keys){
            System.out.println("ProductId: " + product_id);
            System.out.println(products_list.get(product_id));
            System.out.println();
        }
    }
    public static double get_total(){
        Set<String> cart_keys = cart.keySet();

        double total = 0.0;
        for (String cart_id : cart_keys){
            total += products_list.get(cart_id).getPrice() * cart.get(cart_id).getAmount();
        }
        return total;
    }

    public static void print_cart(){
        Set<String> cart_keys = cart.keySet();
        for (String cart_id : cart_keys){
            ProductDetails cprod = products_list.get(cart_id);
            System.out.println(cart_id +"("+ cprod.getName() + ")" + ": " + cart.get(cart_id).getAmount() + " : " +cprod.getPrice()*cart.get(cart_id).getAmount());
        }
        System.out.println("Total: "+ get_total());
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sca = new Scanner(System.in);

        // Will save to a db/json file later that's why it's here
        add_to_cart(0, 19.00, "Hersheys", "image", "a cool description");
        add_to_cart(1, 30.00, "Toblerone", "image", "Tob cool description");



        while(running) {
            clearConsole();
            if (Objects.equals(state, "l")){
                System.out.println("Products List");
                print_pl();
            } else if(Objects.equals(state, "c")){
                print_cart();
            }

            String input = sc.nextLine();

            // TODO: Better input handling
            if (Objects.equals(input, "q")) {
                running = false;
            } else if (Objects.equals(input, "c")) {
                state = "c";
            } else if (Objects.equals(input, "l")) {
                state = "l";
            } else if (Objects.equals(input, "d")) {
                System.out.print("Id: ");
                int key = sca.nextInt();
                cart.remove(String.valueOf(key));

            } else if (!Objects.equals(input, "") && (products_list.containsKey(input))){
                System.out.print("amount: ");
                int amount = sca.nextInt();
                cart.put(input, new CartDetails(amount));
            }
        }
    }
}
