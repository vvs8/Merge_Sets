import java.util.*;

public class Merge<E> {
  private E a, b;
  private Iterator<E> iterA, iterB;

  private boolean advanceA() {
    if (iterA.hasNext()) {
      a = iterA.next();
      return true;
    }
    return false;
  }

  private boolean advanceB() {
    if (iterB.hasNext()) {
      b = iterB.next();
      return true;
    }
    return false;
  }

  public void merge(Set<E> A, Set<E> B, Comparator<E> comp, Set<E> C) {
    iterA = A.iterator();
    iterB = B.iterator();
    boolean aExists = advanceA();
    boolean bExists = advanceB();
    while (aExists && bExists) {
      int x = comp.compare(a, b);
      if (x < 0) {
        aIsLess(a, C);
        aExists = advanceA();
      }
      else if (x == 0) {
        bothAreEqual(a, b, C);
        aExists = advanceA();
        bExists = advanceB();
      }
      else {
        bIsLess(b, C);
        bExists = advanceB();
      }
    }
    while (aExists) { 
      aIsLess(a, C);
      aExists = advanceA();
    }
    while (bExists) { 
      bIsLess(b, C);
      bExists = advanceB();
    }
  }

  protected void aIsLess(E a, Set<E> C) {
    C.add(a);
  }
    
  protected void bothAreEqual(E a, E b, Set<E> C) {
    C.add(a);
  }

  protected void bIsLess(E b, Set<E> C) {
    C.add(b);
  }


}
