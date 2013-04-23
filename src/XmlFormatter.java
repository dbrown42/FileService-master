/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dallas
 */
import java.util.*;
public class XmlFormatter implements FileFormatterStrategy{
    private String data;
    private List<LinkedHashMap<String, String>> dataList;

    public String encode(List<LinkedHashMap<String,String>> data/*, boolean hasHeader*/){
        /*
         * 1. retrieve a KeySet of the Keys (header values) if hasHeader = true
         * 2. Loop thru list and retrieve each Map as a seperate record
         * 3. Ask for values() Collection (our data)
         * 4. Loop thru value collection add to a String followed by a comma
         */
        return this.data;
    }
    
    public List<LinkedHashMap<String, String>> decode(List<String> dataFromFile/*, boolean hasHeader*/){
        dataList = new ArrayList<LinkedHashMap<String, String>>();
        return this.dataList;
    }    
}

