package com.prep.problem;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class N3RepeatedTest {
    N3Repeated obj = new N3Repeated();

    @Test
    public void testRepeatedNumber() {
        List<Integer> inp = List.of(1, 1, 2);

        assertThat(obj.repeatedNumber(inp)).isEqualTo(1);

        inp = List.of(1000441, 1000441, 1000994);

        assertThat(obj.repeatedNumber(inp)).isEqualTo(1000441);
        inp = List.of(1, 1, 1, 2, 3, 5, 7);

        assertThat(obj.repeatedNumber(inp)).isEqualTo(1);
    }

    @Test
    public void mid_level_test() {
        List<Integer> inp = List.of(1000727, 1000727, 1000641, 1000517, 1000212, 1000532, 1000727, 1001000, 1000254, 1000106, 1000405, 1000100, 1000736, 1000727, 1000727, 1000787, 1000105, 1000713, 1000727, 1000333, 1000069, 1000727, 1000877, 1000222, 1000727, 1000505, 1000641, 1000533, 1000727, 1000727, 1000727, 1000508, 1000475, 1000727, 1000573, 1000727, 1000618, 1000727, 1000309, 1000486, 1000792, 1000727, 1000727, 1000426, 1000547, 1000727, 1000972, 1000575, 1000303, 1000727, 1000533, 1000669, 1000489, 1000727, 1000329, 1000727, 1000050, 1000209, 1000109);
        assertThat(obj.repeatedNumber(inp)).isEqualTo(1000727);
    }

}
