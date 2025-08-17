import java.util.* ; 
public class DFS{
    public static void BuildGraph(ArrayList<Edge> graph[] , int v){
        for(int i= 0 ;i < v ; i++){
            graph[i] = new ArrayList<>() ; 
        }   
        graph[0].add(new Edge(0 , 1 , 2)) ; 
        graph[0].add(new Edge(0 , 4 , 21)) ; 
        graph[1].add(new Edge(1 , 2 , 12)) ; 
        graph[2].add(new Edge(2 , 3 , 52)) ; 
        graph[3].add(new Edge(3 , 4 , 222)) ; 
        
    }
    public static void dfs(ArrayList<Edge> graph[] , boolean vis[], int curr){
        vis[curr] = true ; 
        System.out.print(curr + " ") ; 
        for(int i = 0 ;i < graph[curr].size() ; i++){
            if(!vis[graph[curr].get(i).dest]) dfs(graph , vis , graph[curr].get(i).dest) ; 
        }
    }
    public static void main(String []args){
        //     2 
        // 0 ----> 1 
        // |       |12
        // |       |    52
     //  24|       2 ------> 3 
        // |                 |  222
        // |---------------->4
        Scanner sc = new Scanner(System.in) ; 
        int v = 5 ; 
        ArrayList<Edge> graph[] = new ArrayList[v] ; 
        BuildGraph(graph , v) ;
        boolean vis[] = new boolean[v] ; 
        dfs(graph , vis , 0) ; 
    }
}
class Edge{
    int sor ; 
    int dest ; 
    int wt ;  
    Edge(int sor , int dest , int wt){
        this.sor = sor ; 
        this.dest = dest; 
        this.wt = wt ; 
    }
}
