package com.dependencygraph.depgraph;

import java.util.List;

public class Graph {

    private final List nodes;
    private final List links;

    public Graph(List<String> nodes, List<String> links) {
        this.nodes = nodes;
        this.links = links;
    }

    public List getNodes() {
        return nodes;
    }

    public List getLinks() {
        return links;
    }

}