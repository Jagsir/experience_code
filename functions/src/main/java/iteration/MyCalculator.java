package iteration;

import java.util.Scanner;

public
class MyCalculator {
    public static
    void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        while(in.hasNextInt()){
            int n = in.nextInt();
            int p = in.nextInt();
            MyCalculator mc = new MyCalculator();
            try {
                System.out.println(mc.power(n,p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    String power( final int n,
                  final int p) throws Exception {
        try {
            complainIfNegative(n);
            complainIfNegative(p);
        } catch (Exception e) {
            return e.getMessage();
        }
        if(n==0) {
            return ""+0;
        }

        int ret = 1;
        for(int i = 0; i < p; i++) {
            ret *=n;
        }
        return ""+ret;
    }

    private
    void complainIfNegative(final int n) throws Exception {
        if(n < 0) {
            throw new Exception("java.lang.Exception: n and p should be non-negative");
        }
    }
}