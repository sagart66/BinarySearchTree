//wrong output;

import java.util.Scanner;
public class TreeFromPreorderAndInorder {
  static int preorder[];
  static int inorder[];
  static Bst b=new Bst();
  	public static void main(String []args) {
  		Scanner input=new Scanner(System.in);
  		System.out.println("Enter number of nodes");
  		int n=input.nextInt();
  		preorder = new int[n];
  		inorder = new int[n];
  		//System.out.println("Enter Inorder");
  		for(int i=0;i<n;i++)
  			inorder[i]=input.nextInt();
  		
  		//System.out.println("Enter preorder");
  		for(int i=0;i<n;i++)
  			preorder[i]=input.nextInt();
  		printTree();
  		b.inorder();
  	}
  	static void printTree() {
  		b.root=printTree(0,8,-1);//preorder.length);
  	}
  	static Node printTree(int i,int j,int k) {
  		
  		if(i>j)
  			return null;
  		Node n=new Node(preorder[++k]);
  		
  		if(i==j) {
  			return n;
  		}
  		int l=preorder[k];
  		int q;
  		for( q=i;q<=j;q++) {
  			if(l==inorder[q]) {
  				//System.out.println(q);
  				break;
  			}
  		}
  		
  		
  				n.left=printTree(i,q-1,k);
  				n.right=printTree(q+1,j,k);
  				return n;
  				
  			
  				
  		} 
  	}

