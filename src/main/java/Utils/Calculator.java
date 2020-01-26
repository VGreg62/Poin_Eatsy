package Utils;

import java.util.ArrayList;

public class Calculator {

    private Calculator() {
        // never called
    }

    public static double sommeCommande(ArrayList<Double> produits) {
        double calcul = 0;
        for (double somme : produits) {
            calcul += somme;
        }
        return calcul;
    }

}
