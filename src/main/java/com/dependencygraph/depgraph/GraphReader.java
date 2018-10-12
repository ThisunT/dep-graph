package com.dependencygraph.depgraph;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphReader {

    public static JSONArray getGraph() {
        FileReader fr = null;
        String[] textData = new String[1];
        try {
            fr = new FileReader("E:/Projects/dep-graph/src/main/java/com/dependencygraph/depgraph/dependency-graph.json");
            BufferedReader text = new BufferedReader(fr);
            textData[0] = text.readLine();
            text.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(textData[0]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}