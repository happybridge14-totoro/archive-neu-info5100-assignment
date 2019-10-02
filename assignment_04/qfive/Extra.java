package qfive;

import java.util.Arrays;

class Extra {
    public int[] increaseDecrease(String input) {
        int iMin = 0;
        int length = input.length();
        int iMax = length;
        int[] ret = new int[iMax + 1];
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == 'I') {
                ret[i] = iMin++;
            } else {
                ret[i] = iMax--;
            }
        }
        ret[length] = iMax;
        return ret;
    }
    public static void main(String[] args) {
        Extra test = new Extra();
        int[] result  = test.increaseDecrease("IDID");
        System.out.println(Arrays.toString(result));
        result  = test.increaseDecrease("III");
        System.out.println(Arrays.toString(result));
        result  = test.increaseDecrease("DDI");
        System.out.println(Arrays.toString(result));
        result  = test.increaseDecrease("IIDDIDIDIID");
        System.out.println(Arrays.toString(result));
    }
}
