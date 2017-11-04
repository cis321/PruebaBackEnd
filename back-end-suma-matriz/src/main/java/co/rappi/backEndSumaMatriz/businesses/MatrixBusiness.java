package co.rappi.backEndSumaMatriz.businesses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.rappi.backEndSumaMatriz.exceptions.BusinessException;
import co.rappi.backEndSumaMatriz.exceptions.TechnicalException;
import co.rappi.backEndSumaMatriz.representations.MatrixAndOperationsDTO;
import co.rappi.backEndSumaMatriz.representations.Operation;

public class MatrixBusiness {
	
	private static final String UPDATE = "UPDATE";
	
	private static final String QUERY = "QUERY";

	public List<String> calculateResults(MatrixAndOperationsDTO matrixAndOperationsDTO)
			throws TechnicalException, BusinessException {
		
		List<String> results = new ArrayList<String>();
		
		final int xLength = matrixAndOperationsDTO.getxLength();
		final int yLength = matrixAndOperationsDTO.getyLength();
		final int zLength = matrixAndOperationsDTO.getzLength();

		int[][][] matrix = new int[xLength][yLength][zLength];
		
		//Initialize defaut cero value matrix
		
		for (int i = 0; i < xLength; i++) {
			for (int j = 0; j < yLength; j++) {
				for (int k = 0; k < zLength; k++) {
					matrix[i][j][k] = 0;
				}
			}
		}
		
		final List<Operation> operations = matrixAndOperationsDTO.getOperations();
		
		for (Iterator iterator = operations.iterator(); iterator.hasNext();) {
			
			Operation operation = (Operation) iterator.next();
			
			if(operation.getOperation().equals(QUERY)) {
				
				results.add(query(matrix, operation.getX1()-1, operation.getX2()-1, operation.getY1()-1, operation.getY2()-1, operation.getZ1()-1, operation.getZ2()-1));
				
			} else if(operation.getOperation().equals(UPDATE)) {
				
				matrix[operation.getX()-1][operation.getY()-1][operation.getZ()-1] = operation.getW();
				
			}else {
				
				throw new BusinessException(null, "Operation not allowed or incorrect");
			}
		}

		return results;
	}

	private String query(int[][][] matrix, int x1, int x2, int y1, int y2, int z1, int z2) {
		
		int result = 0;
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2 ; j++) {
				for (int k = z1; k <= z2; k++) {
				result += matrix[i][j][k];
				}
			}
		}
		
		return "" + result;
	}
}