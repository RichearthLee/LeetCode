package t39;

import net.sf.json.JSONArray;

public class T39_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T39_Solution t = new T39_Solution();	
		JSONArray json = JSONArray.fromObject(t.generate(6));
		System.out.println(json.toString());
		JSONArray json1 = JSONArray.fromObject(t.getRow(3));
		System.out.println(json1);

	}

}
