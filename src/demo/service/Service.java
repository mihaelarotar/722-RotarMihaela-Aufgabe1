package demo.service;

import demo.entities.Offerte;

import java.util.Comparator;
import java.util.List;

public class Service {

    public List<Offerte> sortOffersByPriceDescending(List<Offerte> offers) {
        for(Offerte offer:offers) {
            offer.setPreis((offer.getPreis()+offer.getPreis()* offer.getMehrwertsteuer()/100));
        }
        offers.sort(Comparator.comparing(Offerte::getPreis).reversed());
        return offers;
    }


}
