import java.util.Scanner;

public class Main {
    static String[] greet = { "Hello! Welcome to Ramen101!", "Salutations good customer! Welcome to Ramen101." };
    // CREATE INSTANCE VARIABLES HERE. Ensure they are static.
    static String[] goodBye = {"Goodbye!", "See you later!", "Good doing business with you!", "Thanks for stopping by!", "Enjoy the rest of your day!"};
    static String[] randomResponse = {"I'm sorry, I didn't get that. ", "Pardon me, what did you say? ", "Sorry, could you repeat that? ", "Excuse me, could you clarify your response and try again? ", "I didn't quite get that, could you try again? "};
    static String[] keywords = { "ramen", "bbq", "appetizers" }; // validate input for BBQ if barbecue typed
    static Ramen[] ramenTypes = { new Ramen("tonkotsu",16), new Ramen("miso", 16), new Ramen("seafood", 19), new Ramen("black garlic", 16), new Ramen("chicken", 16), new Ramen("veggie","veggy","vegetable", 16)};
    static BBQ[] bbqs = { new BBQ("chicken katsu",15), new BBQ("teriyaki chicken", 15), new BBQ("hawaiian bbq chicken",15), new BBQ("hawaiian bbq beef",16),
            new BBQ("hawaiian bbq short rib", 17), new BBQ("bbq chicken and beef",17), new BBQ("bbq chicken and chicken katsu",17), new BBQ("hawaiian bbq trio",19) };
    static Appetizer[] appetizers = { new Appetizer("chicken kara-age", 11), new Appetizer("grill whole squid", 11), new Appetizer("gyoza", 8), new Appetizer("gedashi tofu", 8), new Appetizer("takoyaki", 10), new Appetizer("prawn tempura", 10), new Appetizer("vegetable tempura", 10), new Appetizer("kaki fry", 9), new Appetizer("geso fry", 10), new Appetizer("spam musubi", 8), new Appetizer("lumpia", 8), new Appetizer("crab rangoons",8), new Appetizer("edamame", 8), new Appetizer("spicy cucumber salad", 8), new Appetizer("white rice", 3) };
    // bbq parsing
    // parse input by lowering case

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Creates scanner object.
        System.out.println(greet[(int) (Math.random() * 2)]+ " What would you like to order? We have three main categoreies on our menu: ramen, barbeque, and appetizers. Please let me know if you are interested in any of them! If you would like to quit out of this chat, please type 'q'.");
        int food = -1;
        String userResp = "";
        while(food==-1) {
            userResp = in.nextLine().toLowerCase(); // in.nextLine() uses the scanner object to get the user's
                                                       // response as a String
            if (userResp.equals("q")) {
                System.out.println(goodBye[(int) (Math.random() * 3)]);
                System.exit(69);
            }
            food = firstMenuCheck(userResp);
            if (food!=-1) break;
            System.out.println(getRandomResponse() + "You can ask me about any of our three categories on our menu: Ramen, barbeque, and appetizers.");
        }
        if (food != -1) {
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
                for (Appetizer item : appetizers) {
                    System.out.print(item.getName() + ", ");
                }
            }

