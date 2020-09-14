import java.util.Arrays;

public class Decrypter {
    public int[] reversemanipulate (int[] integer) {
        int swap;

        int i;
        int remainder;
        int plusSeven;

        swap = integer[0];
        integer[0] = integer[2];
        integer[2] = swap;

        swap = integer[1];
        integer[1] = integer[3];
        integer[3] = swap;

        for (i = 0; i < 4; i++)
        {
            remainder = integer[i];

            if (remainder < 7)
            {
                plusSeven = remainder +10;
            }

            else
            {
                plusSeven = remainder;
            }

            integer[i] = plusSeven - 7;
        }

        return integer;

    }

    public String decrypt (String parameter){
        int i;

        String[] input = parameter.split("");


        int[] integer;
        integer = new int[4];



        String output;

        for (i = 0; i < 4; i++)
        {
            integer[i] = Integer.parseInt(input[i]);
        }

        integer = reversemanipulate(integer);

        output = Arrays.toString(integer).replace("[", "").replace("]", "").replace(",","").replace(" ", "");

        return output;
    }
}
