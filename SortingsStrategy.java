/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

/**
 *
 * @author Shivam Dubey & Vince Vu
 */
public interface SortingsStrategy extends Runnable {
    public void sort(int[] arr, SortingsController sc);
}