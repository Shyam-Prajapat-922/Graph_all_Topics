import java.util.* ; 
public class CycleDetection_DirectedGraph{
    public static void BuildGraph(ArrayList<Edge> graph[] , int v){
        for(int i= 0 ;i < v ; i++){
            graph[i] = new ArrayList<>() ; 
        }   
        graph[0].add(new Edge(0, 1, 2));
        graph[1].add(new Edge(1, 2, 3));
        graph[2].add(new Edge(2, 0, 4)); // back edge → cycle
        graph[2].add(new Edge(2, 3, 5));

        
    }
    public static boolean cycleOnDG(ArrayList<Edge> graph[] , int curr , boolean vis[]){
        vis[curr] = true ; 
        boolean flag = false ; 
        for(int i = 0 ;i  < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i) ; 
            if(vis[e.dest])return true ; 
            if(!vis[e.dest]){
                flag |= cycleOnDG(graph , e.dest , vis) ; 
            }
            
        }
        vis[curr] = false ; 
        return flag; 
        
    }
    public static void main(String []args){
        //     2 
        // 0 ----> 1 
        // |       |12
        // |       |    52
     //  21|       2 ------> 3 
        // |                 |  222
        // |---------------->4
        Scanner sc = new Scanner(System.in) ; 
        int v = 4 ; 
        ArrayList<Edge> graph[] = new ArrayList[v] ; 
        BuildGraph(graph , v) ;
        boolean vis[] = new boolean[v] ; 
        System.out.println(cycleOnDG(graph , 0 , vis)) ; 
    }
}
class Edge{
    int sor ; 
    int dest ; 
    int wt ; 
    Edge(int s, int d , int wt){
        this.sor = s ; 
        this.dest = d ; 
        this.wt = wt; 
    }
}
