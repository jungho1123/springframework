package mylab.order.di.xml;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class OrderSpringTest {
    BeanFactory beanFactory;

    @BeforeEach
    void container() {
        beanFactory = new GenericXmlApplicationContext("classpath:mylab-order-di.xml");

    }

    @Test
    void OrderSpringTest() {
        ShoppingCart cart = beanFactory.getBean("shoppingCart", ShoppingCart.class);
        OrderService orderService = beanFactory.getBean("orderService", OrderService.class);

        assertNotNull(cart);
        assertEquals(2, cart.getProducts().size());
        assertEquals("노트북", cart.getProducts().get(0).getName());
        assertEquals("스마트폰", cart.getProducts().get(1).getName());

        assertNotNull(orderService);
        assertNotNull(orderService.getShoppingCart());
        assertEquals(950000, orderService.calculateOrderTotal());
    }
}
