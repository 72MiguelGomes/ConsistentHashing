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

}