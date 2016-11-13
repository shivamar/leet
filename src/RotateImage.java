public class RotateImage {
    public void rotate(int[][] matrix)
	{
		if(matrix == null || matrix[0].length == 1) return;		
		int n = matrix[0].length;
		
		for(int layer=0; layer < n/2; layer++ )
		{
			matrix = rotateLayer(matrix, layer);
		}
	}
	
	//topLeft is first
	//bottomRight is last
	//u need offset to move from 1 to nth row in a layer
	public int[][] rotateLayer(int[][] matrix, int layer)
	{
		int topLeft=layer;
		int bottomRight=(matrix[0].length-1) - layer;
		
		for(int round=layer; round < (matrix[0].length-1) - layer; round++)
		{
		    int offset= round-layer;
			int temp=matrix[topLeft][topLeft+offset];
			matrix[topLeft][topLeft+offset] = matrix[bottomRight-offset][topLeft];
			matrix[bottomRight-offset][topLeft]=matrix[bottomRight][bottomRight-offset];
			matrix[bottomRight][bottomRight-offset]=matrix[topLeft+offset][bottomRight];
			matrix[topLeft+offset][bottomRight]=temp;
		}
		
		return matrix;
	}
}