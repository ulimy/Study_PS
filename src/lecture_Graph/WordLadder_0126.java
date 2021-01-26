package lecture_Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder_0126 {
	// ���۴ܾ���� ��! ���ھ� �ٲ㳪���� ������ �ܾ ã�� �� �ִ� ��� 
	
	public int solve(String begin, String end, List<String> wordList){
		
		//��üũ, end�� ������� ������ ����
		if (wordList==null || !wordList.contains(end)) return 0;
		
		// bfs�̿� -> queue!
		Queue<String> queue = new LinkedList<>();
		// �ߺ��� ������� �ʱ� ���� set�� �ٽ� ����
		Set<String> dict = new HashSet<>(wordList);
		
		// begin ���� ť�� �־����
		queue.offer(begin);
		dict.add(end);
		dict.remove(begin);
		int level = 1;
		
		while(!queue.isEmpty()){
			// ť �ȿ��ִ� ������ŭ �ݺ�
			int size = queue.size();
			for (int i=0;i<size;i++){
				String str = queue.poll();
				//end���� �Դٸ� �ٷ� ����
				if(str.equals(end)) return level;
				for (String neighbor : neighbors(str,wordList)){
					// ���� �ϳ��� �ٲٸ� �Ǵ� �͵� ���� queue�� �ֱ�
					queue.offer(neighbor);
				}
			}
			level++;
		}
	
		return level;
	}
	
	// wordList�� �����ϴ� �ܾ� �� �ѱ��ھ� �ٲ� �ܾ�� ã��
	public List<String> neighbors(String s, List<String> wordList){
		List<String> res = new LinkedList<>(); // ����� ���
		Set<String> dict = new HashSet<>(wordList); //�ߺ� ���ֱ� ���� set
		
		for (int i=0;i<s.length();i++){
			char[] chars = s.toCharArray();
			for (char ch='a';ch<='z';ch++){
				chars[i]=ch; // i=0-> 0��° �ڸ��� �ٲ� a__ ~ z__
				String word = new String(chars);
				// dict�� �����Ѵٸ� (=wordList�� �����Ѵٸ�) �����ϰ� 
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
