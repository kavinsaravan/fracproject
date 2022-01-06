package fracCalc;

public class FracCalcTestExtraCredit
{
    public static void main(String[] args) {
    String[][] tests = {
    {"-20/21", "1_2/3 + 5/4 + 5_5/4 - 2_2/4 / -5_6/3"},
    {"4", "1 + 3 + -3 - -3"},
    {"0", "12 * 18 * 18 * 0"},
    {"3_47/60", "20/8 + 3_1/3 - 4/5 - 5/4"},
    {"1", "12345 - 12345 + 12345 - 12345 + 1"},
    {"0", "0 * 0 / 1 / 4/6 / 2_3/4"},
    {"-1", "1/5 + 1/5 + 1/5 + 1/5 + 1/5 - 2"},
    {"0", "-4 + 1 + 1 + 1 + 1"},
    {"4_1/2", "16/4 / 3/2 * 3/2 + 1/2"},
    {"0", "12457 / -1 + 12457"},
    {"7", "5_3/4 - -6_8/8 - 5_3/4"},
    {"4", "2 * 3 - 6 + 1_1/2 + 1/2 - 1/2 - 1/2 + 3"},
    {"-4", "2 * 3 - 6 + -1_1/2 + -1/2 - -1/2 - -1/2 - 3"},
    {"4", "20 / 5 * -1 + 8"}
    };
    boolean passed = true;
    int counter = 1;
    for (String[] test: tests){
      boolean works=true;
      try {
          String produced = FracCalc.produceAnswer(test[1]);
          works = produced.equals(test[0]);
          if(!works) System.out.println("FAILURE: Your calculator's answer: '" + produced + "' when inputted '" + test[1]+ "' did not match the expected answer: '" + test[0]+"'");
        } catch (Exception e) {
          e.printStackTrace();
          works= false;
        }
      if(!works){
        passed=false;
        System.out.println("\nTest #"+counter+": Failed\n\n");
        break;
      }
      System.out.println("Test #"+counter+": Passed\n\n");
      counter++;
    }
    if(passed) System.out.println("All Extra Credit tests passed :)");
  }
}
