import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] supportedPhones = {"1,2,3,4,5", "6,7,8,4,5"};
        String sp1 = supportedPhones[0].toString();
        String sp2 = supportedPhones[1].toString();

        String[] data = new String[sp1.length()];
        int index = 0;
        for (String val1: sp1.split(",")){
            for (String val2 : sp2.split(",")){
                if(val1.contains(val2)){
                    data[index++] = val2;
                }
            }
        }

        System.out.println("data yang sama = "+Arrays.stream(data).filter(s -> s != null).collect(Collectors.joining(",")));
    }
}