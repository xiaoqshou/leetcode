package test;

public class HeapSort {
	private void print(int[] array)
	{
		for(int i =0;i<array.length;i++)
		{
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	private void swap(int[] array ,int i , int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	private int getParentindex(int child)
	{
		return child/2+child%2-1;
	}
	private int getLChild(int parent)
	{
		
		return 2*parent+1;
	}
	private int getRChild(int parent)
	{
		return 2*parent+2;
	}
	private void genHeap(int[] array)
	{
		int size  = getParentindex(array.length-1);
		for(int i = size;i>=0;i--)
		{
			maxHeap(array,array.length,i);
		}
	}
	/** 
	* @Title: maxHeap 
	* @Description: 堆排序动态调整过程， 从下标为index的数组到下标为heapSize-1的数组进行动态调整
	* @param  array 待排序序列
	* @param  heapSize 数组中参加堆排序的个数
	* @param  index 数组总参加堆排序的起始序号
	* @return void   
	* @throws 
	* @author illy
	* @date Sep 14, 2014 3:09:28 PM 
	*/
	private void maxHeap(int[] array, int heapSize, int index)
	{
		int left = getLChild(index);
		int right = getRChild(index);
		int largest = index;
		if(left<heapSize&&array[index]<array[left])
		{
			largest = left;
		}
		if(right<heapSize&&array[largest]<array[right])
		{
			largest = right;
		}
		//通过判断最大值是父亲与双子节点中的哪一个，如果发生变动，则将最大值与父节点交换位置，交换后，根据堆的性质，被调下来的作为子节点的父节点，其现在的子节点可能不是最大堆了，需要重新调整。
		if(largest!=index)
		{
			swap(array,index,largest);
			maxHeap(array,heapSize,largest);
		}
	}
	private void heapSort(int[] array)
	{
		for(int i = array.length-1;i>0;i--)
		{
			swap(array,i,0);
			maxHeap(array,i,0);
			print(array);
		}
	}
	public static void main(String[] args) {
		int[] test = new int[]{1,3,4,2,6,2,8,9,5,2,1};
		HeapSort hs = new HeapSort();
		hs.genHeap(test);
		hs.heapSort(test);
		hs.print(test);
		
	}
	
}
