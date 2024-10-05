package com.prep.lld.registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.prep.lld.prototype.Student;

/**
 * PrototypeRegistry
 */
public class StudentRegistry {

  private HashMap<String, Student> prototypes = new HashMap<>();

  public void addStudent(String id, Student prototype) {
    prototypes.put(id, prototype);
  }

  public Student getById(String id) {
    Student cloneable = prototypes.get(id);

    if (cloneable == null)
      return null;

    return cloneable.clone();
  }

  public ArrayList<Student> getByClassname(String class_name) {
    ArrayList<Student> list = new ArrayList<>();

    Iterator<Student> iterator = prototypes.values().iterator();

    while (iterator.hasNext()) {
      Student cloneable = iterator.next();
      if (cloneable.getClass_name().equals(class_name))
        list.add(cloneable);
    }

    return list;
  }

}
