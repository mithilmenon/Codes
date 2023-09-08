import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorWeather {
    public static void main(String[] args) throws InterruptedException, IOException {

        int totalCalls = 1000;
        int threadNumber = 100;

        ExecutorService executor = Executors.newFixedThreadPool(threadNumber);
        long startTime = System.currentTimeMillis();
        for (int i=0; i<totalCalls; i++){
            executor.submit(() -> {
                try {
                    WeatherApi.run();
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        long endTime = System.currentTimeMillis();
        System.out.println("total time " + (endTime-startTime));
    }
}
