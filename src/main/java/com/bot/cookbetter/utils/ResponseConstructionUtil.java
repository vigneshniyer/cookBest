package com.bot.cookbetter.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

public class ResponseConstructionUtil {

    private static ResponseConstructionUtil responseConstructionUtil;
    final Logger logger = LoggerFactory.getLogger(ResponseConstructionUtil.class);
    public static ResponseConstructionUtil getInstance() {
        if(responseConstructionUtil == null) {
            responseConstructionUtil = new ResponseConstructionUtil();
        }
        return responseConstructionUtil;
    }

    public JSONObject invokeSearch() throws JSONException {

        JSONObject response;
        String result = "";
        try {
            InputStream is = getClass().getResourceAsStream("/search_options.json");
            //BufferedReader br = new BufferedReader(new FileReader("./resources/search_options.json"));
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
            logger.info("--------------- LOOK HERE ! ------------------");
            logger.info(result);
        } catch(Exception e) {
            e.printStackTrace();
        }
        response = new JSONObject(result);
        return response;
    }

    public JSONObject personalize() {
        JSONObject response = new JSONObject();
            response.put("text", "Personalize command has been invoked.\nOptions to configure profile will be shown to the user.");
            return response;
    }

}
