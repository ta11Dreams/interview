package com.prep.lld.builder;

/**
 * Builder
 */
public class CarBuilder {

  private Car car;

  public CarBuilder() {
    car = new Car();
  }

  public CarBuilder setId(Integer id) {
    car.id = id;
    return this;
  }

  public CarBuilder setName(String name) {
    car.name = name;
    return this;
  }

  public CarBuilder setBuildYear(Integer buildYear) {
    this.car.buildYear = buildYear;
    return this;
  }

  public CarBuilder setColor(String color) {
    this.car.color = color;
    return this;
  }

  public CarBuilder setEngine(String engine) {
    this.car.engine = engine;
    return this;
  }

  public Car build() {
    return car;
  }

  public static class Car {
    public Integer id;
    public String name;
    public Integer buildYear;
    public String color;
    public String engine;
  }
}
