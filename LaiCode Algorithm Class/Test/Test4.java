public class Test4 {


    public static void main(String[] args) {

		  /*Scanner scan=new Scanner(System.in); int m=scan.nextInt();
		  int [] keep=heapsort();
		  for(int i= 0;i < m; i++){
			  int result= keep[i];
		      System.out.print(result);
		   }*/

        int[] array = new int[]{ 1, 3, 5, 7, 2, 4, 6, 8};
        heapsort(array);


    }

    public static int[] heapsort(int[] arr) {

        //int arr[] = { 1, 3, 5, 7, 2, 4, 6, 8 };
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);

        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }

        for (int k = 0; k < arr.length; k++) {
            System.out.println(arr[k]);
        }

        return arr;
    }

    public static void heapify(int arr[], int index, int heapsize) {
        int left = 2 * index + 1; // the local of left children
        while (left < heapsize) {
            int largest = left + 1 < heapsize && arr[left] < arr[left + 1] ? left + 1 : left ;// compare the size of the
            // right children and
            // left children
            largest = arr[largest] > arr[index] ? largest : index;
            // compare the size of father and largest children
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }

    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
