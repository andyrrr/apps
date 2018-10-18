package sorts;

import java.util.ArrayList;

// Java program for implementation of QuickSort 
public class QuickSort {

	void sort(ArrayList<Integer> lista, int menor, int mayor) {
		if (menor < mayor) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(lista, menor, mayor);

			// Recursively sort elements before
			// partition and after partition
			sort(lista, menor, pi - 1);
			sort(lista, pi + 1, mayor);
		}
	}

	int partition(ArrayList<Integer> lista, int menor, int mayor) {
		int pivot = lista.get(mayor);
		int i = (menor - 1); // index of smaller element
		for (int j = menor; j < mayor; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (lista.get(j) <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = lista.get(i);
				lista.set(i, lista.get(j));
				lista.set(j, temp);
				System.out.println(lista);
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = lista.get(i + 1);
		lista.set(i + 1, lista.get(mayor));
		lista.set(mayor, temp);
		System.out.println(lista);

		return i + 1;
	}

	// Driver program
	public static void main(String args[]) {
		ArrayList<Integer> listaFinal = new ArrayList<Integer>();
		String lista = "10,7,8,9,1,5";
		String[] li = lista.split(",");
		for (int i = 0; i < li.length; i++) {
			listaFinal.add(Integer.valueOf(li[i]));
		}
		
		System.out.println(listaFinal);
		QuickSort ob1 = new QuickSort();
		ob1.sort(listaFinal, 0, listaFinal.size() - 1);
		System.out.println(listaFinal);

	}
}
