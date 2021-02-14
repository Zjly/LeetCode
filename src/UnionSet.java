public class UnionSet {
	private final int[] unionSet;
	private final int[] ranks;
	private int count;

	public UnionSet(int length) {
		unionSet = new int[length];
		ranks = new int[length];
		count = length;

		for(int i = 0; i < length; i++) {
			unionSet[i] = i;
			ranks[i] = 1;
		}
	}

	public int findRoot(int index) {
		while(index != unionSet[index]) {
			index = unionSet[index];
		}

		return index;
	}

	public void union(int index1, int index2) {
		int root1 = findRoot(index1);
		int root2 = findRoot(index2);

		if(root1 != root2) {
			if(ranks[root1] > ranks[root2]) {
				unionSet[root2] = root1;
			} else if(ranks[root1] < ranks[root2]) {
				unionSet[root1] = root2;
			} else {
				unionSet[root2] = root1;
				ranks[root1]++;
			}

			count--;
		}
	}

	public boolean isConnected(int index1, int index2) {
		return findRoot(index1) == findRoot(index2);
	}

	public int getConnectCount() {
		return count;
	}

	public int[] getUnionSet() {
		return unionSet;
	}
}
