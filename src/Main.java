import java.util.Scanner;

public class Main {
    // CREATE INSTANCE VARIABLES HERE. Ensure they are static.
    static String[] greet = { "Hello! Welcome to Ramen101!", "Salutations good customer! Welcome to Ramen101." };
    static String[] goodBye = {"Goodbye!", "See you later!", "Good doing business with you!", "Thanks for stopping by!", "Enjoy the rest of your day!"};
    static String[] randomResponse = {"I'm sorry, I didn't get that. ", "Pardon me, what did you say? ", "Sorry, could you repeat that? ", "Excuse me, could you clarify your response and try again? ", "I didn't quite get that, could you try again? "};
    static String[] keywords = { "ramen", "bbq", "appetizers", "barbeque", "barbecue", "appetizer" };
    static Ramen[] ramenTypes = { new Ramen("tonkotsu",16, " rich and creamy pork bone broth with deep umami flavor, topped with tender chashu, green onions, and a marinated egg."), new Ramen("miso", 16, " hearty and slightly sweet broth made with fermented soybean paste, balanced with robust toppings like corn, bamboo shoots, and garlic."), new Ramen("seafood", 19, " delicate, ocean-inspired broth infused with the flavors of shrimp, fish, and seaweed, garnished with seafood toppings."), new Ramen("black garlic", 16, " bold, smoky broth enhanced with roasted black garlic oil, delivering a deep, aromatic flavor."), new Ramen("chicken", 16, " light and clean chicken-based broth, offering a comforting and mild taste with fresh vegetables and chicken slices."), new Ramen("veggie", 16, " plant-based broth brimming with earthy flavors, loaded with seasonal vegetables, tofu, and a hint of miso or soy sauce for depth.")};
    static BBQ[] bbqs = {new BBQ("chicken katsu",15, " crispy, golden-breaded chicken cutlets served with a tangy katsu sauce for a savory crunch in every bite."), new BBQ("teriyaki chicken", 15, " grilled chicken glazed in a sweet and savory teriyaki sauce, perfectly caramelized for a rich flavor."), new BBQ("hawaiian bbq chicken",15, " juicy, marinated chicken grilled to perfection with a touch of smoky island-inspired sweetness."), new BBQ("hawaiian bbq beef",16, " tender slices of marinated beef, grilled and infused with the bold, savory flavors of Hawaiian barbecue."), new BBQ("hawaiian bbq short rib", 17, " succulent, bone-in short ribs with a sweet and smoky glaze, charred to a delicious finish."), new BBQ("bbq chicken and beef",17, " a flavorful combo of grilled Hawaiian BBQ chicken and beef, offering the best of both worlds."), new BBQ("bbq chicken and chicken katsu",17, " satisfying pairing of crispy chicken katsu and juicy Hawaiian BBQ chicken, perfect for variety lovers."), new BBQ("hawaiian bbq trio",19, " hearty platter combining Hawaiian BBQ chicken, beef, and short rib, for the ultimate BBQ feast.")};
    static Appetizer[] appetizers = { new Appetizer("chicken kara-age", 11, " japanese style popcorn chicken with a side of spicy mayo."), new Appetizer("grill whole squid", 11, " whole squid sliced and generously sauced."), new Appetizer("gyoza", 8, " deep fried pork potstickers with a side of a soy vinegar and chili oil sauce."), new Appetizer("agedashi tofu", 8, "Drudged in sweet potato flour and fried. topped with bonito flakes (fish flakes). Accompanied by a side of Tempura Sauce."), new Appetizer("takoyaki", 10, " traditionally considered Japanese street food. Little leg of octopus, battered and fried into a ball, sauced, and topped with bonito flakes (fish flakes)."), new Appetizer("prawn tempura", 10, " Japanese stretched fried prawn. Accompanied by a side of Tempura Sauce."), new Appetizer("vegetable tempura", 10, " Japanese style assorted fried vegetables. Includes broccoli, zucchini,sweet potatoe, and onion. Accompanied by a side of Tempura Sauce."), new Appetizer("kaki fry", 9, " deep fried oysters with a side of spicy mayo."), new Appetizer("geso fry", 10, " fried squid legs with a side of spicy mayo."), new Appetizer("spam musubi", 8, " rice and spam wrapped tightly around with seaweed with sauce inside"), new Appetizer("lumpia", 8, " Filipino style mini egg rolls filled with pork and veggies. Comes with a side of sweet and sour sauce."), new Appetizer("crab rangoons",8, " deep fried wonton wrappers filled with cream cheese and imitation crab. Comes with a side of sweet and sour sauce"), new Appetizer("edamame", 8, " al dente boiled soy beans and salted."), new Appetizer("spicy cucumber salad", 8, " refreshing side dish featuring crisp cucumber slices tossed in a tangy, spicy dressing with hints of garlic and sesame. It's the perfect balance of heat and coolness, ideal for complementing any meal."), new Appetizer("white rice", 3, " every asian's favorite food.")};
    // bbq parsing
    static Scanner in = new Scanner(System.in); // Creates global scanner object.

