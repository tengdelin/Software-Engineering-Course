package reader;

public class FieldInfo {
	private String name;
	private String alias;
	private String type;
	private int maxLength;
	
	public int getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	public int getTotalDigits() {
		return totalDigits;
	}
	public void setTotalDigits(int totalDigits) {
		this.totalDigits = totalDigits;
	}
	public int getFractionDigits() {
		return fractionDigits;
	}
	public void setFractionDigits(int fractionDigits) {
		this.fractionDigits = fractionDigits;
	}
	private int totalDigits;
	private int fractionDigits;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}