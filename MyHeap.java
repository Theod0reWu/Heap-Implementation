import java.util.Scanner;
public class MyHeap{
	private static void pushDown(int[]data,int size,int index){

	}
	private static void swap(int[] data, int a, int b){
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	private static int getRight(int index){return 2*index + 1}
	private static int getLeft(int index){return 2*index + 2;}
	private static int getParent(int index){return (index - 1) / 2;}
	public static void heapify(int[] data){

	}
	public static void heapsort(int[] data){}
	public static void main(String[] args) {
		
	}
}
/*
          100
      /          \
     19           36
   /    \        /   \
  5      6      7     8
 / \    / \   / \   / 
1   10 1   1 1   1 1  
*/