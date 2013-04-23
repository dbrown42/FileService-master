
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dallas
 */

public class FileService {
    private String readerPath;
    private String writerPath;
    private WriterStrategy writerStrategy;
    private ReaderStrategy readerStrategy;
    private FileFormatterStrategy readerFormatter;    
    private FileFormatterStrategy writerFormatter;
    private List<Map<String,String>> data;

    public FileService(String readerPath, FileFormatterStrategy readerFormatter, String writerPath, FileFormatterStrategy writerFormatter) {
        this.readerPath = readerPath;
        this.readerFormatter = readerFormatter;
        this.writerPath = writerPath;
        this.writerFormatter = writerFormatter;
    }

    public List<LinkedHashMap<String,String>> readFile()throws IOException{
        
        return readerStrategy.readFile();
    }    
    
    /**
     * @return the readerPath
     */
    public String getReaderPath() {
        return readerPath;
    }

    /**
     * @param readerPath the readerPath to set
     */
    public void setReaderPath(String readerPath) {
        this.readerPath = readerPath;
    }

    /**
     * @return the writerPath
     */
    public String getWriterPath() {
        return writerPath;
    }

    /**
     * @param writerPath the writerPath to set
     */
    public void setWritePath(String writerPath) {
        this.writerPath = writerPath;
    }

    /**
     * @return the writerStrategy
     */
    public WriterStrategy getWriterStrategy() {
        return writerStrategy;
    }

    /**
     * @param writerStrategy the writerStrategy to set
     */
    public void setWriterStrategy(WriterStrategy writerStrategy) {
        this.writerStrategy = writerStrategy;
    }

    /**
     * @return the readerStrategy
     */
    public ReaderStrategy getReaderStrategy() {
        return readerStrategy;
    }

    /**
     * @param readerStrategy the readerStrategy to set
     */
    public void setReaderStrategy(ReaderStrategy readerStrategy) {
        this.readerStrategy = readerStrategy;
    }

    /**
     * @return the readerFormatter
     */
    public FileFormatterStrategy getReaderFormatter() {
        return readerFormatter;
    }

    /**
     * @param readFormatter the readerFormatter to set
     */
    public void setReaderFormatter(FileFormatterStrategy readerFormatter) {
        this.readerFormatter = readerFormatter;
    }

    /**
     * @return writerFormatter
     */
    public FileFormatterStrategy getWriterFormatter() {
        return writerFormatter;
    }

    /**
     * @param writerrFormatter the writerFormatter to set
     */
    public void setWriterFormatter(FileFormatterStrategy writerFormatter) {
        this.writerFormatter = writerFormatter;
    }
}
