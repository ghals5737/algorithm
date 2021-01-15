import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class back9177 {
    static class Info{
        int aIdx;        
        int bIdx;
        int cIdx;
        public Info(int aIdx,int bIdx,int cIdx){
            this.aIdx=aIdx;
            this.bIdx=bIdx;
            this.cIdx=cIdx;
        }
    }
    static int n;
    static String a,b,c;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        for(int t=0;t<n;t++){
            st=new StringTokenizer(bf.readLine());
            a=st.nextToken();
            b=st.nextToken();
            c=st.nextToken();          
            
            Queue<Info>q=new LinkedList<>();
            q.add(new Info(0,0,0));
            visited=new boolean[a.length()+10][b.length()+10];
            visited[0][0]=true;
            boolean flag=false;
            while(!q.isEmpty()){
                Info el=q.poll();
                int aIdx=el.aIdx;
                int bIdx=el.bIdx;
                int cIdx=el.cIdx;
                if(cIdx==c.length()){
                    flag=true;
                    break;
                }             
                if(aIdx<a.length()&&!visited[aIdx+1][bIdx]&&a.charAt(aIdx)==c.charAt(cIdx)){
                    visited[aIdx+1][bIdx]=true;
                    q.add(new Info(aIdx+1, bIdx, cIdx+1));                     
                }
                if(bIdx<b.length()&&!visited[aIdx][bIdx+1]&&b.charAt(bIdx)==c.charAt(cIdx)){
                    visited[aIdx][bIdx+1]=true;
                    q.add(new Info(aIdx, bIdx+1, cIdx+1));                     
                }   
            }
            String str="Data set "+(t+1)+": ";
            if(flag)System.out.println(str+"yes");
            else System.out.println(str+"no");
        }

    }    
}
