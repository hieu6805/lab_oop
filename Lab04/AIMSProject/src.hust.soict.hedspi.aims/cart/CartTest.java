public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f);

        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);

        cart.printCart();

        cart.searchByTitle("Star");
        cart.searchByTitle("Harry Potter");

        DigitalVideoDisc foundDisc = cart.searchById(dvd1.getId());
        if (foundDisc != null) {
            System.out.println("Found DVD by ID: " + foundDisc.getTitle());
        } else {
            System.out.println("No DVD found with that ID.");
        }
    }
}
