package exception;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		String str = "Jim went Went To to to school went to";
		StringBuffer buffer = new StringBuffer();
		String[] strArr = str.split(" ");
		Map<String, String> strMap = new HashMap<>();
		
		for(int i=0; i< strArr.length; i++) {
			if(strMap.containsKey(strArr[i].toLowerCase())) {
				continue;
			}
			strMap.put(strArr[i].toLowerCase(), strArr[i]);
			buffer.append(strArr[i]).append(" ");
		}
		System.out.println(buffer.toString());
	}
}
