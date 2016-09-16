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
            Scanner  fInput = new Scanner(System.in);

            while (fInput.hasNextLine()) {
                int x = fInput.nextInt();
                int y;
                if (fInput.hasNextLine()) {
                    y = fInput.nextInt();
                } else {
                    throw new InputMismatchException();
                }

                if (y == 0) {
                    throw new java.lang.ArithmeticException(": / by zero");
                }
                System.out.println(x/y);
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getClass().getName() + e.getMessage());
        } catch (NumberFormatException e) {
            InputMismatchException ime = new InputMismatchException(e.getMessage());
            System.out.println(ime.getClass().getName());
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
    }
}

