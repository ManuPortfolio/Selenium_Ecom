package Data_Set;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;


public class DataReader {

    public List<HashMap<String, String>> getJsontoData(String FilePath) throws IOException {

        //Reading JSon File
       String JsonContent =  FileUtils.readFileToString(new File(System.getProperty("user.dir") + "src//test//java/Data_Set//PurchaseOrder.json"),
               StandardCharsets.UTF_8);

       //Converting String into Hashmap values using Databind
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;


    }
}
