package pl.sdacademy.coronavirus.exporting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public interface DataExport {
    //Utwórz interfejs DataExport z metodą export przyjmującą jako parametr nazwę pliku.
    // Metoda będzie służyła do exportu wszystkich danych z bazy, tyczących się krajów oraz zakażeń do pliku o zadanej nazwie.
    // Przykład buforowanego odczytu danych z pliku przy użyciu obiektów
    // typu FileInputStream oraz Scanner.


    static void export() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("entity_data_provider_export.txt");

        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNextLine()) {

            System.out.println(scanner.nextLine());
        }

        scanner.close();
        fileInputStream.close();
    }
}
