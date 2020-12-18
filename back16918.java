import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class back16918 {
    static int[][] map;
    static int n,m,t;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        t=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            String s=st.nextToken();
            for(int j=0;j<m;j++){
                char c=s.charAt(j);
                if(c=='.'){
                    map[i][j]=-1;
                }else{
                    map[i][j]=cnt;
                }
            }
        }
        for(int tt=1;tt<=t;tt++){
            if(tt==1)continue;           
            if(tt%2==0){
                cnt+=2;
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        if(map[i][j]==-1){
                            map[i][j]=cnt;
                        }
                    }
                }
            }else{
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        if(map[i][j]==tt-3){
                            map[i][j]=-1;
                            for(int k=0;k<4;k++){
                                int ny=i+dy[k];
                                int nx=j+dx[k];
                                if(nx>=0&&nx<m&&ny>=0&&ny<n&&map[ny][nx]!=tt-3){
                                    map[ny][nx]=-1;
                                }
                            }
                        }
                    }
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(map[i][j]==-1?'.':'O');
            }
            sb.append('\n');
        }
        System.out.print(sb);           
    }
}