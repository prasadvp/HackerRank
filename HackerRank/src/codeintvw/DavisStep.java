package codeintvw;

import java.util.Scanner;

public class DavisStep {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(calcNum(n));
        }
        in.close();
    }
    
    public static int calcNum(int n) {
        
        if (n == 1) {
            return 1;
        }
        else if(n == 2) {
            return 2;
        }
        else if(n == 3) {
            return 4;
        }
        int[] array = new int[3];
        array[0] = 1;
        array[1] = 2;
        array[2] = 4;
        for (int i = 3; i < n; i++) {
            array[i%3] = array[0] + array[1] + array[2];
        }
        int index = (n%3==0)? array.length-1:n%3-1;
        return array[index];
    }
}

