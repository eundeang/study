package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    String name;
    List<Node> links;
    boolean visited;
    public Node(String name) {
        this.name = name;
        this.links = new LinkedList<>();
    }
    public void link(Node node) {
        links.add(node);
    }

    @Override
    public String toString() {
        return name;
    }

    public void visit(){
        visited = true;
    }
    public boolean isVisited(){
        return visited;
    }
}

public class BFS {
    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");

        a.link(b);
        a.link(d);
        b.link(a);
        b.link(c);
        b.link(e);
        c.link(b);
        c.link(d);
        d.link(a);
        d.link(c);
        d.link(e);
        e.link(b);
        e.link(d);

        // 도달하려는 값!
        Node target = e;

        //BFS
        //예약 목록은 QUEUE로!!
        Queue<Node> queue = new LinkedList<>();
        //큐에 a 예약 (a부터 시작~)
        queue.offer(a);

        while (!queue.isEmpty()) {
            //큐에서 하나를 꺼냄(비교 대상),
            Node n = queue.poll();
            // n을 방문함을 표시
            n.visit();
            System.out.println(""+n);
            // 이것이 우리가 찾고자 하는건지 확인, 찾았으면 끝
            if(n == target) {
                System.out.println("FOUND: "+n);
                break;
            }
            // 못찾았을때 n과 연결 되어 있는 노드를 Queue에 등록
            n.links.stream()
                    .filter(l -> !queue.contains(l) && !l.isVisited())
                    .forEach(queue::offer);

            /*
            위 스트림과 아래 for문은 동일하게 동작
            for (Node l: n.links) {
                if(l.isVisited()) ocontinue;
                if(queue.contains(l)) continue;
                queue.offer(l);
            }
             */

        }

    }
    static void dfs(int nowi, int nowj) {
        visited[nowi][nowj] = true;
        size++;

        for(int d=0;d<4;d++) {
            int next = nowi+di[d];
        }
    }
}
