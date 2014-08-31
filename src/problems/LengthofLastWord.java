package problems;
/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.*/
public class LengthofLastWord {
	public int lengthOfLastWord(String s) {/*
		if(s.isEmpty())
			return 0;
		else
		{
				int num = 0;
				int result = 0;
				int last = s.length()-1;
				for(int i = 0;(i<s.length()&&(String.valueOf(s.charAt(last-i)).equals(" ")));i++)
						num = i+1;
				for(int i=num;(i<s.length()&&(!String.valueOf(s.charAt(last-i)).equals(" ")));i++)
					result = i+1-num;
				return result;
		}
	*/
		if(s.length()==0)
			return 0;
		else
		
		{
				String[] results = s.split(" ");
				if(results.length==0)
					return 0;
				return results[results.length-1].length();
		}
    	
	}
	public static void main(String[] args) {
		System.out.println(new LengthofLastWord().lengthOfLastWord(null));
	}
}
