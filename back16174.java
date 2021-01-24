import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back16174 {
	static class Pair{
		int x;
		int y;
		public Pair(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
	static int n;
	static int[] dx= {1,0};
	static int[] dy= {0,1};
	static int[][] map;
	static boolean[][] visisted;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();		
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		map=new int[n][n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());				
			}
		}
		visisted=new boolean[n][n];
		Queue<Pair>q=new LinkedList<>();
		q.add(new Pair(0,0));
		visisted[0][0]=true;
		while(!q.isEmpty()) {
			Pair p=q.poll();
			int x=p.x;
			int y=p.y;			
			if(x==n-1&&y==n-1) {
				System.out.println("HaruHaru");
				return;				
			}
			for(int i=0;i<2;i++) {
				int nx=x+map[y][x]*dx[i];
				int ny=y+map[y][x]*dy[i];
				if(nx>=0&&nx<n&&ny>=0&&ny<n&&!visisted[ny][nx]) {
					visisted[ny][nx]=true;
					q.add(new Pair(nx,ny));
				}
			}
		}
		System.out.println("Hing");
	}

}
