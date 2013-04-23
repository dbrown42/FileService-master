
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dallas
 */
public interface ReaderStrategy {
    public abstract List<LinkedHashMap<String, String>> readFile()throws IOException;
    public abstract String setFilePath();
    public abstract FileFormatterStrategy getFormatterStrategy();
    public abstract void setFilePath(String filePath);
    public abstract void setFormatter(FileFormatterStrategy formatter);
}
