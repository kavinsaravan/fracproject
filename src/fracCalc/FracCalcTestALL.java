package fracCalc;


public class FracCalcTestALL
{
    public static boolean assertForEarlyCheckpoints(String answer1, String answer2, String answer3, String input)
    {
      String candidate = "";
      try {
        candidate = FracCalc.produceAnswer(input);
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }

        if (candidate == null)
        {
            System.out.println("FAILURE: Your calculator returned a null string");
            return false;
        }
        
        // Candidate must match answer1, answer2, or must reduce to answer3
        if (answer1 != null && candidate.equals(answer1))
        {
            // Passed
            return true;
        }
        if (answer2 != null && candidate.equals(answer2))
        {
            // Passed
            return true;
        }
        if (answer3 != null && FracCalcTestHelper.areFracsEqual(answer3, candidate))
        {
            // Passed
            return true;
        }
        
        System.out.println("FAILURE: Your calculator's answer: '" + candidate + "' when inputted '" + input+ "' did not match the expected answer(s) below");
        if (answer1 != null)
        {
            System.out.println("Checkpoint 1: Expected: '" + answer1 + "'");
        }
        if (answer2 != null)
        {
            System.out.println("Checkpoint 2: Expected: '" + answer2 + "'");
        }
        if (answer3 != null)
        {
            System.out.println("Checkpoint 3: Expected any answer that is equivalent to: '" + answer3 + "'");
        }
        return false;
    }

}

