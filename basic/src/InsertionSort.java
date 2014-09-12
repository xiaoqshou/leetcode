public class InsertionSort
{
	private int[] input;
	public InsertionSort(int[] in)
	{
		input = in;
	}
	
	private void print()
	{
		for(int i = 0 ; i<input.length;i++)
		{
			System.out.print(input[i]);
		}
		System.out.println();
	}

	private void sort()
	{
		int temp;
		for(int i = 1,j; i<input.length;i++)
		{
			temp = input[i];
			for(j = i;j>0;j--)
			{
				if(temp<input[j-1])
					input[j]=input[j-1];
				}
			input[j] = temp;
			print();
		}
	}
	
	public static void main(String[] args)
	{
		int[] test = new int[]{8,7,6,5,4,3,2,1};
		InsertionSort is = new InsertionSort(test);
		is.sort();
	}	
}
