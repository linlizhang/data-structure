package list;

public class MergeSortedLists {
	
	public static void main(String[] args) {
		List list1 = new List();
		//initialize list 1;
		list1.insert(2);
		list1.insert(5);
		list1.insert(18);
		list1.insert(3);
		list1.insert(7);
		list1.insert(20);
		System.out.println(list1.toString());
		
		List list2 = new List();
		list2.insert(12);
		list2.insert(3);
		list2.insert(9);
		System.out.println(list2.toString());
		
		List list3 = mergeList(list1, list2);
		
		System.out.println(list3);
	
	}
	
	public static List mergeList(List la, List lb) {
		List lc = new List(la.length() + lb.length());
		int laIndex = 0, lbIndex = 0 ;
		int minLength = la.length() > lb.length() ? lb.length() : la.length();
		for (; laIndex < minLength && lbIndex < minLength; ) {
				if (la.get(laIndex) > lb.get(lbIndex)) {
					lc.insert(lb.get(lbIndex));
					lbIndex++;
				} else {
					lc.insert(la.get(laIndex));
					laIndex++;
				}
		}
		
		while (laIndex < la.length()) {
			lc.insert(la.get(laIndex++));
		}
		
		while (lbIndex < lb.length()) {
			lc.insert(lb.get(lbIndex++));
		}
		
		return lc;
	}
}
