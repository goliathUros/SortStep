import java.util.*;

public class Sorts
{
  public void bubbleSort(int[] list)
  {
    for(int j = 0; j < list.length; j++){
      for(int i = 0; i < list.length - j - 1; i++){
        if(list[i] > list[i + 1]){
          int temp = list[i];
          list[i] = list[i + 1];
          list[i + 1] = temp;
        }
      }
    }
  }

  public void selectionSort(int[] list)
  {
    int flag, temp;
    for(int k = 0; k < list.length - 1; k++){
      flag = k;
      for(int i = k + 1; i < list.length; i++){
        if(list[i] < list[flag]) {flag = i;}
      }
      temp = list[k];
      list[k] = list[flag];
      list[flag] = temp;
    }
  }

  public void insertionSort(int[] list)
  {
    for(int l = 1; l < list.length; l++) {
      int position = l;
      int key = list[position];
      //Shift larger values to the right
      while (position > 0 && list[position - 1] > key) {
        list[position] = list[position - 1];
        position--;
      }
      list[position] = key;
    }
  }

  private void merge(int[] a, int first, int mid, int last)
  {
    int[] tempArr = new int[a.length];
    int nA = first;
    int nB = mid + 1;
    for(int i = first; i <= last; i++){
      tempArr[i] = a[i];
    }
    int i = first;
    int j = mid + 1;
    int k = first;
    while(i <= mid && j <= last){
      if(tempArr[i] <= tempArr[j]){
        a[k] = tempArr[i];
        i++;
      } else {
        a[k] = tempArr[j];
        j++;
      }
      k++;
    }
    while(i <= mid){
      a[k] = tempArr[i];
      k++;
      i++;
    }
  }

  public void mergeSort(int[] a, int first, int last)
  {
    if(first < last){
      int mid = first + (last - first)/2;
      mergeSort(a, first, mid);
      mergeSort(a, mid + 1, last);
      merge(a, first, mid, last);
    }
  }
}
