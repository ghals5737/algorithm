// class Solution {
//     boolean[][] v;
//     int[][] map;
//     int n;
//     int m;
//     int[] dx={0,1,0,-1};
//     int[] dy={-1,0,1,0};
//     boolean isIn(int x,int y){
//         return x>=0&&x<m&&y>=0&&y<n;
//     }
//     void dfs(int x,int y){
//         v[y][x]=true;        
//         for(int i=0;i<4;i++){
//             int nx=x+dx[i];
//             int ny=y+dy[i];
//             if(isIn(nx,ny)&&!v[ny][nx]&&map[ny][nx]==1){
//                 dfs(nx,ny);
//             }
//         }        
//     }
//     public int numIslands(char[][] grid) {
//         n=grid.length;
//         m=grid[0].length;
//         map=new int[n][m];
//         v=new boolean[n][m];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(grid[i][j]=='1')map[i][j]=1;
//             }
//         }
//         int res=0;
//         for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                 if(!v[i][j]&&map[i][j]==1){
//                     dfs(j,i);
//                     res++;                    
//                 }
//            }
//         }
//         return res;
//     }
// }
