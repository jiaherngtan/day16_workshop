package com.vttp2022.workshop16.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vttp2022.workshop16.model.Checkers;
import com.vttp2022.workshop16.model.Pieces;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class ReadJSON {

    private static final Logger logger = LoggerFactory.getLogger(ReadJSON.class);

    public void readJson() {
        try {
            InputStream fis = new FileInputStream(
                    "/Users/jiaherngtan/Desktop/visa/ssf/workshop16/src/main/resources/templates/checkers.json");

            // create JsonReader object
            JsonReader jsonReader = Json.createReader(fis);

            // get JsonObject from JsonReader
            JsonObject jsonObject = jsonReader.readObject();

            // we can close IO resource and JsonReader now
            jsonReader.close();
            fis.close();

            // Retrieve data from JsonObject and create Post bean
            Checkers checkers = new Checkers();
            Object jsonText = jsonObject.getJsonObject("pieces");
            checkers.setName(jsonObject.getString("name"));
            logger.info("|| " + jsonText + " ||");
            // checkers.setPieces(jsonObject.get(pieces));

            // // reading arrays from json
            // JsonArray jsonArray = jsonObject.getJsonArray("tags");
            // String[] tags = new String[jsonArray.size()];
            // int index = 0;
            // for (JsonValue value : jsonArray) {
            // tags[index++] = value.toString();
            // }
            // post.setTags(tags);
            // // print post object
            // System.out.println(post.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
