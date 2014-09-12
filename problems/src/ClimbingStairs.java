package problems;

public class ClimbingStairs { 
    public int climbStairs(int n) {
    	int n1 =1,n2=1,sn=0;
    	if(n<=3)
    		return n;
    	else
    	{
    		for(int i = 0;i<n-3;i++)
    		{
    			sn = n1 + n2;  
        		n1 = n2;
        		n2 = sn;  
    		} 
    		return n1+2*n2;
    	}
        
    }
    public static void main(String[] args) {
		ClimbingStairs test = new ClimbingStairs();
		System.out.println(test.climbStairs(1));
		System.out.println(test.climbStairs(2));
		System.out.println(test.climbStairs(3));
		System.out.println(test.climbStairs(4));
		System.out.println(test.climbStairs(5));
	}
}
