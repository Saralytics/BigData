import java.util.Map;
import java.util.LinkedHashMap;

public class Map1 {

	public static void main(String[] args) {
		Map<String,Integer> hm = new LinkedHashMap<String,Integer>();
		
		hm.put("b", 100);
		hm.put("a",200);
		hm.put("d", 300);
		
		hm.remove("a");
		
		for(Map.Entry<String, Integer> value:
			hm.entrySet()) {
			System.out.print(value.getKey() + "-" + value.getValue());
			System.out.println();
		}

	}

}
