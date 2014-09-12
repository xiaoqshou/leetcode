package problems;

public class ReverseWordsinaString {
	public String reverseWords(String s) {
		String result = "";
		String[] words = s.split(" ");
		if (words.length == 0 || s.length() == 0)
			return "";
		for (int i = (words.length - 1); i >= 0; i--)
		{
			if(words[i].length()!=0)
				result = result + words[i] + " ";
		}
		StringBuffer sb = new StringBuffer(result);
		return sb.deleteCharAt(sb.length()-1).toString();
	}
	public static void main(String[] args) {
//		System.out.println(new ReverseWordsinaString().reverseWords(" "));
		String s = new ReverseWordsinaString().reverseWords("b  a");
		System.out.println(s+"=="+s.length());
//		System.out.println(new ReverseWordsinaString().reverseWords("ababaabab"));
	}
}
