package problems;

import java.util.Stack;

/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/
public class ValidParentheses {
    public boolean isValid(String s) {
    	Stack stack = new Stack(); 
    	char[] chars = s.toCharArray();
    	if(chars.length>0)
    	{
    		for(int i = 0;i<chars.length;i++)
    		{
    			if((chars[i]=='(')||(chars[i]=='{')||(chars[i]=='['))
    			{
    				stack.push(chars[i]);
    			}
    			else if((chars[i]==')')||(chars[i]=='}')||(chars[i]==']'))
    			{
    				if(stack.isEmpty())
    					return false;
    				int asc = (int)chars[i];
    				if((asc-2)<=(int)(char)stack.peek())
    					stack.pop();
    				else
    					return false;
    			}
    		}
    	}
    	return stack.isEmpty();
    }
    public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid("({}sdfs{d}))))f)"));
	}

}
