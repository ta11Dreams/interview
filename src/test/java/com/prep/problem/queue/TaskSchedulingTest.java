package com.prep.problem.queue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class TaskSchedulingTest {

    TaskScheduling schedule = new TaskScheduling();

    //@Test( timeout = 10000)
    @Test()
    public void testTaskSchduling() {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 5, 6, 4));

        ArrayList<Integer> B = new ArrayList<>(List.of(4,1,6,5));
        int result = schedule.run(A, B);
        Assertions.assertThat(result).isEqualTo(8);

    }
}
