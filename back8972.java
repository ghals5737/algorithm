import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class back8972 {
    static class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static int[] dx = { 0,-1,0,1,-1,0,1,-1,0,1 };
    static int[] dy = { 0,1,1,1,0,0,0,-1,-1,-1};
    static int n,m,nowX,nowY;
    static int[][] map;   
    static Queue<Pair>list=new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            String s=st.nextToken();
            for(int j=0;j<m;j++){
                char c=s.charAt(j);
                if(c=='R'){
                    map[i][j]=2;
                    list.add(new Pair(j,i));
                }else if(c=='I'){
                    map[i][j]=1;
                    nowX=j;
                    nowY=i;
                }else{
                    map[i][j]=0;
                }
            }
        }
        st=new StringTokenizer(bf.readLine());
        String s=st.nextToken();
        for(int ii=0;ii<s.length();ii++){
            char c=s.charAt(ii);
            int num=c-'0';            
            
            int nx=nowX+dx[num];
            int ny=nowY+dy[num];
            //1
            if(map[ny][nx]==2){
                System.out.println("kraj "+(ii+1));
                return;
            }          
            nowX=nx;
            nowY=ny;
            //2
            int size=list.size();          
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    map[i][j]=0;
                }
            }
            map[nowY][nowX]=1;
            for(int q=0;q<size;q++){
                Pair p=list.poll();
                int x=p.x;
                int y=p.y;
                int dir=0;
                int d=987654321;                
                for(int k=1;k<=9;k++){
                    nx=x+dx[k];
                    ny=y+dy[k];
                    if(nx>=0&&nx<m&&ny>=0&&ny<n){
                        int nowD=Math.abs(nowX-nx)+Math.abs(nowY-ny);
                        if(d>nowD){
                            d=nowD;
                            dir=k;
                        }
                    }
                }
                nx=x+dx[dir];
                ny=y+dy[dir];
                if(map[ny][nx]==1){
                    System.out.println("kraj "+(ii+1));
                    return;
                }
                map[ny][nx]+=2;                           
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j]>2)map[i][j]=0;
                    if(map[i][j]==2)list.add(new Pair(j,i));
                }
            }           
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(map[i][j]==0){
                    sb.append('.');
                }else if(map[i][j]==1){
                    sb.append('I');
                }else{
                    sb.append('R');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}