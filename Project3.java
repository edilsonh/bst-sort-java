import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class Project3 extends JFrame {
  public Project3() {
    setTitle("Binary Search Tree Sort");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new GridLayout(4,1));

    JPanel originalListPanel = new JPanel();
    originalListPanel.setLayout(new GridLayout(1,2));
    JLabel originalListLabel = new JLabel("Original List");
    JTextField originalListField = new JTextField("");
    originalListPanel.add(originalListLabel);
    originalListPanel.add(originalListField);
    add(originalListPanel);

    JPanel sortedListPanel = new JPanel();
    sortedListPanel.setLayout(new GridLayout(1,2));
    JLabel sortedListLabel = new JLabel("Sorted List");
    JTextField sortedListField = new JTextField("");
    sortedListField.setEditable(false);
    sortedListField.setBackground(Color.LIGHT_GRAY);
    sortedListPanel.add(sortedListLabel);
    sortedListPanel.add(sortedListField);
    add(sortedListPanel);

    JButton sort = new JButton("Perform Sort");
    add(sort);

    JPanel optionPanel = new JPanel();
    optionPanel.setLayout(new GridLayout(1,2));

    JPanel sortOrderPanel = new JPanel();
    sortOrderPanel.setLayout(new GridLayout(2,1));
    ButtonGroup sortGroup = new ButtonGroup();
    JRadioButton ascend = new JRadioButton("Ascending", true);
    JRadioButton descend = new JRadioButton("Descending", false);
    TitledBorder sortOrderTitle = BorderFactory.createTitledBorder("Sort Order");
    sortOrderPanel.setBorder(sortOrderTitle);
    sortGroup.add(ascend);
    sortGroup.add(descend);
    sortOrderPanel.add(ascend);
    sortOrderPanel.add(descend);

    JPanel numericTypePanel = new JPanel();
    numericTypePanel.setLayout(new GridLayout(2,1));
    ButtonGroup numericGroup = new ButtonGroup();
    JRadioButton integerOption = new JRadioButton("Integer", true);
    JRadioButton fractionOption = new JRadioButton("Fraction", false);
    TitledBorder numericTypeTitle = BorderFactory.createTitledBorder("Numeric Type");
    numericTypePanel.setBorder(numericTypeTitle);
    numericGroup.add(integerOption);
    numericGroup.add(fractionOption);
    numericTypePanel.add(integerOption);
    numericTypePanel.add(fractionOption);

    optionPanel.add(sortOrderPanel);
    optionPanel.add(numericTypePanel);
    add(optionPanel);

    sort.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String direction = "";
        if(ascend.isSelected()) {
          direction = "ascend";
        } else {
          direction = "descend";
        }

        if(integerOption.isSelected()) {
          Tree<String> integerObject = new Tree<String>(originalListField.getText(), direction);
          sortedListField.setText(integerObject.toString());
        } else {
          System.out.println("fraction");
        }
      }
    });

    pack();
    setVisible(true);
    setSize(500,275);
  }

  public static void main(String[] args) {
    new Project3();
  }
}
