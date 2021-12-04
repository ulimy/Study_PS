package programmers_Level_2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class OpenChatRoom {

	public static class Message {
		String id; // 아이디
		boolean enter_or_leave; // true-입장 false-퇴장

		Message(String id, boolean enter_or_leave) {
			this.id = id;
			this.enter_or_leave = enter_or_leave;
		}
	}

	public static String[] solution(String[] record) {
		final String enter = "님이 들어왔습니다.";
		final String leave = "님이 나갔습니다.";

		Map<String, String> user = new HashMap<>(); // <아이디, 닉네임>
		Queue<Message> messages = new LinkedList<>();

		for (String r : record) {
			String[] input = r.split(" ");

			// 입장 - user, message 추가
			if (input[0].equals("Enter")) {
				user.put(input[1], input[2]);
				messages.offer(new Message(input[1], true));
			}

			// 퇴장 - message 추가
			else if (input[0].equals("Leave")) {
				messages.offer(new Message(input[1], false));
			}

			// 닉네임 변경 - user 추가
			else {
				// 그냥 put하면 map은 중복 허용하지 않으므로 알아서 바꿔줌
				user.put(input[1], input[2]);
			}

		}

		String[] answer = new String[messages.size()];
		int i = 0;
		while (!messages.isEmpty()) {
			Message m = messages.poll();
			answer[i++] = user.get(m.id) + ((m.enter_or_leave) ? enter : leave);
		}
		return answer;
	}

	public static void main(String[] args) {
		solution(new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" });

	}

}
