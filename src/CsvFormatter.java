/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dallas
 */
import java.util.*;
public class CsvFormatter implements FileFormatterStrategy{
    private static final String CRLF = "\n";
    private static final String DBL_QUOTE_COMMA = "\",";
    private static final String COMMA = ",";
    private static final String DBL_QUOTE = "\"";
    
    private boolean hasHeader;
    
    public CsvFormatter(boolean hasHeader) {
        this.hasHeader = hasHeader;
    }
    
    public String encode(List<LinkedHashMap<String, String>>  data){
        StringBuilder formattedData = new StringBuilder();

        boolean headerNotSet = true;
        Set<String> fieldNames = null;
        if (this.hasHeader) {
            fieldNames = data.get(0).keySet();
        }

        for (int recordNo = 0; recordNo < data.size(); recordNo++) {
            if (fieldNames != null && headerNotSet) {
                for (String fieldName : fieldNames) {
                    // using quoted values to eliminate problems with
                    // embedded commas in a data value
                    formattedData.append(DBL_QUOTE).append(fieldName).append(DBL_QUOTE);
                    formattedData.append(COMMA);
                }
                // remove trailing comma
                formattedData.deleteCharAt(formattedData.length() - 1);
                formattedData.append(CRLF);
                addDataValues(data, recordNo, formattedData);
                headerNotSet = false;

            } else {
                addDataValues(data, recordNo, formattedData);
            }
        }

        // Here's the CSV formatted data as a single String that can be
        // saved to a file.
        return formattedData.toString();

    }
    
     private String removeQuotes(String data) {
        return data.replaceAll(DBL_QUOTE,"");
    }
     
    
    public List<LinkedHashMap<String,String>> decode(List<String> dataIn){
        List<LinkedHashMap<String, String>> decodedData = new ArrayList<LinkedHashMap<String, String>>();
        
        String[] headerFields = null;
        for (int recordNo = 0; recordNo < dataIn.size(); recordNo++) {
                        
            String[] fields = dataIn.get(recordNo).split(DBL_QUOTE_COMMA);
            if (hasHeader && (recordNo == 0)) { // first record may be header
                headerFields = fields;
//                continue;
            }

            LinkedHashMap<String, String> record =
                    new LinkedHashMap<String, String>();
            for (int i = 0; i < fields.length; i++) {
                if (hasHeader && (recordNo == 0)) { // zero is first record, could be header
                    break; // not a record so skip following code
                    // because it's a header but has no data values

                    // if header included, we store header info as key and data value
                } else if (hasHeader) {
                    headerFields[i] = removeQuotes(headerFields[i]);
                    fields[i] = removeQuotes(fields[i]);
                    record.put(headerFields[i], fields[i]);

                    // if no header we create an artificial key from a counter and add value
                } else {
                    fields[i] = removeQuotes(fields[i]);
                    record.put("" + i, fields[i]);
                }
            }

            // Only add the record if it's not the first row (header)
            if (recordNo != 0) {
                Set<String> keys = record.keySet();
                for(String key : keys) {
                    key = removeQuotes(key);
                }
                Collection<String> values = record.values();
                for(String value : values) {
                    value =  removeQuotes(value);
                }
                decodedData.add(record);
            }
        }

        return decodedData;   
        
    } 
     private void addDataValues(List<LinkedHashMap<String, String>> dataFromFile, int recordNo, StringBuilder formattedData) {
        // write a normal data row
        Collection<String> valueCol = dataFromFile.get(recordNo).values();
        for (String value : valueCol) {
            // using quoted values to eliminate problems with
            // embedded commas in a data value
            formattedData.append(DBL_QUOTE).append(value).append(DBL_QUOTE);
            formattedData.append(COMMA);
        }
        // remove trailing comma
        formattedData.deleteCharAt(formattedData.length() - 1);
        formattedData.append(CRLF);
    }    

}
