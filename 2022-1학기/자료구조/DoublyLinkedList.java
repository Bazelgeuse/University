
class DListNode {
	String data;
	DListNode llink;
	DListNode rlink;

	public DListNode() {

	}

	public DListNode(String s) {
		data = s;
		llink = null;
		rlink = null;
	}
}

class DLinkedList {
	private DListNode head;

	public DLinkedList() { // ������

	}

	public void insertFirst(String s) {
		DListNode newNode = new DListNode(s);
		if (head == null) { // ���� ����Ʈ�� ����x
			head = newNode;
			return;
		} else {
			newNode.rlink = head;
			head = newNode;
		}
		head = newNode;

	}

	public void printList() {
		DListNode p;
		p = head;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.rlink;
		}
		System.out.println();
	}

	public void insertLast(String s) {
		DListNode newNode = new DListNode(s);
		DListNode p = head;
		if (head == null) { // ���� ���� x
			head = newNode;
		} else { // ���� ���� o
			while (p.rlink != null) {
				p = p.rlink;
			}
			p.rlink = newNode;
			newNode.llink = p;
		}
		return;
	}

	public String deleteLast() {
		String s;
		DListNode p, q;
		if (head == null) { // ���� ���� x
			return "������ ���Ұ� ����";
		} else { // ���� ���� o
			p = head;
			q = null;
			while (p.rlink != null) {
				q = p;
				p = p.rlink;
			}
			s = p.data;
			q.rlink = null;
			return s;
		}
	}

	public String deleteFirst() {
		String s;
		DListNode p, q;
		if (head == null) {
			return "������ ���Ұ� ����";
		}
		s = head.data;
		head = head.rlink;
		head.llink = null;
		return s;
	}

	public int finData(String s) {
		int cnt = 0;
		DListNode p = head;
		if (p.data.equals(s)) {
			return 1;
		}
		while (p.rlink != null) {
			cnt++;
			if (p.data.compareTo(s) == 0) {
				return cnt;
			}
			p = p.rlink;
		}
		return cnt;
	}

	public int listCount() {
		DListNode p = head;
		int num = 0;
		while(p != null) {
			num++;
			p=p.rlink;
		}
		
		return num;
	}
}

public class DoublyLinkedList {
	public static void main(String[] args) {
		DLinkedList list = new DLinkedList();

		list.insertFirst("Kim");
		list.insertFirst("Lee");
		list.insertFirst("Park");
		list.printList();
		list.insertLast("Choi");
		list.printList();
//		list.deleteLast();
//		list.deleteLast();
//		list.printList();
//		list.deleteFirst();
//		list.printList();

		System.out.println("������ ���� : " + list.listCount());
		list.printList();
	}
}
