import java.util.* ; 
public class Prims_Algo{
    public static void BuildGraph(ArrayList<Edge> graph[] , int v){
        for(int i= 0 ;i < v ; i++){
            graph[i] = new ArrayList<>() ; 
        }   
        graph[0].add(new Edge(0, 1, 2));
        graph[1].add(new Edge(1, 0, 2));

        graph[0].add(new Edge(0, 2, 6));
        graph[2].add(new Edge(2, 0, 6));

        graph[1].add(new Edge(1, 2, 3));
        graph[2].add(new Edge(2, 1, 3));

        graph[1].add(new Edge(1, 3, 8));
        graph[3].add(new Edge(3, 1, 8));

        graph[2].add(new Edge(2, 3, 5));
        graph[3].add(new Edge(3, 2, 5));
        
    }
    public static void primsAlgo(ArrayList<Edge> graph[] , int n){
        boolean vis[] = new boolean[n] ; 
        int minCost = 0 ; 
        PriorityQueue<int[]> q = new PriorityQueue<>((a , b) -> a[1] - b[1]) ; 
        q.add(new int[]{0 , 0}) ; 
        while(!q.isEmpty()){
            int arr[] = q.poll() ; 
            if(!vis[arr[0]]){
                vis[arr[0]] = true ; 
                minCost += arr[1] ;
                for(int i = 0 ;i < graph[arr[0]].size() ; i++){
                    Edge e = graph[arr[0]].get(i) ; 
                    if(!vis[e.dest]){
                        q.add(new int[]{e.dest , e.wt}) ; 
                    }
                }
            }
        }
        System.out.print(minCost) ; 
        
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
        primsAlgo(graph , v) ; 
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
