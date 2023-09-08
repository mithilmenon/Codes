import java.util.Arrays;

public class WordSplitter {
    static int charCount=0;
    public static int wordCounter(String s) {
        Arrays.asList(s.split("\\s+"))
                .stream()
                .parallel()
                .map(word -> 1)
                .sum(); // terminal operation for count



        String word[]=s.split(" ");

        int wordCount=0;
        if(word[word.length-1]!="") {
            wordCount = word.length;
        }
        charCount+=wordSplitter(word);
        return wordCount;
    }
    public static int wordSplitter(String[] words)
    {   int characterCount=0;
        for (String word : words) {
            characterCount += CharacterCounter.characterCounter(word);
        }
        return characterCount;
    }
}
