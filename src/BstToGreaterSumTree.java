import java.util.Scanner;
public class BstToGreaterSumTree {
static int total;
	public static void main(String []args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter number of elements to be inserted");
		int n=input.nextInt();
		Bst b=new Bst();
		for(int i=0;i<n;i++) {
			b.Insert(input.nextInt());
		}
		//b.preorder();
//		sum(b);//method1
	//	presum(b.root);//method1
		postsum(b.root);//method2
		b.preorder();
	}
	static void sum(Bst b) {
		sum(b.root);
		
	}
	static void sum(Node n) {
		if(n==null)
			return;
		total+=n.data;
		sum(n.left);
		sum(n.right);
	}
	static void presum(Node n) {
		if(n==null)
			return;
		presum(n.left);
		n.data=total-n.data;
		total=n.data;
		presum(n.right);
		
	}
	static void postsum(Node n) {
		if(n==null) return;
		postsum(n.right);
		total+=n.data;
		n.data=total-n.data;
		postsum(n.left);
	}
	
}
