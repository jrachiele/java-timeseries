package linear;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import math.Complex;

public class VectorSpec {

  @Test
  public void whenVectorsAddedThenSumCorrect() {
    Complex c1 = new Complex(3, 5);
    Complex c2 = new Complex(2.5, 4.5);
    Complex c3 = new Complex(2.4, 4.0);
    Complex c4 = new Complex(6, 2);
    
    List<Complex> l1 = new ArrayList<>(2);
    l1.add(c1); l1.add(c2);
    List<Complex> l2 = new ArrayList<>(2);
    l2.add(c3); l2.add(c4);
    
    FieldVector<Complex> vec1 = new FieldVector<>(l1);
    FieldVector<Complex> vec2 = new FieldVector<>(l2);
    FieldVector<Complex> sum = vec1.plus(vec2);
    
    List<Complex> expectedL = new ArrayList<>(2);
    expectedL.add(new Complex(5.4, 9.0));
    expectedL.add(new Complex(8.5, 6.5));
    FieldVector<Complex> expected = new FieldVector<>(expectedL);
    assertThat(sum, is(equalTo(expected)));
  }
  
  @Test
  public void whenVectorsSubtractedThenDiffCorrect() {
    Complex c1 = new Complex(3, 5);
    Complex c2 = new Complex(2.5, 4.5);
    Complex c3 = new Complex(2.4, 4.0);
    Complex c4 = new Complex(6, 2);
    
    List<Complex> l1 = new ArrayList<>(2);
    l1.add(c1); l1.add(c2);
    List<Complex> l2 = new ArrayList<>(2);
    l2.add(c3); l2.add(c4);
    
    FieldVector<Complex> vec1 = new FieldVector<>(l1);
    FieldVector<Complex> vec2 = new FieldVector<>(l2);
    FieldVector<Complex> diff = vec1.minus(vec2);
    
    List<Complex> expectedL = new ArrayList<>(2);
    expectedL.add(new Complex(0.6, 1.0));
    expectedL.add(new Complex(-3.5, 2.5));
    FieldVector<Complex> expected = new FieldVector<>(expectedL);
    assertThat(diff, is(equalTo(expected)));
  }
  
  @Test
  public void whenNormComputedThenResultCorrect() {
    FieldVector<Complex> vec = testVecFourElem();
    assertThat(vec.norm(), is(equalTo(11.05712440013225)));
  }
  
  @Test
  public void whenDotProductThenResultCorrect() {
    FieldVector<Complex> vec1 = testVecTwoElem();
    FieldVector<Complex> vec2 = testVecTwoElem2();
    assertThat(vec1.dotProduct(vec2), is(equalTo(new Complex(51.2, 22.0))));
  }
  
  @Test
  public void whenAxpyComputedResultCorrect() {
    FieldVector<Complex> vec1 = testVecTwoElem();
    FieldVector<Complex> vec2 = testVecTwoElem2();
    Complex alpha = new Complex(7.0, 3.5);
    FieldVector<Complex> axpy = vec1.axpy(vec2, alpha);
    assertThat(axpy.at(0), is(equalTo(new Complex(5.9, 49.5))));
    assertThat(axpy.at(1), is(equalTo(new Complex(7.75, 42.25))));
  }
  
  private final FieldVector<Complex> testVecFourElem() {
    Complex c1 = new Complex(3, 5);
    Complex c2 = new Complex(2.5, 4.5);
    Complex c3 = new Complex(2.4, 4.0);
    Complex c4 = new Complex(6, 2);
    List<Complex> complexList = new ArrayList<>(4);
    complexList.add(c1); complexList.add(c2);
    complexList.add(c3); complexList.add(c4);
    return new FieldVector<>(complexList);
  }
  
  private final FieldVector<Complex> testVecTwoElem() {
    Complex c1 = new Complex(3, 5);
    Complex c2 = new Complex(2.5, 4.5);
    List<Complex> complexList = new ArrayList<>(2);
    complexList.add(c1); complexList.add(c2);
    return new FieldVector<>(complexList);
  }
  
  private final FieldVector<Complex> testVecTwoElem2() {
    Complex c3 = new Complex(2.4, 4.0);
    Complex c4 = new Complex(6, 2);
    List<Complex> complexList = new ArrayList<>(2);
    complexList.add(c3); complexList.add(c4);
    return new FieldVector<>(complexList);
  }
}
