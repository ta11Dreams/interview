package com.prep.lld.prototype;

/**
 * IntelligentStudent
 */
public class IntelligentStudent extends Student {
  String iq;

  public IntelligentStudent(String name, String class_name, String iq) {
    super(name, class_name);
    this.iq = iq;
  }

  public IntelligentStudent(IntelligentStudent student) {
    super(student);
    this.iq = student.iq;
  }

  @Override
  public IntelligentStudent clone() {
    return new IntelligentStudent(this);
  }

}
