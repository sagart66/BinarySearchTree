import java.util.Scanner;
public class CheckSameSetOfElements {
	static int val[];
	static int i=-1;
	static int j=-1;
	public static void main(String []args) {
	Scanner input=new Scanner(System.in);
	System.out.println("Enter Number of Nodes in BST1");
	int n=input.nextInt();
	val=new int[n];
	Bst b=new Bst();
	for(int i=0;i<n;i++)
		b.Insert(input.nextInt());
	System.out.println("Enter Number of Nodes in BST1");
	int n1=input.nextInt();
	Bst b1=new Bst();
	for(int i=0;i<n1;i++)
		b1.Insert(input.nextInt());
	if(n!=n1) {
		System.out.println("No");
	}else {
		inorder(b.root);
		Check(b1.root);
		System.out.println("Yes");
		
	}
	}
static void inorder(Node n) {
	if(n==null)
		return;
	inorder(n.left);
	val[++i]=n.data;
	inorder(n.right);
}
static void Check(Node n) {
	if(n==null)
		return;
	Check(n.left);
	if(val[++j]!=n.data) {
		System.out.println("No");
		System.exit(0);
		
	}
	Check(n.right);
			
}
	}
