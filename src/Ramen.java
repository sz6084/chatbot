public class Ramen extends Food { // inheritance?
    public Ramen(String name, double price, String description) {
        super(name, price, description);
    }
    public Ramen(String name, String altName, String altName2, double price) {
        super(name, altName, altName2, price);
    }
    public Ramen(String name, double price, int spiceLevel, String toppings) {
        super(name, price, spiceLevel, toppings);
    } // may add more specific things
    /*
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getSpiceLevel() {
        return spiceLevel;
    }
    public String toppings() {
        return toppings;
    }
    /*public void setName(String n) {
        name = n;
    }
    public void setPrice(int p) {
        price = p;
    }
    public void setSpiceLevel(int s) {
        spiceLevel = s;
    }
    public void setToppings(String t) {
        toppings = t;
    }
    public String toString() {
        return name+price;
    }*/
}