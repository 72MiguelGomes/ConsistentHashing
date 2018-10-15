package com.hashing.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class RingTest {

  @Test
  public void testRing() {

    List<String> requests = Arrays.asList(
        "test",
        "test2",
        "adasdadsasd",
        "kkkkk",
        "olsslsoslo"
    );

    Node node = new Node("192.168.1.1");

    Node node1 = new Node("192.168.10.1");

    Ring ring = new Ring();
    ring.addNode(node);
    ring.addNode(node1);

    requests.stream()
        .map(key -> new Request(key, key))
        .forEach(ring::addValue);

    ring.printRing();

  }

}