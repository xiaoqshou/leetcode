import java.util.Random;

public class QuickSort
{
	private int[] input;
	public static final Random RND = new Random();
	public QuickSort(int[] inpu)
	{
		input = inpu;
		quickSort(input);	
	}
	private void swap (int[] array, int i,int j)
	{
		int tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}
	private void print()
	{
		for(int i = 0;i<input.length;i++)
		{
			System.out.print(input[i]);
		}
	}
	private int partition(int[] array,int begin,int end)
	{
		int index = begin+RND.nextInt(end-begin+1);
		int pivot = array[index];
		swap(array,index,end);
		for(int i = index = begin;i<end;i++)
		{
			if(array[i]<pivot)
			{
				swap(array,index++,i);
			}
		}
		swap(array,index,end);
		print();
		System.out.println(" pivot:"+pivot);
		return index;	
	}
	public void sort(int[] array, int begin,int end)
	{
		if(begin<end)
		{
			int index = partition(array,begin,end);
			sort(array,begin,index-1);
			sort(array,index+1,end);
		}
	}
	public void quickSort(int[] input)
	{
		sort(input,0,input.length-1);
	}
	public static void main(String[] args)
	{
		int[] test = new int[]{7,9,2,4,6,5,1};
		new QuickSort(test);
	}
}
