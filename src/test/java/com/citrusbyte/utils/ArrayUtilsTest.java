package com.citrusbyte.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Test;

import com.citrusbyte.utils.ArrayUtils;

public class ArrayUtilsTest {

	@Test
	public void flattenArrayMustHave4Elements() {
		Object[] array = new Object[2];
		Object[] nestedArray1 = new Object[3];
		Object[] nestedArray1_3 = new Object[1];
		nestedArray1_3[0] = new Integer(3);
		nestedArray1[0] = new Integer(1);
		nestedArray1[1] = new Integer(2);
		nestedArray1[2] = nestedArray1_3;
		array[0] = nestedArray1;
		array[1] = new Integer(4);
		Object[] flattenArray = ArrayUtils.flatArray(array);
		assertThat(flattenArray.length, equalTo(4));
	}
}
