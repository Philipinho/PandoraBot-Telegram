import api.Connection;
import utils.ReadProperty;
import utils.Utils;
import utils.XMLUtil;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class PandoraBot {
    private String custId;

    public PandoraBot(String custId){
        this.custId = custId;
    }

    public PandoraBot(){

    }

    public String response(String input){
        StringBuilder response = new StringBuilder();

        try {
            String encodedInput = Utils.normalizeInput(URLEncoder.encode(input, "UTF-8"));

            Map<String, String> params = new HashMap<>();
            params.put("botid", ReadProperty.getValue("pandora.bot.id"));
            params.put("custid", custId);
            params.put("input", encodedInput);

            String XMLResponse = Connection.doGETRequest(Utils.buildParams(params));

            response.append(XMLUtil.readOutput(XMLResponse,"that"));

        } catch (IOException e){
            e.printStackTrace();
        }

        return response.toString();
    }

}
