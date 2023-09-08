import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class CopyPasteLambda {
    static Path file= Paths.get("WeatherApi.txt");
    static Path output=Paths.get("output.txt");
    public static void main(String[] args) throws IOException {
        read();
    }
    public static void read(){

        try(Stream<String>lines= Files.lines(file)
                .onClose(()-> System.out.println("File read over"))) {
            lines.forEach(s -> {
                try {
                    Files.writeString(output,s+"\n", StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void clear() throws IOException {
        Files.delete(output);
    }

}
