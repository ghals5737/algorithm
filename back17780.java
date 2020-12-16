import java.util.ArrayList;
import java.util.Scanner;

class back17780{

    static class Chess{
        int x;
        int y;
        int dir;
        boolean isUnder;
        public Chess(int x,int y,int dir,boolean isUnder){
            this.x=x;
            this.y=y;
            this.dir=dir;
            this.isUnder=isUnder;
        }
    }

    //1번부터 순서대로 오,왼,위,아
    static int n;
    static int k;
    static ArrayList<Integer>[][] mapState;
    static Chess[] arr;
    static int[][] map;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();
        map=new int[n][n];
        mapState=new ArrayList[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j]=sc.nextInt();
                mapState[i][j]=new ArrayList<>();
            }
        }

        arr=new Chess[k];

        for(int i=0;i<k;i++){
            int y=sc.nextInt()-1;
            int x=sc.nextInt()-1;
            int dir=sc.nextInt()-1;
            arr[i]=new Chess(x, y, dir, true);
            mapState[y][x].add(i);
        }

        int cnt=0;
        while(cnt<=1000){
            cnt++;
            
            for(int c=0;c<k;c++){
                Chess el=arr[c];
                int x=el.x;
                int y=el.y;
                int dir=el.dir;
                boolean isUnder=el.isUnder;
                if(isUnder){
                    
                    int nx=x+dx[dir];
                    int ny=y+dy[dir];
                    if(nx>=0&&nx<n&&ny>=0&&ny<n){
                        if(map[ny][nx]==0){//흰
                            ArrayList<Integer>tmp=mapState[y][x];
                            ///System.out.println(y+" "+x+"\n"+ny+" "+nx);    
                            
                            for(int num:tmp){                                
                                arr[num].x=nx;
                                arr[num].y=ny;
                                arr[num].isUnder=false;
                                mapState[ny][nx].add(num);
                            }
                            //System.out.println(cnt+" "+c+" "+mapState[ny][nx]+" "+ny+" "+nx);
                            mapState[y][x].clear();
                            arr[mapState[ny][nx].get(0)].isUnder=true;
                            if(mapState[ny][nx].size()>=4){
                                System.out.println(cnt);
                                return;
                            }
                            
                        }
                        else if(map[ny][nx]==1){//빨
                            ArrayList<Integer>tmp=mapState[y][x];                            
                            
                            for(int i=tmp.size()-1;i>=0;i--){
                                int num=tmp.get(i);
                                arr[num].x=nx;
                                arr[num].y=ny;
                                arr[num].isUnder=false;
                                mapState[ny][nx].add(num);
                            }
                            mapState[y][x].clear();
                            arr[mapState[ny][nx].get(0)].isUnder=true;
                            if(mapState[ny][nx].size()>=4){
                                System.out.println(cnt);
                                return;
                            }
                        }else{//파
                            if(dir<=1){
                                dir=1-dir;
                            }else{
                                dir=5-dir;
                            }
                            nx=x+dx[dir];
                            ny=y+dy[dir];
                            if(nx>=0&&nx<n&&ny>=0&&ny<n){
                                if(map[ny][nx]==0){//흰
                                    ArrayList<Integer>tmp=mapState[y][x];
                                    
                                    for(int num:tmp){
                                        arr[num].x=nx;
                                        arr[num].y=ny;
                                        arr[num].isUnder=false;
                                        mapState[ny][nx].add(num);
                                    }
                                    mapState[y][x].clear();
                                    arr[mapState[ny][nx].get(0)].isUnder=true;
                                    if(mapState[ny][nx].size()>=4){
                                        System.out.println(cnt);
                                        return;
                                    }
                                }
                                else if(map[ny][nx]==1){//빨
                                    ArrayList<Integer>tmp=mapState[y][x];                            
                                    
                                    for(int i=tmp.size()-1;i>=0;i--){
                                        int num=tmp.get(i);
                                        arr[num].x=nx;
                                        arr[num].y=ny;
                                        arr[num].isUnder=false;
                                        mapState[ny][nx].add(num);
                                    }
                                    mapState[y][x].clear();
                                    arr[mapState[ny][nx].get(0)].isUnder=true;
                                    if(mapState[ny][nx].size()>=4){
                                        System.out.println(cnt);
                                        return;
                                    }
                                }else{//파
                                    if(dir<=1){
                                        dir=1-dir;
                                    }else{
                                        dir=5-dir;
                                    }                                    
                                }
                            }else{
                                if(dir<=1){
                                    dir=1-dir;
                                }else{
                                    dir=5-dir;
                                }
                            }
                            arr[c].dir=dir;                            
                        }
                    }else{
                        if(dir<=1){
                            dir=1-dir;
                        }else{
                            dir=5-dir;
                        }
                        nx=x+dx[dir];
                        ny=y+dy[dir];
                        if(nx>=0&&nx<n&&ny>=0&&ny<n){
                            if(map[ny][nx]==0){//흰
                                ArrayList<Integer>tmp=mapState[y][x];
                                
                                for(int num:tmp){
                                    arr[num].x=nx;
                                    arr[num].y=ny;
                                    arr[num].isUnder=false;
                                    mapState[ny][nx].add(num);
                                }
                                mapState[y][x].clear();
                                arr[mapState[ny][nx].get(0)].isUnder=true;
                                if(mapState[ny][nx].size()>=4){
                                    System.out.println(cnt);
                                    return;
                                }
                            }
                            else if(map[ny][nx]==1){//빨
                                ArrayList<Integer>tmp=mapState[y][x];                            
                                
                                for(int i=tmp.size()-1;i>=0;i--){
                                    int num=tmp.get(i);
                                    arr[num].x=nx;
                                    arr[num].y=ny;
                                    arr[num].isUnder=false;
                                    mapState[ny][nx].add(num);
                                }
                                mapState[y][x].clear();
                                arr[mapState[ny][nx].get(0)].isUnder=true;
                                if(mapState[ny][nx].size()>=4){
                                    System.out.println(cnt);
                                    return;
                                }
                            }else{//파
                                if(dir<=1){
                                    dir=1-dir;
                                }else{
                                    dir=5-dir;
                                }                                    
                            }
                        }else{
                            if(dir<=1){
                                dir=1-dir;
                            }else{
                                dir=5-dir;
                            }
                        }
                        arr[c].dir=dir;            
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
