import java.util.Scanner;

public class Main {
    static String[] greet = { "Hello! Welcome to Ramen101!", "Salutations good customer! Welcome to Ramen101." };
    // CREATE INSTANCE VARIABLES HERE. Ensure they are static.
    static String[] goodBye = {"Goodbye!", "See you later!", "Good doing business with you!", "Thanks for stopping by!", "Enjoy the rest of your day!"};
    static String[] randomResponse = {"I'm sorry, I didn't get that. ", "Pardon me, what did you say? ", "Sorry, could you repeat that? ", "Excuse me, could you clarify your response and try again? ", "I didn't quite get that, could you try again? "};
    static String[] keywords = { "ramen", "bbq", "appetizers" }; // validate input for BBQ if barbecue typed
    static Ramen[] ramenTypes = { new Ramen("tonkotsu",16, "A rich and creamy pork bone broth with deep umami flavor, topped with tender chashu, green onions, and a marinated egg."), new Ramen("miso", 16, "A hearty and slightly sweet broth made with fermented soybean paste, balanced with robust toppings like corn, bamboo shoots, and garlic."), new Ramen("seafood", 19, "A delicate, ocean-inspired broth infused with the flavors of shrimp, fish, and seaweed, garnished with seafood toppings."), new Ramen("black garlic", 16, "A bold, smoky broth enhanced with roasted black garlic oil, delivering a deep, aromatic flavor."), new Ramen("chicken", 16, "A light and clean chicken-based broth, offering a comforting and mild taste with fresh vegetables and chicken slices."), new Ramen("veggie", 16, "A plant-based broth brimming with earthy flavors, loaded with seasonal vegetables, tofu, and a hint of miso or soy sauce for depth.")};
    static BBQ[] bbqs = {new BBQ("chicken katsu",15, "A crispy, golden-breaded chicken cutlets served with a tangy katsu sauce for a savory crunch in every bite."), new BBQ("teriyaki chicken", 15, "Grilled chicken glazed in a sweet and savory teriyaki sauce, perfectly caramelized for a rich flavor."), new BBQ("hawaiian bbq chicken",15, "Juicy, marinated chicken grilled to perfection with a touch of smoky island-inspired sweetness."), new BBQ("hawaiian bbq beef",16, "Tender slices of marinated beef, grilled and infused with the bold, savory flavors of Hawaiian barbecue."), new BBQ("hawaiian bbq short rib", 17, "Succulent, bone-in short ribs with a sweet and smoky glaze, charred to a delicious finish."), new BBQ("bbq chicken and beef",17, "A flavorful combo of grilled Hawaiian BBQ chicken and beef, offering the best of both worlds."), new BBQ("bbq chicken and chicken katsu",17, "A satisfying pairing of crispy chicken katsu and juicy Hawaiian BBQ chicken, perfect for variety lovers."), new BBQ("hawaiian bbq trio",19, "A hearty platter combining Hawaiian BBQ chicken, beef, and short rib, for the ultimate BBQ feast.")};
    static Appetizer[] appetizers = { new Appetizer("chicken kara-age", 11, "Japanese style popcorn chicken with a side of spicy mayo."), new Appetizer("grill whole squid", 11, "Whole squid sliced and generously sauced."), new Appetizer("gyoza", 8, "Deep fried pork potstickers with a side of a soy vinegar and chili oil sauce."), new Appetizer("agedashi tofu", 8, "Drudged in sweet potato flour and fried. Topped with bonito flakes (fish flakes). Accompanied by a side of Tempura Sauce."), new Appetizer("takoyaki", 10, "Traditionally considered Japanese street food. Little leg of octopus, battered and fried into a ball, sauced, and topped with bonito flakes (fish flakes)."), new Appetizer("prawn tempura", 10, "Japanese stretched fried prawn. Accompanied by a side of Tempura Sauce."), new Appetizer("vegetable tempura", 10, "Japanese style assorted fried vegetables. Includes broccoli, zucchini,sweet potatoe, and onion. Accompanied by a side of Tempura Sauce."), new Appetizer("kaki fry", 9, "deep fried oysters with a side of spicy mayo."), new Appetizer("geso fry", 10, "fried squid legs with a side of spicy mayo."), new Appetizer("spam musubi", 8, "rice and spam wrapped tightly around with seaweed with sauce inside"), new Appetizer("lumpia", 8, "Filipino style mini egg rolls filled with pork and veggies. Comes with a side of sweet and sour sauce."), new Appetizer("crab rangoons",8, "deep fried wonton wrappers filled with cream cheese and imitation crab. Comes with a side of sweet and sour sauce"), new Appetizer("edamame", 8, "al dente boiled soy beans and salted."), new Appetizer("spicy cucumber salad", 8, "refreshing side dish featuring crisp cucumber slices tossed in a tangy, spicy dressing with hints of garlic and sesame. It's the perfect balance of heat and coolness, ideal for complementing any meal."), new Appetizer("white rice", 3, "Every asian's favorite food.")};
    // bbq parsing
    // parse input by lowering case
    static Scanner in = new Scanner(System.in); // Creates global scanner object.

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in); // Creates scanner object.
        System.out.println(greet[(int) (Math.random() * 2)]+ " What would you like to order? We have three main categories on our menu: ramen, barbeque, and appetizers. Please let me know if you are interested in any of them! If you would like to quit out of this chat, please type 'q'.");
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

            System.out.println("Would you like to order one of these? If not, type 'q' to go back to the main menu.");
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

    public static void help(String n) {
        if (n.contains("help")) {
            System.out.println("Sure! Do you want descriptions or recommendations?");
            String userResp = in.next().toLowerCase();
            if (userResp.contains("recommend")) {
                System.out.println("Which food are you interested in, ramen, barbecue, or appetizers?");
                userResp = in.next().toLowerCase();
                if (userResp.contains("ramen")) {
                    System.out.println("Choose 1-4");
                    System.out.println("1. Rich and hearty flavored ramen");
                    System.out.println("2. Light and refreshing ramen");
                    System.out.println("3. Vegetarian option");
                    System.out.println("4. Extra toppings");
                    userResp = in.next();
                    if (userResp.contains("1")) {
                        System.out.println("We recommend Tonkotsu ramen or miso ramen, with Tonkotsu having a creamy, flavorful broth made from pork bones. It's perfect for those wanting a deep umami taste. Miso Ramen is made with miso-based broth, this ramen offers a savory, slightly tangy flavor, with a full-bodied richness. It's great for those who want a more intricate taste.")
                    } else if (userResp.contains("2")) {
                        System.out.println("We recommend Shoyu Ramen. This soy sauce-based broth is lighter than tonkotsu or miso but still offers a flavorful depth. Add some fresh veggies and a soft-boiled egg and it's perfect.")
                    } else if (userResp.contains("3")) {
                        System.out.println("We recommend Veggie Ramen, as not only is it the only vegetarian option but ")
                    } else if (userResp.contains("4")) {
                        
                    } else {
                        
                    }
                } else if (userResp.contains("barbecue")) {

                } else if (userResp.contains("appetizers")) {

                } else {
                    System.out.println("Exiting to main menu...");
                }
            }                   // may want to write a helper method for detecting which food user wants

            else if (userResp.contains("description")) {
                int itemChecker = -1;
                System.out.println("Alright! What menu category would you like to know about? Ramen, barbeque, or appetizers.");
                userResp = in.next().toLowerCase();
                if (userResp.contains("ramen")) {
                    System.out.print("Sure! Which of the following ramen flavors are you interested in? ");
                    for (Ramen x : ramenTypes) {
                        System.out.print(x.getName() + ", ");
                    }
                    while (itemChecker == -1) {
                        userResp = in.nextLine().toLowerCase();
                        checkForQuit(userResp);
                        for (int i=0;i<ramenTypes.length;i++) {
                            if (userResp.contains(ramenTypes[i].getName())) {
                                itemChecker = i;
                            }
                        }
                        if (itemChecker != -1) {
                            break;
                        }
                        System.out.print(getRandomResponse() + "Let me know if you are interested in any of the following dishes: ");
                        for (Ramen item : ramenTypes) { // display out method
                                System.out.print(item.getName() + ", ");
                        }
                    }

                }

            }
        }
    }

}