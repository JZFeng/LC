package jz.lc.medium;

//Version 1: Union Find.
class UF {
	int[] father = null;
	int count = 0;

	UF(int n) {
		father = new int[n];
		for (int i = 0; i < n; i++) {
			father[i] = i;
		}
	}

	int find(int x) { //compress find. X is index of array father;
		int f = x;
		while (father[f] != f) {
			f = father[f];
		}

		//update all nodes on the path.
		while (father[x] != x) {
			int tmp = father[x];
			father[x] = f;
			x = tmp;
		}

		return f;
	}

	void connect(int a, int b) { //parameters are index of array father.
        int f_a  = find(a);
        int f_b = find(b);
        if (f_a != f_b) {
            father[f_a] = f_b; //Attention !!!! father[f_a] = f_b  NOT f_a = f_b;
            count--;
        }
    }

	int query() {
		return count;
	}

	void set_count(int n) {
		count = n;
	}

}

public class NumberofIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;
		UF unionfind = new UF(m * n);
		int total = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					total++;
				}
			}
		}
		unionfind.set_count(total);
		
		for (int i = 0 ; i < m ; i++) {
			for (int j = 0 ; j < n ; j++) {
				if ( grid[i][j] == '1' ) {
					if ( i > 0 && grid[i - 1][j] == '1' ) 
						unionfind.connect( i*n+j, (i-1)*n +j );
					
					if ( i < m - 1 && grid[i + 1][j] == '1' ) 	
						unionfind.connect( i*n+j, (i+1)*n +j );
					
					if ( j >0 && grid[i][j - 1] == '1') 
						unionfind.connect( i*n+j, i*n + j - 1 );
					
					if ( j < n - 1 && grid[i][j + 1] == '1') 
						unionfind.connect(i*n+j , i*n + j + 1);

				}
			}
		}
		
		return unionfind.query();

	}
}
