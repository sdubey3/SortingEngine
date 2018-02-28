/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import javafx.application.Platform;

/**
 *
 * @author Shivam Dubey & Vince Vu
 */
public class MergeSort implements SortingsStrategy {
    private int[] array;
    private int[] tempMergArr;
    private int length;
    private SortingsController sc;
     
    @Override
    public void sort(int inputArr[], SortingsController svc) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        this.sc = svc;
        doMergeSort(0, length - 1, sc);
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex, SortingsController sc) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle, sc);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex, sc);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
            try {
                Platform.runLater(() -> {
                    sc.draw();
                });
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }

    @Override
    public void run() {
        
    }
}
