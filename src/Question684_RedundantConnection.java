public class Question684_RedundantConnection {
	public static void main(String[] args) {

	}
}

class Solution684 {
	public int[] findRedundantConnection(int[][] edges) {
		int[] unionSet = new int[edges.length];

		for(int i = 0; i < edges.length; i++) {
			unionSet[i] = i;
		}

		for(int[] edge : edges) {
			int point1 = edge[0] - 1;
			int point2 = edge[1] - 1;

			int root1 = findRoot(unionSet, point1);
			int root2 = findRoot(unionSet, point2);

			if(root1 == root2) {
				return new int[]{point1 + 1, point2 + 1};
			}

			union(unionSet, point1, point2);
		}

		return null;
	}

	public int findRoot(int[] unionSet, int index) {
		if(unionSet[index] == index) {
			return index;
		}

		return unionSet[index] = findRoot(unionSet, unionSet[index]);
	}

	public void union(int[] unionSet, int index1, int index2) {
		int root1 = findRoot(unionSet, index1);
		int root2 = findRoot(unionSet, index2);

		if(root1 != root2) {
			unionSet[root2] = root1;
		}
	}
}

