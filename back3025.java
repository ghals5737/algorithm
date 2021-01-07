import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back3025 {
    static int n,m;
    static int[][] map;   
    static boolean isPossible(int x,int y){
        return x>=0&&x<m&&y>=0&&y<n;
    }   
    static void move(int x,int y){
        int ny=y+1;
        //1         
		if(ny==n||map[ny][x]==1){
            map[y][x]=2;
            return;
        }
        //2
        else if(map[ny][x]==0){
            move(x,ny);            
        }
        //3
        else if(map[ny][x]==2){
            //3-1            
            if((isPossible(x-1, y)&&map[y][x-1]==0)&&(isPossible(x-1,ny)&&map[ny][x-1]==0)){
                move(x-1, y);
            }            
            //3-2           
            else if((isPossible(x+1, y)&&map[y][x+1]==0)&&(isPossible(x+1,ny)&&map[ny][x+1]==0)){
                move(x+1, y);
            }
            //3-3
            else map[y][x]=2;            
        }        
    }
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
                if(c=='.'){
                    map[i][j]=0;
                }else{
                    map[i][j]=1;
                }
            }
        }

        st=new StringTokenizer(bf.readLine());
        int t=Integer.parseInt(st.nextToken());
        for(int tt=0;tt<t;tt++){
            st=new StringTokenizer(bf.readLine());
            int idx=Integer.parseInt(st.nextToken());
            move(idx-1,0);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==0)sb.append('.');
                else if(map[i][j]==1)sb.append('X');
                else sb.append('O');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }    
}
