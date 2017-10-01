public class Sequence_first {
    int i_before = 1;
    int i_after = 1;
    int i_compare = 1;
    int current_number_find;

    byte [] sequence_second_numbers;
    byte [] sequence_before=null;
    byte [] compare_sequence_array=null;
    boolean compare_result = false;

    public Sequence_first(byte[] v) {
        this.sequence_second_numbers = v;
        while (compare_result != true ) {
            if ( i_before>=99 ) return;
            generate_sequence_before_compare(sequence_second_numbers, sequence_before);
            compare_sequence(compare_sequence_array, sequence_second_numbers);
            if (compare_result == true) {System.out.println("index="+current_number_find); return;}
            else {generate_sequence_after_compare(sequence_second_numbers, compare_sequence_array);}
        }
    }

    public int get_Number_before(){
        return i_before;
    }
    public void set_Number_before (int number)
    {
        this.i_before=number;
    }
    public int get_Number_for_compare(){
        return i_compare;
    }
    public void set_Number_for_compare (int number)
    {
        this.i_compare=number;
    }
    public int get_Number_after(){
        return i_after;
    }
    public void set_Number_after (int number)
    {
        this.i_after=number;
    }

    public boolean compare_sequence (byte [] a, byte [] b){
        get_Number_for_compare();
        boolean result = true;
        for (int i=0; i<a.length-b.length+1; i++){
            result = true;
            for (int j=0; j<b.length; j++){

                if (b[j]!=a[j+i]) {
                    result=false;
                    break;
                }

            }
            if (result==true) {this.current_number_find=i+1;
                /*
                int number_in_sequence= i+1;
                int start_number = get_Number_for_compare();
                int index =0;
                while(index < number_in_sequence){
                    int digit_degree = 1;
                    int count_digit = 0;
                    while (start_number / digit_degree > 0) {
                        digit_degree *= 10;
                        count_digit++;
                        index = index+1;
                    }
                    start_number++;
                }
                current_number_find=start_number;
                break;
                */
                break;
            }
        }
        this.compare_result = result;
        return result;
    }

    public byte[] generate_sequence_before_compare(byte[] sequence_second_numbers, byte[] sequence_before){
        int i = get_Number_before();
        byte [] in_sequence = sequence_before;
        String s="";
        if (sequence_before==null) {}
        else {
            for (int count_in = 0; count_in < in_sequence.length; count_in++) {
                s = s + in_sequence[count_in];
            }
        }
        //if (s.length>=1000) return;
        while (s.length()<100) {

            int digit_degree = 1;
            int count_digit = 0;
            while (i / digit_degree > 0) {
                digit_degree *= 10;
                count_digit++;
            }
            if ((s.length() + count_digit >= 100)) {break;}
            else{
                while(digit_degree > 1){
                s = s + (i%digit_degree)/(digit_degree/10);
                digit_degree /= 10;
                }
            }
            i++;
        }

        byte [] compare_sequence_array=new byte[s.length()];
        for (int f=0; f<s.length(); f++){
            compare_sequence_array[f] = Byte.parseByte(Character.toString(s.charAt(f)));
        }
        this.compare_sequence_array=compare_sequence_array;
        set_Number_before(i);
        return compare_sequence_array;
    }

    public byte[] generate_sequence_after_compare (byte[] sequence_second_numbers, byte[] compare_sequence_array) {
        int i_after = get_Number_after();
        byte [] in_sequence = compare_sequence_array;
        String s="";
        if (compare_sequence_array == null) {}
        else {
            for (int count_in = 0; count_in < in_sequence.length; count_in++) {
                s = s + in_sequence[count_in];
            }
        }
        String s1=s;
        while (s1.length()>50){

            int digit_degree = 1;
            int count_digit = 0;
            while (i_after / digit_degree > 0) {
                digit_degree *= 10;
                count_digit++;
            }
            if ((s1.length() - count_digit < 50)) {break;}
            while(digit_degree > 1){
                s1=s1.substring(1,s1.length());
                digit_degree /= 10;
            }
            i_after++;

        }

        byte [] after_crop_sequence_array=new byte[s1.length()];
        for (int f=0; f<s1.length(); f++){
            after_crop_sequence_array[f] = Byte.parseByte(Character.toString(s1.charAt(f)));
        }
        this.sequence_before=after_crop_sequence_array;
        set_Number_after(i_after);
        set_Number_for_compare(i_after);
        return after_crop_sequence_array;
    }

}