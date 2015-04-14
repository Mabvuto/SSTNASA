package tn.sta.eximus.sta;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;



public class AstronautController {



    private ObjectMapper objectMapper = null;
    private JsonFactory jsonFactory=null;
    private JsonParser jp = null;
    private File jsonOutputFile;
    private File jsonFile;
public String Ui="";
    public AstronautController() {


    }



public JSONArray downloadJsonFile(String url) {
        try {
            JSONArray json = readJsonFromUrl(url);



return json;
        }


        catch (Exception e){

        }

return null;

    }


        private  String readAll(Reader rd) throws IOException {
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            return sb.toString();
        }

        public JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
            InputStream is = new URL(url).openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                String jsonText = readAll(rd);
                JSONArray json = new JSONArray(jsonText);
                return json;
            } finally {
                is.close();
            }
        }





}