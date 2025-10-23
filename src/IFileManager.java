import java.io.IOException;
import java.util.List;

/**
 * Interface quan ly doc/ghi file
 */
public interface IFileManager {
    /**
     * Doc du lieu tu file
     * @param fileName ten file
     * @return danh sach du lieu doc duoc
     * @throws IOException
     */
    List<String> readFromFile(String fileName) throws IOException;
    
    /**
     * Ghi du lieu vao file
     * @param fileName ten file
     * @param data du lieu can ghi
     * @throws IOException
     */
    void writeToFile(String fileName, List<String> data) throws IOException;
}