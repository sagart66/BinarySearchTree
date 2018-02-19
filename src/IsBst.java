import java.util.Scanner;
public class IsBst {
	public static void main(String []args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter number of nodes");
		Bst b = new Bst();
		int n=input.nextInt();
		for(int i=0;i<n;i++)
			b.Insert(input.nextInt());
		b.inorder();
		System.out.println(isBst(b));
		b.root.data=10;
		b.inorder();//change as per your requirement
		System.out.println(isBst(b));
	}
	static boolean isBst(Bst b) {
		return isBst(b.root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	static boolean isBst(Node n,int min,int max) {
		if(n!=null) {
			if(n.data>min && n.data<max) {
				return isBst(n.left,min,n.data) && isBst(n.right,n.data,max);
				
			}else {
				return false;
			
			}
		}
		return true;
				
	}
	
}
