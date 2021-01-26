package lecture_Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder_0126 {
	// 시작단어부터 한! 글자씩 바꿔나가며 마지막 단어를 찾을 수 있는 경우 
	
	public int solve(String begin, String end, List<String> wordList){
		
		//널체크, end가 들어있지 않으면 리턴
		if (wordList==null || !wordList.contains(end)) return 0;
		
		// bfs이용 -> queue!
		Queue<String> queue = new LinkedList<>();
		// 중복을 허용하지 않기 위해 set에 다시 저장
		Set<String> dict = new HashSet<>(wordList);
		
		// begin 먼저 큐에 넣어놓기
		queue.offer(begin);
		dict.add(end);
		dict.remove(begin);
		int level = 1;
		
		while(!queue.isEmpty()){
			// 큐 안에있는 개수만큼 반복
			int size = queue.size();
			for (int i=0;i<size;i++){
				String str = queue.poll();
				//end까지 왔다면 바로 리턴
				if(str.equals(end)) return level;
				for (String neighbor : neighbors(str,wordList)){
					// 글자 하나만 바꾸면 되는 것들 전부 queue에 넣기
					queue.offer(neighbor);
				}
			}
			level++;
		}
	
		return level;
	}
	
	// wordList에 존재하는 단어 중 한글자씩 바꾼 단어들 찾기
	public List<String> neighbors(String s, List<String> wordList){
		List<String> res = new LinkedList<>(); // 결과값 담기
		Set<String> dict = new HashSet<>(wordList); //중복 없애기 위해 set
		
		for (int i=0;i<s.length();i++){
			char[] chars = s.toCharArray();
			for (char ch='a';ch<='z';ch++){
				chars[i]=ch; // i=0-> 0번째 자리가 바뀜 a__ ~ z__
				String word = new String(chars);
				// dict에 존재한다면 (=wordList에 존재한다면) 삭제하고 
				if (dict.remove(word)){
					res.add(word);
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		WordLadder_0126 a = new WordLadder_0126();

		String[] words = {"hot","dot","lot","log","cog"};
		List<String> wordList = Arrays.asList(words);
		
		System.out.println(a.solve("hit","cog",wordList));
	}

}
