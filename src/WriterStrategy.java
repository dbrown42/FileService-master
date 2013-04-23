
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
public interface WriterStrategy {
    public abstract List<LinkedHashMap<String, String>> getDataIn();
    public abstract void setDataIn(List<LinkedHashMap<String, String>> dataIn);
    public abstract String writeFile() throws IOException;
    public abstract FileFormatterStrategy getFormatterStrategy();
    public abstract void setFormatter(FileFormatterStrategy formatter);    
    //public abstract List<LinkedHashMap<String, String>> writeFile()throws IOException;    
}
