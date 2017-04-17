package challenge;

import java.util.*;

public class MatchingSets {
    /**
     * 1. Method for creating sorted list
     * 2. Method for incrementing -- DONE
     * 3. Method for decrementing -- DONE
     * 4. Find the elements which are not
     */
    int nop;
    List<Integer> listX;
    List<Integer> listY;
    public MatchingSets(int[] arrX, int[] arrY) {
        listX = createList(arrX);
        listY = createList(arrY);
        System.out.println(listX.size());
        System.out.println(listY.size());
    }

    public void matchingSetsDriver(){
        /**
         * 1. Create the list
         * 2. if the number of elements mismatched is <2 then return -1
         */
        nop = -1;
        int noene = areArraysEqual();

        if(noene < 2) {
            if(noene == 0) nop = 0;
            else nop = -1;
        }
        else  {
            //call a anothe method which executes a while loop
            nop = iterArray();
        }
        System.out.println(nop);
    }

    public int iterArray() {
        int loop_count = listX.size();
        while(areArraysEqual() != 0 && loop_count != 0) {
            compareArrays();
            System.out.println("Loop count:"+loop_count+" Nop:"+nop);

            loop_count -- ;
        }
        return nop;
    }

    public List<Integer> createList(int arr[]) {
        Integer tmpList[] = new Integer[arr.length];

        for(int i = 0; i<arr.length;i++) {
            tmpList[i] = arr[i];
        }
        List<Integer> sortedList = new ArrayList<Integer>(Arrays.asList(tmpList));
        Collections.sort(sortedList);
        return sortedList;
    }

    public int areArraysEqual() {
        //count the number of elements that are not equal
        int noene = 0;

        //Iterate through the list and compare if they are equal
        for(int i=0; i<listX.size(); i++) {
            int elemX = listX.get(i);
            int elemY = listY.get(i);

            if(elemX != elemY)
                noene++;
        }
        return noene;
    }

    public void compareArrays() {
        int decrement_index = -1;
        int increment_index = -1;


        for(int i = 0; i< listX.size(); i++) {
            Integer elemX = listX.get(i);
            Integer elemY = listY.get(i);
            if((elemX < elemY) && increment_index == -1 ) {
                increment_index = i;
            }

            else if((elemY < elemX) && decrement_index == -1) {
                decrement_index = i;
            }

            if(increment_index != -1 && decrement_index != -1) {
                int elemI = listX.remove(increment_index);
                listX.add(increment_index, ++elemI);
                increment_index = 1;

                int elemD = listX.remove(decrement_index);
                listX.add(decrement_index, --elemD);
                decrement_index = -1;
                if(nop == -1)
                    nop = 0;
                nop++;
            }
        }
    }
}

