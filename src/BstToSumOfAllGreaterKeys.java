import java.util.Scanner;
public class BstToSumOfAllGreaterKeys {
	static int total;
	public static void main(String []args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter number of elements to be inserted");
		int n=input.nextInt();
		Bst b=new Bst();
		for(int i=0;i<n;i++) {
			b.Insert(input.nextInt());
		}
		b.preorder();
		update(b.root);
		b.preorder();
		
	}
	
	static void update(Node n) {
		if(n==null)
			return;
		update(n.right);
		total+=n.data;
		n.data=total;
		update(n.left);
		
		
		
	}
	
	
	
}