    public static void main(String[] args) {
        println(greet[(int) (Math.random() * 2)]+ " What would you like to order? We have three main categories on our menu: ramen, barbeque, and appetizers. Please let me know if you are interested in any of them! If you would like recommendations or descriptions of any of the dishes, please type 'help'. If you would like to quit out of this chat, please type 'q'.");
        int food = -1;
        String userResp = "";
        while(food==-1) {
            userResp = in.nextLine().toLowerCase(); 
            help(userResp);
            if (userResp.equals("q")) {
                println(goodBye[(int) (Math.random() * 3)]);
                System.exit(69);
            }
            food = firstMenuCheck(userResp);
            if (food!=-1) {
                break;
            }
            println(getRandomResponse() + "You can ask me about any of our three categories on our menu: ramen, barbeque, and appetizers.");
        }
        if (food != -1) {
            System.out.print("Sure! We offer a variety of " + keywords[food] + ", including our top choices: ");
            if (keywords[food].equals("ramen")) {
                for (Ramen item : ramenTypes) { // display out method
                    System.out.print(item.getName() + ", ");
                }
            } else if (keywords[food].equals("bbq") || keywords[food].equals("barbeque") || keywords[food].equals("barbecue")) {
                for (BBQ item : bbqs) {
                    System.out.print(item.getName() + ", ");
                }
            } else if (keywords[food].equals("appetizers") || keywords[food].equals("appetizer")) {
                for (Appetizer item : appetizers) {
                    System.out.print(item.getName() + ", ");
                }
            }

            println("Would you like to order one of these? If not, type 'q' to go back to the main menu.");
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
            println("How spicy would you like your " + ramenTypes[foodIndex].getName() + " ramen to be? Please enter an integer from 0 to 4 inclusive, with 0 being no spice and 4 being extra spicy. If you would like to exit to the main menu, please type 'q'.");
            while (spiceCheck.equals("-1")) {
                userResp = in.nextLine().toLowerCase(); 
                if (userResp.equals("q")) {
                    main(greet);
                }
                if (userResp.contains("0") || userResp.contains("1") || userResp.contains("2") || userResp.contains("3") || userResp.contains("4")) {
                    spiceCheck = userResp;
                    break;
                }
                println(getRandomResponse() + "Enter an integer from 0 to 4 inclusive to determine your spice level: ");
            }
                System.out.printf("You placed an order for %s with spice level %s which is $%.2f%n",ramenTypes[foodIndex].getName(), spiceCheck, ramenTypes[foodIndex].getPrice()); // printf
                println("Type yes to confirm your order, and type no to quit to the main menu: ");
                while (!(userResp.equals("yes") && userResp.equals("no"))) {
                userResp = in.nextLine().toLowerCase();
                if (userResp.equals("yes")) {
                    println("Your order has been placed, enjoy! 🍜");
                    break;
                } else if (userResp.equals("no")) {
                    main(greet);
                }
                else {
                    println(getRandomResponse() + "If you would like to confirm your order, please type 'yes'. To return back into the main menu, please type 'no'.");
                }
            }
            } else if(food == 1 || food == 3 || food == 4) {
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
                println("Type yes to confirm your order, and type no to quit to the main menu: ");
                while (!(userResp.equals("yes") && userResp.equals("no"))) {
                userResp = in.nextLine().toLowerCase();
                if(userResp.equals("yes")) {
                    println("Your order has been placed, enjoy! 🥩");
                    break;
                } else if (userResp.equals("no")) {
                    main(greet);
                }
                else {
                    println(getRandomResponse() + "If you would like to confirm your order, please type 'yes'. To return back into the main menu, please type 'no'.");
                }
            }
            } else if(food==2 || food == 5) {
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
                println("Type yes to confirm your order, and type no to quit to the main menu: ");
                while (!(userResp.equals("yes") && userResp.equals("no"))) {
                userResp = in.nextLine().toLowerCase();
                if(userResp.equals("yes")) {
                    println("Your order has been placed, enjoy! 🍽️");
                     break;
                } else if (userResp.equals("no")) {
                    main(greet);
                }
                else {
                    println(getRandomResponse() + "If you would like to confirm your order, please type 'yes'. To return back into the main menu, please type 'no'.");
                }
            }
        }
            else if (foodIndex == -1){
                println(getRandomResponse());
            }
        }
        println(goodBye[(int) (Math.random() * 3)]);
        in.close();
        System.exit(69);
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
            println("Sure! Would you like to hear about the descriptions of certain dishes or recommendations? If not, type 'q' to return to the main menu.");
            String userResp = in.nextLine().toLowerCase();
            if (userResp.equals("q")) {
                main(greet);
            }
            while (!userResp.contains("recommend") && !userResp.contains("description")) {
                println("Would you like to ask me for a description or a recommendation for a dish? Type 'q' if you would like to return to the main menu.");
                userResp = in.nextLine().toLowerCase();
                if (userResp.equals("q")) {
                    main(greet);
                    break;
                }
            }
            if (userResp.contains("recommend")) {
                println("Which food are you interested in, ramen, barbecue, or appetizers? If not, type 'q' to quit to the main menu.");
                userResp = in.nextLine().toLowerCase();
                while (!userResp.contains("ramen") && !userResp.contains("appetizer") && !userResp.contains("barbecue") && !userResp.contains("barbeque") && !userResp.contains("bbq")) {
                    if (userResp.equals("q")) {
                        main(greet);
                        break;
                    }
                    println(getRandomResponse() + "Let me know if you are interested in ramen, barbecue, or appetizers. Input 'q' to quit out to the main menu.");
                    userResp = in.nextLine().toLowerCase();
                    if (userResp.equals("q")) {
                        main(greet);
                        break;
                    }
                }
                if (userResp.contains("ramen")) {
                    println("Input 1, 2, or 3 that best matches what you're interested in: ");
                    println("1. Rich and hearty flavored ramen");
                    println("2. Light and refreshing ramen");
                    println("3. Vegetarian option");
                    println("Or, type 'q' to return to the main menu.");
                    while (!userResp.contains("1") && !userResp.contains("2") && !userResp.contains("3")) {
                    userResp = in.nextLine();
                    if (userResp.contains("1")) {
                        println("We recommend Tonkotsu ramen or miso ramen, with Tonkotsu having a creamy, flavorful broth made from pork bones. It's perfect for those wanting a deep umami taste. Miso Ramen is made with miso-based broth, this ramen offers a savory, slightly tangy flavor, with a full-bodied richness. It's great for those who want a more intricate taste.");
                    } else if (userResp.contains("2")) {
                        println("We recommend Shoyu Ramen. This soy sauce-based broth is lighter than tonkotsu or miso but still offers a flavorful depth. Add some fresh veggies and a soft-boiled egg and it's perfect.");
                    } else if (userResp.contains("3")) {
                        println("We recommend Veggie Ramen, as not only is it the only vegetarian option but it has a variety of vegetables.");
                    } else if (userResp.equals("q")) {
                        println("Exiting to main menu...");
                        main(greet);
                    } else {
                        println(getRandomResponse() + " Please type a number from 1 to 3 for a recommendation for the corresponding choice. If you would like to return to the main menu, please type q.");
                    }
                }
                    println(" Is there any other dish you would like to know about? If yes, type 'yes', and if not, type 'q' to return to the main menu. ");
                    while (!userResp.contains("yes") && !userResp.contains("q")) {
                        userResp = in.nextLine().toLowerCase();
                        if (userResp.contains("yes")) {
                            help("help");
                        }
                        else if (userResp.contains("q")) {
                            main(greet);
                        }
                        println(getRandomResponse() + " Type 'q' to exit to the main menu, or 'yes' to ask about another dish.");
                    } 
                
                } else if (userResp.contains("barbecue")||userResp.contains("bbq")||userResp.contains("barbeque")) {
                    println("Input 1, 2, or 3 that best matches what you're interested in: ");
                    println("1. Classic Chicken BBQ");
                    println("2. Beef & Short Ribs BBQ");
                    println("3. Combination BBQ Platters");
                    println("Or, type 'q' to return to the main menu.");
                    while (!userResp.contains("1") && !userResp.contains("2") && !userResp.contains("3")) {
                    userResp = in.nextLine();
                    if (userResp.contains("1")) {
                        println("We recommend Teriyaki Chicken, Hawaiian BBQ Chicken, Chicken.");
                    } else if (userResp.contains("2")) {
                        println("We recommend Shoyu Ramen. This soy sauce-based broth is lighter than tonkotsu or miso but still offers a flavorful depth. Add some fresh veggies and a soft-boiled egg and it's perfect.");
                    } else if (userResp.contains("3")) {
                        println("We recommend Veggie Ramen, as not only is it the only vegetarian option but it has a variety of vegetables.");
                    } else if (userResp.equals("q")) {
                        println("Exiting to main menu...");
                        main(greet);
                    } else {
                        println(getRandomResponse() + " Please type a number from 1 to 3 for a recommendation for the corresponding choice. If you would like to return to the main menu, please type q.");
                    } 
                }
                    println(" Is there any other dish you would like to know about? If yes, type 'yes', and if not, type 'q' to return to the main menu. ");
                    while (!userResp.contains("yes") && !userResp.contains("q")) {
                        userResp = in.nextLine().toLowerCase();
                        if (userResp.contains("yes")) {
                            help("help");
                            break;
                        }
                        else if (userResp.contains("q")) {
                            main(greet);
                            break;
                        }
                        println(getRandomResponse() + " Type 'q' to exit to the main menu, or 'yes' to ask about another dish.");
                    }
                
                } else if (userResp.contains("appetizers")) {
                    println("Input 1, 2, or 3 that best matches what you're interested in: ");
                    println("1. Something light");
                    println("2. A fried snack");
                    println("3. Seafood ");
                    println("4. Vegetarian options");
                    println("Or, type 'q' to return to the main menu.");
                    while (!userResp.contains("1") && !userResp.contains("2") && !userResp.contains("3") && !userResp.contains("4")) {
                        userResp = in.nextLine();
                        if (userResp.contains("1")) {
                            System.out.print("We recommend getting the edamame. It's a small appetizer filled with a savory flavor that's perfect before any of our main courses.");
                        } else if (userResp.contains("2")) {
                            System.out.print("We recommend the chicken kara-age or geso fry. Both have a numerous amount of delicious spices mixed together to create a rich flavor, which complements the spicy mayo that comes with each.");
                        } else if (userResp.contains("3")) {
                            System.out.print("We recommend the takoyaki. Each fried ball is packed with seasoned octopus and mouth-watering sauces, seasoned with our signature sesame seeds and fish flakes.");
                        } else if (userResp.contains("4")) {
                            System.out.print("We recommend the vegetable tempura. Carefully deep fried, this appetizer has the most satisfying crunch with every bite.");
                        } else if (userResp.equals("q")) {
                            println("Exiting to main menu...");
                            main(greet);
                        } else {
                            println(getRandomResponse() + " Please type a number from 1 to 4 for a recommendation for the corresponding choice. If you would like to return to the main menu, please type q.");
                        }
                    }
                println(" Is there any other dish you would like to know about? If yes, type 'yes', and if not, type 'q' to return to the main menu. ");
                while (!userResp.contains("yes") && !userResp.contains("q")) {
                    userResp = in.nextLine().toLowerCase();
                    if (userResp.contains("yes")) {
                        help("help");
                        break;
                    }
                    else if (userResp.contains("q")) {
                        main(greet);
                        break;
                    }
                    println(getRandomResponse() + " Type 'q' to exit to the main menu, or 'yes' to ask about another dish.");
                }
                } 
            }

