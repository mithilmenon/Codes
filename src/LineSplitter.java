import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class LineSplitter implements Runnable{

    AtomicInteger wordCount= new AtomicInteger();
    public static void main(String[] args) {

    }

    private void addWordCount(String s) {
        wordCount.addAndGet(WordSplitter.wordCounter(s));
    }

    @Override
    public void run() {
        Path input= Paths.get("Sample.txt");


        try(Stream<String>line= Files.lines(input)) {
            line
                    .parallel()
                    .forEach(this::addWordCount);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(wordCount);
        int charCount = WordSplitter.charCount;
        System.out.println(charCount);
    }
}
