
class ArrayBT {
	int count=0;
	int num=0;
	public void inorder(char[] T, int i) {
		//Left + Process +Right subtree
		if(T[i]!='\0') { 
			inorder(T, i*2); //left subtree
			System.out.print(" "+T[i]);
			inorder(T, i*2+1); //right subtree
		}
	}
	public void preorder(char[] T, int i) {
		if(T[i]!='\0') {
			System.out.print(" " + T[i]);
			preorder(T, i*2);
			preorder(T, i*2+1);
		}
	}
	public void postorder(char[] T, int i) {
		if(T[i]!='\0') {
			postorder(T, i*2);
			postorder(T, i*2+1);
			System.out.print(" " + T[i]);
		}
	}
	public int nodeCount(char[] T, int i) {
		if(T[i]!='\0') {
			num++;
			nodeCount(T,i*2);
			nodeCount(T,i*2+1);
		}
		return num;
	}
	public void descendents(char[] T, int i, int cnt) {
		if(T[i]!='\0') {
			if(cnt==0) {
				cnt++;
			}
			else {
				System.out.println(" " + T[i]);
			}
			descendents(T, i*2, cnt);
			descendents(T, i*2+1, cnt);
		}
		
	}
	public void ancestors(char[] T, int i) {
		if(T[i]>1) {
			System.out.print(" " + T[i/2]);
			ancestors(T, i/2);
		}
		
	}
	public void leafCount(char T[], int i) {
		if(T[i]!='\0') {
			if ((T[i*2]=='\0')&&(T[i*2+1]=='\0')){
				count++;
			}
			leafCount(T,i*2);
			leafCount(T,i*2+1);
		}
    }
}
public class BTMain{
	public static void main(String[] args) {
		
		ArrayBT tree1 = new ArrayBT();
		char T[]= new char[25];
		T[1]='a';
		T[2]='b';
		T[3]='c';
		T[4]='d';
		T[5]='e';
		T[6]='f';
		T[7]='g';
		T[8]='h';
		T[9]='i';
		T[10]='j';
		//T[11]='\0';
//		System.out.println(" inorder");
//		tree1.inorder(T, 1);
//		System.out.println();
//		System.out.println("end of inorder");

//		System.out.println(" preorder");
//		tree1.preorder(T, 1);
//		System.out.println();
//		System.out.println("end of preorder");
		
//		System.out.println(" postorder");
//		tree1.postorder(T, 1);
//		System.out.println();
//		System.out.println("end of postorder");
		
//		tree1.ancestors(T, 2);
//		tree1.descendents(T, 4, 0);
		
		System.out.println(tree1.nodeCount(T, 5));
		
//		tree1.leafCount(T,1);
//		System.out.println();
//		System.out.println(" number of leaves = "+tree1.count);
	}	
}

