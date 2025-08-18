import java.util.* ; 
public class Articulation_Point{
    public static void BuildGraph(ArrayList<Edge> graph[] , int v){
        for(int i= 0 ;i < v ; i++){
            graph[i] = new ArrayList<>() ; 
        }   
        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 0, 1));
        
        graph[0].add(new Edge(0, 2, 1));
        graph[2].add(new Edge(2, 0, 1));
        
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 2, 1));
        
        graph[3].add(new Edge(3, 4, 1));
        graph[4].add(new Edge(4, 3, 1));


        
    }
    public static void dfs1(ArrayList<Edge> graph[] , boolean vis[], int curr, int dt[] , int low[] , int par , int time , boolean ap[]){
        vis[curr] = true ;
        dt[curr] = low[curr] = ++time ; 
        int child = 0 ; 
        for(int i = 0 ;i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i) ; 
            if(e.dest == par)continue ; 
            else if(!vis[e.dest]){
                dfs1(graph , vis , e.dest , dt , low , curr , time , ap) ; 
                low[curr] = Math.min(low[curr] , low[e.dest]) ; 
                if(dt[curr] <= low[e.dest] && par != -1 ){
                    ap[curr] = true ; 
                }
                child++ ; 
            }else {
                low[curr] = Math.min(low[curr] , dt[e.dest]) ; 
            }
        }
        if(par == -1 && child > 1)ap[curr] = true ; 
    }
    public static void ArtiPoint(ArrayList<Edge> graph[] , int v){
        int dt[]= new int[v] ; 
        int low[] = new int[v] ; 
        boolean vis[] = new boolean[v] ; 
        int time = 0 ; 
        boolean ap[] = new boolean[v] ; 
        for(int i = 0 ;i < v; i++){
            if(!vis[i]){
                dfs1(graph , vis , i , dt , low , -1 , time ,ap) ; 
            }
        }
        System.out.println() ; 
        for(int i= 0 ;i < v ; i++){
            if(ap[i])System.out.println(i) ; 
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in) ; 
        int v = 6 ; 
        ArrayList<Edge> graph[] = new ArrayList[v] ; 
        BuildGraph(graph , v) ;
        ArtiPoint(graph , v)  ;
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
