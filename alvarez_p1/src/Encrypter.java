import java.util.Arrays;

public class Encrypter {
    public int[] manipulate (int[] integer) {
        int i;

        int plusSeven;
        int remainder;

        int swap;
        for (i = 0; i < 4; i++)
        {
            plusSeven = integer[i] +7;
            remainder = plusSeven % 10;
            integer[i] = remainder;
        }

        swap = integer[0];
        integer[0] = integer [2];
        integer[2] = swap;

        swap = integer[1];
        integer[1] = integer[3];
        integer[3] = swap;

        return integer;

    }

    public String encrypt (String parameter) {
        String[] input = parameter.split("");

        int[] integer;
        integer = new int[4];

        int i;

        String output;

        for (i = 0; i < 4; i++)
        {
            integer[i] = Integer.parseInt(input[i]);
        }

        integer = manipulate(integer);

        output = Arrays.toString(integer).replace("[", "").replace("]", "").replace(",","").replace(" ", "");

        return output;
    }
}
