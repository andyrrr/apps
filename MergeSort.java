package sorts;

import java.util.ArrayList;

public class MergeSort {
	void sort(ArrayList<Integer> lista, int izq, int der) {
		if (izq < der) {
			// Find the middle point
			int med = (izq + der) / 2;

			// Sort first and second halves
			sort(lista, izq, med);
			sort(lista, med + 1, der);

			// Merge the sorted halves
			merge(lista, izq, med, der);
		}
	}

	void merge(ArrayList<Integer> lista, int izq, int med, int der) {
		// Find sizes of two subarrays to be merged
		int n1 = med - izq + 1;
		int n2 = der - med;

		/* Create temp arrays */
		ArrayList<Integer> L = new ArrayList<Integer>();
		ArrayList<Integer> R = new ArrayList<Integer>();
		for (int i = 0; i < n1; ++i) {
			L.add(lista.get(izq + i));
		}

		System.out.println("Izquierda: " + L);
		for (int j = 0; j < n2; ++j) {
			R.add(lista.get(med + 1 + j));
		}

		System.out.println("Derecha: "+R);
		int i = 0;
		int j = 0;
		int k = izq;
		while (i < n1 && j < n2) {
			if (L.get(i) <= R.get(j)) {
				lista.set(k, L.get(i));
				i++;
				System.out.println(lista);
			} else {
				lista.set(k, R.get(j));
				j++;
				System.out.println(lista);
			}
			k++;
		}

		while (i < n1) {
			lista.set(k, L.get(i));
			i++;
			k++;
			System.out.println(lista);
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			lista.set(k, R.get(j));
			j++;
			k++;
			System.out.println(lista);
		}
	}

	// Driver method
	public static void main(String args[]) {
		ArrayList<Integer> listaFinal = new ArrayList<Integer>();
		String lista = "3,60,35,2,45,320,5";
		String[] li = lista.split(",");
		for (int i = 0; i < li.length; i++) {
			listaFinal.add(Integer.valueOf(li[i]));
		}
		System.out.println(listaFinal);
		MergeSort ob1 = new MergeSort();
		ob1.sort(listaFinal, 0, listaFinal.size() - 1);
		System.out.println(listaFinal);

	}
}