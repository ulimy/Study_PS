package programmers_HighScoreKit;

import java.util.Arrays;

public class Hash {
	
	// 완주하지 못한 선수
	 public String AthletesNotComplete(String[] participant, String[] completion) {
		 
		 Arrays.sort(participant);
		 Arrays.sort(completion);
		 
		 for(int i=0;i<completion.length;i++){
			 if(!participant[i].equals(completion[i])){
				 return participant[i];
			 }
		 }
		 
		 return participant[participant.length-1];
	 }

	public static void main(String[] args) {
		
		return;
	}

}
