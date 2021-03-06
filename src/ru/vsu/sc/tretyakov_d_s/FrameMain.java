package ru.vsu.sc.tretyakov_d_s;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import java.io.File;
import java.io.PrintWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import ru.vsu.sc.tretyakov_d_s.Solution.Solution;
import ru.vsu.sc.tretyakov_d_s.Utils.ArrayUtils;
import ru.vsu.sc.tretyakov_d_s.Utils.JTableUtils;
import ru.vsu.sc.tretyakov_d_s.Utils.SwingUtils;


public class FrameMain extends JFrame {

  private JPanel panelMain;
  private JTable tableInput;
  private JButton buttonLoadInputFromFile;
  private JButton buttonRandomInput;
  private JButton buttonSaveInputInfoFile;
  private JButton checkForOrderedSequence;
  private JTextField result;
  private JButton saveTheAnswerToButton;
  private JButton buttonSaveOutputIntoFile;
  private JTable tableOutput;
  private JButton buttonReverseColumns;

  private JFileChooser fileChooserOpen;
  private JFileChooser fileChooserSave;
  private JMenuBar menuBarMain;
  private JMenu menuLookAndFeel;

  public FrameMain() {
    this.setTitle("Task 8");
    this.setContentPane(panelMain);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();

    Solution solution = new Solution();

    JTableUtils.initJTableForArray(tableInput, 40, true, true, true, true);
    tableInput.setRowHeight(25);

    fileChooserOpen = new JFileChooser();
    fileChooserSave = new JFileChooser();
    fileChooserOpen.setCurrentDirectory(new File("."));
    fileChooserSave.setCurrentDirectory(new File("."));
    FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
    fileChooserOpen.addChoosableFileFilter(filter);
    fileChooserSave.addChoosableFileFilter(filter);

    fileChooserSave.setAcceptAllFileFilterUsed(false);
    fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
    fileChooserSave.setApproveButtonText("Save");

    menuBarMain = new JMenuBar();
    setJMenuBar(menuBarMain);

    JTableUtils.writeArrayToJTable(tableInput, new int[][]{
        {1, 2, 3, 4, 5},
        {16, 17, 18, 19, 6},
        {15, 24, 25, 20, 7},
        {14, 23, 22, 21, 8},
        {13, 12, 11, 10, 9}
    });
    this.pack();

    buttonLoadInputFromFile.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        try {
          if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
            int[][] arr = ArrayUtils.readIntArray2FromFile(
                fileChooserOpen.getSelectedFile().getPath());
            JTableUtils.writeArrayToJTable(tableInput, arr);
          }
        } catch (Exception e) {
          SwingUtils.showErrorMessageBox(e);
        }
      }
    });
    buttonRandomInput.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        try {
          int[][] matrix = ArrayUtils.createRandomIntMatrix(
              tableInput.getRowCount(), tableInput.getColumnCount(), 100);
          JTableUtils.writeArrayToJTable(tableInput, matrix);
        } catch (Exception e) {
          SwingUtils.showErrorMessageBox(e);
        }
      }
    });
    buttonSaveInputInfoFile.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        try {
          if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
            int[][] matrix = JTableUtils.readIntMatrixFromJTable(tableInput);
            String file = fileChooserSave.getSelectedFile().getPath();
            if (!file.toLowerCase().endsWith(".txt")) {
              file += ".txt";
            }
            ArrayUtils.writeArrayToFile(file, matrix);
          }
        } catch (Exception e) {
          SwingUtils.showErrorMessageBox(e);
        }
      }
    });
    checkForOrderedSequence.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        try {
          int[][] matrix = JTableUtils.readIntMatrixFromJTable(tableInput);
          if (solution.checkArrayForSequence(matrix)) {
            result.setText("Arranged sequence");
          } else {
            result.setText("Not an arranged sequence");
          }
        } catch (Exception e) {
          SwingUtils.showErrorMessageBox(e);
        }
      }
    });
    saveTheAnswerToButton.addActionListener(actionEvent -> {
      try {
        if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
          String file = fileChooserSave.getSelectedFile().getPath();
          if (!file.toLowerCase().endsWith(".txt")) {
            file += ".txt";
          }
          PrintWriter writer1 = new PrintWriter(file);
          writer1.println(result.getText());
          writer1.close();
        }
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Unable to save data to this file!", "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    });
  }


  {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
    $$$setupUI$$$();
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer >>> IMPORTANT!! <<< DO NOT edit this method OR
   * call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    panelMain = new JPanel();
    panelMain.setLayout(new GridLayoutManager(9, 3, new Insets(10, 10, 10, 10), 10, 10));
    final JScrollPane scrollPane1 = new JScrollPane();
    panelMain.add(scrollPane1,
        new GridConstraints(0, 0, 5, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
            GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 330), null, 0, false));
    tableInput = new JTable();
    scrollPane1.setViewportView(tableInput);
    checkForOrderedSequence = new JButton();
    checkForOrderedSequence.setHideActionText(false);
    checkForOrderedSequence.setText("Check the sequence of elements for order");
    panelMain.add(checkForOrderedSequence,
        new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(354, 30), null, 0, false));
    buttonLoadInputFromFile = new JButton();
    buttonLoadInputFromFile.setText("Load an array from a file");
    panelMain.add(buttonLoadInputFromFile,
        new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final JLabel label1 = new JLabel();
    label1.setHorizontalAlignment(0);
    label1.setHorizontalTextPosition(0);
    label1.setText("Result:");
    panelMain.add(label1,
        new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null,
            new Dimension(138, 16), null, 0, false));
    result = new JTextField();
    result.setEditable(false);
    result.setHorizontalAlignment(0);
    panelMain.add(result, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST,
        GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW,
        GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    buttonRandomInput = new JButton();
    buttonRandomInput.setText("Fill with random numbers");
    panelMain.add(buttonRandomInput, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER,
        GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED,
        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    saveTheAnswerToButton = new JButton();
    saveTheAnswerToButton.setText("Save the answer to a file");
    panelMain.add(saveTheAnswerToButton,
        new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    buttonSaveInputInfoFile = new JButton();
    buttonSaveInputInfoFile.setHideActionText(false);
    buttonSaveInputInfoFile.setText("Save the array to a file");
    panelMain.add(buttonSaveInputInfoFile,
        new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER,
            GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return panelMain;
  }

  private void createUIComponents() {
    // TODO: place custom component creation code here
  }
}
