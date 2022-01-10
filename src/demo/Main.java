package demo;

import demo.entities.Offerte;
import demo.repository.Repository;
import demo.service.Service;

import java.io.IOException;
import java.util.List;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
