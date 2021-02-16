import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class beak9470 {
    static int t,k,m,p;
    static ArrayList<Integer>[] node;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  
        t=Integer.parseInt(st.nextToken());
        for(int tt=0;tt<t;tt++){
            st=new StringTokenizer(bf.readLine());  
            k=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());
            p=Integer.parseInt(st.nextToken());
            int[] arr=new int[m+1];
            int[] max=new int[m+1];
            int[][] chk=new int[m+1][m+1];
            node=new ArrayList[m+1];
            for(int i=0;i<=m;i++)node[i]=new ArrayList<>();
            for(int i=0;i<p;i++){
                st=new StringTokenizer(bf.readLine());  
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                node[a].add(b);
                arr[b]++;        
            }    
            Queue<Integer>q=new LinkedList<>();
            for(int i=1;i<=m;i++){
                if(arr[i]==0){
                    max[i]=1;
                    q.add(i);
                }
            }
            while(!q.isEmpty()){
                int now=q.poll();
                for(int next:node[now]){
                    max[next]=Math.max(max[next],max[now]);
                    chk[next][max[next]]++;
                    arr[next]--;
                    if(arr[next]==0){
                        int tmp=max[next];
                        if(chk[next][tmp]>=2)max[next]=max[now]+1;
                        else max[next]=max[now];
                        q.add(next);
                    }
                }
            }
            System.out.println(k+" "+max[m]);        
        }        

    }
    
}
