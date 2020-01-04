package com.vp;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoStringsSolution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
    	boolean isFound = false;
    	
    	//Better solution:

    	for(char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()){
    		if(s1.indexOf(c) > -1 && s2.indexOf(c) > -1){
    			isFound = true;
    			break;
    		}
    	}
    /*
     * VP Solution 
    	Map<String,Integer> stringMap = new HashMap<>();
    	for(char ch: s1.toCharArray()){
    		stringMap.put(String.valueOf(ch),1);
    	}
    	//isFound = Stream.of(s2.toCharArray()).anyMatch(k->s1.contains(k.toString()));
    	for(char ch: s2.toCharArray()){
    		if(stringMap.get(String.valueOf(ch))!=null){
    			isFound = true;
    			break;
    		}
    	}
    	*/
    	
    	return isFound?"YES":"NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
     //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
          /*  bufferedWriter.write(result);
            bufferedWriter.newLine();*/
        }

       // bufferedWriter.close();

        scanner.close();
    }
}

