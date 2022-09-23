package pojo;

import java.util.Arrays;

import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;



public class ProductTest {
	
	public static void main(String[] args) throws SerializeException, ParseException {
		
		
		//Serialization  ==>POJO to Json
		
		JsonSerializer jsonSerializer =   JsonSerializer.DEFAULT_READABLE;
		
		//Create Array if needed
		String sellerName[] = {"Staples", "BestBuy", "Apple Store"};
		
		//instantiation object 
		Product product = new Product("MacPro", 1000, "White", sellerName);
		String json = jsonSerializer.serialize(product);
		System.out.println(json);
		
		
	
		
		Product product2 = new Product("MacAir", 850, "White", sellerName);
		String json2 = jsonSerializer.serialize(product2);
		System.out.println("JSON Format : "+ json2);
		
		
		Product product3 = new Product("iPad", 500, "White", sellerName);
		String json3 = jsonSerializer.serialize(product3);
		System.out.println("JSON Format : " + json3);
		
		
		// Pojo to XML
		XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_SQ_READABLE;
		String json4 =xmlSerializer.serialize(product);
		System.out.println("XML Format :" + json4);
		
		
		//pojo to HTML
		HtmlSerializer htmlSerilaizer = HtmlSerializer.DEFAULT_SQ_READABLE;
		String json5 =htmlSerilaizer.serialize(product);
		System.out.println("HTML Format :"  + json5);
		
		
		
		//Deserialization  JSON to POJO
		
				JsonParser jsonParser = JsonParser.DEFAULT;
				String jsonVal = "{\n"
						+ "	\"color\": \"White\",\n"
						+ "	\"name\": \"MacPro\",\n"
						+ "	\"price\": 1000,\n"
						+ "	\"sellerName\": [\n"
						+ "		\"Staples\",\n"
						+ "		\"BestBuy\",\n"
						+ "		\"Apple Store\"\n"
						+ "	]\n"
						+ "}";
				
				//use instantiation object 
//				Product pro = new Product();
//						pro = jsonParser.parse(jsonVal, Product.class);
				
				//use @Beanc in product class
				Product pro = jsonParser.parse(jsonVal, Product.class);
				System.out.println(pro.getColor());
				System.out.println(pro.getName());
				System.out.println(pro.getPrice());
				System.out.println(Arrays.toString(pro.getSellerName()));
		
		
		
	}
	
	
	
	
	
	
	

}
