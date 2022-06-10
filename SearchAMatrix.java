import java.util.ArrayList;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

/**
 * SearchAMatrix
 */
public class SearchAMatrix {

    static boolean findTargetInMatrix(ArrayList<ArrayList<Integer>> mat, int m, int n, int target) {

        int left= 0;
        int right=m*n-1;
        int mid;
        while (left<=right) {
            mid=left+(right-left)/2;
            int middle = mat.get(mid/n).get(mid%n);
            if(middle==target){
                return true;
            }
            else if(middle>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }

		return false;
	}
    public static void main(String[] args) {
        int target=7;
        int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        ArrayList <ArrayList<Integer>> mat= new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            ArrayList <Integer> temp = new ArrayList<>();
            for (int j = 0; j < matrix[0].length; j++) {
                temp.add(matrix[i][j]);
            }
            mat.add(temp);
        }
        System.out.println(findTargetInMatrix(mat,matrix.length,matrix[0].length,target));
    }
}