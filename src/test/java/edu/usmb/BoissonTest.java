package edu.usmb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class BoissonTest {

    @Test
     void testBoissonNonAlcoolisee() {
        Boisson boisson = new Boisson("Eau");
        assertEquals("Eau", boisson.nom);
        assertFalse(boisson.alcoolise);
        assertNull(boisson.degre);
        assertNull(boisson.volume);
        assertNull(boisson.prix);
        assertEquals("Eau", boisson.toString());
    }

    @Test
     void testBoissonAlcoolisee() {
        Boisson boisson = new Boisson("Vin", 12.5f);
        assertEquals("Vin", boisson.nom);
        assertTrue(boisson.alcoolise);
        assertEquals(Float.valueOf(12.5f), boisson.degre);
        assertNull(boisson.volume);
        assertNull(boisson.prix);
        assertEquals("Vin (l'abus d'alcool est dangereux pour la sante)", boisson.toString());
    }


    @Test
     void testBoissonNonAlcooliseeAvecDegre() {
        Boisson boisson = new Boisson("Jus de fruit", 0.0f);
        assertEquals("Jus de fruit", boisson.nom);
        assertFalse(boisson.alcoolise);
        assertEquals(Float.valueOf(0.0f), boisson.degre);
        assertNull(boisson.volume);
        assertNull(boisson.prix);
        assertEquals("Jus de fruit", boisson.toString());
    }
}