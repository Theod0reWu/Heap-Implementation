import java.util.Scanner;
public class MyHeap{
	private static void pushDown(int[]data,int size,int index){}
	public static void heapify(int[] data){}
	public static void heapsort(int[] data){}
	public static String toHeapString(int[] arr){
		if (arr.length == 0){return "";}
		int hieght = (int)(Math.log(arr.length) / Math.log(2)) + 1;
		String out = ""; String lastRow = ""; 
		String spaces = "                                                                                                    ";
		String edge = "";
		int leaves = arr.length - (int)Math.pow(2,hieght - 1) + 1;
		int oldLeaves = 0;
		for (int l = hieght-1, i = 0; i < hieght * 2-1; i++){
			if (i % 2 == 0){
				String beginingSpace = ""; String copy = new String(edge); /*
				if (edge.indexOf("/") != -1){
					beginingSpace = spaces.substring(0,edge.indexOf("/")+1);
					copy = copy.substring(edge.indexOf("\\")+1);
				}//System.out.println(copy);
				*/
				for (int e = 0; e < leaves; e++){//System.out.println(copy); 
					String space = ""; int num = arr[(int)Math.pow(2,l) + e - 1];
					if (i > 0 ){
						int n = 0;
						n = copy.indexOf("\\");
						int m = n;
						if (copy.indexOf("/") != -1) {m = copy.indexOf("/")+1;}
						if (n== -1){ n = m;} //System.out.println(n+":"+m);
						int q = (m+n)/2 - (num+"").length()/2; //System.out.println(copy.length());
						if (q < 0){q = 0;}
						beginingSpace = spaces.substring(0,q); //System.out.println(n+":"+m+"|"+q);
						if (n < copy.length()){copy = copy.substring(n+1);} 
						if (beginingSpace.length() == 0) {beginingSpace = "    ";}
						if (n > q){space = spaces.substring(0,n - q);}
					}//System.out.println(copy.length());
					if ((i==0 || copy.length() <= 2)  && e % 2 == 1 ){beginingSpace = "   ";}
					else if ((i == 0 || copy.length() <= 2) && e > 0) {beginingSpace = " ";}
					lastRow+=beginingSpace+num + space;
				} lastRow += " ";
				oldLeaves = leaves;
				leaves = (int)Math.pow(2,l-1); 
				l--;
				out = lastRow + "\n"+out;
			}
			if (i % 2 == 1){ //System.out.println(lastRow + "|");
				edge = "";boolean first = false;
				for (int o = 0; o < lastRow.length();o++){
					if (o > 0  && !first&& !lastRow.substring(o-1,o).equals(" ") && lastRow.substring(o,o+1).equals(" ")){
						edge+="/"; first = true;
					}
					else if (o < lastRow.length()-1 &&first&&lastRow.substring(o,o+1).equals(" ") && !lastRow.substring(o+1,o+2).equals(" ")){
						edge += "\\ "; o++; //o if one behind the spaces
						while (!lastRow.substring(o,o+1).equals(" ")){edge+=" ";o++;} //o move ahead by one
						first = false;
					}   //works!!!
					else{edge+=" ";}
				}
				lastRow = "";
				out = edge +"\n"+ out;
			}

		}
		return out;
	}
	public static void main(String[] args) {
		System.out.println(toHeapString(new int[]{100,19,36,5,6,7,8,1,10,1,1,1,1,1,1,1}));
		int[][] arrs = new int[100][];
		for (int i = 0; i < 100; i++){
			arrs[i]= new int[i];
			for(int e  = 0 ; e<i;e++){
				arrs[i][e] = e;
			}
		}
		for (int[] a : arrs){
			System.out.println(toHeapString(a));
		}System.out.println("123".substring(0,0));
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