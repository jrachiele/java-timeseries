package data;

import org.junit.Test;

import static data.Pair.intPair;
import static data.Pair.newPair;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class PairSpec {

    @Test
    public void testEqualsAndHashCode() {
        Pair<String, Integer> x = newPair("first", 1);
        Pair<String, Integer> y = newPair("first", 2);
        Pair<String, Integer> z = newPair("first", 1);
        assertThat(x, is(z));
        assertThat(x.hashCode(), is(z.hashCode()));
        assertThat(x, is(not(y)));
        assertThat(y, is(not(x)));
        assertThat(x, is(notNullValue()));
        y = newPair("second", 1);
        assertThat(x, is(not(y)));
        assertThat(x, is(not(new Object())));
        Pair<Integer, Integer> a = intPair(1, 2);
        Pair<Integer, Integer> b = intPair(2, 1);
        assertThat(a, is(not(b)));
        assertThat(b, is(not(a)));
    }

    @Test
    public void testComparable() {
        Pair<Integer, Integer> a = intPair(1, 2);
        Pair<Integer, Integer> b = intPair(1, 2);
        assertThat(a.compareTo(b), is(0));
        b = intPair(1, 3);
        assertThat(a.compareTo(b), is(lessThan(0)));
        b = intPair(0, 2);
        assertThat(a.compareTo(b), is(greaterThan(0)));
    }
}
