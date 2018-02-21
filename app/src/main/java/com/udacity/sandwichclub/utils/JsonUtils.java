package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich parsedSandwich = new Sandwich();
        try {
            JSONObject jsonSandwich = new JSONObject(json);
            JSONObject jsonSandwichName = jsonSandwich.getJSONObject(Sandwich.JSON_NAME);
            parsedSandwich = new Sandwich(
                    jsonSandwichName.optString(Sandwich.JSON_MAIN_NAME),
                    getJsonArrayAsList(jsonSandwichName.optJSONArray(Sandwich.JSON_ALSO_KNOWN_AS)),
                    jsonSandwich.optString(Sandwich.JSON_PLACE_OF_ORIGIN),
                    jsonSandwich.optString(Sandwich.JSON_DESCRIPTION),
                    jsonSandwich.optString(Sandwich.JSON_IMAGE),
                    getJsonArrayAsList(jsonSandwich.optJSONArray(Sandwich.JSON_INGREDIENTS))
            );

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return parsedSandwich;
    }

    private static List<String> getJsonArrayAsList(JSONArray jsonArray) {
        List<String> list = new ArrayList<>();
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(jsonArray.optString(i));
            }
        }
        return list;
    }
}
