public class BBQ extends Food {
    public BBQ(String name, double price) {
        super(name, price);
    }
    public BBQ(String name, String altName, String altName2, double price) {
        super(name, altName, altName2, price);
    }
    public BBQ(String name, double price, int spiceLevel, String toppings) {
        super(name, price, spiceLevel, toppings);
    }
}
