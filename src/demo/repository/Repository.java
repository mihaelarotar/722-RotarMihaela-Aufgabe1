package demo.repository;

import demo.entities.Offerte;
import demo.entities.Ort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IFileRepository<Offerte>{
    /**
     * reads data from given file
     * @param fileName name of the file
     * @param separationCharacter String, separates the attributes of each object
     * @return list of objects in file
     * @throws IOException if an I/O exception has occurred
     */
    @Override
    public List<Offerte> readFromFile(String fileName, String separationCharacter) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = bufferedReader.readLine();
        String[] attributes;
        Offerte offer;
        List<Offerte> offers = new ArrayList<>();
        while (line != null) {
            attributes = line.split(separationCharacter);
            offer = new Offerte(Integer.valueOf(attributes[0]), attributes[1], Integer.parseInt(attributes[2]),
                    Float.parseFloat(attributes[3]), attributes[4], Ort.valueOf(attributes[5]));
            offers.add(offer);

            line = bufferedReader.readLine();
        }

        return offers;
    }

    /**
     * writes data to given file
     * @param fileName name of the file
     * @param objects list of objects to be saved to file
     * @param separationCharacter String, separates the attributes of each object
     * @throws IOException if an I/O exception has occurred
     */
    @Override
    public void writeToFile(String fileName, List<Offerte> objects, String separationCharacter) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (Offerte offer : objects) {
            String line = offer.getId() + separationCharacter + offer.getUnternehmensname()
                    + separationCharacter + offer.getPreis() + separationCharacter + offer.getMehrwertsteuer()
                    + separationCharacter + offer.getAdresse() + separationCharacter + offer.getOrt();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

    }
}
