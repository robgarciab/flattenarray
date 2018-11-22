package com.citrusbyte.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ArrayUtils {

	public static Object[] flatArray(Object[] array) {

		List<Object> flattenList = new ArrayList<>();
		flattenList.addAll(Arrays.asList(array));

		ListIterator<Object> iterator = flattenList.listIterator();

		int index = 0;

		while (iterator.hasNext()) {
			Object item = iterator.next();
			if (item instanceof Integer) {
				index++;
			} else {
				List<Object> nestedArray = new ArrayList<>();
				nestedArray.addAll(Arrays.asList((Object[])item));
				iterator.remove();
				for (Object nestedItem : nestedArray) {
					iterator.add(nestedItem);
				}
				iterator = flattenList.listIterator(index);
			}
		}
		return flattenList.toArray();
	}
}
