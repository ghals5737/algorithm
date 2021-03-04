import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beak12908 {
    static class Pair{
        int sx;
        int sy;
        int ex;
        int ey;
        public Pair(int sx,int sy,int ex,int ey){
            this.sx=sx;
            this.sy=sy;
            this.ex=ex;
            this.ey=ey;
        }
    }
    static int sX,sY,eX,eY;
    static long ans;
    static boolean[] v=new boolean[7];
    static int[] arr;
    static ArrayList<Pair>list=new ArrayList<>();
    static void dfs(int idx,int cnt){
        if(cnt==7){
            int x=sX;
            int y=sY;
            long time=0;
            for(int num:arr){                
                int sx=list.get(num).sx;
                int sy=list.get(num).sy;
                int ex=list.get(num).ex;
                int ey=list.get(num).ey;
                int dist=Math.abs(x-sx)+Math.abs(y-sy);
                time+=dist;
                if(ex==eX&&ey==eY){
                     ans=Math.min(ans,time);                      
                     return;               
                }
                time+=10;
                x=ex;
                y=ey;
            }
            return;
        }
        for(int i=0;i<7;i++){
            if(!v[i]){
                v[i]=true;
                arr[idx]=i;
                dfs(idx+1,cnt+1);
                v[i]=false;
            }
        }
    }
                                                
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        sX=Integer.parseInt(st.nextToken());
        sY=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        eX=Integer.parseInt(st.nextToken());
        eY=Integer.parseInt(st.nextToken());
        ans=Long.MAX_VALUE;
        arr=new int[7];
        for(int i=0;i<3;i++){
            st=new StringTokenizer(bf.readLine());
            int sx=Integer.parseInt(st.nextToken());
            int sy=Integer.parseInt(st.nextToken());
            int ex=Integer.parseInt(st.nextToken());
            int ey=Integer.parseInt(st.nextToken());
            list.add(new Pair(sx,sy,ex,ey));
            list.add(new Pair(ex,ey,sx,sy));
        }
        list.add(new Pair(eX,eY,eX,eY));
        dfs(0,0);
        System.out.println(ans);
    }    
}
