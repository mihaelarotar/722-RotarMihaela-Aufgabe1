package demo.repository;

import java.io.IOException;
import java.util.List;

public interface IFileRepository<E> {
    /**
     * reads data from given file
     * @param fileName name of the file
     * @param separationCharacter String, separates the attributes of each object
     * @return list of objects in file
     * @throws IOException if an I/O exception has occurred
     */
    List<E> readFromFile(String fileName, String separationCharacter) throws IOException;

    /**
     * writes data to given file
     * @param fileName name of the file
     * @param objects list of objects to be saved to file
     * @param separationCharacter String, separates the attributes of each object
     * @throws IOException if an I/O exception has occurred
     */
    void writeToFile(String fileName, List<E> objects, String separationCharacter) throws IOException;
}
