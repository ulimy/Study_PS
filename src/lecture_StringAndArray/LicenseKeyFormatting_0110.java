package lecture_StringAndArray;

public class LicenseKeyFormatting_0110 {
	
	/*
	 �־��� String�� ������ ����, �빮�ڷ� �ٲٰ� ������ k��ŭ�� ����
	 
	 input : str="8-5g-3-J" k=4
	 output : 8-5G3J
	 
	 StringBuilder �̿��ϱ� (new ���ʿ� ����)
	 
	 */
	
	public String solve(String str, int k){
		
		// 1) ������ ����
		String newStr = str.replace("-","");
		
		// 2) �빮�ں�ȯ
		newStr = newStr.toUpperCase();
		
		// 3) ������ k��ŭ�� ����
		StringBuilder sb = new StringBuilder();
		int length = newStr.length();
		
		// ��Ʈ�������� �ű��
		for (int i=0;i<length;i++){
			sb.append(newStr.charAt(i));
		}
		
		//�ڿ������� k��°��
		for (int i=k;i<length;i=i+k){
			// char�̴ϱ� ���� ����ǥ
			sb.insert(length-i,'-');
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		LicenseKeyFormatting_0110 a = new LicenseKeyFormatting_0110();
		System.out.println(a.solve("5F3Z-2e-9-w", 4));
	}

}
