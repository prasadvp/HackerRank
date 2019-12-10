package com.vp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	long numOfCharacters = 0;  
    	//Edge case: if  the string length is one and that is "a", return n
    	if(s!=null ){
    		if( s.length() == 1){
    			if(COMPARE_STRING.equalsIgnoreCase(s)){
    				numOfCharacters = n;
        		}
    		}
    		else{
    			numOfCharacters = calculateNumOfCharacters(s, n);
    	    	
    		}
    	}
    	
    	return numOfCharacters;

    }

	private static long calculateNumOfCharacters(String s, long n) {
		/* For String length > 1
		 * 	Loop through the string and find the # of a, construct hash map/set with positions
		 *  Calculate  n / s.length. Multiply the value by # of a
		 *  Calculate n % s.length. Loop through index from 1 until the values reaches the Mod value. 
		 *  Query the hash map and add to value in second step*/
		int index= 0;
		int numberOfA= 0;
		Map<Integer,Integer> posValueMap = new HashMap<>();
		char[] inputText = s.toCharArray();
		long numOfCharacters = 0;
		while(index < inputText.length){
			if('a' == inputText[index]){
				numberOfA++;
				posValueMap.put(index+1, 1);
			}
			index++;
		}
		if(numberOfA > 0){
			numOfCharacters = (n/s.length())*numberOfA;		
			long remainingChars = n %s.length();			
			index=1;
			while(index<=remainingChars ){
				numOfCharacters += posValueMap.get(index)!=null?posValueMap.get(index):0;
				index++;
			}
		}
		return numOfCharacters;
	}
    private static final Scanner scanner = new Scanner(System.in);
    private static final String COMPARE_STRING = "a";

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = "aba";

        long n = 10;
       // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println(result);
/*        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        numberList.forEach(System.out::println);*/
/*
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}

