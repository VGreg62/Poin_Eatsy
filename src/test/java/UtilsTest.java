import Utils.Calculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UtilsTest {

    @Test
    void sommeCommande() {
        ArrayList<Double> commande = new ArrayList<>(Arrays.asList(20.0, 30.5, 15.9, 21.6));

        assertEquals(88.0, Calculator.sommeCommande(commande));
    }

    @Test
    void sommeCommandeFail() {
        ArrayList<Double> commande = new ArrayList<>(Arrays.asList(20.0, 30.5, 15.9, 21.6));

        assertNotEquals(86.0, Calculator.sommeCommande(commande));
    }
}
