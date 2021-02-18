import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak2618 {
    static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int n,m;
    static int[][] dp;
    static ArrayList<Pair>listA=new ArrayList<>();    
    static ArrayList<Pair>listB=new ArrayList<>();    
    static int solve(int l,int r){
        if(l==m||r==m){
            return 0;
        }
        if(dp[l][r]!=-1)return dp[l][r];
        dp[l][r]=987654312;
        int next=Math.max(l,r)+1;
        int dA=Math.abs(listA.get(next).x-listA.get(l).x)+Math.abs(listA.get(next).y-listA.get(l).y);
        int dB=Math.abs(listB.get(next).x-listB.get(r).x)+Math.abs(listB.get(next).y-listB.get(r).y);
        int costA=solve(next, r)+dA;
        int costB=solve(l,next)+dB;
        return dp[l][r]=Math.min(costA,costB);
    }
    static void trace(int l,int r){
        if(l==m||r==m){
            return;
        }        
        
        int next=Math.max(l,r)+1;
        int dA=Math.abs(listA.get(next).x-listA.get(l).x)+Math.abs(listA.get(next).y-listA.get(l).y);
        int dB=Math.abs(listB.get(next).x-listB.get(r).x)+Math.abs(listB.get(next).y-listB.get(r).y);
        int costA=solve(next, r)+dA;
        int costB=solve(l,next)+dB;
        if(costA<costB){
            System.out.println(1);
            trace(next, r);
        }else{
            System.out.println(2);
            trace(l,next);
        }
    }            
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        m=Integer.parseInt(st.nextToken());
        dp=new int[m][m];
        for(int i=0;i<m;i++)for(int j=0;j<m;j++)dp[i][j]=-1;                
        listA.add(new Pair(1,1));
        listB.add(new Pair(n,n));
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            listA.add(new Pair(b,a));
            listB.add(new Pair(b,a));
        }
        System.out.println(solve(0, 0));
        trace(0, 0);        
    }    
}
