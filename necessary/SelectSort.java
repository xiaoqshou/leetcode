public class SelectSort
{
	int [] inArray;

	public SelectSort(int[] input)
	{
		inArray = input;
	}

	private void swap(int i,int j)
	{
		int temp = inArray[j];
		inArray[j] = inArray[i];
		inArray[i] = temp;
	}

	public void sort()
	{
		for(int i = 0 ; i<inArray.length; i++)
		{
			int minIndex = i;	
			for(int j = i+1; j<inArray.length;j++)
			{
				if(inArray[i]>inArray[j])
					minIndex = j;
			}
			swap(i,minIndex);
			print();
		}
	}
	private void print()
		{
			for(int i = 0 ;i<inArray.length;i++)
			{
				System.out.print(inArray[i]+" ");
			}
			System.out.println();
		}

	public static void main(String[] args)
	{
		int test[] =  new int[]{9,8,7,6,5,4,3,2,1,0};
		SelectSort ss = new SelectSort(test);
		ss.sort();
	}
}
