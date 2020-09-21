import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.conn.MySQLConnection;
import com.dao.impl.AddressDAO;
import com.dao.impl.EWalletDAO;
import com.dao.impl.InvoiceDAO;
import com.dao.impl.OrderCartDAO;
import com.dao.impl.PaymentDAO;
import com.dao.impl.ProductDAO;
import com.dao.impl.ShipmentDAO;
import com.dao.impl.UserDAO;
import com.entity.Address;
import com.entity.EWallet;
import com.entity.Invoice;
import com.entity.OrderCart;
import com.entity.Payment;
import com.entity.Product;
import com.entity.Shipment;
import com.entity.User;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        MySQLConnection.init();
        // testProduct();
        // testUser();
        // testAddress();
        // testEWallet();
        // testPayment();
        // testShipment();
        // testCart();
        // testInvoice();

        System.out.println("Program ended.");
    }

    static void testCart() {
        OrderCartDAO cartdao = new OrderCartDAO();
        UserDAO userdao = new UserDAO();

        OrderCart c = new OrderCart();

        System.out.println("Creating cart ...");
        c.setCheckoutDate(new Date());
        c.setUser(userdao.find(4));
        cartdao.create(c);

        System.out.println("Getting cart ...");
        for (OrderCart cart : cartdao.getAll()) {
            System.out.println(cart.getCheckoutDate().toString());
        }

        System.out.println("Updating cart ...");
        c = cartdao.getAll().get(0);
        c.setCheckoutDate(new Date());
        cartdao.update(c.getCartID(), c);

        System.out.println("Removing cart ...");
        // cartdao.destroy(c.getCartID());
    }

    static void testInvoice() {
        InvoiceDAO invoicedao = new InvoiceDAO();
        AddressDAO addressdao = new AddressDAO();
        PaymentDAO paymentdao = new PaymentDAO();
        ShipmentDAO shipmentdao = new ShipmentDAO();
        OrderCartDAO cartdao = new OrderCartDAO();

        Invoice i = new Invoice();

        System.out.println("Creating invoice ...");
        i.setTransactionNo("15FDR182C");
        i.setStatus("Waiting for payment");
        i.setAddress(addressdao.find(2));
        i.setPayment(paymentdao.find(2));
        i.setShipment(shipmentdao.find(2));
        i.setCart(cartdao.find(2));
        invoicedao.create(i);

        System.out.println("Getting invoice ...");
        for (Invoice invoice : invoicedao.getAll()) {
            System.out.println(invoice.getStatus());
        }

        System.out.println("Updating invoice ...");
        i = invoicedao.getAll().get(0);
        i.setStatus("On shipment");
        invoicedao.update(i.getInvoiceID(), i);

        System.out.println("Removing invoice ...");
        // invoicedao.destroy(i.getInvoiceID());
    }

    static void testShipment() {
        ShipmentDAO shipmentdao = new ShipmentDAO();

        Shipment p = new Shipment();

        System.out.println("Creating shipment ...");
        p.setName("JNE");
        p.setService("Reguler");
        shipmentdao.create(p);

        System.out.println("Getting shipment ...");
        for (Shipment shipment : shipmentdao.getAll()) {
            System.out.println(shipment.getName());
        }

        System.out.println("Updating shipment ...");
        p = shipmentdao.getAll().get(0);
        p.setService("YES");
        shipmentdao.update(p.getShipmentID(), p);

        System.out.println("Removing shipment ...");
        // shipmentdao.destroy(p.getShipmentID());
    }

    static void testPayment() {
        PaymentDAO paymentdao = new PaymentDAO();

        Payment p = new Payment();

        System.out.println("Creating payment ...");
        p.setName("OVO");
        p.setType("emoney");
        paymentdao.create(p);

        System.out.println("Getting payment ...");
        for (Payment payment : paymentdao.getAll()) {
            System.out.println(payment.getName());
        }

        System.out.println("Updating payment ...");
        p = paymentdao.getAll().get(0);
        p.setName("Gopay");
        paymentdao.update(p.getPaymentID(), p);

        System.out.println("Removing payment ...");
        // paymentdao.destroy(p.getPaymentID());
    }

    static void testEWallet() {
        EWalletDAO ewalletdao = new EWalletDAO();
        UserDAO userdao = new UserDAO();

        EWallet e = new EWallet();

        System.out.println("Creating address ...");
        e.setBalance(10000);
        e.setPin(123456);
        e.setUser(userdao.find(4));
        ewalletdao.create(e);

        System.out.println("Getting address ...");
        for (EWallet ewallet : ewalletdao.getAll()) {
            System.out.println(ewallet.getBalance());
        }

        System.out.println("Updating address ...");
        e = ewalletdao.getAll().get(0);
        e.setBalance(500000);
        ewalletdao.update(e.getEwalletID(), e);

        System.out.println("Removing address ...");
        // ewalletdao.destroy(e.getEwalletID());
    }

    static void testAddress() {
        AddressDAO addressdao = new AddressDAO();
        UserDAO userdao = new UserDAO();

        Address a = new Address();

        System.out.println("Creating address ...");
        a.setProvince("Jawa Barat");
        a.setCity("Bandung");
        a.setDetails("Somewhere in Bandung");
        a.setLatitude(1.00);
        a.setLongitude(-1.00);
        a.setUser(userdao.find(4));
        addressdao.create(a);

        System.out.println("Getting address ...");
        for (Address address : addressdao.getAll()) {
            System.out.println(address.getCity());
        }

        System.out.println("Updating address ...");
        a = addressdao.getAll().get(0);
        a.setCity("Sukabumi");
        addressdao.update(a.getAddressID(), a);

        System.out.println("Removing address ...");
        // addressdao.destroy(a.getAddressID());
    }

    static void testUser() {
        List<User> users = new ArrayList<>();
        UserDAO userdao = new UserDAO();

        System.out.println("Creating user ...");
        User u = new User();
        u.setEmail("ragnarok@gmail.com");
        u.setPassword("12345678");
        u.setFullname("Odin Sedunia");
        u.setDob(new Date());
        u.setGender(1);
        u.setPhoneNumber("087268492012");
        u.setPhotoUrl("default.jpg");
        u.setDateJoined(new Date());
        userdao.create(u);

        System.out.println("Getting users ...");
        users = userdao.getAll();
        for (User user : users) {
            System.out.println(user.getFullname());
        }

        System.out.println("Updating user ...");
        u = users.get(0);
        u.setFullname("Odin Ragnarok");
        u.setPhoneNumber("16625378829");
        // userdao.update(u.getUserID(), u);

        System.out.println("Deleting user ...");
        // userdao.destroy(u.getUserID());
    }

    static void testProduct() {
        List<Product> products = new ArrayList<>();
        ProductDAO productdao = new ProductDAO();

        System.out.println("Creating product ...");
        Product p = new Product();
        p.setName("iPhone X");
        p.setBrand("Apple");
        p.setDescription("New iPhone X 128GB");
        p.setColor("Black");
        p.setWeight(1.90);
        p.setCondition(0);
        p.setImgUrl("default.jpg");
        p.setStock(10);
        p.setPrice(22000000);
        p.setDateCreated(new Date());
        productdao.create(p);

        System.out.println("Getting product ...");
        products = productdao.getAll();
        for (Product product : products) {
            System.out.println(product.getName());
        }

        System.out.println("Updating product ...");
        p = products.get(0);
        p.setColor("Silver");
        p.setPrice(21500000);
        productdao.update(p.getProductID(), p);
    }
}
