package com.programcreek.matrix;

public class SpiralMatrix {

	public static void main(String[] args) {
		
		int row = 3;
		int column = 3;
		int number = 1;
		int matrix[][] = new int[row][column]; 
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				matrix[i][j] = number++; 
			}
		}
		boolean flag = true;
		int rowCounter = 0;
		int colCounter = 0;
		int rowSize = 2;
		boolean counterFlag = true;
		int colSize = 2;
		boolean colCounterFlag = true;
		int checker = 20;
		while(number-- >0){
			
			for(int i=0;i<row;i++){
				System.out.println(matrix[colCounter][rowCounter]);
				if((rowCounter == rowSize && flag) || (colCounter == colSize && !flag)){
//					counterFlag = !counterFlag;
					flag = !flag;
				}
				if(flag){
					
					if(counterFlag){
						rowCounter++;	
					}else{
						rowCounter--;
					}
//					if(rowCounter == rowSize){
//						rowSize--;
//					}
				}else{
					if(counterFlag){
						colCounter++;	
					}else{
						colCounter--;
					}
//					if(colCounter == colSize){
//						colSize--;
//					}
				}	
			}
			counterFlag = !colCounterFlag;
			
		}
	}
}
