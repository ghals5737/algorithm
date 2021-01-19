import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bacl1766 {
    static int n,m;
    static int[] in;
    static ArrayList<Integer>[] node;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        in=new int[n+1];
        node=new ArrayList[n+1];
        for(int i=0;i<=n;i++)node[i]=new ArrayList<>();

        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());   
            node[a].add(b);         
            in[b]++;
        }
        PriorityQueue<Integer>q=new PriorityQueue<>();
        for(int i=1;i<=n;i++){
            if(in[i]==0)q.add(i);
        }
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            int now=q.poll();            
            sb.append(now+" ");
            for(int next:node[now]){
                in[next]--;
                if(in[next]==0)q.add(next);
            }
        }
        sb.append("\n");
        System.out.print(sb);
    }    
}
