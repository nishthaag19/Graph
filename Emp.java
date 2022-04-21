import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Emp {
    private int id;
    private String name;
    private int sal;
    Map<Emp, LinkedList<Emp>> gmap;
    static ArrayList<Emp> a;

    public Emp() {
        gmap = new HashMap<>();
    }

    public Emp(int id, String name, int sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Emp gmap= new Emp();
        Emp e1 = new Emp(1, "a", 1000);
        Emp e2 = new Emp(2, "b", 2000);
        Emp e3 = new Emp(3, "c", 3000);
        Emp e4 = new Emp(4, "d", 4000);
        gmap.addEdge(e1,e2,true);
        gmap.addEdge(e1,e3,true);
        gmap.addEdge(e1,e4,true);
        gmap.addEdge(e3,e4,true);
        gmap.addEdge(e2,e4,true);
        gmap.print();

       int arr[][]= new int[4][4];
        a= new ArrayList<>();
        a.add(e1);
        a.add(e2);
        a.add(e3);
        a.add(e4);

        addMatrix(arr,e1,e2,true);
        addMatrix(arr,e1,e3,true);
        addMatrix(arr,e1,e4,true);
        addMatrix(arr,e3,e4,true);
        addMatrix(arr,e2,e4,true);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; i < arr[j].length; i++) {
                System.out.print(arr[i][j] + "   ");
            }
        }

    }
    static public void addMatrix(int arr[][],Emp v1, Emp v2, boolean isBiDirectional) {
       arr[a.indexOf(v1)][a.indexOf(v2)]= 1;
       arr[a.indexOf(v2)][a.indexOf(v1)]= 1;

    }
    public void addEdge(Emp v1, Emp v2, boolean isBiDirectional) {
        LinkedList<Emp> V1neighbour = gmap.getOrDefault(v1, new LinkedList<>());
        V1neighbour.add(v2);
        gmap.put(v1, V1neighbour);
        if (isBiDirectional) {
            LinkedList<Emp> V2neighbour = gmap.getOrDefault(v2, new LinkedList<>());
            V2neighbour.add(v1);
            gmap.put(v2,V2neighbour);
        }
    }
        public void print() {
            for (Map.Entry<Emp,LinkedList<Emp>> res : gmap.entrySet()) {
                System.out.println(res.getKey() + " " + res.getValue());
            }
        }

}
