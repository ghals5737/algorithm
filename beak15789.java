import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class beak15789 {
    static int n,m,c,h,k;
    static int[] arr;
    static int[] cnt;
    static int find(int x){
        if(arr[x]==x)return x;
        else return arr[x]=find(arr[x]);
    }
    static void merge(int a,int b){
        a=find(a);
        b=find(b);
        if(a!=b){
            if(cnt[a]>=cnt[b]){
                cnt[a]+=cnt[b];
                arr[b]=a;
            }else{
                cnt[b]+=cnt[a];
                arr[a]=b;
            }            
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n+1];
        cnt=new int[n+1];
        for(int i=0;i<=n;i++){arr[i]=i;cnt[i]=1;}
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());            
            int b=Integer.parseInt(st.nextToken());
            merge(a, b);
        }
        st=new StringTokenizer(bf.readLine());
        c=Integer.parseInt(st.nextToken());        
        h=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());        
        int num1=find(c);
        int num2=find(h);   
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{return b-a;});   
        boolean[] check=new boolean[n+1];  
        for(int i=1;i<=n;i++){
            int now=find(i);
            if(now!=num1&&now!=num2&&!check[now]){
                  pq.add(cnt[now]);           
                  check[now]=true;       
            }
        }
        int ans=cnt[num1];
        while(!pq.isEmpty()){
            if(k==0)break;
            ans+=pq.poll();
            k--;
        }        
        System.out.println(ans);      
    }    
}
