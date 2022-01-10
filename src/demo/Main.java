package demo;

import demo.entities.Offerte;
import demo.entities.Ort;
import demo.repository.Repository;
import demo.service.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Repository repository = new Repository();
        Service service = new Service();

        try {
            List<Offerte> offers = repository.readFromFile("src/offerten.txt", "&");
            for(Offerte offer : offers) {
                System.out.println(offer);
            }

            List<Offerte> sortedOffers = service.sortOffersByPriceDescending(offers);
            for(Offerte offer : sortedOffers) {
                System.out.println(offer);
            }
            repository.writeToFile("src/offertensortiert.txt", sortedOffers, "&");

            offers = repository.readFromFile("src/offerten.txt", "&");
            List<Map.Entry<Ort, Float>> top = service.getPlacesTop(offers);

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/statistik.txt"));
            for (Map.Entry<Ort, Float> pair : top) {
                String line = pair.getKey() + ": " + pair.getValue();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
