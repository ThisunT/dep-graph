package com.dependencygraph.depgraph;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class GraphReader {

    public static JSONObject getGraph() {

        JSONParser parser = new JSONParser();
        JSONObject jsonGraph = null;
        JSONObject finalGraph = new JSONObject();
        JSONArray nodes = new JSONArray();
        JSONArray edges = null;
        JSONArray finalNodes = new JSONArray();
        JSONArray finalEdges = new JSONArray();

        try {
            Object graph = parser.parse(new FileReader("dependency-graph.json"));

            jsonGraph = (JSONObject) graph;

            nodes = (JSONArray) jsonGraph.get("artifacts");
            int i=0;
            for (Object node : nodes){
                JSONObject jsonNode  = (JSONObject) node;
                if(!jsonNode.get("groupId").toString().contains("cambio")){
                    continue;
                }
                jsonNode.put("name", jsonNode.get("id"));
                jsonNode.remove("id");
                jsonNode.put("id", Integer.parseInt(jsonNode.get("numericId").toString())-1);
                jsonNode.remove("numericId");

                finalNodes.add(jsonNode);

                i++;
            }

            edges = (JSONArray) jsonGraph.get("dependencies");
            int j=0;
            for (Object edge : edges){
                JSONObject jsonEdge  = (JSONObject) edge;
                if(!( jsonEdge.get("from").toString().contains("cambio") && jsonEdge.get("to").toString().contains("cambio") )){
                    continue;
                }
                jsonEdge.put("source", jsonEdge.get("numericFrom"));
                jsonEdge.remove("numericFrom");
                jsonEdge.put("target", jsonEdge.get("numericTo"));
                jsonEdge.remove("numericTo");

                finalEdges.add(jsonEdge);

                j++;
            }

            finalGraph.put("nodes", finalNodes);
            finalGraph.put("links", finalEdges);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalGraph;
    }
}