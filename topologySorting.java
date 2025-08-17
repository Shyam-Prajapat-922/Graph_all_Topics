import java.util.* ; 
public class topologySorting{
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
    public static void dfs(ArrayList<Edge> graph[] , boolean vis[], int curr, Stack<Integer> stack){
        vis[curr] = true ;
        for(int i = 0 ;i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i) ; 
            if(!vis[e.dest])dfs(graph , vis , e.dest , stack) ; 
        }
        stack.push(curr) ; 
    }
    public static void topologySort(ArrayList<Edge> graph[] , int v){
        Stack<Integer> stack = new Stack<>() ; 
        boolean vis[] = new boolean[v] ; 
        for(int i= v -1 ; i >= 0 ; i--){
            if(!vis[i]){
                dfs(graph , vis , i, stack) ; 
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ") ; 
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in) ; 
        int v = 6 ; 
        ArrayList<Edge> graph[] = new ArrayList[v] ; 
        BuildGraph(graph , v) ;
        topologySort(graph , v) ; 
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
