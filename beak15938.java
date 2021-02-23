import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class beak15938 {
    static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int sX,sY,eX,eY,t,n;
    static long ans;
    static long mod=1000000000+7;
    static HashSet<String>set=new HashSet<>();
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static long[][][] v=new long[401][401][300];       
    static long dfs(int x,int y,int tt){        
        int rx=sX+x;
        int ry=sY+y;
        if(Math.abs(eX-rx)+Math.abs(eY-ry)>t-tt)return 0;
        if(eX==rx&&eY==ry){return 1;}
        if(tt==t)return 0;
        if(v[x+200][y+200][tt]!=-1)return v[x+200][y+200][tt];
        v[x+200][y+200][tt]=0;
        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            int rnx=sX+nx;
            int rny=sY+ny;
            if(!set.contains((rnx+"")+(rny+""))){                
                v[x+200][y+200][tt]=(v[x+200][y+200][tt]+dfs(nx,ny,tt+1)%mod)%mod;                
            }
        }    
        return v[x+200][y+200][tt];    
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine()); 
        sX=Integer.parseInt(st.nextToken());
        sY=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine()); 
        t=Integer.parseInt(st.nextToken()); 
        st=new StringTokenizer(bf.readLine()); 
        eX=Integer.parseInt(st.nextToken());
        eY=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine()); 
        n=Integer.parseInt(st.nextToken());
        sX+=100000;
        sY+=100000;
        eY+=100000;
        eX+=100000;
        for(int i=0;i<401;i++)for(int j=0;j<401;j++)for(int k=0;k<300;k++)v[i][j][k]=-1;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine()); 
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            x+=100000;
            y+=100000;
            String s=(x+"")+(y+"");
            set.add(s);
        }   
        ans=0;         
        System.out.println(dfs(0,0,0)%mod);    
    }    
}
