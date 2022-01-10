package reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class GMLReader {
	private String pathname;
	
	public GMLReader(String pathname) {
		this.pathname=pathname;
	}

	public Record open() throws IOException {
		Record result = null;

		try(FileInputStream in = new FileInputStream(this.pathname);) {			
			result = parseContent(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	private void  parseField(Record result) throws DocumentException{		
		List<FieldInfo> rtn=new ArrayList<FieldInfo>();
		//Read xsd
		SAXReader saxReader = new SAXReader();
		FileInputStream inXsdFile=null;
		String xsdFile=this.pathname.replace(".gml", ".xsd");
		try{			
			inXsdFile = new FileInputStream(xsdFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}			
				
		Document document = saxReader.read(inXsdFile);			
		Element root = document.getRootElement();
			
		List<Element> elements = root.elements("element");
		for (Element  e:elements) {
			String name=e.attributeValue("name");
			String substitutionGroup=e.attributeValue("substitutionGroup");
			if(substitutionGroup.equals("gml:_Feature")) {
				result.setName(name);
			}
		}
	   
		elements = root.elements("complexType");			
		Element element = elements.get(1);
		element=element.element("complexContent");
		element=element.element("extension");
		element=element.element("sequence");
		
		elements= element.elements("element");	
		for (Element  field:elements) {
			FieldInfo fld=new FieldInfo();
			String fldname=field.attributeValue("name");	
			if(fldname.equalsIgnoreCase("geometryProperty")) {
				String type=field.attributeValue("type");	
				type=type.replace("gml:","");
				type=type.replace("PropertyType","");
				result.setGeometryType(type);
				continue;
			}
			Element simpleType=field.element("simpleType");
			Element restriction=simpleType.element("restriction");
			String ftype=restriction.attributeValue("base");		
			ftype=ftype.replace("xs:", "");
			
			fld.setName(fldname);
			fld.setType(ftype);
			
			if(ftype.equals("string")) {
				Element maxLength=restriction.element("maxLength");
				int maxlen=Integer.parseInt(maxLength.attributeValue("value"));
				fld.setMaxLength(maxlen);					
			}
			else if(ftype.equals("decimal")) {
				Element totalDigits=restriction.element("totalDigits");
				int total=Integer.parseInt(totalDigits.attributeValue("value"));
				fld.setTotalDigits(total);		
				
				Element fractionDigits=restriction.element("fractionDigits");
				int fraction=Integer.parseInt(fractionDigits.attributeValue("value"));
				fld.setFractionDigits(fraction);		
			}
			else if(ftype.equals("integer")) {
				Element totalDigits=restriction.element("totalDigits");
				int total=Integer.parseInt(totalDigits.attributeValue("value"));
				fld.setTotalDigits(total);			
			}
			rtn.add(fld);
		}
		result.setFields(rtn);
	}
	
	private Record parseContent(FileInputStream in) {
		Record result = new Record();
		try {			
			parseField(result);		
			
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(in);			
			Element root = document.getRootElement();
						
			Element boundedBy= root.element("boundedBy");
			Element Box= boundedBy.element("Box");
			
			Box box=new Box();
			List<Element> elements = Box.elements("coord");
			Element  XY1=elements.get(0);
			Element X=XY1.element("X");
			Element Y=XY1.element("Y");
			box.setXmin(Double.parseDouble(X.getText()));
			box.setYmin(Double.parseDouble(Y.getText()));
			
			Element XY2=elements.get(1);
			X=XY2.element("X");
			Y=XY2.element("Y");
			box.setXmax(Double.parseDouble(X.getText()));
			box.setYmax(Double.parseDouble(Y.getText()));
			result.setBox(box);
			
			elements = root.elements("featureMember");
			
			List<Feature> features=new ArrayList<Feature>();
			
			String FID_=result.getName()+".";
			for (Element  Feature:elements) {
				Feature f=new Feature();
				Element el=Feature.element(result.getName());
				String FID=el.attributeValue("fid");
				FID=FID.replace(FID_, "");
				Element geometryProperty=el.element("geometryProperty");
				Element geometryProperty1=geometryProperty.element(result.getGeometryType());
				if(result.getGeometryType().equalsIgnoreCase("Point")) {
					Element coordinates=geometryProperty1.element("coordinates");
					String  geometry=coordinates.getText();
					f.setGeometry(geometry);
				}
				else if(result.getGeometryType().equalsIgnoreCase("MultiPolygon")) {
					Element polygonMember=geometryProperty1.element("polygonMember");
					List<Element> Polygons = polygonMember.elements("Polygon");
					for(Element Polygon:Polygons) {
						Element outerBoundaryIs=Polygon.element("outerBoundaryIs");
						Element LinearRing=outerBoundaryIs.element("LinearRing");
						Element coordinates=LinearRing.element("coordinates");
						String  geometry=coordinates.getText();
						String old=f.getGeometry();
						if(old!=null && !old.isEmpty() )
							geometry=old+"|"+geometry;
						f.setGeometry(geometry);
					}
				}
				else if(result.getGeometryType().equalsIgnoreCase("Polygon")) {
					
				}
				else if(result.getGeometryType().equalsIgnoreCase("MultiLineString")) {
					Element lineStringMember=geometryProperty1.element("lineStringMember");
					List<Element> LineStrings = lineStringMember.elements("LineString");
					for(Element LineString:LineStrings) {
						Element coordinates=LineString.element("coordinates");
						String  geometry=coordinates.getText();
						String old=f.getGeometry();
						if(old!=null && !old.isEmpty() )
							geometry=old+"|"+geometry;
						f.setGeometry(geometry);
					}
				}
				else if(result.getGeometryType().equalsIgnoreCase("LineString")) {
					
				}
				
				List<AttributeValue> attributes=new ArrayList<AttributeValue>();
				attributes.add(new AttributeValue("fid",FID));
				for(FieldInfo fld:result.getFields()) {
					Element e=el.element(fld.getName());
					AttributeValue av=new AttributeValue(fld.getName(),e.getTextTrim());
					attributes.add(av);
				}
				f.setAttributes(attributes);
				features.add(f);
			}		
			
			result.setFeatures(features);
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return result;
	}
}
