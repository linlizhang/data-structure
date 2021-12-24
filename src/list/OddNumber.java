package list;

import java.util.ArrayList;
import java.util.List;

public class OddNumber {

	public static void main(String[] args) {
		System.out.println(palindrome("aaba"));
	}


	public static int palindrome(String s) {
		// Write your code here
		List<String> strs = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String t = s.substring(i, j);
				if (isEqual(t) && !strs.contains(t)) {
					System.out.println(t);

					strs.add(t);

				}
			}
		}

		return strs.size();
	}

	private static boolean isEqual(String s) {
		if (s.length() == 1) {
			return true;
		}
		int left = 0, right = s.length();
		int index = (right - left) / 2;
		String leftStr = s.substring(left, index);
		String rightStr = "";
		if (s.length()%2 == 0) {
			rightStr = s.substring(index , right);
		} else {
			rightStr = s.substring(index + 1, right);
		}
		return leftStr.equals(rightStr);

	}

}
