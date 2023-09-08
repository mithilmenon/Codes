public class CharacterCounter {
    public static int characterCounter(String word){
        int character=0;
        int i = 0;
        while( i<word.length())
        {
            if((word.charAt(i)!='\0')&&(word.charAt(i)!=' '))
            {
                character++;
            }
            i++;
        }
    return character;
    }
}
