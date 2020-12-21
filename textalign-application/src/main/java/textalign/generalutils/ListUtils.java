package textalign.generalutils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListUtils {
	
	/**
	 * Unions two lists without manipulating either of the original ones
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static <T> List<T> union( List<T> list1, List<T> list2 ) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }
	
	/**
	 * Unions a list with an element without manipulating the passed list
	 * @param list
	 * @param element
	 * @return
	 */
	public static <T> List<T> union( List<T> list, T element) {
        Set<T> set = new HashSet<T>();

        set.addAll(list);
        set.add(element);

        return new ArrayList<T>(set);
    }
	
	/**
	 * Unions a list with an element without manipulating the passed list
	 * @param list
	 * @param element
	 * @return
	 */
	public static <T> List<T> union( T element, List<T> list ) {
        return union(list, element);
    }
	
}
