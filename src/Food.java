public class Food {
    private String name;
    private String altName;
    private String altName2;
    private double price; // in USD
    private int spiceLevel; // extra prices?
    private String toppings; // extra prices?
    private String description;

    public Food(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public Food(String name, String altName, String altName2, double price) {
        this.name = name;
        this.altName = altName;
        this.altName2 = altName2;
        this.price = price;
    }
    public Food(String name, double price, int spiceLevel, String toppings) {
        this.name = name;
        this.price = price;
        this.spiceLevel = spiceLevel;
        this.toppings = toppings;
    }

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
    }*/
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
        return name+" "+price;
    }
}
