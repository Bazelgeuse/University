class CNode {
	int data;
	CNode clink;
	public CNode(int x) {
		data=x;
	}
}

class CLinkedList {
	CNode head;
	public void addLast(int x) {
		CNode cnewNode = new CNode(x);
		if(head == null) {
			head=cnewNode;
			cnewNode.clink=head;
		}else {
			CNode p = head;
			do {
				p=p.clink;;
			}while(p.clink!=head);
			p.clink=cnewNode;
			cnewNode.clink=head;
		}
	}
	
	public void print() {
		CNode p = head;
		int cnt = 0;
		do {
			cnt++;
			System.out.print(" " + p.data);
			p=p.clink;
		}while(p != head);
		System.out.println("cnt = " + cnt);
	}
}


public class CircularLinkedList {
	public static void main(String[] args) {
		CLinkedList c = new CLinkedList();
		
		c.addLast(20);
		c.addLast(4);
		c.addLast(3);
		c.addLast(7);
		c.print();
	}
}
