package org.java3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EcommerceSystemTest {
    private Cart cart;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        product1 = new Product(1, "Product 1", 10.0);
        product2 = new Product(2, "Product 2", 20.0);
    }

    @Test
    void testAddProductToCart() {
        cart.addProduct(product1);
        assertEquals(1, cart.getProducts().size());
    }

    @Test
    void testRemoveProductFromCart() {
        cart.addProduct(product1);
        cart.removeProduct(product1);
        assertEquals(0, cart.getProducts().size());
    }

    @Test
    void testPlaceOrder() {
        cart.addProduct(product1);
        cart.addProduct(product2);
        Order order = new Order(1, cart.getProducts());
        assertEquals("Pending", order.getStatus());
        order.setStatus("Shipped");
        assertEquals("Shipped", order.getStatus());
    }
}

