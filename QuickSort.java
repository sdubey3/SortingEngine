/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import javafx.application.Platform;

/**
 *
 * @author Shivam
 */
public class QuickSort implements SortingsStrategy {
    
    private int startingInd;
    private int endingInd;
    private int[] array;

    @Override
    public void sort(int[] arr, SortingsController sc) {
        this.array = arr;
        this.startingInd = 0;
        this.endingInd = arr.length-1;
        quickSort(array,startingInd,endingInd, sc);
    }
    
    int partition(int arr[], int low, int high, SortingsController sc) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        try {
            Platform.runLater(() -> {
                sc.draw();
            });
            Thread.sleep(50);
        } catch (InterruptedException ex) {
        }

        return i + 1;
    }
    
    void quickSort(int arr[], int low, int high, SortingsController sc) {
        if (low < high) {
            int pi = partition(arr, low, high, sc);
            quickSort(arr, low, pi - 1, sc);
            quickSort(arr, pi + 1, high, sc);
        }
    }

    @Override
    public void run() {
        
    }
    
}
