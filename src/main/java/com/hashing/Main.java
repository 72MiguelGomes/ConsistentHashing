package com.hashing;

import com.hashing.model.Node;
import com.hashing.model.Ring;

public class Main {

  public static void main(String[] args) {

    Node node = new Node("192.168.1.1");

    Node node1 = new Node("192.168.10.1");

    Ring ring = new Ring();
    ring.addNode(node);
    ring.addNode(node1);

    ring.addValue("test");

    ring.addValue("test4");

    ring.printRing();
  }

}
