/*parent nodes are bigger than child nodes
    always complete except for last row
    use- quick to insertion and deletion and sorting
    but slow to traverse and search
    */
//analyze this code seems useful

import java.util.Arrays;


public class heap {


    private Data3[] theHeap;


    private int itemsInArray = 0;
    private int maxSize;

    public heap(int maxSize) {


        this.maxSize = maxSize;


        theHeap = new Data3[maxSize];


    }

    public void insert(int index, Data3 newData) {


        theHeap[index] = newData;


        itemsInArray++;


    }


    // Old Tree Generation Code


    public void printTree(int rows) {

        int spaces = 0;


        int iteration = 1;


        while (iteration <= rows) {


            int indent = (int) Math

                    .abs(((Math.pow(-2, -iteration)) * (-16 + (Math.pow(2,

                            iteration)))));


            int indexToPrint = (int) (.5 * (-2 + (Math.pow(2, iteration))));


            int itemsPerRow = (int) (Math.pow(2, iteration - 1));


            int maxIndexToPrint = indexToPrint + itemsPerRow;


            for (int j = 0; j < indent; j++)

                System.out.print(" ");


            for (int l = indexToPrint; l < maxIndexToPrint; l++) {


                System.out.print(theHeap[l].key);


                for (int k = 0; k < spaces; k++)
                    System.out.print(" ");


            }


            spaces = indent;


            iteration++;


            System.out.println();


        }


    }


    public void printTree2(int rows) {


        // Number of spaces between items in tree


        int spaces = 0;


        int iteration = 1;


        // Generate all of the indents that are

        // needed depending on the number of rows

        // to print


        int[] indent = getIndentArray(rows);


        while (iteration <= rows) {


            // Find first Index : .5 * (-2 + 2^n)


            int indexToPrint = (int) (.5 * (-2 + (Math.pow(2, iteration))));


            // Number of Items per Row : 2^(n - 1)


            int itemsPerRow = (int) (Math.pow(2, iteration - 1));


            int maxIndexToPrint = indexToPrint + itemsPerRow;



            /*
096
             * System.out.println("Indent: " + indent[iteration - 1]);
097
             * System.out.println("indexToPrint: " + indexToPrint);
098
             * System.out.println("itemsPerRow: " + itemsPerRow);
099
             * System.out.println("maxIndexToPrint: " + maxIndexToPrint);
100
             */


            // Print the indents needed


            for (int j = 0; j < indent[iteration - 1]; j++)

                System.out.print(" ");


            // Print all of the index values for each row

            // indexToPrint represents the first index in the

            // row, while maxIndexToPrint equals the last


            for (int l = indexToPrint; l < maxIndexToPrint; l++) {


                // If the array isn't full don't try to print

                // indexes that don't exist


                if (l < itemsInArray) {


                    System.out.print(String.format("%02d", theHeap[l].key));


                    for (int k = 0; k < spaces; k++)

                        System.out.print(" ");


                }


            }


            // In a tree the spaces get bigger in the

            // same way that indents get smaller


            spaces = indent[iteration - 1];


            iteration++;


            System.out.println();


        }


    }


    // Calculate each indent per row for the tree

    // then reverse their order to go from biggest

    // to smallest


    public int[] getIndentArray(int rows) {


        int[] indentArray = new int[rows];


        for (int i = 0; i < rows; i++) {


            indentArray[i] = (int) Math.abs((-2 + (Math.pow(2, i + 1))));


        }


        Arrays.sort(indentArray);


        indentArray = reverseArray(indentArray);


        return indentArray;


    }


    // Reverse the indent values in the array

    // so that they go from biggest to smallest


    public int[] reverseArray(int[] theArray) {


        // Index of the first element

        int leftIndex = 0;


        // Index of last element

        int rightIndex = theArray.length - 1;


        while (leftIndex < rightIndex) {

            // Exchange the left and right elements

            int temp = theArray[leftIndex];

            theArray[leftIndex] = theArray[rightIndex];

            theArray[rightIndex] = temp;


            // Move the indexes to check towards the middle

            leftIndex++;

            rightIndex--;

        }


        return theArray;

    }


    // Fill the heap with random numbers based on

    // the number that is passed in


    public void generateFilledArray(int randNum) {


        Data3 randomData1;


        for (int i = 0; i < this.maxSize; i++) {


            randomData1 = new Data3((int) (Math.random() * randNum) + 1);


            this.insert(i, randomData1);


        }


    }


    public static void main(String[] args) {


        System.out.println("OLD TREE");


        heap newHeap = new heap(70);


        // If I generate 2 digit numbers nothing lines up


        // newHeap.generateFilledArray(90);


        newHeap.generateFilledArray(9);


        // If I increase to over 4 rows the spaces are lost in the last row


        // newHeap.printTree(5);


        // newHeap.printTree(6);


        System.out.println("\nNEW TREE\n");


        newHeap.printTree2(6);


    }


}

class Data3 {


    public int key;


    public Data3(int key) {


        this.key = key;


    }


}
