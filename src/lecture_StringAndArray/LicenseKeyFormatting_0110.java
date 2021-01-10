package lecture_StringAndArray;

public class LicenseKeyFormatting_0110 {
	
	/*
	 주어진 String에 하이픈 제거, 대문자로 바꾸고 끝에서 k만큼씩 끊기
	 
	 input : str="8-5g-3-J" k=4
	 output : 8-5G3J
	 
	 StringBuilder 이용하기 (new 할필요 없음)
	 
	 */
	
	public String solve(String str, int k){
		
		// 1) 하이픈 제거
		String newStr = str.replace("-","");
		
		// 2) 대문자변환
		newStr = newStr.toUpperCase();
		
		// 3) 끝에서 k만큼씩 끊기
		StringBuilder sb = new StringBuilder();
		int length = newStr.length();
		
		// 스트링빌더에 옮기기
		for (int i=0;i<length;i++){
			sb.append(newStr.charAt(i));
		}
		
		//뒤에서부터 k번째씩
		for (int i=k;i<length;i=i+k){
			// char이니까 작은 따옴표
			sb.insert(length-i,'-');
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		LicenseKeyFormatting_0110 a = new LicenseKeyFormatting_0110();
		System.out.println(a.solve("5F3Z-2e-9-w", 4));
	}

}
