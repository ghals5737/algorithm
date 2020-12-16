import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back10875 {
    static class Info{
        int t;
        String dir;
        public Info(int t,String dir){
            this.t=t;
            this.dir=dir;
        }
    }
    static class  Line{
        int maxX;
        int maxY;
        int minX;
        int minY;        
        public Line(int maxX,int maxY,int minX,int minY){
            this.maxX=maxX;
            this.maxY=maxY;
            this.minX=minX;
            this.minY=minY;
        }
    }    
    static int L;
    static int N;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};    
    static ArrayList<Info>list=new ArrayList<>();

    static boolean check(int x,int y){
        
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        L=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            int t=Integer.parseInt(st.nextToken());
            String s=st.nextToken();
            list.add(new Info(t,s));
        }
        int nowX=0;
        int nowY=0;
        int nowD=1;
        int ans=0;
        for(Info el:list){
            int t=el.t;
            String dir=el.dir;
            for(int i=0;i<t;i++){
                int nextX=nowX+dx[nowD];
                int nextY=nowY+dy[nowD];
                ans++;
                if(!check(nextX,nextY)){
                    System.out.println(ans);
                    return;
                }             
            }
            if(dir.equals("L")){
                
            }else{
                
            }
        }
    }
}
