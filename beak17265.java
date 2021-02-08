import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak17265 {
    static int n;
    static int[][] map;
    static boolean[][] v;
    static int[] dx={1,0};
    static int[] dy={0,1};
    static int max;
    static int min;
    static void dfs(int x,int y,int sum,int mode){        
        if(y==n-1&&x==n-1){            
            max=Math.max(max,sum);
            min=Math.min(min,sum);
            return;            
        }       
        for(int i=0;i<2;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0&&nx<n&&ny>=0&&ny<n&&!v[ny][nx]){
                int num=map[ny][nx];
                if(num>=0&&num<=5){
                    int result=sum;
                    if(mode==6){
                        result+=num;
                    }else if(mode==7){
                        result-=num;
                    }else{
                        result*=num;
                    }
                    dfs(nx,ny,result,mode);
                }else{
                    dfs(nx,ny,sum,map[ny][nx]);                    
                }
            }
        }               
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());  
        n=Integer.parseInt(st.nextToken());
        map=new int[n][n];
        v=new boolean[n][n];
        min=987654321;
        max=-987654321;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());  
            for(int j=0;j<n;j++){
                String s=st.nextToken();
                char c=s.charAt(0);
                if(c>='0'&&c<='5'){
                    map[i][j]=c-'0';
                }else{
                    if(c=='+'){
                        map[i][j]=6;
                    }else if(c=='-'){
                        map[i][j]=7;
                    }else{
                        map[i][j]=8;
                    }
                }
            }
        }         
        dfs(0,0,map[0][0],0);
        System.out.println(max+" "+min);                 
    }
}
