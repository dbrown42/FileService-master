
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dbrown69
 */
public class TextFileWriter {
    private List<LinkedHashMap<String, String>> dataIn;
    private FileFormatterStrategy formatter;
    private static final String IO_ERROR_MSG = "Houston, we have a problem! reading this file";

    public TextFileWriter(FileFormatterStrategy formatter, List<LinkedHashMap<String, String>> dataIn) {
        this.formatter = formatter;
        this.dataIn = dataIn;
    }

    
    public String writeFile() throws IOException{
        return this.formatter.encode(this.getDataIn());
    }

    /**
     * @return the formatter
     */
    public FileFormatterStrategy getFormatter() {
        return formatter;
    }

    /**
     * @param formatter the format to set
     */
    public void setFormatter(FileFormatterStrategy formatter) {
        this.formatter = formatter;
    }

    /**
     * @return the dataIn
     */
    public List<LinkedHashMap<String, String>> getDataIn() {
        return dataIn;
    }

    /**
     * @param dataIn the dataIn to set
     */
    public void setDataIn(List<LinkedHashMap<String, String>> dataIn) {
        this.dataIn = dataIn;
    }
          
}
