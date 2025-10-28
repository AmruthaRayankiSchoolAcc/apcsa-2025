package piglatin;
import java.util.Scanner;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.
        String testTitle = translate(input.getTitle());
        translatedBook.setTitle(testTitle);
        for (int i = 0; i < input.getLineCount(); i++) {
            translatedBook.appendLine(translate(input.getLine(i)));
        }
        return translatedBook;
    }

    public static String translate(String input) {
        //System.out.println("  -> translate('" + input + "')");
        String result = "";
        Scanner sc1 = new Scanner(input);

        // TODO: translate a string input, store in result.
        // This method must call translateWord once for each word in the string.
        while (sc1.hasNext()) {
            String word = sc1.next();
            result += translateWord(word);
            if (sc1.hasNext()) {
                result += " ";
            }
        }
        sc1.close();
        return result;
    }

    private static String translateWord(String input) {
        //System.out.println("  -> translateWord('" + input + "')");

        int endIndex = 0;
        String vowels = "aeiouyAEIOUY";
        String tail = "";
        char period = '.';
        String newInput = input;

        if (input.length() == 0 || input.charAt(0) == ' ') {
            return "";
        }
        if (newInput.charAt(newInput.length() - 1) == period) {
            tail = ".";
            //then remove the last period
            newInput = newInput.substring(0,newInput.length()-1);
        }
        if (vowels.indexOf(input.substring(0,1)) != -1) {
            return input + "ay";
        }
        else {
            for (int i = 0; i < newInput.length(); i++) {
                if (vowels.indexOf(newInput.charAt(i)) == -1) {
                    endIndex++;
                } else {
                    break;
                }
            }
            String startVowelString = "";
            if (isCapital(newInput.substring(0,1))) {
                        String nonVowelString = lowercase(newInput.substring(0,1)) + newInput.substring(1, endIndex);
                        if (endIndex < newInput.length()) {
                            startVowelString = capitilize(newInput.substring(endIndex,endIndex+1)) + newInput.substring(endIndex+1);
                        } else {
                            startVowelString = "";
                        }
                        return startVowelString + nonVowelString + "ay" + tail;
            } else {
                return newInput.substring(endIndex, newInput.length()) + newInput.substring(0, endIndex) + "ay" + tail;
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
