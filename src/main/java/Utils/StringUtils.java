package Utils;

public class StringUtils {

    private StringUtils(){
        //never called
    }

    public static String intToString(int number){
        return String.valueOf(number);
    }

    public static String doubleToString(double number){
        return String.valueOf(number);
    }

    public static int stringToInt(String number){
        return Comparator.isInt(number) ? Integer.parseInt(number) : 0;
    }

    public static double stringToDouble(String number){
        return Comparator.isDouble(number) ? Integer.parseInt(number) : 0;
    }

}
