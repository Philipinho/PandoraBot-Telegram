package com.litesoftwares;

import com.litesoftwares.api.Connection;
import com.litesoftwares.utils.ReadProperty;
import com.litesoftwares.utils.Utils;
import com.litesoftwares.utils.XMLUtil;
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

            response.append(XMLUtil.readOutput(XMLResponse));

        } catch (IOException e){
            e.printStackTrace();
        }

        return response.toString();
    }

}
