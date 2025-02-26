package edu.usmb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class BoissonTest {

    @Test
     void testBoissonNonAlcoolisee() {
        Boisson boisson = new Boisson("Eau");
        assertEquals("Eau", boisson.getNom());
        assertFalse(boisson.getAlcoolise());
        assertNull(boisson.getDegre());
        assertNull(boisson.getVolume());
        assertNull(boisson.getPrix());
        assertEquals("Eau", boisson.toString());
    }

    @Test
     void testBoissonAlcoolisee() {
        Boisson boisson = new Boisson("Vin", 12.5f);
        assertEquals("Vin", boisson.getNom());
        assertTrue(boisson.getAlcoolise());
        assertEquals(Float.valueOf(12.5f), boisson.getDegre());
        assertNull(boisson.getVolume());
        assertNull(boisson.getPrix());
        assertEquals("Vin (l'abus d'alcool est dangereux pour la sante)", boisson.toString());
    }


    @Test
     void testBoissonNonAlcooliseeAvecDegre() {
        Boisson boisson = new Boisson("Jus de fruit", 0.0f);
        assertEquals("Jus de fruit", boisson.getNom());
        assertFalse(boisson.getAlcoolise());
        assertEquals(Float.valueOf(0.0f), boisson.getDegre());
        assertNull(boisson.getVolume());
        assertNull(boisson.getPrix());
        assertEquals("Jus de fruit", boisson.toString());
    }
}