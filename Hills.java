import java.util.*;

public class Hills {
	int[][] key;
	int[][] iKey;
	int n;

	public Hills(int[][] key) {
		this.key = key;
		n = 26;
		iKey = getInverseKey();
	}

	public String ciper(String data, boolean action) {
		int[][] curKey;
		System.out.println(data);
		if(!action) {
			curKey = iKey;
			for(int i = 0; i < iKey.length; i++){
				for(int j = 0; j < iKey.length; j++) {
					System.out.print(iKey[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			curKey = key;
		}
		char[] arrayData = data.toCharArray();
		int[] block = new int[curKey.length];
		int[] resultBlock = new int[curKey.length];
		StringBuilder result = new StringBuilder();

		for(int i = 0; i < arrayData.length; i++) {
			block[i%curKey.length] = (int) (arrayData[i] - 97);
			if((i + 1)%curKey.length == 0 || ((arrayData.length%curKey.length != 0) && (i == (arrayData.length - 1)))){
				resultBlock = multiply(block, curKey);
				for(int j = 0; j < curKey.length; j++){
					char c = (char)(resultBlock[j] + 97);
					result.append(c);
				}
			}
		}
		return result.toString();

	}

	private int[] multiply(int[] curBlock, int[][] key) {
		int[] result = new int[key.length];
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				result[i] += key[i][j] * curBlock[j];
			}
			result[i] = result[i]%n;
			if(result[i] < 0){
				result[i] += n;
			}
		}
		return result;
	}

	private int[][] getInverseKey() {
		int det = getDet(key);
		if (det < 0){
			det = det + this.n;
		}
		System.out.println("det: " + det);
		if(det == 0){
			throw new RuntimeException("det = 0");
		}
		if(euclid(det, this.n)){
			throw new RuntimeException("(det, n) not 1");
		}
		System.out.println("euclid");
		int inverseDet = findInverse(this.n, det, 0, 1);
		System.out.println("inverse det: " + inverseDet);
		System.out.println("det: " + det);
		int[][] matrix = transpose(getAlgAddMatrix(key));
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				matrix[i][j] = (matrix[i][j]*inverseDet)%this.n;
				if(matrix[i][j] < 0){
					matrix[i][j] += this.n;
				}
			}	
		}
		return matrix;
	}

	private int getDet(int[][] a) {
		int det = 0;
		if(a.length == 2) {
			det = (a[0][0] * a[1][1] - a[0][1]*a[1][0])%this.n;
			return det;
		}
		for(int i = 0; i < a.length; i++) {
			det += (a[0][i]*(int)Math.pow(-1, 2 + i)*getDet(getSubDet(i, 0, a)))%this.n; 
		}
		return det;
	}

	private int[][] getSubDet(int col, int row, int[][] matrix) {
		int size = matrix.length - 1;
		int[][] result = new int[size][size];
		for(int n = 0; n < size; n++){
			for(int k = 0; k < size; k++){
				if(k >= col && n >= row){
					result[n][k] = matrix[n + 1][k + 1]; 
				} else if(n >= row && k < col){
					result[n][k] = matrix[n + 1][k]; 
				} else if(k >= col && n < row){
					result[n][k] = matrix[n][k + 1];
				} else {
					result[n][k] = matrix[n][k];
				}
			}
		}
		return result;
	}

	private int[][] getAlgAddMatrix(int[][] matrix) {
		int[][] result = new int[matrix.length][matrix.length];
		if(matrix.length == 2) {
			result[0][0] = matrix[1][1]%this.n;
			result[0][1] = -matrix[1][0]%this.n;
			result[1][0] = -matrix[0][1]%this.n;
			result[1][1] = matrix[0][0]%this.n;
			return result;
		}
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result.length; j++){
				result[i][j] = ((int)Math.pow(-1, 2 + i + j) * getDet(getSubDet(j, i, matrix)))%this.n;
			}
		}
		return result;
	}

	private int[][] transpose(int[][] matrix) {
		int[][] result = new int[matrix.length][matrix.length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				result[i][j] = matrix[j][i];
			}
		}
		return result;
	}

	private boolean euclid(int x, int y){
		int a = x;
		//if(a < 0){
		//	a = a + y;
		//}
		int b = y;
		while((a != 0) && (b != 0)) {
			if(a >= b) {
				a = a %b;
			} else {
				b = b % a;
			}
			System.out.println(a + " " + b);
		}
		return((a + b) != 1);//false - нет взаимнопростых делителей
	}

	private int findInverse(int r2, int r1, int y2, int y1){//r2 - 	модуль, r1 - к нему нужно найти обратное, 1, 0
		int r0;
		int y0;
		r0 = r2 % r1;
		y0 = y2 - y1 * (r2 / r1);
		if (r0 == 0){
			if (y1 < 0) {
				return (y1 + this.n);
			}
			return y1;
		} else {
			return findInverse(r1, r0, y1, y0);
		}	
	}
}