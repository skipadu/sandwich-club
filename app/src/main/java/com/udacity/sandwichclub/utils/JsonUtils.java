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
                    jsonSandwichName.getString(Sandwich.JSON_MAIN_NAME),
                    getJsonArrayAsList(jsonSandwichName.getJSONArray(Sandwich.JSON_ALSO_KNOWN_AS)),
                    jsonSandwich.getString(Sandwich.JSON_PLACE_OF_ORIGIN),
                    jsonSandwich.getString(Sandwich.JSON_DESCRIPTION),
                    jsonSandwich.getString(Sandwich.JSON_IMAGE),
                    getJsonArrayAsList(jsonSandwich.getJSONArray(Sandwich.JSON_INGREDIENTS))
            );

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return parsedSandwich;
    }

    private static List<String> getJsonArrayAsList(JSONArray jsonArray) throws JSONException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getString(i));
        }
        return list;
    }
}
