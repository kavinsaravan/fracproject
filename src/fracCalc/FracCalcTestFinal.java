package fracCalc;
import java.util.*;

//Final fraccalc submission tests
public class FracCalcTestFinal
{
    public static void main(String[] args) {
    String[][] tests = {
    {"4_3/7", "1_1/7 + 3_2/7"},
    {"1_1/5", "3/5 + 3/5"},
    {"1_1/5", "4/5 + 2/5"},
    {"1/4", "1/8 + 1/8"},
    {"1", "2/5 + 3/5"},
    {"1", "2/3 + 1/3"},
    {"10", "3 + 7"},
    {"2", "1 + 1"},
    {"4", "1 + 3"},
    {"452", "452 + 0"},
    {"254", "0 + 254"},
    {"1021778", "124543 + 897235"},
    {"2/5", "3/5 + -1/5"},
    {"900", "978 + -78"},
    {"900", "-78 + 978"},
    {"-1_1/4", "-3_3/4 + 2_2/4"},
    {"-1_1/4", "2_2/4 + -3_3/4"},
    {"5_5/6", "20/8 + 3_1/3"},
    {"1_1/20", "4/5 + 2/8"},
    {"-9035", "-9035 + 0"},
    {"-64", "64 + -128"},
    {"-133", "-98 + -35"},
    {"62_11/19", "0 + 34_543/19"},
    {"-44_229/888", "-38_3/72 + -4_82/37"},
    {"1/5", "3/5 - 2/5"},
    {"0", "1/5 - 1/5"},
    {"0", "4_1/2 - 4_1/2"},
    {"4/5", "9/10 - 1/10"},
    {"1/5", "5/10 - 3/10"},
    {"0", "68591 - 68591"},
    {"7", "42 - 35"},
    {"-2/5", "2/5 - 4/5"},
    {"-7/8", "5_3/4 - 6_5/8"},
    {"-1_1/4", "-3_3/4 - -2_2/4"},
    {"-1_5/8", "4_1/2 - 5_9/8"},
    {"-1_1/8", "3_3/4 - 4_7/8"},
    {"-6_1/4", "-3_3/4 - 2_2/4"},
    {"-36891", "48623 - 85514"},
    {"-9284", "0 - 9284"},
    {"53/96", "75/32 - 43/24"},
    {"16_23/24", "75/4 - 43/24"},
    {"12_3/8", "5_3/4 - -6_5/8"},
    {"8_5/21", "-12_3/7 - -20_2/3"},
    {"-65_247/336", "-32_75/16 - 27_43/21"},
    {"3", "1_1/2 * 2"},
    {"6/25", "3/5 * 2/5"},
    {"164268", "234 * 702"},
    {"216", "12 * 18"},
    {"8", "12/3 * 2/1"},
    {"2", "16 * 1/8"},
    {"2", "3 * 2/3"},
    {"1_1/2", "6 * 1/4"},
    {"8994872", "1 * 8994872"},
    {"378/943", "27/41 * 14/23"},
    {"5_929/943", "1_27/41 * 3_14/23"},
    {"-8", "12/3 * -2/1"},
    {"-8", "-12/3 * 2/1"},
    {"8", "-12/3 * -2/1"},
    {"-15_5/7", "-3_2/3 * 4_2/7"},
    {"-15_5/7", "3_2/3 * -4_2/7"},
    {"15_5/7", "-3_2/3 * -4_2/7"},
    {"-842346", "1 * -842346"},
    {"-75421", "-1 * 75421"},
    {"37953", "-1 * -37953"},
    {"0", "0 * 4/5"},
    {"0", "0 * 0"},
    {"0", "0 * 9321"},
    {"0", "0 * -5902"},
    {"0", "146 * 0"},
    {"0", "3_25/26 * 0"},
    {"0", "-24_1/3 * 0"},
    {"1065_115/168", "-32_75/16 * -27_43/21"},
    {"-15_67/943", "1_27/41 * -3_140/23"},
    {"4_2/3", "3_2/4 * 4/3"},
    {"9/16", "3/4 / 4/3"},
    {"2_1/4", "3/2 / 2/3"},
    {"9457", "9457 / 1"},
    {"6/11", "6 / 11"},
    {"4/9", "4 / 9"},
    {"1", "23 / 23"},
    {"2_6/7", "20 / 7"},
    {"13/24", "1_1/12 / 2"},
    {"1", "3/4 / 3/4"},
    {"1_5/8", "-13 / -8"},
    {"-2803", "-2803 / 1"},
    {"-12457", "12457 / -1"},
    {"45236", "-45236 / -1"},
    {"-2_6/7", "-20 / 7"},
    {"1_13/32", "-3_3/4 / -2_2/3"},
    {"-1_13/32", "-3_3/4 / 2_2/3"},
    {"-1_13/32", "3_3/4 / -2_2/3"},
    {"0", "-0 / 98701"},
    {"0", "-0 / -98701"},
    {"0", "0 / -98701"},
    {"0", "0 / 37569"},
    {"0", "0 / 46/27"},
    {"0", "0/24 / 1/46"},
    {"0", "0/11 / 6/7"},
    {"2_2/3", "16/4 / 3/2"},
    {"-2_2/3", "16/4 / -3/2"},
    {"6_661/5520", "-38_3/72 / -4_82/37"},
    {"-5/21", "1_2/3 / -5_6/3"}
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
    if(passed) System.out.println("All Final tests passed :)");
  }
}