            System.out.println("Would you like to order one of these? If not, type 'q' to quit out of this chat.");
            int foodIndex = -1;
            if (food==0) {
                while (foodIndex == -1) {
                userResp = in.nextLine().toLowerCase();
                checkForQuit(userResp);
                for (int i=0;i<ramenTypes.length;i++) {
                    if (userResp.contains(ramenTypes[i].getName())) {
                        foodIndex = i;
                    }
                }
                if (foodIndex != -1) {
                    break;
                }
                System.out.print(getRandomResponse() + "Let me know if you are interested in any of the following dishes: ");
                    for (Ramen item : ramenTypes) { // display out method
                        System.out.print(item.getName() + ", ");
                    }

                
            }
            String spiceCheck = "-1";
            System.out.println("How spicy would you like your " + ramenTypes[foodIndex].getName() + " ramen to be? Please enter an integer from 0 to 4 inclusive, with 0 being no spice and 4 being extra spicy. If you would like to exit to the main menu, please type 'q'.");
            while (spiceCheck.equals("-1")) {
                userResp = in.nextLine().toLowerCase(); 
                if (userResp.equals("q")) {
                    main(greet);
                }
                if (userResp.contains("0") || userResp.contains("1") || userResp.contains("2") || userResp.contains("3") || userResp.contains("4")) {
                    spiceCheck = userResp;
                    break;
                }
                System.out.println(getRandomResponse());
            }
                System.out.printf("You placed an order for %s with spice level %s which is $%.2f%n",ramenTypes[foodIndex].getName(), spiceCheck, ramenTypes[foodIndex].getPrice()); // printf
                System.out.println("Type yes to confirm your order, and type no to quit to the main menu: ");
                while (!(userResp.equals("yes") && userResp.equals("no"))) {
                userResp = in.next().toLowerCase();
                if (userResp.equals("yes")) {
                    System.out.println("Your order has been placed, enjoy! 🍜");
                    break;
                } else if (userResp.equals("no")) {
                    main(greet);
                }
                else {
                    System.out.println(getRandomResponse() + "If you would like to confirm your order, please type 'yes'. To return back into the main menu, please type 'no'.");
                }
            }
            } else if(food==1) {
                while (foodIndex == -1) {
                    userResp = in.nextLine().toLowerCase();
                    checkForQuit(userResp);
                    for (int i=0;i<bbqs.length;i++) {
                        if (userResp.contains(bbqs[i].getName())) {
                            foodIndex = i;
                        }
                    }
                    if (foodIndex != -1) {
                        break;
                    }
                    System.out.print(getRandomResponse() + "Let me know if you are interested in any of the following dishes: ");
                        for (BBQ item : bbqs) {
                            System.out.print(item.getName() + ", ");
                        }
                }
                System.out.printf("You placed an order for %s which is $%.2f%n",bbqs[foodIndex].getName(),bbqs[foodIndex].getPrice()); // printf
                System.out.println("Type yes to confirm your order, and type no to quit to the main menu: ");
                while (!(userResp.equals("yes") && userResp.equals("no"))) {
                userResp = in.next().toLowerCase();
                if(userResp.equals("yes")) {
                    System.out.println("Your order has been placed, enjoy! 🥩");
                    break;
                } else if (userResp.equals("no")) {
                    main(greet);
                }
                else {
                    System.out.println(getRandomResponse());
                }
            }
            } else if(food==2) {
                while (foodIndex == -1) {
                    userResp = in.nextLine().toLowerCase();
                    checkForQuit(userResp);
                    for (int i=0;i<appetizers.length;i++) {
                        if (userResp.contains(appetizers[i].getName())) {
                            foodIndex = i;
                        }
                    }
                    if (foodIndex != -1) {
                        break;
                    }
                    System.out.print(getRandomResponse() + "Let me know if you are interested in any of the following dishes: ");
                        for (Appetizer item : appetizers) {
                            System.out.print(item.getName() + ", ");
                        }
                }
                System.out.printf("You placed an order for %s which is $%.2f%n",appetizers[foodIndex].getName(),appetizers[foodIndex].getPrice()); // printf
                System.out.println("Type yes to confirm your order, and type no to quit to the main menu: ");
                while (!(userResp.equals("yes") && userResp.equals("no"))) {
                userResp = in.next().toLowerCase();
                if(userResp.equals("yes")) {
                    System.out.println("Your order has been placed, enjoy! 🍽️");
                     break;
                } else if (userResp.equals("no")) {
                    main(greet);
                }
                else {
                    System.out.println(getRandomResponse());
                }
            }
        }
            else if (foodIndex == -1){
                System.out.println(getRandomResponse());
            }
        }
        System.out.println(goodBye[(int) (Math.random() * 3)]);
        in.close();
    }
    public static String getRandomResponse() {
        return randomResponse[(int) (Math.random() * 5)];
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
            main(greet);
        }
    }

}