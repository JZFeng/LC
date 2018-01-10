package jz;

import java.io.File;
import java.util.Random;

public class RenameMusicFiles {

	public static void main(String[] args) {

		File f = new File("/Users/jzfeng/Downloads/music");
		System.out.println(f.getAbsolutePath());
		
		if (f.exists() && f.isDirectory()) {
			File[] allFiles = f.listFiles();
			int numOfFiles = allFiles.length;
			int[] array = new int[numOfFiles];
			for (int i = 0; i < numOfFiles; i++) {
				array[i] = i;
			}
			Random rd = new Random();

			for (int i = numOfFiles - 1; i >= 0; i--) {
				File file = allFiles[i];
				int index = rd.nextInt(i + 1);
				swap(array, index, i);

				file.renameTo(new File("/Users/jzfeng/Downloads/target/" + array[i] + file.getName()));
			}

		}

	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
