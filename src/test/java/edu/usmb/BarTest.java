package edu.usmb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BarTest {
    @Test
    void testServiceBoissonNonDispo() {
        Bar bar = new Bar();
        assertNull(bar.serv("biere"));
    }

    @Test
    void testCategoryBoissonAdd() {
        Bar bar = new Bar();
        Boisson vin = new Boisson("vin",18.0f);
        bar.add(vin);
        assertNotNull(bar.getBoissonAlcoolisee());
    }


    @Test
    public void testToString() {
        Bar bar = new Bar();
        bar.getBoissonFroide().add(new Boisson("Coca"));
        bar.getBoissonAlcoolisee().add(new Boisson("Bière", 5.0f));
        bar.getCocktailSansAlcool().add(new Cocktail("Virgin Mojito",false));
        bar.getCocktailAvecAlcool().add(new Cocktail("Margarita",true));
        bar.getBoissonChaude().add(new Boisson("Café"));

        String result = bar.toString();
        assertTrue(result.contains("Coca"));
        assertTrue(result.contains("Bière"));
        assertTrue(result.contains("Virgin Mojito"));
        assertTrue(result.contains("Margarita"));
        assertTrue(result.contains("Café"));
    }
}