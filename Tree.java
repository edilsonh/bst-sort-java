import java.util.*;

public class Tree<T> implements Comparable {
  private ArrayList<String> s = new ArrayList<>();
  private String sortedList = "";
  private String direction = "";

  public Tree(String s, String direction) {
    this.direction = direction;
    String[] m = s.split(" ");
    for (String i:m) {
      this.insert(i);
    }
  }

  public void insert(String n) {
    s.add(n);
  }

  public void compareTo() {
    int count = s.size() - 1;

    for (int i=0; i<s.size()-1; i++) {
      int firstNumber = Integer.parseInt(s.get(i));
      int secondNumber = Integer.parseInt(s.get(i+1));

      if (firstNumber > secondNumber && direction == "ascend") {
        s.set(i, String.valueOf(secondNumber));
        s.set(i+1, String.valueOf(firstNumber));
      } else if (firstNumber < secondNumber && direction == "descend") {
        s.set(i, String.valueOf(secondNumber));
        s.set(i+1, String.valueOf(firstNumber));
      } else {
        count -= 1;
      }
    }

    if (count > 0) {
      compareTo();
    } else {
      for (String k: s) {
        sortedList += k + " ";
      }
    }
  }

  public String toString() {
    compareTo();
    return sortedList;
  }
}
