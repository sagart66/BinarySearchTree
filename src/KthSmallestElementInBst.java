import java.util.Scanner;
public class KthSmallestElementInBst {
	static int val;
	public static void main(String []args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Number of Nodes");
		int n=input.nextInt();
		Bst b=new Bst();
		for(int i=0;i<n;i++)
			b.Insert(input.nextInt());
		System.out.println("Enter value of K");
		int k=input.nextInt();
		System.out.print("Kth smallest element is  ");
		ele(b.root,k);
		//b.inorder();
	
	}
	static void ele(Node node,int k) {
		if(node==null)
			return;
		ele(node.left,k);
		val++;
		if(val==k) {
			System.out.println(node.data);
		}
		ele(node.right,k);
	}
	
	
}
