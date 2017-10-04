import java.io.*;

public class Sequence_IO {
    public Sequence_IO(BufferedReader bufferedReader) {
        bufferedReader = null;
    }

    public byte [] readNumber(InputStream bufferedReader, int max_numbers) {
        try {
            char c;
            String s = "";
            do {
                c = (char) bufferedReader.read();
                if (c != '\n') {
                    s = s + Character.toString(c);
                }
            }
            while (c != '\n');
                try {
                    if (s.length() > max_numbers) {
                        System.err.println("Invalid length");
                        return null;
                    }
                    byte [] result=new byte[s.length()];
                    try {

                        for (int i = 0; i <s.length(); i++) {
                            result[i] = Byte.parseByte(Character.toString(s.charAt(i)));
                            if ((int) (s.charAt(i)) < 48 || (int) (s.charAt(i)) > 57) {
                                System.err.println("Invalid Digit");
                                return null;
                            }
                        }
                        return result;
                    }
                    catch (NumberFormatException nfe) {
                        System.err.println("Invalid Input Numbers");
                    }
                }
                catch (IndexOutOfBoundsException i_out_bounds) {
                    System.err.println("Invalid length of numbers");
                }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
