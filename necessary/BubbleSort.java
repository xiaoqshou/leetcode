public class BubbleSort
{
	private int[] input;
	
	public BubbleSort(int[] in)
	{
		input = in;
	}
	private void print()
	{
		for(int i=0 ; i<input.length;i++)
				System.out.print(input[i]);
				System.out.println();
	}

	private void swap(int i,int j)
	{
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	public void bubbleSort()
	{
		for(int j = input.length ; j>1;j--)
		{
			for(int i = 0 ; i<j-1 ; i++)
			{
				if(input[i]>input[i+1])
					swap(i,i+1);
			}
			print();
		}
	}
	public int[] result()
	{
		return input;
	}

	public static void main(String[] args)
	{
		int[] test = new int[]{8,5,7,6,4,3,2,1};
		BubbleSort bs = new BubbleSort(test);
		bs.bubbleSort();	
	}	
}	
