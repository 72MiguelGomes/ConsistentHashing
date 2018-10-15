package com.hashing.model;

import java.util.Objects;
import java.util.TreeMap;

public class Ring {

  private TreeMap<Integer, Node> nodes = new TreeMap<>();

  public void addNode(Node newNode) {
    int newNodeHash = newNode.getHash();

    if (!nodes.isEmpty()) {
      Node nodeToMigrate = getNode(newNodeHash);

      // ######## Concurrency Problem
      nodeToMigrate
          .getRequestsToMigrate(newNodeHash)
          .parallelStream()
          .forEach(newNode::addRequest);

      nodes.put(newNode.getHash(), newNode);

      nodeToMigrate.removeMigratedItems(newNodeHash);
      // ######## Concurrency Problem
    } else {
      nodes.put(newNode.getHash(), newNode);
    }
  }

  public void addValue(Request request) {

    int hash = request.getHash();

    Node node = getNode(hash);

    node.addRequest(request);
  }

  private Node getNode(int hash) {
    Integer nodeHash = nodes.ceilingKey(hash);

    return nodes.get(nodeHash != null ? nodeHash : nodes.firstKey());
  }

  public void printRing() {
    nodes.values().forEach(System.out::print);
  }

  public Request getRequest(String key) {
    int hash = Objects.hash(key);

    Node node = this.getNode(hash);

    return node.getRequest(hash);
  }

}
