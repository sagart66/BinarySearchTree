import java.util.Scanner;
public class ImplementationBST {
	public static void main(String []args) {
		Scanner input=new Scanner(System.in);
		Bst a=new Bst();
		while(true) {
			System.out.println("Enter choice\n1. Insert\n2. delete\n3. Count Nodes \n4. Search element\n5. Check Empty");
	
			switch(input.nextInt()){
			case 1:
				System.out.println("Enter element to be inserted");
				a.Insert(input.nextInt());
				break;
			case 2:
				System.out.println("Enter element to be deleted");
				a.Delete(input.nextInt());
				break;
			case 3:
				System.out.println("Total number of nodes:"+a.countNode());
				
				break;
			case 4:
				System.out.println("Enter element to be searched");
				int p=input.nextInt();
				System.out.println("Found status:"+a.search(p));
				break;
			case 5:
				System.out.println("Empty status:"+a.isEmpty());
				break;
				
			}
			System.out.println("Inorder traversal for bst");
			a.inorder();
			a.z=0;
			System.out.println("Post order traversal of bst");
			a.postOrder();
			System.out.println();
		}
	}
}
class Node{
	public int data;
	public Node left;
	public Node right;
	Node(int d){
		data=d;
		left=null;
		right=null;
	}
	
}
class Bst{
	public static int z;
	public Node root;
	Bst(){

	root=null;	
	}
	Bst(Node node){
	root=node;
	}
	
	Bst(int d){
		root=new Node(d);
	}
	
	boolean isEmpty() {
		if(root==null)
			return true;
		return false;
	}
	
	
	void Insert(int data) {
		root=Insert(root,data);
	}
	
	Node Insert(Node node,int data) {
		if(node==null) {
			node=new Node(data);
			
		}
		else if(node.data>data) {
			node.left=Insert(node.left,data);
		}else if(node.data<data)
			node.right=Insert(node.right,data);
		
		return node;
	}
	
	int countNode() {
		return countNodes(root);
	}
	int countNodes(Node node) {
		if(node==null)
			return 0;
		int l=1;
		l+=countNodes(node.left);
		l+=countNodes(node.right);
		return l;
	}
	boolean search(int d) {
		return search(root,d);
	}
	boolean search(Node node,int data) {
		if(node!=null)
		{
		if(node.data==data)
			return true;
		if(node.data<data)
			return search(node.right,data);
		if(node.data>data)
			return search(node.right,data);
		}
		return false;
	}
	void Delete(int val) {
		
		if(isEmpty()) {
			System.out.println("BST is empty");
			
		}else if(!search(val)) {
			System.out.println("No such element in BST");
			
		}
		else {
		root=Delete(root,val);
		System.out.println("Element deleted");
		}
	}
	Node Delete(Node node,int data){
		if(node.data==data) {
		if(node.left==null && node.right==null) {
			node=null;
			return node;
		
		}
		else if(node.left!=null && node.right!=null) {
			Node temp=node.right;
			Node temp1=node.right;
			while(temp.left!=null) {
				temp1=temp;
				temp=temp.left;
			}
			temp1.left=null;
			node=temp;
			
			
		}
		else if(node.left!=null) {
			node=node.left;
		}
		else if(node.right!=null) {
			node=node.right;
		}
		return node;
		
		}
		 if(node.data<data) {
			node.right=Delete(node.right,data);
			
		}else{
			node.left=Delete(node.left,data);
		}
		 return node;
		
	}
	
	void preorder() {
		if(root==null)
			System.out.println("BST is empty");
		else
		preOrder(root);
	}
	void preOrder(Node node) {
		if(node==null)
			return;
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);	
	}
	void inorder() {
		if(root==null)
			System.out.println("BST is empty");
		else
		inOrder(root);
		System.out.println();
	}
	void inOrder(Node node) {
		if(node==null)
			return;
		inOrder(node.left);
		//this.z++;
		//if(z==4)
		System.out.print(node.data+" ");
		
		inOrder(node.right);
		
	}
	void postOrder() {
		if(root==null)
			System.out.println("BST is empty");
		else
		postOrder(root);
	}
	void postOrder(Node node) {
		if(node==null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
	}
	
	
	
	
}
