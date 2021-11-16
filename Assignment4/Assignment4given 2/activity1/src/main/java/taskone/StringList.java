package taskone;

import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.util.Collections;


class StringList {
    
    List<String> strings = new ArrayList<String>();

    public void add(String str) {
        int pos = strings.indexOf(str);
        if (pos < 0) {
            strings.add(str);
        }
		
    }
	
	public String pop(String ind) {
		int element = Integer.parseInt(ind);
		
		return strings.remove(element);
	}	

	public String count() {
		String number = Integer.toString(strings.size());
		
		return number;
	}
	
	public String reverse(String ind2) {	
		int element2 = Integer.parseInt(ind2);
		String strr = strings.get(element2);
		String rev = new StringBuffer(strr).reverse().toString();
		strings.set(element2, rev);
		
		return rev;
    }
	
	public void quit() {
		System.exit(0);
	}

    public boolean contains(String str) {
        return strings.indexOf(str) >= 0;
    }

    public int size() {
        return strings.size();
    }

    public String toString() {
        return strings.toString();
    }
}