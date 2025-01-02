package com.prep.problem;

import java.util.List;

public class N3Repeated {
    public int repeatedNumber(final List<Integer> a) {
        if ( a.size() == 1 || a.size() == 2 ) return a.getFirst();

        int count1 = 1;
        int count2 = 0;
        int num1 = a.getFirst();
        int num2 = 0;
        int i = 1;

        while (num2 == 0) {
            if ( num1 == a.get(i))
                count1++;
            else {
                num2 = a.get(i);
                count2 = 1;
            }
            i++;
        }

        for ( ; i < a.size(); i++ ) {
            int num = a.get(i);


            if ( num == num1 ) count1++;
            else if ( num == num2 ) count2++;
            else if (count1 == 0) { num1 = num; count1 = 1; }
            else if (count2 == 0) { num2 = num; count2 = 1; }
            else {
                count1--; count2--;
            }
        }

        System.out.printf("num1: %s, num2: %s, count1: %s, count2: %s", num1, num2, count1, count2);
        int n3 = a.size()/3;
        count1 = count2 = 0;

        for (Integer integer : a) {
            if (integer == num1) count1++;
            if (integer == num2) count2++;
        }

        if ( count1 > n3 ) return num1;
        if ( count2 > n3 ) return num2;

        return -1;

    }
}
