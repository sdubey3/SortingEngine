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
public class BubbleSort implements SortingsStrategy {
    @Override
    public void sort(int[] array, SortingsController sc) {
        int i, j;
        int tmp;
        for (i = 0; i < array.length - 1; i++) {
            for (j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //swap arr[j] and arr[j+1]
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
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
