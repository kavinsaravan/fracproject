package fracCalc;

// Checkpoint 1-only tests
public class FracCalcTestCheckpoint1
{
  public static void main(String[] args) {
    String[][] tests = {
      {"6_5/8", "whole:6 numerator:5 denominator:8", "12_3/8", "5_3/4 + 6_5/8"},
      {"20", "whole:20 numerator:0 denominator:1", "-20_3/7", "-3/7 - 20"},
      {"27/21", "whole:0 numerator:27 denominator:21", "-33_2/7", "-32 - 27/21"}
    };
    boolean passed = true;
    int counter = 1;
    for (String[] test: tests){
      boolean works = FracCalcTestALL.assertForEarlyCheckpoints(test[0],test[1],test[2],test[3]);
      if(!works){
        passed=false;
        System.out.println("\nTest #"+counter+": Failed\n\n");
        break;
      }
      System.out.println("Test #"+counter+": Passed\n\n");
      counter++;
    }
    if(passed) System.out.println("All Checkpoint 1 tests passed :)");
  }
}
