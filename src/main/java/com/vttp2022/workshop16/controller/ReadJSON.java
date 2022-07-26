package com.vttp2022.workshop16.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.vttp2022.workshop16.model.Checkers;

public class ReadJSON {
    public static void main(String[] args) throws IOException {
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
        checkers.setName(jsonObject.getString("name"));
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
    }
}
