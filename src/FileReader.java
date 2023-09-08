import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) {
        try {
            File test = new File("Sample.txt");
            Scanner Read=new Scanner(test);
            int words=0,letters=0;
            do
            {
                String text=Read.nextLine();
                String[] word=text.split(" ");
                if(word[word.length-1]!="") {
                    words += word.length;
                }
                int i = 0;
                while( i<text.length())
                {
                    if((text.charAt(i)!='\0')&&(text.charAt(i)!=' '))
                    {
                        letters++;
                    }
                    i++;
                }

            }while(Read.hasNextLine());
            System.out.println(letters+" "+words);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
