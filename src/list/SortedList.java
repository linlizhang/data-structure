package list;

import exception.ListOutofIndexException;

public class SortedList {
	
	private int[] list;
	
	private int capacity = 20;
	
	private int count = 0;
	
	public SortedList() {
		list = new int[capacity];
	}
	
	public SortedList(int capacity) {
		this.capacity = capacity;
		this.list = new int[this.capacity];
	}
	
	public int get(int index)  {
		if (index >= count || index < 0) {
			throw new ListOutofIndexException();
		}
		
		return list[index];
	}
	
	public void insert(int value) {
		if (count == capacity) {
			throw new RuntimeException("List is full");
		}
		
		int location = 0;
		for (int index = count -1 ;index >= 0;) {
			if (value < list[index]) {
				index--;
			} else {
				location = index + 1;
				break;
			}
		}
		
		for (int index = count; index > location; index--) {
			list[index] = list[index-1];
		}
		list[location] = value;
		count++;
	}
	
	public SortedList merge(SortedList lb) {
		SortedList lc = new SortedList(this.length() + lb.length());
		int laIndex = 0, lbIndex = 0 ;
		int minLength = this.length() > lb.length() ? lb.length() : this.length();
		for (; laIndex < minLength && lbIndex < minLength; ) {
				if (this.get(laIndex) > lb.get(lbIndex)) {
					lc.insert(lb.get(lbIndex));
					lbIndex++;
				} else {
					lc.insert(this.get(laIndex));
					laIndex++;
				}
		}
		
		while (laIndex < this.length()) {
			lc.insert(this.get(laIndex++));
		}
		
		while (lbIndex < lb.length()) {
			lc.insert(lb.get(lbIndex++));
		}
		
		return lc;
	}
	
	public void clear() {
		count = 0;
	}
	
	public void destroy() {
		list = null;
	}
	
	public boolean isEmpty() {
		return 0 == length();
	}
	
	public int length() {
		return count;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int index = 0; index < count; index++) {
			str.append(list[index]).append(" " );
		}
		
		return str.toString();
	}
}
