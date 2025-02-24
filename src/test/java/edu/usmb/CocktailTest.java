package edu.usmb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CocktailTest {

    @Test
     void testCocktailCreation() {
        Cocktail cocktail = new Cocktail("Mojito",true);
        assertEquals("Mojito", cocktail.getNom());
        assertFalse(cocktail.alcoolise);
    }


    @Test
     void testAlcoolFree() {
        Cocktail cocktail = new Cocktail("Virgin Mojito",false);
        assertTrue(cocktail.alcoolFree());

        cocktail.alcoolise = true;
        assertFalse(cocktail.alcoolFree());
    }

    @Test
     void testToString() {
        Cocktail cocktail = new Cocktail("Mojito",true);
        cocktail.add("Rhum", 50.0,true);
        cocktail.add("Menthe", 20.0,false);
        cocktail.add("Citron", 10.0,false);
        cocktail.add("Eau gazeuse", 20.0,true);

        String expected = "Rhum 50.0%\tMenthe 20.0%\tCitron 10.0%\tEau gazeuse 20.0%\t";
        assertEquals(expected, cocktail.toString());
    }

    @Test
     void testToStringEmptyCocktail() {
        Cocktail cocktail = new Cocktail("Empty Cocktail",true);
        assertEquals("", cocktail.toString());
    }

    @Test
     void testAddNullIngredient() {
        Cocktail cocktail = new Cocktail("Mojito",true);
        assertThrows(NullPointerException.class, () -> {
            cocktail.add(null, 50.0,true);
        });
    }

    @Test
    void testAddIngredientAlcoolisee() {
        Cocktail cocktail = new Cocktail("Mojito",true);
        cocktail.add("Rhum", 100.0,true);
        assertFalse(cocktail.alcoolFree());
    }
}