import java.io.*;
import java.text.MessageFormat;
import java.util.Date;

public class StringTest{

    public static void main( String[] args ){
        int           i  = 0;
        long          prev_time;
        long          time1;
        long          time2;
        MessageFormat mf = new MessageFormat("Blah %d Blah");

        for (int j = 0; j < 10; j++) {
            prev_time = System.currentTimeMillis();

            long length = 0;
            for( i = 0; i< 100000; i++){
                String s = "Blah" + i + "Blah";
                //length+=s.length();
            }
            time1 = System.currentTimeMillis() - prev_time;

            prev_time = System.currentTimeMillis();
            for( i = 0; i<100000; i++){
                String s = mf.format(new Object[] {i});
                //length+=s.length();
            }
            time2 = System.currentTimeMillis() - prev_time;

            System.out.printf("Time for | '+' loop: %2d | 'format' loop: %d\n", time1, time2);
        }
    }
}