            else if (userResp.contains("description")) {
                int itemChecker = -1;
                println("Alright! What menu category would you like to know about? Ramen, barbeque, or appetizers? Type 'q' to return to the main menu, if you so wish.");
                while (!userResp.contains("ramen") && !userResp.contains("barbeque") && !userResp.contains("appetizer")) {
                    userResp = in.nextLine().toLowerCase();
                    if (userResp.contains("ramen") || userResp.contains("barbeque") || userResp.contains("bbq") || userResp.contains("barbecue") || userResp.contains("appetizer")) {
                        break;
                    }
                    if (userResp.equals("q")) {
                        main(greet);
                        break;
                    }
                    println(getRandomResponse() + "Type in one of our three menu categories: ramen, barbeque, or appetizer. If you would like to go back to the main menu, type 'q'");
                }
                if (userResp.equals("q")) {
                    main(greet);
                }
                else if (userResp.contains("ramen")) {
                    System.out.print("Sure! Which of the following ramen flavors are you interested in? ");
                    for (Ramen x : ramenTypes) {
                        System.out.print(x.getName() + ", ");
                    }
                    println("Or, type 'q' to head back to the main menu.");
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
                    println("Of course! Our " + ramenTypes[itemChecker].getName() + " ramen is a" + ramenTypes[itemChecker].getDescription() + " Is there any other dish you would like to know about? If yes, type 'yes', and if not, type 'q' to return to the main menu.");
                    while (!userResp.contains("yes") && !userResp.contains("q")) {
                        userResp = in.nextLine().toLowerCase();
                        if (userResp.contains("yes")) {
                            help("help");
                            break;
                        }
                        else if (userResp.contains("q")) {
                            main(greet);
                            break;
                        }
                        println(getRandomResponse() + " Type 'q' to exit to the main menu, or 'yes' to ask about another dish.");
                    }
                }
                else if (userResp.contains("barbeque") || userResp.contains("bbq") || userResp.contains("barbecue")) {
                    System.out.print("Sure! Which of the following barbeque flavors are you interested in? ");
                    for (BBQ x : bbqs) {
                        System.out.print(x.getName() + ", ");
                    }
                    println("Or type 'q' to head back to the main menu.");
                    while (itemChecker == -1) {
                        userResp = in.nextLine().toLowerCase();
                        checkForQuit(userResp);
                        for (int i=0;i<bbqs.length;i++) {
                            if (userResp.contains(bbqs[i].getName())) {
                                itemChecker = i;
                            }
                        }
                        if (itemChecker != -1) {
                            break;
                        }
                        System.out.print(getRandomResponse() + "Let me know if you are interested in any of the following dishes: ");
                        for (BBQ item : bbqs) { // display out method
                                System.out.print(item.getName() + ", ");
                        }
                        println("Or, type 'q' to go back to the main menu.");
                    }
                    println("Of course! Our " + bbqs[itemChecker].getName() + " ramen is a" + bbqs[itemChecker].getDescription() + "Is there any other dish you would like to know about? If yes, type 'yes', and if not, type 'q' to return to the main menu.");
                    while (!userResp.contains("yes") && !userResp.contains("q")) {
                        userResp = in.nextLine().toLowerCase();
                        if (userResp.contains("yes")) {
                            help("help");
                            break;
                        }
                        else if (userResp.contains("q")) {
                            main(greet);
                            break;
                        }
                        println(getRandomResponse() + " Type 'q' to exit to the main menu, or 'yes' to ask about another dish.");
                    }
                }
                else if (userResp.contains("appetizer")) {
                    System.out.print("Sure! Which of the following barbeque flavors are you interested in? ");
                    for (Appetizer x : appetizers) {
                        System.out.print(x.getName() + ", ");
                    }
                    println("Or, type 'q' to return to the main menu.");
                    while (itemChecker == -1) {
                        userResp = in.nextLine().toLowerCase();
                        checkForQuit(userResp);
                        for (int i=0;i<appetizers.length;i++) {
                            if (userResp.contains(appetizers[i].getName())) {
                                itemChecker = i;
                            }
                        }
                        if (itemChecker != -1) {
                            break;
                        }
                        System.out.print(getRandomResponse() + "Let me know if you are interested in any of the following dishes: ");
                        for (Appetizer item : appetizers) { // display out method
                                System.out.print(item.getName() + ", ");
                        }
                        println("Or, type 'q' to head back to the main menu.");
                    }
                    println("Of course! Our " + appetizers[itemChecker].getName() + " ramen is a" + appetizers[itemChecker].getDescription() + "Is there any other dish you would like to know about? If yes, type 'yes', and if not, type 'q' to return to the main menu.");
                    while (!userResp.contains("yes") && !userResp.contains("q")) {
                        userResp = in.nextLine().toLowerCase();
                        if (userResp.contains("yes")) {
                            help("help");
                            break;
                        }
                        else if (userResp.contains("q")) {
                            main(greet);
                            break;
                        }
                        println(getRandomResponse() + " Type 'q' to exit to the main menu, or 'yes' to ask about another dish.");
                    }
                }
            }
        }
    }

    public static void println(String message) {
        int delay = 20; // Delay in milliseconds

        for (char ch : message.toCharArray()) {
            System.out.print(ch);  // Print each character
            try {
                Thread.sleep(delay); // Delay for specified milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(); // Move to the next line after the message is printed
    }
}