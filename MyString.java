import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class MyString {
    public static void main(String[] args) {

    }

    public static String reversAndUpperCase(String str) {
        StringBuilder reversedString = new StringBuilder(str).reverse();
        return reversedString.toString().toUpperCase();
    }

    public static int showHowManyVocals(String str) {
        int vocals = 0;
        String stringInLowerCases = str.toLowerCase();
        for (int i = 0; i < stringInLowerCases.length(); i++) {
            if (stringInLowerCases.charAt(i) == 'a' || stringInLowerCases.charAt(i) == 'e' ||
                    stringInLowerCases.charAt(i) == 'i' || stringInLowerCases.charAt(i) == 'o' ||
                    stringInLowerCases.charAt(i) == 'u')
                vocals++;
        }
        return vocals;
    }
    public static String returnTheLongestWord(String str) {
        String longest = Arrays.stream(str.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
        return longest;
    }
    public static int howManyTimesIsInString(String str, String str2){
        int howManyTimes = 0;
        for (int i = 0; i <= str.length() - str2.length(); i++) {
            String substring = str.substring(i, i + str2.length());
            if (substring.equals(str2)) {
                howManyTimes = howManyTimes + 1;
            }
        }
        return howManyTimes;
    }
    public static int howManyWords(String str){
        String[] array = str.split(" ");
        return array.length;
    }
    public static String introducePhoneNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de teléfono: ");
        return scanner.nextLine();
    }
    public static String formatPhoneNumber(String number){
        String cleanNumber = number.replaceAll("[^0-9]", "");
        if (cleanNumber.length() != 11) {
            throw new IllegalArgumentException("ERROR: El número de teléfono no tiene la longitud correcta.");
        }
        String countryCode = cleanNumber.substring(0, 2);
        String areaCode = cleanNumber.substring(2, 5);
        String theRest = cleanNumber.substring(5);

        return String.format("(+%s)-%s-%s", countryCode, areaCode, theRest);
    }
    public static void vocalsCounters(String str){
        int as = 0;
        int es = 0;
        int is = 0;
        int os = 0;
        int us = 0;
        String stringInLowerCases = str.toLowerCase();
        for (int i = 0; i < stringInLowerCases.length(); i++) {
            if (stringInLowerCases.charAt(i) == 'a'){
                as++;
            } else if (stringInLowerCases.charAt(i) == 'e'){
                es++;
            } else if (stringInLowerCases.charAt(i) == 'i'){
                is++;
            } else if (stringInLowerCases.charAt(i) == 'o'){
                os++;
            } else if (stringInLowerCases.charAt(i) == 'u'){
                us++;
            }
        }
        String[] aAsterisks = new String[as];
        String[] eAsterisks = new String[es];
        String[] iAsterisks = new String[is];
        String[] oAsterisks = new String[os];
        String[] uAsterisks = new String[us];

        for (int j =0; j < as; j++){
            aAsterisks[j] = "*";
        }
        for (int j =0; j < es; j++){
            eAsterisks[j] = "*";
        }
        for (int j =0; j < is; j++){
            iAsterisks[j] = "*";
        }
        for (int j =0; j < os; j++){
            oAsterisks[j] = "*";
        }
        for (int j =0; j < us; j++){
            uAsterisks[j] = "*";
        }
        String aJoined = String.join("",aAsterisks);
        String eJoined = String.join("",eAsterisks);
        String iJoined = String.join("",iAsterisks);
        String oJoined = String.join("",oAsterisks);
        String uJoined = String.join("",uAsterisks);

        System.out.println("Hola a todos");
        System.out.println("a = " + as + aJoined);
        System.out.println("e = " + es + eJoined);
        System.out.println("i = " + is + iJoined);
        System.out.println("o = " + os + oJoined);
        System.out.println("u = " + us + uJoined);
    }


}