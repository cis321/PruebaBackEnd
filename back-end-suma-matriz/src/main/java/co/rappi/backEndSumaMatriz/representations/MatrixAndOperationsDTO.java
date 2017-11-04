package co.rappi.backEndSumaMatriz.representations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MatrixAndOperationsDTO {

	private final int xLength;

	private final int yLength;

	private final int zLength;

	private final List<Operation> operations;

	@JsonCreator
	public MatrixAndOperationsDTO(@JsonProperty("xLength") int xLength, @JsonProperty("yLength") int yLength,
			@JsonProperty("zLength") int zLength, @JsonProperty("operations") List<Operation> operations) {

		this.operations = operations;
		this.xLength = xLength;
		this.yLength = yLength;
		this.zLength = zLength;
	}

	public int getxLength() {
		return xLength;
	}

	public int getyLength() {
		return yLength;
	}

	public int getzLength() {
		return zLength;
	}

	public List<Operation> getOperations() {
		return operations;
	}

}
