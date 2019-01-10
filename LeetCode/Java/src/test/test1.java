package test;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		System.out.println(Find(16,arr));
         
	}
	 public static boolean Find(int target, int [][] array) {
	        int rowCount=array.length;
	        int colCount=array[0].length;
	        int i=0,j=colCount-1;
	        boolean f=false;
	        while(i<rowCount&&j>=0){
	        	if(target==array[i][j]){
	                f=true;
	                break;               
	            }
	            if(target>array[i][j]){
	                i++;
	                continue;
	            }
	            if(target<array[i][j]){
	                j--;
	                continue;
	            }
	            
	        }
	       return f;
	    }

}
