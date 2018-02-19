import java.util.Scanner;
public class ImplementationSelfBalancingBST {
	public static void main(String []args) {
		Scanner input=new Scanner(System.in);
		SbBst b = new SbBst();
		while(true) {
			System.out.println("Enter your choice\n"
					+ "1. Insert\n"
					+ "2. Delete(Not implemented)"
					+ "\n3. Search"
					+ "\n4. Check Empty"
					+ "\n5. Count Nodes"
					+ "\n6. Clear tree"
					);
			switch(input.nextInt()) {
			case 1:
				System.out.println("Enter element to be inserted");
				b.Insert(input.nextInt());
				break;
			case 2:
				System.out.println("Enter element to be Deleted");
				b.Delete(input.nextInt());
				break;
			case 3:
				System.out.println("Enter element to be searched");
				boolean a=b.search(input.nextInt());
				System.out.println("Found status:"+a);				
				break;
				
			case 4:
				System.out.println("Empty status"+b.isEmpty());
				break;
			case 5:
				System.out.println("Total Number of Nodes are:"+b.countNodes());
				break;
			case 6:
				b.clear();
				break;
			
			}
//			System.out.println("Inorder for tree");
			b.preOrder();
			System.out.println();
			
			
		}
	}
}
class SBNode{
	SBNode left,right;
	int data;
	int height;
	SBNode(int d){
		left=null;
		right=null;
		data=d;
		height=0;
	}
	SBNode(){
		left=null;
		right=null;
		data=0;
		height=0;
		
	}
	
}
class SbBst{
	SBNode root;
	SbBst(){
		root=null;
	}
	public boolean isEmpty() {
		if(root==null)
			return true;
		return false;
	}
	public int max(int a,int b)
	{
		return a>b?a:b;
	}
	public void clear() {
		root=null;
	}
	
	public int height(SBNode n) {
		return (n==null)?-1:n.height;
		
	}
	public void Insert(int d) {
		root=Insert(root,d);
	}
	private SBNode Insert(SBNode n,int d) {
		if(n==null)
			n=new SBNode(d);
		else if(d<n.data) {
			n.left=Insert(n.left,d);
			if(height(n.left)-height(n.right)==2) {
				if(d<n.left.data) 
					n=rotateleft(n);
				else 
					n=doubleRotateleft(n);
				
			}
		}
			else if(d>n.data) {
				n.right=Insert(n.right,d);
				if(height(n.right)-height(n.left)==2) {
					if(d>n.right.data) 
						n=rotateright(n);
					else if(d<n.right.data)
						n=doublerotateright(n);
					
				}
			}else {}
				n.height=max(height(n.left),height(n.right))+1;
				return n;
			}
	
	SBNode rotateleft(SBNode n) {
		SBNode n1=n.left;
		n.left=n1.right;
		n1.right=n;
		n.height=max(height(n.left),height(n.right))+1;
		n1.height=max(height(n1.left),height(n1.right))+1;
		return n1;
	}
	
	
	SBNode doubleRotateleft(SBNode n) {
		n.left=rotateright(n.left);
		return rotateleft(n);
	}
	SBNode rotateright(SBNode n) {

		SBNode n1=n.right;
		n.right=n1.left;
		n1.left=n;
		n.height=max(height(n.left),height(n.right))+1;
		n1.height=max(height(n1.left),height(n1.right))+1;
		return n1;
	}
	SBNode doublerotateright(SBNode n) {
	n.right=rotateleft(n.left);
	return rotateright(n);
	}
	void Inorder() {
		System.out.println("Inorder traversal for given BST");
		if(root==null)
			System.out.println("BST is empty");
		else
		Inorder(root);
	}
	private void Inorder(SBNode n) {
		if(n!=null) {
		Inorder(n.left);
		System.out.print(n.data+" ");
		Inorder(n.right);
		}
	
	}
	 void preOrder() {
		 System.out.println("PreOrder traversal for given BST");
		if(root==null)
			System.out.println("BST is empty");
		else
		 preOrder(root);
	}
	 private void preOrder(SBNode n) {
		 if(n!=null) {
			 System.out.print(n.data+" ");
			 preOrder(n.left);
			 preOrder(n.right);
			 
		 }
	 }
	 boolean search(int d) {
		 return search(root,d);
	 }
	 
	boolean search(SBNode n,int d) {
		if(n==null)
			return false;
		if(n.data==d)
			return true;
		if(d<n.data)
			return search(n.left,d);
		else 
			return search(n.right,d);
	}
	int countNodes() {
		return countNodes(root);
	}
	
	int countNodes(SBNode n) {
		if(n==null)
			return 0;
		return countNodes(n.left)+countNodes(n.right)+1;
		
		
	}
	
	public int getBalance(SBNode n) {
		return (height(n.left)-height(n.right));
	}
	
	
	public void Delete(int val) {
		if(root==null)
			System.out.println("BST is empty");
		else if(!search(val))
			System.out.println("No such element is present in BST");
		else {
			root=Delete(root,val);
			System.out.println("Element deleted");
		}
	}
	private  SBNode Delete(SBNode n,int val) {
		if(n==null)
			return n;
		if(val<n.data)
			n.left=Delete(n.left,val);
		else if(val>n.data)
			n.right=Delete(n.right,val);
		else {
			if(n.left==null && n.right==null) {
				n=null;
			}
			else if(n.left==null) {
				n=n.right;
			}else if(n.right==null) {
				n=n.left;
			}
			else {
				SBNode p=n.right;
				while(p.left!=null) {
					p=p.left;
				}
				n=p;
				n.right=Delete(n.right,p.data);
				
			}
		}
		n.height=max(height(n.left),height(n.right))+1;
		int balance=getBalance(n);
		if(balance==2) {
			if(height(n.left.left)>height(n.left.right))
				n=rotateleft(n);
			else
				n=doubleRotateleft(n);
			
		}else if(balance==-2) {
			if(height(n.right.left)>height(n.right.right))
				n=doublerotateright(n);
			else
				n=rotateright(n);
			
		}
		return n;
	}	
}





