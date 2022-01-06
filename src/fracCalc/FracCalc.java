package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) 
    {
      Scanner console = new Scanner(System.in);
        System.out.print("Give an equation: ");
        String input = console.nextLine();
        String secondOperand = produceAnswer(input);
        System.out.print(secondOperand);
        // TODO: Read the input from the user and call produceAnswer with an equation

    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)//do not alter this method header
    { 
      int lastSpace = input.lastIndexOf(" ");
        String last = input.substring(lastSpace + 1);
        last = reduce(last);

        int firstSpace = input.indexOf(" ");
        String first = input.substring(0, firstSpace);
        first = reduce(first);

        String firstWhole = "";
        if(first.contains("_")) {
            firstWhole = first.substring(0, first.indexOf('_'));
        } else {
            firstWhole = first;
        }
        String firstNumerator = "0";
        String firstDenominator = "1";
        if (first.contains("/")) {
            firstNumerator = first.substring(first.indexOf('_') + 1, first.indexOf('/'));
            firstDenominator = first.substring(first.indexOf('/') + 1,first.length());
        }
        String secondWhole = "";
        if(last.contains("_")) {
            secondWhole = last.substring(0, last.indexOf('_'));
        } else {
            secondWhole = last;
        }
        String secondNumerator = "0";
        String secondDenominator = "1";
        if (last.contains("/")) {
            secondNumerator = last.substring(last.indexOf('_') + 1, last.indexOf('/'));
            secondDenominator = last.substring(last.indexOf('/') + 1, last.length());
        }
        int firstNumer = getParsedInt(firstNumerator);
        int firstDenom = getParsedInt(firstDenominator);
        int firstWholeNum = getParsedInt(firstWhole);
        int firstNumber = (firstDenom * firstWholeNum) + firstNumer;
        int firstAnswer = firstWholeNum;
        if (firstNumer != 0 && firstDenom != 0) {
            firstAnswer = firstNumber / firstDenom;
        }

        int secondNumer = getParsedInt(secondNumerator);
        int secondDenom = getParsedInt(secondDenominator);
        int secondWholeNum = getParsedInt(secondWhole);
        int secondNumber = (secondDenom * secondWholeNum) + secondNumer;
        int secondAnswer = secondWholeNum;
        if (secondNumer != 0 && secondDenom != 0) {
            secondAnswer = secondNumber / secondDenom;
        }
        String finalAnswer = "";
        int otherNumer = 0;
        int otherDenom  = 0;
        int otherWhole = 0;
        if (first.equals("0")) {
            if(input.contains(" * ")) {
                finalAnswer = "0";
            } else {
                finalAnswer = last;
            }
        } else if (last.equals("0")) {
            if(input.contains(" * ")) {
                finalAnswer = "0";
            } else {
                finalAnswer = first;
            }
        } else {
            if(input.contains(" * ")) {
                otherNumer = ((firstWholeNum * firstDenom) + firstNumer) * ((secondWholeNum * secondDenom) + secondNumer);
                otherDenom = firstDenom * secondDenom;
                otherWhole = 0; 
            } else if(input.contains(" / ")) {
              int invNumerator = secondDenom;
              int invDenominator = (secondWholeNum * secondDenom) + secondNumber;
              otherNumer = ((firstWholeNum * firstDenom) + firstNumer) * ((0 * invDenominator) + invNumerator);
              otherDenom = firstDenom * invDenominator;
              otherWhole = 0;
            } else {
                if(input.contains(" - ")) {
                  if(firstDenom == secondDenom) {
                    otherNumer = firstNumer - secondNumer;
                    otherDenom = firstDenom;
                  } else {
                    otherDenom = firstDenom * secondDenom;
                    otherNumer = (firstNumer * secondDenom) - (secondNumer * firstDenom);
                  }
                  otherWhole = firstWholeNum - secondWholeNum;
                  if (otherNumer < 0 && otherWhole != 0) {
                        otherWhole--;
                        otherNumer = otherDenom + otherNumer;
                    }
                } else {
                    if(firstDenom == secondDenom) {
                      otherNumer = firstNumer + secondNumer;
                      otherDenom = firstDenom;
                    } else if (firstDenom > secondDenom && (firstDenom % secondDenom) == 0) {
                      otherNumer = firstNumer + (secondNumer * secondDenom);
                      otherDenom = firstDenom;
                    } else if (firstDenom < secondDenom && (secondDenom % firstDenom) == 0) {
                            otherNumer = secondNumer + (firstNumer * firstDenom);
                            otherDenom = secondDenom;
                    } else {
                        otherNumer = (firstNumer * secondDenom) + (secondNumer * firstDenom);
                        otherDenom = firstDenom * secondDenom;
                    }
                    otherWhole = firstWholeNum + secondWholeNum;
                }
            }
            if (otherWhole == 0) {
                finalAnswer = otherNumer + "/" + otherDenom;
            } else {
                finalAnswer = otherWhole + "_" + otherNumer + "/" + otherDenom;
            }
        }
        if(input.contains(" + ")) {
            return(reduce(finalAnswer));
        } else if(input.contains(" - ")) {
            return(reduce(finalAnswer));
        } else if(input.contains(" * ")) {
            return(reduce(finalAnswer));
        } else if(input.contains(" / ")) {
            return(reduce(finalAnswer));
        }
        return("Whole: " + secondWhole + "\nNumerator: " + secondNumerator + "\nDenominator: " + secondDenominator);
    }
    public static int getParsedInt(String number) {
        if (number.equals("")) {
            return 0;
        }
        if (number.indexOf("/") > -1) {
            return 0;
        }
        return Integer.parseInt(number);
    }
    public static String reduce(String number) {
        String numString = "";
        String denString = "";
        int wholeNumber = 0;
        if(number.contains("_")) {
            wholeNumber = getParsedInt(number.substring(0, number.indexOf('_')));
        } else {
            wholeNumber = getParsedInt(number);
        }
        String fracNumber = number.substring(number.indexOf('_') + 1);
        if (fracNumber.contains("/")) {
            numString = fracNumber.substring(0, fracNumber.indexOf('/'));
            int numerator = getParsedInt(numString);
            denString = fracNumber.substring(fracNumber.indexOf('/') + 1);
            int denominator = getParsedInt(denString);
            int remainder = 0;
            if (numerator == denominator && numerator > 0) {
                wholeNumber += 1;
                return String.valueOf(wholeNumber);
            } else if (numerator > denominator && denominator > 0) {
                if (wholeNumber >= 0) {
                    wholeNumber += (numerator / denominator);
                } else {
                    wholeNumber -= (numerator / denominator);
                }
                remainder = (numerator % denominator);
                if (remainder == 0) {
                    return String.valueOf(wholeNumber);
                } else {
                    if (wholeNumber == 0) {
                        return remainder + "/" + denominator;
                    } else {
                        return wholeNumber + "_" + remainder + "/" + denominator;
                    }
                }
            } else if (numerator != 0) {
                if ((denominator % numerator) == 0) {
                    denominator /= numerator;
                    numerator = 1;
                }
                if (wholeNumber == 0) {
                    return  numerator + "/" + denominator;
                } else {
                    return wholeNumber + "_" + numerator + "/" + denominator;
                }
            } else {
                return String.valueOf(wholeNumber);
            }
        } else {
            return number;
        }
        //return "";
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
