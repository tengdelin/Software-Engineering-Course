
package reader;

import java.util.ArrayList;
import java.util.List;


public class Record  {    
			
	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGeometryType() {
		return geometryType;
	}

	public void setGeometryType(String geometryType) {
		this.geometryType = geometryType;
	}

	public List<FieldInfo> getFields() {
		return fields;
	}

	public void setFields(List<FieldInfo> fields) {
		this.fields = fields;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	 private String name;			 
	 private String geometryType;	 
	 private Box box;
	 private List<FieldInfo> fields;	 
	 private List<Feature> features;
	 
     
    public Record(){
    	name = "";
    	features = new ArrayList<Feature>();
    	fields = new ArrayList<FieldInfo>();
    	box=new Box();
    }

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}
   	 
    
}