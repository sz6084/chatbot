import java.util.Scanner;
public class Main
{
        static String[] greet = {"Hello! Welcome to Ramen101!", "Salutations good customer! Welcome to Ramen101"};
    //CREATE INSTANCE VARIABLES HERE. Ensure they are static.
    static String[] goodBye = {"bye", "see you later!", "good doing business with you"};
    static String[] keywords = {"ramen", "bbq", "barbecue", "appetizers"};
    static String[] ramenTypes = {"tonkotsu", "miso", "seafood", "black garlic", "chicken", "veggie", "veggy", "vegetable"};
    static String[] bbqs = {"chicken katsu", "teriyaki chicken", "hawaiian bbq chicken", "hawaiian bbq beef", "hawaiian bbq short rib", "bbq chicken and beef", "bbq chicken and chicken katsu", "hawaiian bbq trio"};
    static String[] appetizers = {"chicken kara-age", "grill whole squid", "gyoza", "agedashi tofu", "takoyaki", "prawn tempura", "vegetable tempura", "kaki fry", "geso fry", "spam musubi", "lumpia", "crab rangoons", "edamame", "spicy cucumber salad", "white rice"};
    // bbq parsing
    // parse input by lowering case
   
       public static void main(String[] args)
       {
        Scanner in = new Scanner (System.in);//Creates scanner object.
        //Scanner in2 = new Scanner (System.in);//Creates a second scanner object.
        System.out.println(greet[(int)(Math.random() * 2)]);
        String userResp = in.nextLine().toLowerCase(); //in.nextLine() uses the scanner object to get the user's responnse as a String
        // System.out.println(userResp);
        int food = firstMenuCheck(userResp);
        if(food==-1) {
                getRandomResponse();
        } else {
                System.out.print("Sure! We offer a variety of " +keywords[food]+ ", including our top choices: ");
                if(keywords[food].equals("ramen")) {
                        for (String item:ramenTypes) { // display out method
                                System.out.print(item+", ");
                        }
                } else if (keywords[food].equals("bbq")) {
                        for (String item:bbqs) {
                                System.out.print(item+", ");
                        }
                } else if (keywords[food].equals("appetizers")) {
                        for (String item:ramenTypes) {
                                System.out.print(item+", ");
                        }
                }
                // options to q to prev menu or 
                System.out.println("Would you like to order one of these? If not, type 'q' to quit out of this chat.");
                userResp = in.nextLine().toLowerCase();
                // restart by calling main if invalid input?
        }
        in.close();
            System.out.println(goodBye[(int)(Math.random() * 3)]);

        //You will need to make sure your chatbot continues looping until it sees certain keywords from the user such as "bye","goodbye"...
        // do you need a while loop or a for loop?
          
        //Consider: How do I check what the user says and compare it to my keywords? What methods do I have?
             
       }

       //Create other methods that might be helpful down here. 
       //For example a method called checkWord where the user traverses through an array to check if a word matches.
       
       //One method you might need is getRandomResponse()
       public static String getRandomResponse(){
            return "";
       }
       // It'll generate a random response when the chatbot doesn't understand what to say

       //Here is an example of a method you might use.
         public static String getResponse(String statement)
         {
                 String response = "";
                 if (statement.indexOf("no") >= 0)
                 {
                         response = "Why so negative?";
                 }
                 else if (statement.indexOf("mother") >= 0
                                 || statement.indexOf("father") >= 0
                                 || statement.indexOf("sister") >= 0
                                 || statement.indexOf("brother") >= 0)
                 {
                         response = "Tell me more about your family.";
                 }
                 else
                 {
                         //respoonse = getRandomResponse() <--- yo uwill need to create this methodd.
                 }
                 return response;
         }
         public static int firstMenuCheck(String in){
                int menuCounter = -1;
                for (int i = 0; i < keywords.length; i++) {
                        if (in.contains(keywords[i])) {
                                menuCounter = i;
                        }
                }
                return menuCounter;
        }

}