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
public class InsertionSort implements SortingsStrategy {
    @Override
    public void sort(int arr[],SortingsController sc){
        int curr;
        int i,j;
        for(i=0;i<arr.length;i++){
            curr=arr[i];
            for(j=i;j>0 && arr[j-1] > curr;j--){
                arr[j]=arr[j-1];
            }
            arr[j]=curr;
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
