package com.qa.javaAssessment;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {
		int a = -1;
		int b = -1;
		for (int i = 0; i< (input.length() - 3); i++) {
			String test = input.substring(i, i+4).toLowerCase();
			if (test.contentEquals("bert")) {
				if (a == -1) {
					a = i;
				} else {
					b = i;
				}
			}

		}
		String reverse = "";
		if (a > -1 && b > -1) {
			String word = input.substring(a+4, b);
			for (int i = word.length(); i > 0; i--) {
				reverse += word.substring(i-1, i);
			}
		}
		
		
		return reverse;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		int[] ints = {a, b, c};
		Arrays.parallelSort(ints);
		
		int d = ints[1] - ints[0];
		int e = ints[2] - ints[1];
		
		if (d == e) {
			return true;
		} 
		else {
		return false;
		}
	}	

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		int strip = (input.length() - a) / 2;
		String word = input.substring(0, strip);
		word += input.substring(strip + a, strip + a + strip);
		return word;
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		int count = 0;
		int max = 0;
		for (int i=1; i < input.length(); i++) {
			if (input.charAt(i) == input.charAt(i-1)) {
				count++;
				if (count > max) {
					max = count;
				}
			} else {
				count = 0;
			}
		}
		if (max > 0) {
			max++;
		}
		return max;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		int count = 0;
		for (int i=0; i < (input.length() - 1); i++) {
			if ((input.charAt(i) == "a" || input.charAt(i) == "A") &&
					(input.charAt(i+1) == "m" || input.charAt(i+1) == "M")) {
				if (i == 0 || input.charAt(i-1) == " ") {
					if (i > (input.length() - 2) || input.charAt(i+2) == " ") {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		String word = "";
		if (arg1 % 3 == 0) {
			word += "fizz";
		}
		if (arg1 % 5 == 0) {
			word += "buzz";
		}
		return word;
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		String[] nums = input.split(" ");
		int max = 0;
		for (String num : nums) {
			int count = 0;
			for (int i=0; i < num.length(); i++) {
				count += Character.getNumericValue(num.charAt(i));
			}
			if (count > max) {
				max = count;
			}
		}
		return max;
	}
}
