public class MergeSort {
	private void print(int[] array)
	{
		for(int i = 0;i<array.length;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
	private int[] copy(int[] array,int begin,int end)
	{
		int[] list = new int[end-begin+1];
		for(int i = 0,j=begin ; j<end+1 ;j++)
		{
			list[i++] = array[j];
		}
		return list;
	}
	private int[] merge(int[] a ,int[] b)
	{
		int[] mer  = new int[a.length+b.length];
		int i = 0,j = 0,k=0;
		while((i<a.length)&&(j<b.length))
		{
			if(a[i]<=b[j])
			{
				mer[k++] = a[i];
				i++;
			}
			else
			{
				mer[k++] = b[j];
				j++;
			}
		}
		for(;i<a.length;i++)
			mer[k++]=a[i];
		for(;j<b.length;j++)
			mer[k++]=b[j];
		print(mer);
		return mer;
	}
	public int[] mergeSort(int[] array)
	{
		if(array.length>1)
		{
			int index = (array.length)/2;
			int[]a = copy(array,0,index-1);
			int[]b = copy(array,index,array.length-1);
			a = mergeSort(a);
			b = mergeSort(b);
			int[] mer = merge(a,b);
			return mer;
		}
		else
			return array;
	}
	public static void main(String[] args) {
		int[] test = new int[]{1,0,1,2,9,5,3,1};
		MergeSort ms = new MergeSort();
		ms.print(ms.mergeSort(test));
		
	}
}
