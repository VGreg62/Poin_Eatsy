package Utils;

public class Comparator {

    private Comparator() {
        // never called
    }

    public static boolean isInt(String str) {
        boolean check = false;
        if (str != null) {
            try {
                Integer.parseInt(str);
                check = true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                check = false;
            }
        }
        return check;
    }

    public static boolean isDouble(String str) {
        boolean check = false;
        if (str != null) {
            try {
                Double.parseDouble(str);
                check = true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                check = false;
            }
        }
        return check;
    }
}
