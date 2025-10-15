package piglatin;

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

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        result = translateWord(input);

        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");


        // TODO: Replace this code to correctly translate a single word.
        // Start here first!
        // This is the first place to work.
        boolean startWithe = input.substring(0,1).equals("e");
        boolean startWithE = input.substring(0,1).equals("E");
        boolean startWitha = input.substring(0,1).equals("a");
        boolean startWithA = input.substring(0,1).equals("A");
        boolean startWithi = input.substring(0,1).equals("i");
        boolean startWithI = input.substring(0,1).equals("I");
        boolean startWitho = input.substring(0,1).equals("o");
        boolean startWithO = input.substring(0,1).equals("O");
        boolean startWithu = input.substring(0,1).equals("u");
        boolean startWithU = input.substring(0,1).equals("U");

        //private boolean isVowel(c) {

        //}
        if (startWitha == true || startWithA == true || startWithe == true || startWithE == true || startWithi == true || startWithI == true || startWitho == true || startWithO == true || startWithu == true || startWithU == true) {
            return input + "ay";
        }
        else {
            for (int i = 0; i < input.length(); i++) {
                input.charAt(i) 
            }
        }
        
        String result = input;
        return result;
    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
