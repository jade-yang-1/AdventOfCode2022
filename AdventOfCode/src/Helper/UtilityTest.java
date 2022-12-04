package Helper;
import java.util.ArrayList;
import java.util.Arrays;

import Helper.Helper;
/**
 *  To be used for testing the utility functions. 
 * @author jyouayang
 *
 */
public class UtilityTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,6,8,9,10));
		int[] z = {1,2,3,3,4,5,6,7,87};
		System.out.println(a + " - " + Helper.getMaxInt(a) + " - " + Helper.getMaxInt(z));
	}

}
