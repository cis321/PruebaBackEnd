package co.rappi.backEndSumaMatriz.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Operation {
	
	private final String operationName;
	
	private final int x;
	
	private final int y;
	
	private final int z;
	
	private final int W;
	
	private final int x1;
	
	private final int x2;
	
	private final int y1;
	
	private final int y2;
	
	private final int z1;
	
	private final int z2;
	
	@JsonCreator
	public Operation(@JsonProperty("operationName") String opetarionName, @JsonProperty("x") int x, @JsonProperty("y") int y, @JsonProperty("z") int z, @JsonProperty("W") int W, @JsonProperty("x1") int x1, @JsonProperty("x2") int x2, @JsonProperty("y1") int y1, @JsonProperty("y2") int y2, @JsonProperty("z1") int z1, @JsonProperty("z2") int z2) {
		
		this.operationName = opetarionName;
		this.x = x;
		this.y = y;
		this.z = z;
		this.W = W;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.z1 = z1;
		this.z2 = z2;
	}

	public String getOperation() {
		return operationName;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public int getW() {
		return W;
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY1() {
		return y1;
	}

	public int getY2() {
		return y2;
	}

	public int getZ1() {
		return z1;
	}

	public int getZ2() {
		return z2;
	}
}
