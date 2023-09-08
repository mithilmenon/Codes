import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWeatherApi {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileWriter input=new FileWriter("WeatherApi.txt",true);
        input.write(WeatherApi.run()+"\n");
        input.close();
    }


}
