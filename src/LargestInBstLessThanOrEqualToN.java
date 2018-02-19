import java.util.Scanner;
public final class LargestInBstLessThanOrEqualToN {
	static int max2=Integer.MIN_VALUE;
	
	public static void main(String []args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter number of nodes");
		int n=input.nextInt();
		Bst b= new Bst();
		for(int i=0;i<n;i++) 
			b.Insert(input.nextInt());
		System.out.println("Enter element to find relative to");
		findLargest(b.root,input.nextInt());
		
	}
	static void findLargest(Node n,int val) {
		if(n==null)
			return;
		findLargest(n.left,val);
		if(val>=n.data) {
			max2=n.data;
		}
		else {
			if(max2==Integer.MIN_VALUE) 
				System.out.println("No element present in BST");
			else System.out.println("Such element is:"+max2);
		System.exit(0);
		}
		findLargest(n.right,val);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
