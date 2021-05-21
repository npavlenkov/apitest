package company;


import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseApi {
    JSONObject getJson(String address) throws IOException {
        JSONObject ob = new JSONObject(new String(Files.readAllBytes(Paths.get(address))));
        return ob;
    }
}
