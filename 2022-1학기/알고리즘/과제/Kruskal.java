import java.util.ArrayList;
import java.util.Collections;
 
//Comparable 은 정렬을 위해서
class Edge2 implements Comparable<Edge2> {
    int v1;
    int v2;
    int cost;
 
    Edge2(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
 
    @Override
    public int compareTo(Edge2 o) {  // cost를 가지고 정렬을 하겠다고 기준을 만듬
        if (this.cost < o.cost) {
            return - 1;
        }
        else if (this.cost == o.cost) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
 
public class Kruskal {
    public static int[] parent;
    public static ArrayList<Edge2> Edge2List;
 
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
 
        if (x != y) {
            parent[y] = x;
        }
    }
 
    public static int find(int x) {  // 부모 노드 찾는 메소드
        if (parent[x] == x) {
            return x;
        }
 
        return parent[x] = find(parent[x]);
    }
 
    //same parent means cycle
    public static boolean isSameParent(int x, int y) {
        x = find(x);  // find 메소드를 통해서 부모 노드 번호를 리턴 받음
        y = find(y);
 
        if (x == y) {
            return true;
        }
        else {
            return false;
        }
    }
 
    public static void main(String[] args) {
        Edge2List = new ArrayList<Edge2>();
 
        Edge2List.add(new Edge2(0, 1, 5));
        Edge2List.add(new Edge2(3, 4, 1));
        Edge2List.add(new Edge2(3, 6, 2));
        Edge2List.add(new Edge2(3, 2, 3));
        Edge2List.add(new Edge2(6, 7, 3));
        Edge2List.add(new Edge2(5, 2, 3));
        Edge2List.add(new Edge2(1, 7, 4));
        Edge2List.add(new Edge2(1, 2, 4));
        Edge2List.add(new Edge2(1, 5, 4));
        Edge2List.add(new Edge2(0, 7, 5));
        Edge2List.add(new Edge2(5, 3, 6));
        Edge2List.add(new Edge2(0, 1, 8));  
        
 
        parent = new int[11];
 
        for (int i = 1; i <= 7; ++i) {
            parent[i] = i;
        }
 
        Collections.sort(Edge2List);// 간선들을 정렬
 
        int sum = 0;
        for (int i = 0; i < Edge2List.size(); ++i) {
            Edge2 Edge2 = Edge2List.get(i);
            if(!isSameParent(Edge2.v1, Edge2.v2)) {// no cycle
            	System.out.println(" "+Edge2.v1+" "+Edge2.v2);
                sum += Edge2.cost;
                union(Edge2.v1, Edge2.v2);
            }
        }
 
        System.out.println(sum);
    }
}
