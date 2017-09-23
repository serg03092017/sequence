import java.io.*;
import java.lang.*;
public class Sequence_processing {
    public static void main (String args[]) {
        Sequence_IO num1 = new Sequence_IO(new BufferedReader(new InputStreamReader(System.in)));

            byte[] v = num1.readNumber(System.in, 50);
            for (int i = 0; i < v.length; i++) {
                System.out.print(v[i]);
            }
            if (v.length == 0) return;

            System.out.println();
            System.out.println("length=" + v.length);

            Sequence_first push = new Sequence_first(v);
    }
}
