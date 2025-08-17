import java.util.* ; 
public class Kosaraju_algo{
    public static void BuildGraph(ArrayList<Edge> graph[] , int v){
        for(int i= 0 ;i < v ; i++){
            graph[i] = new ArrayList<>() ; 
        }   
        graph[5].add(new Edge(5, 2, 1));
        graph[5].add(new Edge(5, 0, 1));
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 1));

        
    }
    public static void dfs2(ArrayList<Edge> graph[], boolean vis[], int curr){
        vis[curr] = true ;
        System.out.print(curr + " ") ; 
        for(int i = 0 ;i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i) ; 
            if(!vis[e.dest])dfs2(graph , vis , e.dest ) ; 
        }
    }
    public static void dfs1(ArrayList<Edge> graph[] , boolean vis[], int curr, Stack<Integer> stack){
        vis[curr] = true ;
        for(int i = 0 ;i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i) ; 
            if(!vis[e.dest])dfs1(graph , vis , e.dest , stack) ; 
        }
        stack.push(curr) ; 
    }
    public static void KosarajuAlgo(ArrayList<Edge> graph[] , int v){
        Stack<Integer> stack = new Stack<>() ; 
        boolean vis[] = new boolean[v] ; 
        // topologyGrath 
        for(int i= v -1 ; i >= 0 ; i--){
            if(!vis[i]){
                dfs1(graph , vis , i, stack) ; 
            }
        }
        // transpose the graph 
        ArrayList<Edge> transpose[] = new ArrayList[v] ;
        for(int i= 0 ;i < v ; i++){
            transpose[i] = new ArrayList<>() ; 
        }
        for(int i= 0 ;i < v ; i++){
            for(int j = 0 ; j < graph[i].size() ; j++){
                Edge e = graph[i].get(j); 
                transpose[e.dest].add(new Edge(e.dest , e.sor , e.wt)) ;
            }
        }
        Arrays.fill(vis , false) ; 
        // perform the dfs on topology order
        while(!stack.isEmpty()){
            int curr = stack.pop(); 
            if(!vis[curr]){
                dfs2(transpose , vis , curr ) ; 
                System.out.println() ; 
            }
        }
        
        
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in) ; 
        int v = 6 ; 
        ArrayList<Edge> graph[] = new ArrayList[v] ; 
        BuildGraph(graph , v) ;
        KosarajuAlgo(graph , v) ; 
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
