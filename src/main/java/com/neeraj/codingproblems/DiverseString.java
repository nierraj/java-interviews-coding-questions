package com.neeraj.codingproblems;

public class DiverseString {

	public String getDiverseString(int a, int b, int c) {
		int frequency[] = new int[3];
		frequency[0] = a;
		frequency[1] = b;
		frequency[2] = c;
		int previousChar[] = new int[3];
		previousChar[0] = 0;
		previousChar[1] = 0;
		previousChar[2] = 0;
		String sequence = "";

		while (true) {
			int order[] = order(frequency);
			int index1 = order[0];
			int index2 = order[1];
			if (frequency[index1] == 0)
				break;
			else if (previousChar[index1] < 2) {
				// System.out.print(intToChar(index1) + " ");
				previousChar[index1]++;
				for (int i = 0; i < 3; i++) {
					if (i != index1)
						previousChar[i] = 0;
				}
				sequence = sequence + intToChar(index1);
				frequency[index1]--;
			} else if (frequency[index2] == 0)
				break;
			else {
				// System.out.print(intToChar(index2) + " ");
				sequence = sequence + intToChar(index2);
				frequency[index2]--;
				previousChar[index2]++;
				for (int i = 0; i < 3; i++) {
					if (i != index2)
						previousChar[i] = 0;
				}
			}
		}
		return sequence;
	}

	public char intToChar(int i) {
		if (i == 0) {
			return ('a');
		}
		if (i == 1) {
			return ('b');
		} else
			return ('c');
	}

	public int[] order(int frequency[]) {
		int maxNumberIndex = 0;
		if (frequency[0] >= frequency[1] && frequency[0] >= frequency[2]) {
			maxNumberIndex = 0;
		} else if (frequency[1] >= frequency[2] && frequency[1] >= frequency[0]) {
			maxNumberIndex = 1;
		} else if (frequency[2] >= frequency[0] && frequency[2] >= frequency[1]) {
			maxNumberIndex = 2;
		}

		int indexArray[] = new int[2];
		indexArray[0] = maxNumberIndex;
		int nrr[] = new int[2];
		int k = 0;
		for (int i = 0; i < frequency.length; i++) {
			if (i != maxNumberIndex) {
				nrr[k] = i;
				k++;
			}
		}
		if (frequency[nrr[0]] >= frequency[nrr[1]])
			indexArray[1] = nrr[0];
		else
			indexArray[1] = nrr[1];
		return indexArray;
	}

	public static void main(String[] args) {

		DiverseString diverseString = new DiverseString();
		System.out.println(diverseString.getDiverseString(6, 1, 1));
		System.out.println(diverseString.getDiverseString(1, 3, 1));
		System.out.println(diverseString.getDiverseString(0, 1, 8));
	}
}
