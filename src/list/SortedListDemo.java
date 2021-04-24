package list;

public class SortedListDemo {
	
	public static void main(String[] args) {
		SortedList list1 = new SortedList();
		//initialize list 1;
		list1.insert(2);
		list1.insert(5);
		list1.insert(18);
		list1.insert(3);
		list1.insert(7);
		list1.insert(20);
		System.out.println(list1.toString());
		
		SortedList list2 = new SortedList();
		list2.insert(12);
		list2.insert(3);
		list2.insert(9);
		System.out.println(list2.toString());
		
		SortedList list3 = list1.merge(list2);
		
		System.out.println(list3);
	
	}
}
