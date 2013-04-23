
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
public class TextFileReader {
    private String filePath;
    private FileFormatterStrategy formatter;
    private static final String IO_ERROR_MSG = "Houston, we have a problem! reading this file";

    public TextFileReader(FileFormatterStrategy formatter, String filePath) {
        this.filePath = filePath;
        this.formatter = formatter;
    }

    
    public List<LinkedHashMap<String, String>> readFile() throws IOException{
         BufferedReader in = null;
         List<String> dataIn = new ArrayList<String>();
         try {  
            in = new BufferedReader(new java.io.FileReader(filePath));
            String line = in.readLine();               
            while(line != null){  
                dataIn.add(line);
                line = in.readLine();
            }
         } catch(IOException ioe) {
            System.out.println(IO_ERROR_MSG);
         } finally {                
            in.close();
         }
         return formatter.decode(dataIn);
    }
    
    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
       
}
