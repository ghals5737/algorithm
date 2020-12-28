import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back2174 {
    static class Pair{
        int x;
        int y;
        int d;
        public Pair(int x,int y,int d){
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }
    static class Command{
        int num;
        String cmd;
        int aa;
        public Command(int num,String cmd,int aa){
            this.num=num;
            this.cmd=cmd;
            this.aa=aa;
        }
    }
    static int n,m,a,b;
    static int[][] map;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static ArrayList<Pair> robot=new ArrayList<>();
    static ArrayList<Command> commands=new ArrayList<>();
    static boolean isAble(int x,int y){
        return x>0&&x<=m&&y>0&&y<=n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        map=new int[n+1][m+1];
        st=new StringTokenizer(bf.readLine());
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        int[] arr=new int[n+1];
        for(int i=0;i<=n;i++)arr[i]=n+1-i;
        for(int i=0;i<a;i++){
            st=new StringTokenizer(bf.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            String d=st.nextToken();
            if(d.equals("W")){
                robot.add(new Pair(x,arr[y],3));
            }else if(d.equals("N")){
                robot.add(new Pair(x,arr[y],0));
            }else if(d.equals("S")){
                robot.add(new Pair(x,arr[y],2));
            }else{
                robot.add(new Pair(x,arr[y],1));
            }
            map[arr[y]][x]=i+1;            
        }
        
        for(int i=0;i<b;i++){
            st=new StringTokenizer(bf.readLine());
            int num=Integer.parseInt(st.nextToken());
            String cmd=st.nextToken();
            int aa=Integer.parseInt(st.nextToken());
            commands.add(new Command(num, cmd, aa));
        }
        for(int k=0;k<b;k++){
            Command c=commands.get(k);
            int num=c.num;
            String cmd=c.cmd;
            int aa=c.aa;
            Pair p=robot.get(num-1);
            int x=p.x;
            int y=p.y;
            int d=p.d;
            for(int kk=0;kk<aa;kk++){                
                if(cmd.equals("L")){
                    d--;
                    if(d<0)d=3;
                }else if(cmd.equals("R")){
                    d++;
                    if(d>3)d=0;
                }else{
                    int nx=x+dx[d];
                    int ny=y+dy[d];
                    if(!isAble(nx, ny)){
                        System.out.println("Robot "+num+" crashes into the wall");
                        return;
                    }else{
                        if(map[ny][nx]!=0){
                            System.out.println("Robot "+num+" crashes into robot "+map[ny][nx]);
                            return;
                        }
                    }
                    map[y][x]=0;
                    x=nx;
                    y=ny;
                    map[y][x]=num;                           
                }                
            }
            robot.set(num-1,new Pair(x,y,d));
        }
        System.out.println("OK");
    }    
}
