import java.util.* ; 
public class BellMan_Ford_Algo{
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
    public static void bellmenFordAlgo(ArrayList<Edge> graph[] , int n){
        int dist[] = new int[n] ; 
        for(int i = 0 ;i < n ; i++){
            if(dist[i] != i) dist[i] = Integer.MAX_VALUE ; 
        }
        for(int i= 0 ; i < n -1 ; i ++){
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < graph[j].size() ; k++){
                    Edge e = graph[j].get(k) ; 
                    int u = e.sor ; 
                    int v = e.dest ; 
                    int wt = e.wt ; 
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt ; 
                    }
                }
            }
        }
        for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < graph[j].size() ; k++){
                    Edge e = graph[j].get(k) ; 
                    int u = e.sor ; 
                    int v = e.dest ; 
                    int wt = e.wt ; 
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                        System.out.println("Negative weight cycle in our graph") ; 
                        break ; 
                    }
                }
        }
        for(int i = 0 ;i < n ; i++){
            System.out.print(dist[i] + "  ") ; 
        }
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
        int v = 5 ; 
        ArrayList<Edge> graph[] = new ArrayList[v] ; 
        BuildGraph(graph , v) ;
        bellmenFordAlgo(graph , v); 
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
