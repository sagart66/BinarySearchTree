/**
 * This file contains
 * 1. Iterative traversal preorder, inorder
 * postorder with one stack 
 * postorder with two stack
 * postorder() > with two stack
 * postOrder() > with one stack
 * */
import java.util.Scanner;
import java.util.Stack;
import java.util.Iterator;
public class IterativeTraversal {
	public static void main(String []args) {
		Scanner input=new Scanner(System.in);
		Bst b = new Bst();
		System.out.println("Enter number of elements to be inserted");
		int n=input.nextInt();
		System.out.println("Enter "+n+" numbers");
		for(int i=0;i<n;i++)
			b.Insert(input.nextInt());
		//inorder(b);
		//preorder(b);
		postOrder(b);
		System.out.println();
		b.postOrder();
		//b.inorder();
		//b.preorder();
	}
	static void preorder(Bst b) {
		Node n=b.root;
		Stack<Node> s=new Stack();
		while(n!=null) {
		
			while(n!=null) {
				System.out.print(n.data+" ");
				if(n.right!=null)
				s.push(n.right);
				n=n.left;
			}
			
			if(!s.isEmpty()) {
				n=s.pop();
				
				
			}

		}

	}
	//Iterative postorder using two stacks
	static void postorder(Bst b) {
		Stack<Node> s1=new Stack();
		Stack<Node> s2=new Stack();
		Node n=b.root;
		s1.push(n); 
		while(n!=null) {
			while(n!=null) {
				s2.push(n);
				if(n.right!=null)
					s1.push(n.right);
				if(n.left!=null)
					s1.push(n.left);
				n=n.left;
				
			}
			if(!s1.isEmpty() && !s2.isEmpty()) {
				while(!s1.isEmpty() && !s2.isEmpty() && s1.peek()==s2.peek())
				{
					s1.pop();
					System.out.print(s2.pop().data+" ");
				}
				if(!s1.empty())
				   n=s1.peek();
				else n=null;
			}else n=null;
		}
	}
	//Iterative post order using only one stack
	static void postOrder(Bst b) {
		Node n=b.root;
		Node  x;
		Node k=null;
		Stack<Node> s=new Stack();
		while(n!=null) {
		while(n.left!=null) {
			s.push(n);
			n=n.left;
	}
		s.push(n);
		if(!s.isEmpty())
		    x=s.peek();
		else x=null;
		while(x!=null && (x.right==null || x.right==k)) {
			System.out.print(x.data+" ");
			k=s.pop();
			if(!s.isEmpty())
			x=s.peek();
			else x=null;
			
		}
		if(x==null) return;
		if( x.right!=null) {
			n=x.right;
		}
		}
		
		
		}
	static void inorder(Bst b) {
		Node n=b.root;
		
		Stack<Node> s=new Stack();
		while(n!=null) {
			
		while(n!=null) {
			s.push(n);
			n=n.left;
			
		}
		
		while(!s.isEmpty()) {
			 n=s.pop();
			System.out.print(n.data+" ");
		}
		n=n.right;
		
		}
		
		
	}
	
}
