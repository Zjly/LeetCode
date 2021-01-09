import java.util.ArrayList;
import java.util.List;

public class Question228_SummaryRanges {
	public static void main(String[] args) {

	}
}

class Solution228 {
	public List<String> summaryRanges(int[] nums) {
		if(nums.length == 0) {
		    return new ArrayList<>();
		}

		List<String> result = new ArrayList<>();
		int begin = nums[0];
		int end = nums[0];

		for(int i = 1; i < nums.length; i++) {
			if(nums[i] - 1 != nums[i - 1]) {
				if(begin == end) {
				    result.add(String.valueOf(begin));
				} else {
					result.add(begin + "->" + end);
				}
			    begin = nums[i];
			    end = nums[i];
			} else {
			    end++;
			}
		}

		if(begin == end) {
			result.add(String.valueOf(begin));
		} else {
			result.add(begin + "->" + end);
		}

		return result;
	}
}