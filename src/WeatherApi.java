import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherApi{

    static void numberOfApiCalls(int n) throws IOException, InterruptedException {
        for(int i=0; i<n; i++) {
            run();
            System.out.println("calling");
        }
    }

    static String run() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://weatherapi-com.p.rapidapi.com/current.json?q=53.1%2C-0.13"))
                .header("X-RapidAPI-Key", "042f63e5cdmshef571236239da95p1b8bedjsn15b317b19788")
                .header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        String response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString()).body();
        return response;
    }


}







