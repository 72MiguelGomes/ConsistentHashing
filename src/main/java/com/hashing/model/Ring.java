package com.hashing.model;

import java.util.Objects;
import java.util.TreeMap;

public class Ring {

  private TreeMap<Integer, Node> nodes = new TreeMap<>();

  public void addNode(Node node) {
    // TODO: Re-Balance
    nodes.put(node.getHash(), node);
  }

  public void addValue(String value) {

    int hash = Objects.hash(value);

    Integer nodeHash = nodes.ceilingKey(hash);

    Node node = nodes.get(nodeHash != null ? nodeHash : nodes.firstKey());

    node.addRequest(new Request(value));
  }

  public void printRing() {
    nodes.values().forEach(System.out::print);
  }

}
