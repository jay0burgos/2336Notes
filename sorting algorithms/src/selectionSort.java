
    //has two nested loops
    //n^2 since every loop goes to n
    //checks every number does a comparison and moves on
    //not adaptivep-> always acts the same
public class selectionSort {
        /**
         * The method for sorting the numbers
         */
        public static void selectionSort(double[] list) {
            for (int i = 0; i < list.length - 1; i++) {
                // 1- Find the minimum in the list[i..list.length-1]
                double currentMin = list[i];
                int currentMinIndex = i;

                for (int j = i + 1; j < list.length; j++) {
                    if (currentMin > list[j]) {
                        currentMin = list[j];
                        currentMinIndex = j;
                    }
                }
                // 2- Swap list[i] with list[currentMinIndex] if necessary;
                if (currentMinIndex != i) {
                    list[currentMinIndex] = list[i];
                    list[i] = currentMin;
                }
            }
        }

        //recursive selection sort
        public static void sort(double[] list) {
            sort(list, 0, list.length - 1); // Sort the entire list
        }

        private static void sort(double[] list, int low, int high) {
            if (low < high) {
                // 1- Find the smallest number and its index in list(low .. high)
                int indexOfMin = low;
                double min = list[low];
                for (int i = low + 1; i <= high; i++) {
                    if (list[i] < min) {
                        min = list[i];
                        indexOfMin = i;
                    }
                }
                // 2- Swap the smallest in list(low .. high) with list(low)
                list[indexOfMin] = list[low];
                list[low] = min;
                // Sort the remaining list(low+1 .. high)
                sort(list, low + 1, high);
            }
            //if low goes over high, no more calling the method
        }
    }
