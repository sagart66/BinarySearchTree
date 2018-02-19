import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class LevelOrderAndReverseLevelOrderTraversal {
	public static void main(String []args) {
		Scanner input=new Scanner(System.in);
		Bst b = new Bst();
		System.out.println("Enter number of elements to be inserted");
		int n=input.nextInt();
		for(int i=0;i<n;i++)
			b.Insert(input.nextInt());
	//	LevelOrderTraversal(b);
		ReverseOrderTraversal2(b);
		
	}
	static void LevelOrderTraversal(Bst b) {
		Node n=b.root;
		Queue<Node> q=new LinkedList();
		q.add(n);
		Node x;
		while(n!=null && !q.isEmpty()) {
			x=q.remove();
			System.out.print(x.data+" ");
			if(x.left!=null)
				q.add(x.left);
			if(x.right!=null)
				q.add(x.right);
		}
	}
	//REVERSE LEVEL ORDER WITH ONE ARRAY AND KNOW NUMBER OF ELEMENTS IN TREE
	static void ReverseOrderTraversal1(Bst b,int n) {
		Node a[]=new Node[n];
		int i=0;
		int j=0;
		Node l;
		a[i]=b.root;
		while(j<n && i<n) {
			l=a[i];
			if(l.right!=null)
			a[++j]=l.right;
			if(l.left!=null && j<n)
			a[++j]=l.left;
			i++;
		}
		j=n-1;
		while(j>=0) {
			System.out.print(a[j--].data+" ");
		}
	}
//reverse order traversal with linked list;
	static void ReverseOrderTraversal2(Bst b) {
		LinkedList<Node> a=new LinkedList();
		int i=1;
		Node l=b.root;
		a.add(b.root);
		if(l.right!=null)
			a.add(l.right);
		if(l.left!=null)
			a.add(l.left);
		while(a.get(i)!=a.getLast()) {
			l=a.get(i);
			if(l.right!=null)
				a.add(l.right);
			if(l.left!=null)
				a.add(l.left);
			i++;
		}
		while(!a.isEmpty()) {
			System.out.print(a.removeLast().data+" ");
		}
		
	}	 
	
	
	
	
	
	
	
	
	
	
}
