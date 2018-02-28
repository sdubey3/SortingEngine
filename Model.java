/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Shivam Dubey & Vince Vu
 */
public class Model {
    
    private int intArray[];
    private int arraySize;
    
    public void setArraySize(int size) {
        arraySize = size;
    }
    
    public int getArraySize() {
        return arraySize;
    }
    
    public void reset (int size) {
        arraySize = size;
    }
    
    public int[] getUnsortedList() {
        intArray = new int[arraySize];
        for (int i=0;i<arraySize;i++) {
            Boolean check;
            int randomNum;
            do {
                randomNum = ThreadLocalRandom.current().nextInt(1,arraySize+1);
                check=true;
                for(int j=0;j<i;j++) {
                    if (randomNum == intArray[j]) {
                        check=false;
                        break;
                    }
                }
            } while(!check);
            intArray[i]=randomNum;
        }
        return intArray;
    }      
}