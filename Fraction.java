import java.util.*;
import javax.swing.*;

public class Fraction implements Comparable {
  private ArrayList<String> f = new ArrayList<>();
  private String direction = "";
  private String sortedList = "";

  public Fraction(String f, String direction) {
    this.direction = direction;
    String[] fractions = f.split(" ");
    for (String i:fractions) {
      insert(i);
    }
  }

  public void insert(String g) {
    f.add(g);
  }

  public void compareTo() {
    try {
      int count = f.size() - 1;
      int divCount = 0;

      for (int i=0; i<f.size()-1; i++) {
        String f1 = f.get(i);
        String[] checkFraction1 = f1.split("");
        for (String cf: checkFraction1) {
          if (cf.equals("/")) {
            divCount += 1;
          }
          if (divCount>1) {
            throw new NumberFormatException("Invalid fraction");
          }
        }
        divCount = 0;
        String[] firstNumber = f1.split("/");
        double firstNumberValue = Double.valueOf(firstNumber[0])/Double.valueOf(firstNumber[1]);

        String f2 = f.get(i+1);
        String[] checkFraction2 = f2.split("");
        for (String cf: checkFraction2) {
          if (cf.equals("/")) {
            divCount += 1;
          }
          if (divCount>1) {
            throw new NumberFormatException("Invalid fraction");
          }
        }
        divCount = 0;
        String[] secondNumber = f2.split("/");
        if (secondNumber.length > 2) {
          throw new NumberFormatException("Invalid fraction");
        }
        double secondNumberValue = Double.valueOf(secondNumber[0])/Double.valueOf(secondNumber[1]);

        if (firstNumberValue > secondNumberValue && direction == "ascend") {
          f.set(i, f2);
          f.set(i+1, f1);
        } else if (firstNumberValue < secondNumberValue && direction == "descend") {
          f.set(i, f2);
          f.set(i+1, f1);
        } else {
          count -= 1;
        }
      }

      if (count > 0) {
        compareTo();
      } else {
        for (String k: f) {
          sortedList += k + " ";
        }
      }
    } catch(Exception e) {
      System.out.println(e);
      JFrame nd = new JFrame();
      JOptionPane.showMessageDialog(nd, "Improper fraction format");
    }
  }

  public String toString() {
    compareTo();
    return sortedList;
  }
}
