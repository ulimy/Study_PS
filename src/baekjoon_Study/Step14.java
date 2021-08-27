package baekjoon_Study;

import java.util.Scanner;

public class Step14 {
	
	// N과 M
	static int M,N;
	static int[] arr;
	static StringBuilder result = new StringBuilder();
	
	static boolean[] visited;
	
	public static void p_15649(int count){
		
		// count가 M이라면 배열이 가득  찼으므로 print
		if(count==M){
			for(int a : arr) result.append(a+" ");
			result.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++){
			if(!visited[i]){
				// arr에 값 넣기
				arr[count] = i;
				visited[i] = true;
				
				// arr에 다음 값 넣기
				p_15649(count+1);
				
				// arr에 M만큼 담고 출력한 후일테니 false로 다시 바꿔주기
				visited[i] = false;
			}
		}
		
		return;

	}


	public static void p_15650(int count,int num){
		if(count==M){
			for(int a : arr) result.append(a+" ");
			System.out.println(result.toString());
			return;
		}
		
		// 오름차순이므로 앞에서 정한 숫자보다 큰 숫자들 중에서만 고르기
		for(int i=num+1;i<=N;i++){
			arr[count] = i;
			p_15650(count+1,i);
		}
		
		return;
	}

	
	public static void p_15651(int count){
		if(count==M){
			for(int a : arr) result.append(a+" ");
			result.append("\n");
			return;
		}

		// 같은 수를 여러번 골라도 되므로 처음부터 끝까지 반복
		for(int i=1;i<=N;i++){
			arr[count] = i;
			p_15651(count+1);
		}
		
		return;

	}
	
	public static void p_15652(int count,int num){
		if(count==M){
			for(int a : arr) result.append(a+" ");
			result.append("\n");
			return;
		}
		
		// 오름차순이므로 앞에서 정한 숫자보다 큰 숫자들 중에서만 고르기
		// 같은 숫자를 골라도 되므로 num도 포함
		for(int i=num;i<=N;i++){
			arr[count] = i;
			p_15652(count+1,i);
		}
		
		return;
	}
	
	// n-queen
	static int queen_n;
	static int queen_result=0;
	static int[] queen_arr;
	
	// 가로, 세로, 대각선으로 겹치치 않도록 queen 놓기
	public static void p_9663(int depth){
		// 마지막 행까지 다 채웠다면 성공!
		if(depth==queen_n){
			queen_result++;
			return;
		}
		
		//depth행 i열에 queen 놓을 수 있는지 확인하기
		for(int i=0;i<queen_n;i++){
			
			queen_arr[depth]=i;
			boolean check = true;
			
			for(int j=0;j<depth;j++){
				// 열 & 대각선 확인 (행은 행끼리, 열은 열끼리 차이가 같음)
				if(queen_arr[j]==i || (depth-j)==Math.abs(i-queen_arr[j])){
					check = false;
					break;
				}
			}
			
			// 가능하다면 다음 depth진행
			if(check) p_9663(depth+1);
			
		}
		
		return;
		
	}
	
	//sudoku
	static int[][] sudoku = new int[9][9];
	
