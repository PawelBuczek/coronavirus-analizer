package pl.sdacademy.weather;

public class Main {
    public static void main(String[] args) {
        Weather weather = new Weather(12.48,56.68,6.22);
        System.out.println(weather.getCloudCover());
        System.out.println(weather.getId());
    }
}
