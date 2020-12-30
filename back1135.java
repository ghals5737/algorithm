import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back1135 {
    static class Pair{
        int cost;
        int next;
        public Pair(int cost,int next){
            this.cost=cost;
            this.next=next;
        }
    }
    static int n;
    static ArrayList<Pair>[] node;
    static int dfs(int num){
        int ret=0;
        for(int i=0;i<node[num].size();i++){
            node[num].get(i).cost=1+dfs(node[num].get(i).next);
        }
        node[num].sort((Pair a,Pair b)->{
            return b.cost-a.cost;
        });
        for(int i=0;i<node[num].size();i++){
            node[num].get(i).cost+=i;
            ret=Math.max(ret,node[num].get(i).cost);
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        node=new ArrayList[n+1];
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            int num=Integer.parseInt(st.nextToken());
            if(num!=-1){
                node[num].add(new Pair(0,i));
            }
        }
        System.out.println(dfs(0));
    }    
}
