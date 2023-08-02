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
			while(temp.link != null) {//마지막노드를 찾음
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
		list1 = tmp; // 찍어낸 빵의 주소를 list1에 저장. 드디어 list1에 첫번째 원소가 저장됨.
		// 두번째 원소
		tmp = new LinkedList2();
		tmp.data = "Lee";
		tmp.link = null;
		list1.link = tmp; // 2번째 원소를 끝에 연결
		// 세번째 원소
		tmp = new LinkedList2();
		tmp.data = "Park";
		tmp.link = null;
		list1.link.link = tmp;
		System.out.print("list1 = (");
		System.out.print(list1.data + ", ");
		System.out.print(list1.link.data + ", ");
		System.out.println(list1.link.link.data + ")");
		// 1. list2 = ("apple", "strawberry", "orange", "banana", "melon") 만들어라.
		LinkedList3 temp = new LinkedList3();
		temp.addLast("apple");
		temp.addLast("strawberry");
		temp.addLast("orange");
		temp.addLast("banana");
		temp.addLast("melon");
		// 선두에 원소추가하라
		// 2. list2 = ("pineapple", "apple", "strawberry", "orange", "banana", "melon")
		// 만들어라
		temp.addFirst("pineapple");
		// 두번째 원소를 제거하라.
		temp.removeList(2);
		// 3. list2 = ("pineapple", "strawberry", "orange", "banana", "melon")
		// 4. list2의 원소의 개수를 계산하여 출력하라.
		System.out.println("원소의 갯수는 : " + temp.countList());
		// 5. list2의 마지막에 "durian"을 추가하라
		temp.addLast("durian");
		// list2 = ("pineapple", "strawberry", "orange", "banana", "melon", "durian")
		// 6. list2의 마지막원소를 제거하라
		temp.removeLast();
		// 7. 세번째 원소인 "orange"를 "mango"로 변경하라
		temp.changeList("orange", "mango");
		temp.print();
	}
}
