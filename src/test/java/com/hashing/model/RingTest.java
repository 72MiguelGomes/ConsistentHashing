package com.hashing.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Test;

public class RingTest {

  @Test
  public void testRing() {

    List<String> requests = Arrays.asList(
        "test",
        "adasdadsasd",
        "kkkkk",
        "olsslsoslo",
        "asdoasls"
    );

    Ring ring = new Ring();
    ring.addNode(new Node("192.168.1.1"));
    ring.addNode(new Node("192.168.10.1"));
    ring.addNode(new Node("10.10.22.1"));

    requests.stream()
        .map(key -> new Request(key, key))
        .forEach(ring::addValue);

    //ring.addNode(new Node("10.10.22.1"));

    ring.printRing();

    requests.stream()
        .map(ring::getRequest)
        .filter(Objects::nonNull)
        .forEach(Assert::assertNotNull);
  }

  @Test
  public void testBalancingAddNode() {

    List<String> requests = Arrays.asList(
        "test",
        "adasdadsasd",
        "kkkkk",
        "olsslsoslo",
        "asdoasls"
    );

    Ring ring = new Ring();
    ring.addNode(new Node("192.168.1.1"));
    ring.addNode(new Node("192.168.10.1"));
    ring.addNode(new Node("10.10.22.1"));
    requests.stream()
        .map(key -> new Request(key, key))
        .forEach(ring::addValue);

    Ring ring2 = new Ring();
    ring2.addNode(new Node("192.168.1.1"));
    ring2.addNode(new Node("192.168.10.1"));
    requests.stream()
        .map(key -> new Request(key, key))
        .forEach(ring2::addValue);
    ring2.addNode(new Node("10.10.22.1"));

    Assert.assertEquals(ring, ring2);
  }

  @Test
  public void testBalancingRemoveNode() {

    List<String> requests = Arrays.asList(
        "test",
        "adasdadsasd",
        "kkkkk",
        "olsslsoslo",
        "asdoasls"
    );

    Ring ring = new Ring();
    ring.addNode(new Node("192.168.1.1"));
    ring.addNode(new Node("192.168.10.1"));
    requests.stream()
        .map(key -> new Request(key, key))
        .forEach(ring::addValue);

    Ring ring2 = new Ring();
    ring2.addNode(new Node("192.168.1.1"));
    ring2.addNode(new Node("192.168.10.1"));
    ring2.addNode(new Node("10.10.22.1"));
    requests.stream()
        .map(key -> new Request(key, key))
        .forEach(ring2::addValue);
    ring2.removeNode(new Node("10.10.22.1"));

    Assert.assertEquals(ring, ring2);
  }

}