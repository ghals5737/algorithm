import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class beak1068{
    static ArrayList<Integer>[] edge;
    static int n;
    static int m;
    static int total;
    static void dfs(int prev,int now){
        if(edge[now].isEmpty())total++;
        for(int next:edge[now]){
            if(next!=prev){
                dfs(now,next);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();		
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        edge=new ArrayList[n];
        for(int i=0;i<n;i++){
            edge[i]=new ArrayList<>();
        }
        int root=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int num=Integer.parseInt(st.nextToken());
            if(num!=-1){
                edge[num].add(i);
                map.put(i,num);
            }else{
                root=i;
            }
        }
        st=new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        if(map.containsKey(m)){
            int r=map.get(m);
            edge[r].remove(edge[r].indexOf(m));
        }
        dfs(-1,root);
        System.out.println(total);
    }
}