package com.prep.problem.queue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueLetterTest {

    UniqueLetter prog = new UniqueLetter();

    @Test
    public void solve() {
        String inp = "jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl";
        String out = prog.solve(inp);

        Assertions.assertThat(out).isEqualTo("jjjjjjjjjjjjjjjjjjjjjyyyyyyyyyyyyyyyyyyyyyyyyyyyqqqqq");
    }
}