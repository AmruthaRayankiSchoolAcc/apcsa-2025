package piglatin;
import java.util.Scanner;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.
        

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");
        String result = "";
        int wordCount = 0;
        Scanner sc1 = new Scanner(input);

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        while (sc1.hasNext()) {
            String word = sc1.next();
            wordCount++;
            result += translateWord(word);
        }
        sc1.close();
        //result = translateWord(input);

        return result;
    }

    private static String translateWord(String input) {
        int endIndex = 1;
        String vowels = "aeiouyAEIOUY";
        String tail = "";
        char period = '.';
        char space = ' ';
        int periodIndex = 0;

        System.out.println("  -> translateWord('" + input + "')");

        // TODO: Replace this code to correctly translate a single word
        // This is the first place to work.
        if (vowels.indexOf(input.substring(0,1)) != -1) {
            return input + "ay" + tail;
        }
        else {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == period) {
                        tail = input.substring(i);
                        periodIndex = input.indexOf(i);
                        break;
                }
            }
            String newInput = input.replace(input.charAt(periodIndex), space);
            for (int i = 1; i < newInput.length(); i++) {
                if (vowels.indexOf(newInput.charAt(i)) == -1) {
                    endIndex++;
                } else {
                    break;
                }
            }
            if (isCapital(input.substring(0,1))) {
                        String nonVowelString = lowercase(input.substring(0,1)) + input.substring(1, endIndex);
                        String startVowelString = capitilize(input.substring(endIndex,endIndex+1)) + input.substring(endIndex+1, input.length());
                        return startVowelString + nonVowelString + "ay" + tail;
            } else {
                return input.substring(endIndex, input.length()) + input.substring(0, endIndex) + "ay" + tail;
            }
            //result = startVowelString + nonVowelString + "ay";
            //result = input.substring(endIndex, input.length()) + input.substring(0, endIndex) + "ay";
    }
}

    // Add additonal private methods here.
    // For example, I had one like this:
    private static boolean isCapital(String input) {
        if (input.length() == 0) {
            return false;
        } else if (input.substring(0,1).toUpperCase().equals(input.substring(0,1))) {
            return true;
        } else {
            return false;
        }
    }
    private static String capitilize(String input) {
        if (input.length() != 0) {
            return input.substring(0,1).toUpperCase();
        }
        return input;
    }
    private static String lowercase(String input) {
        if (input.length() != 0) {
            return input.substring(0,1).toLowerCase();
        }
        return input;
    }


}
