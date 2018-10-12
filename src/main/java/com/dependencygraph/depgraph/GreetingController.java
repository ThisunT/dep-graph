package com.dependencygraph.depgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final List<String> nodes = new ArrayList<>();
    private final List<String> links = new ArrayList<>();

    @RequestMapping("/graph")
    public Graph graph() {
        nodes.add("a");
        nodes.add("b");
        links.add("ab");
        links.add("ds");
        return new Graph(nodes, links);
    }

    @RequestMapping("/raw")
    public JSONArray rawGraph(){
        return GraphReader.getGraph();
    }
}
