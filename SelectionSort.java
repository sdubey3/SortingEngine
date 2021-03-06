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
public class SelectionSort implements SortingsStrategy {
    @Override
    public void sort(int[] arr, SortingsController sc){
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
            try {
                Platform.runLater(() -> {
                    sc.draw();
                });
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
        }
    }

    @Override
    public void run() {
        
    }
}
