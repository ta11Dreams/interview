package com.prep;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * MergeSort
 */
public class MergeSort implements Callable<List<Integer>> {
  List<Integer> unSortedList;
  ExecutorService service;

  public MergeSort(List<Integer> input, ExecutorService service) {
    this.unSortedList = input;
    this.service = service;
  }

  @Override
  public List<Integer> call() throws Exception {
    if (unSortedList.size() == 1)
      return unSortedList;

    int mid = unSortedList.size() / 2;

    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    for (int i = 0; i < mid; i++) {
      left.add(unSortedList.get(i));
    }

    for (int i = mid; i < unSortedList.size(); i++) {
      right.add(unSortedList.get(i));
    }

    MergeSort mergeRight = new MergeSort(right, service);
    MergeSort mergeLeft = new MergeSort(left, service);

    Future<List<Integer>> leftFuture = service.submit(mergeLeft);
    Future<List<Integer>> rightFuture = service.submit(mergeRight);

    List<Integer> sortedLeft = leftFuture.get();
    List<Integer> sortedRight = rightFuture.get();

    List<Integer> sorted = new ArrayList<>();

    int i = 0;
    int j = 0;

    while (i < sortedLeft.size() && j < sortedRight.size()) {
      if (sortedLeft.get(i) < sortedRight.get(j)) {
        sorted.add(sortedLeft.get(i));
        i++;
      } else {
        sorted.add(sortedRight.get(j));
        j++;
      }
    }

    while (i < sortedLeft.size()) {
      sorted.add(sortedLeft.get(i));
      i++;
    }

    while (j < sortedRight.size()) {
      sorted.add(sortedRight.get(j));
      j++;
    }

    return sorted;

  }
  // Identify the return type to return
  // Implement the callable

}
