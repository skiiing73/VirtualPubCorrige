package edu.usmb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PubTest {

    @Test
    void testApprovisionnerBar() {
        Pub pub = new Pub();
        Boisson coca = new Boisson("Coca");
        pub.getCave().add(coca);
        pub.approvisionnerBar("Coca");
        assertEquals(coca,pub.getBar().serv("Coca"));
    }

}