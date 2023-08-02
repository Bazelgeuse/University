class LinkedList2 {
	String data;
	LinkedList2 link;
}

class LinkedList3 {
	LinkedList2 head;
	LinkedList2 tail;
	
	public void print() {
		LinkedList2 temp = head;
	    while(temp != null) {
	        System.out.print(temp.data+" ");
	        temp = temp.link;
	    }
	    System.out.println();
	}
	
	public void addFirst(String n) {
		LinkedList2 newNode = new LinkedList2();
		newNode.data = n;
		newNode.link = null;
		if(head == null) {
			head=newNode;
		}
		else {
			newNode.link = head;
			head = newNode;
		}
	}
	
	public void addLast(String n) {
		LinkedList2 newNode = new LinkedList2();
		newNode.data = n;
		newNode.link = null;
		if(head == null) {
			head = newNode;
		}
		else {
			LinkedList2 temp = head;
			while(temp.link != null) {//��������带 ã��
		        temp = temp.link;
		    }
			temp.link=newNode;
		}
	}
	
	public void removeList(int x) {
		LinkedList2 p, q;
		int count = 1;
		if(head ==null) {
			return;
		}
		p = head; 
		q = null;
		while(count < x) {
			count++;
			q=p;
			p=p.link;
		}
		q.link = p.link;
	}
	
	public String removeLast() {
		String x = " ";
		LinkedList2 p,q;
		if(head == null) {
			return "No";
		}
		p = head;
		q = null;
		while(p.link != null) {
			q = p;
			p = p.link;
		}
		x = p.data;
		q.link=null; 
		return p.data;
	}
	
	public int countList() {
		int cnt = 0;
		LinkedList2 temp = head;
	    while(temp != null) {
	    	cnt++;
	    	temp = temp.link;
	    }
	    return cnt;
	}
	
	public void changeList(String x, String y) {
		LinkedList2 p;
		p = head;
		while(p != null) {
			if(p.data.equals(x)) {
				p.data = y;
			}
			p=p.link;
		}			
	}
}

public class LinkedListBasic {

	public static void main(String[] ar) {
		// list1 = ("Kim", "Lee", "Park")
		LinkedList2 list1, list2;
		LinkedList2 tmp, tail, p;
		tmp = new LinkedList2();
		tmp.data = "Kim";
		tmp.link = null;
		list1 = tmp; // �� ���� �ּҸ� list1�� ����. ���� list1�� ù��° ���Ұ� �����.
		// �ι�° ����
		tmp = new LinkedList2();
		tmp.data = "Lee";
		tmp.link = null;
		list1.link = tmp; // 2��° ���Ҹ� ���� ����
		// ����° ����
		tmp = new LinkedList2();
		tmp.data = "Park";
		tmp.link = null;
		list1.link.link = tmp;
		System.out.print("list1 = (");
		System.out.print(list1.data + ", ");
		System.out.print(list1.link.data + ", ");
		System.out.println(list1.link.link.data + ")");
		// 1. list2 = ("apple", "strawberry", "orange", "banana", "melon") ������.
		LinkedList3 temp = new LinkedList3();
		temp.addLast("apple");
		temp.addLast("strawberry");
		temp.addLast("orange");
		temp.addLast("banana");
		temp.addLast("melon");
		// ���ο� �����߰��϶�
		// 2. list2 = ("pineapple", "apple", "strawberry", "orange", "banana", "melon")
		// ������
		temp.addFirst("pineapple");
		// �ι�° ���Ҹ� �����϶�.
		temp.removeList(2);
		// 3. list2 = ("pineapple", "strawberry", "orange", "banana", "melon")
		// 4. list2�� ������ ������ ����Ͽ� ����϶�.
		System.out.println("������ ������ : " + temp.countList());
		// 5. list2�� �������� "durian"�� �߰��϶�
		temp.addLast("durian");
		// list2 = ("pineapple", "strawberry", "orange", "banana", "melon", "durian")
		// 6. list2�� ���������Ҹ� �����϶�
		temp.removeLast();
		// 7. ����° ������ "orange"�� "mango"�� �����϶�
		temp.changeList("orange", "mango");
		temp.print();
	}
}
