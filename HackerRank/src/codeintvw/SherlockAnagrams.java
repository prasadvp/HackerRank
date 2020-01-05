package com.vp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    	int total = 0;
    	Map<String,Integer> stringMap = new HashMap<>();
    	for(int i =0;i<s.length();i++){
    		for(int j=i+1;j<=s.length();j++){
    			char[] substringAry = s.substring(i, j).toCharArray();
    			Arrays.sort(substringAry);
    			String substring = String.valueOf(substringAry);
    			int value = stringMap.getOrDefault(substring, 0);

    			total += value;

    			stringMap.put(substring, ++value);
    		}
    	}
    	return total;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

/*
//Complete the sherlockAndAnagrams function below.
static int sherlockAndAnagrams(String s) {
 HashMap<String, Integer> map = new HashMap<String, Integer>();

 // Keep track of how many anagrams we've seen
 int totalCount = 0;

 // Generate all substrings (N^2)
 for(int i = 0 ; i < s.length(); i++)
 {
     for(int j=i+1 ; j <= s.length(); j++)
     {
         String currentSubString = s.substring(i,j);

         // Sort all strings E.g. ab & ba both == ab now
         char[] chars = currentSubString.toCharArray();
         Arrays.sort(chars);
         currentSubString = String.valueOf(chars);

         // If sorted substring has been seen before
         if(map.containsKey(currentSubString)) 
         {
             // Check how many times we've seen it and add that amount to the count
             int value = map.get(currentSubString);
             totalCount=totalCount+value;

             // Increment the times we've seen the string
             map.put(currentSubString, value+1);
         } 
         else 
         {
             // Never seen it before = insert and set to 1 to indiciate we've now seen it
             map.put(currentSubString, 1);
         }
     }
 }
 return totalCount;
}
*/