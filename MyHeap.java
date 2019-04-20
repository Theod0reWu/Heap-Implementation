import java.util.Arrays;
public class MyHeap{
	private static void pushDown(int[]data,int size,int index){
		while (getLeft(index) < size){
			//System.out.println(HeapHelp.toString(data));
			int maxIndex = -1;
			if (getRight(index) >= size || data[getLeft(index)] >= data[getRight(index)]){
				if (data[index] < data[getLeft(index)]){maxIndex = getLeft(index);}
			}
			else if (getRight(index) < size && data[getLeft(index)] < data[getRight(index)]){
				if (data[index] < data[getRight(index)]){maxIndex = getRight(index);}
			}
			if (maxIndex != -1){
				swap(data, index, maxIndex);
				index = maxIndex;
			}
			else {index = size;}
		}
		//System.out.println(HeapHelp.toString(data));
	}
	private static void swap(int[] data, int a, int b){
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	private static int getLeft(int index){return 2*index + 1;}
	private static int getRight(int index){return 2*index + 2;}
	private static int getParent(int index){return (index - 1) / 2;}
	public static void heapify(int[] data){
		for (int i = (int)Math.pow(2,(int)(Math.log(data.length) / Math.log(2)))-2; i >= 0; i--){
			pushDown(data, data.length, i);
		}
	}
	public static void heapsort(int[] data){
		heapify(data);
		int size = data.length-1;
		while (size > 0){
			swap(data, 0, size);
			pushDown(data, size,0);
			size--;
		}
	}
	public static void mains(String[] args) {
		int[] a = new int[]{1,3,41,1,3,432,43,3,34,24,2};
		System.out.println("**************");
		heapsort(a);
	}
	public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        heapsort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }}
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