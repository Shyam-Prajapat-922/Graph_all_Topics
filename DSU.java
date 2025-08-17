import java.util.* ; 
public class DSU{
    int parent[] ; 
    int rank[] ; 
    DSU(int n){
        parent = new int[n] ; 
        for(int i = 0 ;i < n ; i++){
            parent[i] = i ; 
        }
        rank = new int[n] ; 
    }
    public int ultimateParent(int par){
        if(parent[par] != par){
            return parent[par] = ultimateParent(parent[par]) ; 
        }
        return par ; 
    }
    public void BuildDSU(int u , int v){
        int pu = ultimateParent(u) ; 
        int pv = ultimateParent(v) ; 
        if(pu == pv)return ; 
        if(rank[pu] < rank[pv]){
            parent[pu]= pv ; 
        }else if(rank[pu] > rank[pv]){
            parent[pv] = pu ; 
        }else {
            rank[pu]++ ; 
            parent[pv]= pu ; 
        }
    }
    public  static void BuildGraph(ArrayList<Edge> graph[] , int v){
        for(int i= 0 ;i < v ; i++){
            graph[i] = new ArrayList<>() ; 
        }   
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 0));

        graph[1].add(new Edge(1, 3));
        graph[3].add(new Edge(3, 1));

        graph[2].add(new Edge(2, 4));
        graph[4].add(new Edge(4, 2));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));
        
    }
    public static void main(String[]args){
        int v = 5 ; 
         ArrayList<Edge> graph[] = new ArrayList[v] ; 
         
         DSU d = new DSU(v) ; 
         BuildGraph(graph , v) ;
         for(int i = 0 ;i < v ; i++){
             for(int j = 0 ; j < graph[i].size() ; j++){
                 Edge e = graph[i].get(j) ; 
                 d.BuildDSU(e.sor , e.dest) ;
             }
         }
         int ch = 0 ; 
         int count = 0 ; 
         for(int i = 0 ;i < v ; i++){
             if(d.parent[i] == i)count++ ; 
             if(count== 2){
                 ch = 1 ; 
                 break; 
             }
         }
         System.out.println(count >=2 ? "DisConcted graph" : "Connected Graph") ;
    }
}
class Edge{
    int sor ; 
    int dest ; 
    Edge(int sor , int dest ){
        this.sor = sor ; 
        this.dest = dest; 
    }
}
