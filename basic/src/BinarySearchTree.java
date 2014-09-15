package test;

public class BinarySearchTree {
	public static void main(String[] args) {
		BSTree bst = new BSTree();
//		Node node1 = new Node(5);
//		Node node2 = new Node(6);
//		Node node3 = new Node(7);
//		bst.setRoot(new Node(7));
//		bst.insertRe(node3,node1);
//		bst.insertRe(node3,node2);
		bst.insert(3);
		bst.insert(1);
		bst.insert(5);
		bst.insert(2);
		bst.insert(4);
		bst.insert(6);
		bst.preTraversal(bst.root);
		System.out.println();
		bst.midTraversal(bst.root);
		System.out.println();
		bst.postTraversal(bst.root);
		System.out.println();
		System.out.println(bst.getMaxNode(bst.root).value);
		System.out.println(bst.getMinNode(bst.root).value);
	}
}

/**
 * @ClassName:Node
 * @Description node
 * @author illy
 * @date Sep 15, 2014 2:39:52 PM
 */
class Node
{
	public int id;
	public int value;
	public Node lChild;
	public Node rChild;
	public Node(int value)
	{
		this.value = value;
	}
}
class BSTree
{
	public Node root;
	public Node find(int key)
	{
		Node current = root;
		while(current.value != key)
		{
			if(current.value>key)
				current = current.rChild;
			else
				current = current.lChild;
			if(current == null)
				return null;
		}
		return current;
	}
	
	public void setRoot(Node node) {
		// TODO Auto-generated method stub
		this.root = node;
	}

	/** 
	* @Title: insert 
	* @Description: 递归插入  需要确定其根节点 两个参数
	* @param  root
	* @param  leaf
	* @return void   
	* @throws 
	* @author illy
	* @date Sep 15, 2014 4:58:38 PM 
	*/
	public void insertRe(Node root ,Node leaf)
	{
		if(this.root == null)
		{
			this.root =root;
		}
		if(root == null)
		{
			root = leaf;
			return;
		}
		if(root.value<leaf.value)
		{
			if(root.rChild == null)
				root.rChild = leaf;
			else
				insertRe(root.rChild,leaf);
		}
		if(root.value>leaf.value)
		{
			if(root.lChild == null)
				root.lChild =leaf;
			else
				insertRe(root.lChild,leaf);
		}
	}
	/** 
	* @Title: insert 
	* @Description: 非递归插入 
	* @param @param leaf
	* @return void   
	* @throws 
	* @author illy
	* @date Sep 15, 2014 5:08:49 PM 
	*/
	public void insert(int i)
	{
		Node leaf = new Node(i);
		if(this.root == null)
		{
			this.root = leaf;
		}
		else{
			Node current = this.root; 
			Node parent;
			while(true)
			{
				parent = current;
				if(leaf.value<current.value)
				{
					current = current.lChild;
					if(current == null)
					{
						parent.lChild = leaf;
						return;
					}
				}
				else
				{
					current = current.rChild;
					if(current == null)
					{
						parent.rChild = leaf;
						return;
					}
				}
			}
		}
	}
	public void delete(int id)
	{
		
	}
	//递归前序
	public void preTraversal(Node root)
	{
		if(root != null)
		{
			System.out.print(root.value+" ");
			preTraversal(root.lChild);
			preTraversal(root.rChild);
		}
	}
	//递归中序
	public void midTraversal(Node root)
	{
		if(root != null)
		{
			preTraversal(root.lChild);
			System.out.print(root.value+" ");
			preTraversal(root.rChild);
		}
	}
	//递归后序
	public void postTraversal(Node root)
	{
		if(root!= null)
		{
			postTraversal(root.lChild);
			postTraversal(root.rChild);
			System.out.print(root.value+" ");
		}
	}
	public Node getMinNode(Node root)
	{
		if(root == null)
			return null;
		while(root.lChild != null)
			root = root.lChild;
		return root;
	}
	public Node getMaxNode(Node root)
	{
		if(root == null)
			return null;
		while(root.rChild != null)
			root = root.rChild;
		return root;
	}
	
}