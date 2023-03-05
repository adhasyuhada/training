import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] sd = {"12345", "67845"};

            char[] ca = sd[0].toCharArray();
            char[] cb = sd[1].toCharArray();

            String[] index = new String[ca.length];
            int count = 0;
            for (int i = 0; i < ca.length; i++){
                if(ca[i] != cb[i]){
                    index[i] = ""+i;
                    count++;
                }
            }

        System.out.print("total caracter tidak sama adalah "+ count +". yaitu index "+ Arrays.stream(index).filter(s -> s != null ).collect(Collectors.joining(",")));
    }
}