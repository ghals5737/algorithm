import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class beak16571 {
    static int[][] map=new int[3][3];
    static boolean isWin(int turn){
        for(int y=0;y<3;y++) {
			if(map[y][0]==turn&&map[y][0]==map[y][1]&&map[y][1]==map[y][2]) return true;
		}
		for(int x=0;x<3;x++) {
			if(map[0][x]==turn&&map[0][x]==map[1][x]&&map[1][x]==map[2][x]) return true;
		}
		if(map[0][0]==turn&&map[0][0]==map[1][1]&&map[1][1]==map[2][2]) return true;
		if(map[0][2]==turn&&map[0][2]==map[1][1]&&map[1][1]==map[2][0]) return true;    
        return false;
    }
    static int solve(int turn){
        if(isWin(3-turn))return -1;
        int min=2;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(map[i][j]==0){
                    map[i][j]=turn;
                    min=Math.min(min,solve(3-turn));
                    map[i][j]=0;
                }
            }
        }
        if(min==2||min==0)return 0;
        return -min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));        
        int cnt=0;        
        for(int i=0;i<3;i++){
            StringTokenizer st=new StringTokenizer(bf.readLine());            
            for(int j=0;j<3;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]!=0)cnt++;               
            }
        }
        int result=0;        
        if(cnt%2==0)result=solve(1);
        else result=solve(2);
        if(result==0)System.out.println("D");        
        else if(result==1)System.out.println("W");
        else System.out.println("L");
    }    
}
