import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak1405 {
	static double[] arr=new double[4];
	static boolean[][] v=new boolean[60][60];
	static int[] dx= {0,1,0,-1};
	static int[] dy= {-1,0,1,0};
	static int n;
	static double dfs(int x,int y,int cnt) {
		if(n==cnt)return 1.0;
		v[y][x]=true;
		double result=0.0;
		for(int i=0;i<4;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(!v[ny][nx]) {
				result+=arr[i]*dfs(nx,ny,cnt+1);				
			}						
		}
		v[y][x]=false;
		return result;		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();		
		StringTokenizer st=new StringTokenizer(br.readLine());		
		n=Integer.parseInt(st.nextToken());
		arr[1]=Integer.parseInt(st.nextToken())/100.0;
		arr[3]=Integer.parseInt(st.nextToken())/100.0;
		arr[2]=Integer.parseInt(st.nextToken())/100.0;
		arr[0]=Integer.parseInt(st.nextToken())/100.0;
		System.out.println(dfs(14,14,0));
	}
}
