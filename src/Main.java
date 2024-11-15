import java.util.Scanner;

public class Main {
    static String[] greet = { "Hello! Welcome to Ramen101!", "Salutations good customer! Welcome to Ramen101." };
    // CREATE INSTANCE VARIABLES HERE. Ensure they are static.
    static String[] goodBye = { "bye", "see you later!", "good doing business with you" };
    static String[] keywords = { "ramen", "bbq", "appetizers" }; // validate input for BBQ if barbecue typed
    static Ramen[] ramenTypes = { new Ramen("tonkotsu",16), new Ramen("miso", 16), new Ramen("seafood", 19), new Ramen("black garlic", 16), new Ramen("chicken", 16), new Ramen("veggie","veggy","vegetable", 16)};
    static BBQ[] bbqs = { new BBQ("chicken katsu",15), new BBQ("teriyaki chicken", 15), new BBQ("hawaiian bbq chicken",15), new BBQ("hawaiian bbq beef",16),
            new BBQ("hawaiian bbq short rib", 17), new BBQ("bbq chicken and beef",17), new BBQ("bbq chicken and chicken katsu",17), new BBQ("hawaiian bbq trio",19) };
    static String[] appetizers = { "chicken kara-age", "grill whole squid", "gyoza", "agedashi tofu", "takoyaki",
            "prawn tempura", "vegetable tempura", "kaki fry", "geso fry", "spam musubi", "lumpia", "crab rangoons",
            "edamame", "spicy cucumber salad", "white rice" };
    // bbq parsing
    // parse input by lowering case

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Creates scanner object.
        System.out.println(greet[(int) (Math.random() * 2)]+" What would you like to order?");
        String userResp = in.nextLine().toLowerCase(); // in.nextLine() uses the scanner object to get the user's
                                                       // response as a String
        checkForQuit(userResp); // fix goodbye dialog repeating bug
        int food = firstMenuCheck(userResp);
        if (food == -1) {
            getRandomResponse();
        } else {
            System.out.print("Sure! We offer a variety of " + keywords[food] + ", including our top choices: ");
            if (keywords[food].equals("ramen")) {
                for (Ramen item : ramenTypes) { // display out method
                    System.out.print(item.getName() + ", ");
                }
            } else if (keywords[food].equals("bbq")) {
                for (BBQ item : bbqs) {
                    System.out.print(item.getName() + ", ");
                }
            } else if (keywords[food].equals("appetizers")) {
                for (Ramen item : ramenTypes) {
                    System.out.print(item.getName() + ", ");
                }
            }
            // options to q to prev menu or
            System.out.println("Would you like to order one of these? If not, type 'q' to quit out of this chat.");
            userResp = in.nextLine().toLowerCase();
            checkForQuit(userResp);
            int ramenIndex = -1;
            int bbqIndex = -1;
            int appetizerIndex = -1;
            
            if (food==0) {
                for (int i=0;i<ramenTypes.length;i++) {
                    if (userResp.contains(ramenTypes[i].getName())) {
                        ramenIndex = i;
                    }
                }
            } else if(food==1) {
                for (int i=0;i<bbqs.length;i++) {
                    if (userResp.contains(bbqs[i].getName())) {
                        bbqIndex = i;
                    }
                }
            } else if(food==2) {
                for (int i=0;i<appetizers.length;i++) {
                    if (userResp.contains(appetizeres[i].getName())) { // have not finished making appetizers class
                        appetizerIndex = i;
                    }
                }
            }
            System.out.printf("You placed an order for %s which is $%.2f%n",ramenTypes[ramenIndex].getName(),ramenTypes[ramenIndex].getPrice()); // printf
            System.out.println("Type yes to confirm your order, and type no to quit: ");
            userResp = in.next().toLowerCase();
            if(userResp.equals("yes")) {
                System.out.println("Your order has been placed, enjoy! 🍜");
            } else {
                System.exit(69);
            }
        }
        in.close();
        System.out.println(goodBye[(int) (Math.random() * 3)]);

        // You will need to make sure your chatbot continues looping until it sees
        // certain keywords from the user such as "bye","goodbye"...
        // do you need a while loop or a for loop?

        // Consider: How do I check what the user says and compare it to my keywords?
        // What methods do I have?

    }

    // Create other methods that might be helpful down here.
    // For example a method called checkWord where the user traverses through an
    // array to check if a word matches.

    // One method you might need is getRandomResponse()
    public static String getRandomResponse() {
        return "";
    }
    // It'll generate a random response when the chatbot doesn't understand what to
    // say

    // Here is an example of a method you might use.
    public static String getResponse(String statement) {
        String response = "";
        if (statement.indexOf("no") >= 0) {
            response = "Why so negative?";
        } else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0) {
            response = "Tell me more about your family.";
        } else {
            // respoonse = getRandomResponse() <--- yo uwill need to create this methodd.
        }
        return response;
    }

    public static int firstMenuCheck(String in) { // make more general menucheck to replace later
        int menuCounter = -1;
        for (int i = 0; i < keywords.length; i++) {
            if (in.contains(keywords[i])) {
                menuCounter = i;
            }
        }
        return menuCounter;
    }

    public static void checkForQuit(String n) {
        if (n.equals("q")) {
            main(appetizers);
        }
    }

}