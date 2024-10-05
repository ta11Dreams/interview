package com.prep.lld.prototype;

/**
 * Student
 */
public class Student implements Cloneable<Student> {
  String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  String class_name;

  public String getClass_name() {
    return class_name;
  }

  public void setClass_name(String class_name) {
    this.class_name = class_name;
  }

  public Student(String name, String class_name) {
    this.name = name;
    this.class_name = class_name;
  }

  public Student(Student student) {
    this.name = student.name;
    this.class_name = student.class_name;
  }

  @Override
  public Student clone() {
    return new Student(this);
  }

}
