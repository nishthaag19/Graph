import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BfsSSSP {
   Map<Integer,LinkedList<Integer>>  gmap;

   public BfsSSSP(){
       gmap=new HashMap<>();
   }

   public static void main(String[] args) {
        BfsSSSP gmap=new BfsSSSP();
        gmap.addEdge(10,20,true);
        gmap.addEdge(10,30,true);
        gmap.addEdge(20,40,true);
        gmap.addEdge(30,40,true);
        gmap.addEdge(30,50,true);
        gmap.addEdge(50,60,true);
        gmap.print();
       System.out.println("bfs traversal :");
        gmap.bfsTraversal(10);
       System.out.println();
        gmap.shortPath(40,60);

    }

    // to add edges
    public void addEdge(int v1, int v2, boolean isBiDirectional){
        LinkedList<Integer> V1neighbour = gmap.getOrDefault(v1, new LinkedList<>());
        V1neighbour.add(v2);
        gmap.put(v1, V1neighbour);
        if(isBiDirectional){
            LinkedList<Integer> V2neighbour = gmap.getOrDefault(v2, new LinkedList<>());
            V2neighbour.add(v1);
            gmap.put(v2, V2neighbour);
        }
    }
    //bfs traversal
    public void bfsTraversal(int source){
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(source);
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(source);
        while(!bfs.isEmpty()){
            int front = bfs.poll();
            System.out.print(front+"   ");
            LinkedList<Integer> neighbourList = gmap.get(front);
            for(Integer i : neighbourList){
                if(!visited.contains(i)) {
                    bfs.add(i);
                    visited.add(i);
                }
            }
        }
    }
    //Single Source Shortest path using breadth first search.
    public void shortPath(int source , int des){
        Queue<Integer> bfs= new LinkedList<>();
        bfs.add(source);
        Map<Integer,Integer> dis= new HashMap<>();
        for(int i: gmap.keySet()) {
            dis.put(i, Integer.MAX_VALUE);
        }
        dis.put(source,0);
        while(!bfs.isEmpty()){
            int front = bfs.poll();
            LinkedList<Integer> adjList=gmap.get(front);
            for(int i : adjList){
                if(dis.get(i)==Integer.MAX_VALUE){
                    bfs.add(i);
                    int distance = dis.get(front)+1;
                    dis.put(i,distance);
                    if(i==des)
                        System.out.println(source+"   is  "+ distance+"  from  "+ i);
                }
            }

        }

    }

    public void print(){
        for(Map.Entry<Integer, LinkedList<Integer>> res : gmap.entrySet()){
            System.out.println(res.getKey() + " " + res.getValue());
        }
    }

}
