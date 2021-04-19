import java.util.*;

class CC implements Comparator<Integer> {
  public int compare(Integer a, Integer b){
    return a - b;
  }
}

class Main {
  public static void main(String[] args) {
    Merge<Integer> mrg = new Merge<Integer>();


    Set<Integer> setA = new HashSet<>();
    setA.add(1);
    setA.add(2);
    setA.add(3);

    Set<Integer> setB = new HashSet<>();
    setB.add(4);
    setB.add(5);
    setB.add(6);
    setB.add(7);

    Set<Integer> setC = new HashSet<>();
    
    mrg.merge(setA, setB, new CC(), setC);

    System.out.println(setC);

  }
}