	public static boolean sudoku_check(int row,int col, int value){
		// 행
		for (int i = 0; i < 9; i++) {
			if (sudoku[row][i] == value) return false;
		}				
		
		// 열
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][col] == value) return false;
		}
		
		// 3*3 
		int set_row = (row / 3) * 3; // value가 속한 3x3의 행의 첫 위치
		int set_col = (col / 3) * 3; // value가 속한 3x3의 열의 첫 위치
		
		for (int i = set_row; i < set_row + 3; i++) {
			for (int j = set_col; j < set_col + 3; j++) {
				if (sudoku[i][j] == value) {
					return false;
				}
			}
		}
		 
		// 중복 없으면 true
		return true;

	}
	
	public static void p_2580(int row,int col){
		
		// 행 끝났다면 다음 열로 넘어가기
		if (col==9) {
			p_2580(row+1,0);
			return;
		}
		
		// 열 끝났다면 스도쿠 완성! 출력
		if(row==9){
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					result.append(sudoku[i][j] + " ");
				}
				result.append('\n');
			}
			System.out.println(result.toString());
			
			// 한번만 출력해야하므로 시스템 종료해버리기
			System.exit(0);
		}
		
		// 0이라면 집어넣을 숫자 탐색
		if(sudoku[row][col]==0){
			
			for (int i=1; i<=9; i++) {
				// 찾았다면 집어넣고 다음으로 진행
				if(sudoku_check(row,col,i)){
					sudoku[row][col]=i;
					p_2580(row,col+1);
				}
			}
			
			// 탐색 끝나면 원래대로
			sudoku[row][col] = 0;
			return;
		}
		
		p_2580(row,col+1);

	}
	
	//연산자 끼워넣기
	static int o_n;
	static int[] o_nums;
	static int[] o_operators = new int[4];
	static int o_max = -100000000;
	static int o_min = 100000000;
	
	public static void p_14888(int count,int result){
		
		if(count==o_n){
			o_max = Math.max(o_max,result);
			o_min = Math.min(o_min, result);
			return;
		}
		
		// 연산 진행할 다음 숫자
		int num = o_nums[count];
		//연산 결과 (탐색을 끝나고 돌아왔을 떄 result값이 변해있으면 안되므로 새로 선언)
		int r=0;
		
		for(int i=0;i<4;i++){
			
			if(o_operators[i]>0){
				
				// 존재하는 연산자 하나 사용
				o_operators[i]--;
				
				// 연산 진행
				switch(i){
					case 0:
						r = result+num;
						break;
					case 1:
						r = result-num;
						break;
					case 2:
						r = result*num;
						break;
					case 3:
						
						if(result<0){
							r = (result*-1)/num;
							r*=-1;
						}else{
							r = result/num;
						}
						
						break;
				}		
				
				// 연산이 끝나면 다음 count 진행
				p_14888(count+1,r);
				
				// 탐색한 후에는 연산자 개수 원래대로 돌려주기
				o_operators[i]++;
			}
		}
		
		return;
	}

	// 스타트와 링크
	static int sl_n; // 사람수
	static int[][] sl_score; // 능력치
	static int sl_min; 
	static int[] sl_start; //스타트팀으로 선택된 사람들
	
	public static void p_14889(int count,int index){
		
		// 다 뽑았으면 계산
		if(count==sl_n/2){
			
			//link팀
			int[] sl_link = new int[sl_n/2];
			int start_index=0;
			int link_index=0;
			
			for(int i=0;i<sl_n;i++){
				if(start_index<sl_n/2 && i==sl_start[start_index]) {
					start_index++;
				}else{
					sl_link[link_index]=i;
					link_index++;
				}
			}
			
			// start 팀의 능력치 구하기
			int start_score=0;
			int link_score=0;
			
			for(int i : sl_start){
				for(int j : sl_start){
					start_score+=sl_score[i][j];
				}
			}
			
			for(int i : sl_link){
				for(int j : sl_link){
					link_score+=sl_score[i][j];
				}
			}
			
			sl_min = Math.min(sl_min, Math.abs(start_score-link_score));
			
			return;
		}
		
		// start팀 뽑기
		for(int i=index;i<sl_n;i++){
			sl_start[count] = i;
			p_14889(count+1,i+1);
		}
	
		return;
			
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		N = sc.nextInt();
//		M = sc.nextInt();
//		// 길이가 M인 수열
//		arr = new int[M];
		
//		// 1부터 N까지의 방문여부
//		visited = new boolean[N+1];
//		result.setLength(0);
//		p_15649(0);
//		System.out.println(result.toString());
		
//		result.setLength(0);
//		p_15650(0,0);
//		System.out.println(result.toString());
		
//		result.setLength(0);
//		p_15651(0);
//		System.out.println(result.toString());
		
//		result.setLength(0);
//		p_15652(0,1);
//		System.out.println(result.toString());
		
//		n = sc.nextInt();
//		n_arr = new int[n];
//		p_9663(0);
//		System.out.println(n_result);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = sc.nextInt();
			}
		}
		
		p_2580(0,0);
		
//		o_n = sc.nextInt();
//		o_nums = new int[o_n];
//		for(int i=0;i<o_n;i++) o_nums[i] = sc.nextInt(); //숫자 입력
//		for(int i=0;i<4;i++) o_operators[i] = sc.nextInt(); //연산자 입력
//		p_14888(1,o_nums[0]);
//		System.out.println(max);
//		System.out.println(min);
		
//		sl_n = sc.nextInt();
//		sl_score = new int[sl_n][sl_n];
//		sl_start = new int[(sl_n)/2];
//		
//		// 능력치 입력
//		for(int i=0;i<sl_n;i++){
//			for(int j=0;j<sl_n;j++){
//				sl_score[i][j] = sc.nextInt();
//			}
//		}
//		
//		sl_min = Integer.MAX_VALUE;
//		
//		p_14889(0,0);
//		System.out.println(sl_min);

		sc.close();
		
		return;

	}

}
