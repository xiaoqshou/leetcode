package illyAlgorithm;


public class SimpleTest {
	public int mutiple = 10;
	private int node1 = 1;
	private int node2 = 2;
	private int node3 = 3;
	private int node4 = 4;
	private int node5 = 5;
	public void setMuti(int muti)
	{
		this.mutiple = muti;
	}
	private int calcNodeVal(int node)
	{
		return node*mutiple;
	}
	/**
	 * 计算节点实际区间范围
	 */
	private void cal()
	{
		this.node1 = calcNodeVal(node1);
		this.node2 = calcNodeVal(node2);
		this.node3 = calcNodeVal(node3);
		this.node4 = calcNodeVal(node4);
		this.node5 = calcNodeVal(node5);
	}
	public void judgeArea(Individual iCase)
	{
		if((iCase.value>node5)||iCase.value<0)
			System.out.println("invalid");
		else
		{
			if(iCase.value>this.node3)
			{
				iCase.execPath.add(1);
				iCase.branches.add(6);
				if(iCase.value>this.node4)
				{
					iCase.execPath.add(1);
					iCase.branches.add(8);
				}
				else
				{
					iCase.execPath.add(0);
					iCase.branches.add(7);
				}
			}
			else if(iCase.value>this.node1)
			{
				iCase.execPath.add(1);
				iCase.branches.add(3);
				if(iCase.value>this.node2)
				{
					iCase.execPath.add(1);
					iCase.branches.add(5);
				}
				else
				{
					iCase.execPath.add(0);
					iCase.branches.add(4);
				}
			}
			else
			{
				iCase.execPath.add(0);
				iCase.branches.add(2);
			}
		}
	}
	public static void main(String[] args) {
		SimpleTest test = new SimpleTest();
		test.cal();
		/*int[] testNums = {5,15,25,35,45};
		for (int i : testNums) {
			test.judgeArea(i);
		}*/
	}
}
