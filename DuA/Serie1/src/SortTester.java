/**
 * File: SortTester.java
 *
 * Einfaches Testprogramm der Sortieralgorithmen.
 */
import java.util.Random;


public class SortTester {

	public static void printArray(int[] array)
	{
		// Ausgabe des Arrays:
		for (int i=0; i<array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		Timer timer=new Timer();
		Random random=new Random();
		
		// zu sortierender Array:
		for (int laenge=0; laenge<=100000; laenge+=100)
		{
			//Array mit der Länge laenge erstellen:
			int[] array=new int[laenge];
			
			for (int i=0; i<laenge;i++)
			{
				array[i]=random.nextInt(laenge);
			}
			
			//Array sortieren:
			
			//int[] array = {5, 2, 9, 1, 2, 7, 3, 2, 4, 8, 1};
			int[] array2 = new int[array.length];
			java.lang.System.arraycopy(array, 0, array2, 0, array.length);
		
			timer.reset();
			Sorting.insertionSort(array);
			long timeInsertSort=timer.timeElapsed();
			//printArray(array);
		
			timer.reset();
			Sorting.mergeSort(array2, 0, array.length-1);
			long timeMergeSort=timer.timeElapsed();
			//printArray(array2);
		
			System.out.println(laenge + "\t" + timeInsertSort + "\t" + timeMergeSort);
		}
	}
}


