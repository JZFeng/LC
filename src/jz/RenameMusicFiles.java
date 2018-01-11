package jz;

import java.io.File;
import java.util.Random;

public class RenameMusicFiles {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please enter a valid path");
			System.exit(0);
		}

		for (int i = 0; i < args.length; i++) {
			if (args[i].trim().length() > 0) {
				String parameter = args[i].trim();
				
				while (parameter.endsWith("/")) {
					parameter = parameter.substring(0, parameter.length() - 1);
				}

				File f = new File(parameter);
				System.out.println(f.getAbsolutePath());
				renameFilesRandomly(f);

			}

		}

	}

	private static void renameFilesRandomly(File f) {
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
				file.renameTo(new File(f.getAbsolutePath() + "/" + array[i] + file.getName()));
			}

		}
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
