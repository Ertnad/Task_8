package ru.vsu.sc.tretyakov_d_s;

public class CmdArgs {

  public static class CmdParams {
    public String inputFile;
    public String outputFile;
    public boolean window;
    public boolean error;
    public boolean help;
  }

  public static CmdParams parseArgs(String[] args) {
    CmdParams params = new CmdParams();

    if (args.length > 0) {
      if (args[0].equals("--help")) {
        params.help = true;
        return params;
      }

      if (args[0].equals("--window")) {
        params.window = true;
        return params;
      }

      params.inputFile = args[0];
      if (args.length > 1) {
        params.outputFile = args[1];
        return params;
      } else {
        params.outputFile = null;
      }
    } else {
      params.help = true;
      params.error = true;
    }

    return params;
  }

}
