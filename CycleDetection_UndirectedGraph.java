import java.util.* ; 
public class CycleDetection_UndirectedGraph{
    public static void BuildGraph(ArrayList<Edge> graph[] , int v){
        for(int i= 0 ;i < v ; i++){
            graph[i] = new ArrayList<>() ; 
        }   
        graph[0].add(new Edge(0, 1, 2));
        graph[1].add(new Edge(1, 0, 2));

        graph[1].add(new Edge(1, 2, 3));
        graph[2].add(new Edge(2, 1, 3));

        graph[2].add(new Edge(2, 3, 5));
        graph[3].add(new Edge(3, 2, 5));
        
    }
    public static boolean cycleOnUDG(ArrayList<Edge> graph[] , int curr , int par , boolean vis[]){
        vis[curr] = true ; 
        boolean flag = false ; 
        for(int i = 0 ;i  < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i) ; 
            if(vis[e.dest] && e.dest ==  par)continue ; 
            if(!vis[e.dest]){
                flag |= cycleOnUDG(graph , e.dest , curr , vis) ; 
            }else return true ; 
            
        }
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
        System.out.println(cycleOnUDG(graph , 0 , -1 , vis)) ; 
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
