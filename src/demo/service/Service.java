package demo.service;

import demo.entities.Offerte;
import demo.entities.Ort;

import java.util.*;
import java.util.stream.Collectors;

public class Service {

    /**
     * sorts the given list by price (including tva) descending
     * @param offers given list
     * @return the sorted list
     */
    public List<Offerte> sortOffersByPriceDescending(List<Offerte> offers) {
        for(Offerte offer:offers) {
            offer.setPreis((offer.getPreis()+offer.getPreis()* offer.getMehrwertsteuer()/100));
        }
        offers.sort(Comparator.comparing(Offerte::getPreis).reversed());
        return offers;
    }

    /**
     * creates a top of places by prices
     * @param offers the list to be sorted
     * @return a top of places by prices
     */
    public List<Map.Entry<Ort, Float>> getPlacesTop(List<Offerte> offers) {
        /*Map<Ort, Long> places = offertes.stream()
                .collect(Collectors.groupingBy(Offerte::getOrt, Collectors.counting()));*/

        Map<Ort, Float> placesMap = new HashMap<>();

        for (Offerte offer : offers) {
            if(placesMap.containsKey(offer.getOrt())) {
                placesMap.put(offer.getOrt(), offer.getPreis()+placesMap.get(offer.getOrt()));
            }
            else {
                placesMap.put(offer.getOrt(), offer.getPreis());
            }
        }

        return placesMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
    }
}
