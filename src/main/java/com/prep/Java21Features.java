package com.prep;

import java.util.function.Function;

/**
 * Java21Featureg
 */
public class Java21Features {

  public String pattern(Object key) {
    return switch (key) {
      case String s when s.length() == 1 -> "it is string less than 1";
      case String s when s.length() > 1 -> "it is string greater than 1";
      case Integer i -> "it is integer";
      case Long l -> "it is long";
      case Double d -> "it is double";
      case Character c -> "it is character";
      case Object o -> "unknown";
    };
  }

  public String ifPattern() {
    Object o = "I am text";

    if (o instanceof String s && s.length() > 1) {
      return s + " verfied";
    } else
      return "unverfied";
  }

  public void recordPatternTest() {
    Point p1 = new Point(12, 12);
    System.out.println(recordPattern(p1));

    Point p2 = new Point("23", "12");
    System.out.println(recordPattern(p2));

    Point p3 = new Point(true, false);
    System.out.println(recordPattern(p3));

    Function<Integer, Integer> func = doubleIt("");
    System.out.println(func.apply(12));
    Function<Integer, Integer> func2 = doubleIt(12);
    System.out.println(func2.apply(12));
  }

  private String recordPattern(Point p) {
    return switch (p) {
      case Point(Integer x, Integer y) -> caseHandler();
      case Point(String x, String y) -> {
        yield "both string";
      }
      default -> "both object";
    };
  }

  private String caseHandler() {
    return "both are integer";
  }

  private Function<Integer, Integer> doubleIt(Object o) {
    return switch (o) {
      case String s -> i -> i * 2;
      default -> i -> 20;
    };

  }
}

/**
 * InnerJava21Features
 */
record Point(Object x, Object y) {
}
