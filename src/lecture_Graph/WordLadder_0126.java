package lecture_Graph;

import java.util.Arrays;
import java.util.List;

public class WordLadder_0126 {
	// 한! 글자씩 바꿀 수 있는 경우
	
	public int solve(String begin, String end, List<String> wordList){
		return 0;
	}

	public static void main(String[] args) {
		WordLadder_0126 a = new WordLadder_0126();

		String[] words = {"hot","dot","lot","log","cog"};
		List<String> wordList = Arrays.asList(words);
		
		System.out.println(a.solve("hit","cog",wordList));
	}

}
