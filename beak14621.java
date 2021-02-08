import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak14621 {
    static class Pair{
        int from;
        int to;
        int cost;
        public Pair(int from,int to,int cost){
            this.from=from;
            this.to=to;
            this.cost=cost;
        }
    }
    static int n,m,ans;
    static boolean[] isMan,check;
    static ArrayList<Pair> node=new ArrayList<>();
    static int[] arr;   
    static int cnt; 
    static int find(int x){
        if(arr[x]==x)return x;
        else return arr[x]=find(arr[x]);
    }
    static void merge(int a,int b,int cost){
        a=find(a);
        b=find(b);
        if(a!=b){
            if(a>b){
                int tmp=a;
                a=b;
                b=tmp;
            }
            arr[b]=a;
            ans+=cost;
            if(!check[a]){
                check[a]=true;
                cnt++;
            }
            if(!check[b]){
                check[b]=true;
                cnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        isMan=new boolean[n+1];
        arr=new int[n+1];
        check=new boolean[n+1];
        for(int i=0;i<=n;i++)arr[i]=i;
        st=new StringTokenizer(bf.readLine());                        
        for(int i=1;i<=n;i++){
            String s=st.nextToken();
            if(s.equals("M")){
                isMan[i]=true;
            }
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            if(isMan[from]!=isMan[to]){
                node.add(new Pair(from,to,cost));
            }
        }
        node.sort((Pair a,Pair b)->{return a.cost-b.cost;});
        ans=0;
        cnt=0;                
        for(Pair p:node){
            merge(p.from,p.to,p.cost);
        }        
        if(cnt==n)System.out.println(ans);
        else System.out.println(-1);
    }    
}
