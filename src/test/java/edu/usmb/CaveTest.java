package edu.usmb;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CaveTest {

    @Test
    void testTakeExistingBoisson() {
        Cave cave = new Cave();
        Boisson vin = new Boisson("Vin", 12.5f);
        cave.add(vin);

        Boisson taken = cave.take("Vin");

        assertNotNull(taken, "La boisson doit être trouvée et retirée.");
        assertEquals("Vin", taken.getNom(), "Le nom de la boisson récupérée doit être 'Vin'.");
        assertTrue(cave.toString().contains("Cave :\n"), "La cave ne doit plus contenir 'Vin'.");
    }

    @Test
    void testTakeNonExistingBoisson() {
        Cave cave = new Cave();
        Boisson taken = cave.take("Bière");

        assertNull(taken, "Si la boisson n'existe pas, la méthode doit retourner null.");
    }

    @Test
    void testTakeFromEmptyCave() {
        Cave cave = new Cave();
        Boisson taken = cave.take("Whisky");

        assertNull(taken, "Une cave vide ne doit pas permettre de récupérer une boisson.");
    }

    @Test
    void testTakeNullOrEmptyName() {
        Cave cave = new Cave();
        cave.add(new Boisson("Coca", 0.0f));

        assertNull(cave.take(null), "Un nom null doit retourner null.");
        assertNull(cave.take(""), "Un nom vide doit retourner null.");
    }

    @Test
    void testBoissonRemovedAfterTake() {
        Cave cave = new Cave();
        cave.add(new Boisson("Jus d'orange", 0.0f));

        Boisson taken = cave.take("Jus d'orange");
        assertNotNull(taken, "La boisson doit être trouvée et retirée.");
        assertNull(cave.take("Jus d'orange"), "Après avoir été prise, la boisson ne doit plus être disponible.");
    }
}
