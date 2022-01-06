package fracCalc;

// Checkpoint 3-only tests
public class FracCalcTestCheckpoint3
{
  public static void main(String[] args) {
    String[][] tests = {
     {null, null, "4_3/7", "1_1/7 + 3_2/7"},
    {null, null, "1", "2/3 + 1/3"},
    {null, null, "1021778", "124543 + 897235"},
    {null, null, "-1_1/4", "-3_3/4 + 2_2/4"},
    {null, null, "1_1/20", "4/5 + 2/8"},
    {null, null, "62_11/19", "0 + 34_543/19"},
    {null, null, "0", "4_1/2 - 4_1/2"},
    {null, null, "-1_1/4", "-3_3/4 - -2_2/4"},
    {null, null, "8_5/21", "-12_3/7 - -20_2/3"},
    {null, null, "3", "1_1/2 * 2"},
    {null, null, "378/943", "27/41 * 14/23"},
    {null, null, "164268", "234 * 702"},
    {null, null, "-8", "-12/3 * 2/1"},
    {null, null, "15_5/7", "-3_2/3 * -4_2/7"},
    {null, null, "0", "0 * 0"},
    {null, null, "0", "0 * 9321"},
    {null, null, "0", "0 * -5902"},
    {null, null, "1065_115/168", "-32_75/16 * -27_43/21"},
    {null, null, "-15_67/943", "1_27/41 * -3_140/23"},
    {null, null, "9/16", "3/4 / 4/3"},
    {null, null, "2_1/4", "3/2 / 2/3"},
    {null, null, "-2_6/7", "-20 / 7"},
    {null, null, "1_13/32", "-3_3/4 / -2_2/3"},
    {null, null, "0", "0 / 46/27"},
    {null, null, "0", "0/24 / 1/46"},
    {null, null, "-2_2/3", "16/4 / -3/2"},
    {null, null, "6_661/5520", "-38_3/72 / -4_82/37"}
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
    if(passed) System.out.println("All Checkpoint 3 tests passed :)");
  }
}
