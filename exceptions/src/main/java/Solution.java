import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created: 15/09/2016 6:23 AM.
 */
public
class Solution {
    public static
    void main(String[] args) throws Exception {

        try {
            Scanner  finput = new Scanner(System.in);
            String[] input  = new String[2];

            while (finput.hasNextLine()) {
                //finput.nextInt();
                input[0] = finput.nextLine();

                //System.out.println(input[0] + " " + input[0].length());

                if (finput.hasNextLine()) {
                    input[1] = finput.nextLine();
                    //System.out.println(input[1] + " " + input[1].length());
                } else {
                    throw new InputMismatchException();
                }
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
//                if (!("" + x).equals(input[0]) ||
//                    !("" + y).equals(input[1])) {
//                    throw new InputMismatchException();
//                }
                if (y == 0) {
                    throw new java.lang.ArithmeticException(" / by zero");
                }
                System.out.println(x/y);
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getClass().getName() + ":" + e.getMessage());
        } catch (NumberFormatException e) {
            InputMismatchException ime = new InputMismatchException(e.getMessage());
            System.out.println(ime.getClass().getName());
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
    }
}

