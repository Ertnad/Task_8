package ru.vsu.sc.tretyakov_d_s;


import java.io.FileNotFoundException;
import java.io.PrintStream;
import ru.vsu.sc.tretyakov_d_s.Solution.Solution;
import ru.vsu.sc.tretyakov_d_s.Utils.ArrayUtils;

public class ConsoleMain {

  public static void main(String[] args) throws Exception {

    CmdArgs.CmdParams params = CmdArgs.parseArgs(args);

    if (params.help) {
      printHelp(params.error);
      System.exit(params.error ? 1 : 0);
    } else if (params.window) {
      GuiMain.main(args);
    } else {
      boolean isArraySequence = executeCheck(params);
      printIsArraySequence(isArraySequence, params);
    }
  }

  private static void printHelp(boolean error) {
    PrintStream out = error ? System.err : System.out;
    out.println("Usage: ");
    out.println("  <cmd> args <input-file> (<output-file>)");
    out.println("  <cmd> --help");
    out.println("  <cmd> --window  // show window");
  }

  private static boolean executeCheck(CmdArgs.CmdParams params) {
    int[][] array = ArrayUtils.readIntArray2FromFile(params.inputFile);

    if (array == null) {
      System.err.printf("Can't read array from \"%s\"%n", params.inputFile);
      System.exit(2);
    }

    Solution checking = new Solution();
    return checking.checkArrayForSequence(array);
  }

  private static void printIsArraySequence(boolean isArraySequence, CmdArgs.CmdParams params)
      throws FileNotFoundException {
    PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile) : System.out;
    out.println("The array is an ordered sequence: " + isArraySequence);
    out.close();
  }
}