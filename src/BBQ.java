public class BBQ extends Food {
    public BBQ(String name, double price, String description) {
        super(name, price, description);
    }
    public BBQ(String name, String altName, String altName2, double price) {
        super(name, altName, altName2, price);
    }
    public BBQ(String name, double price, int spiceLevel, String toppings) {
        super(name, price, spiceLevel, toppings);
    }
}
