package CodingHire.StringAndArray;
import java.util.ArrayList;

/*
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class A002_EvaluateArithmeticExpression {
	
	public static void main(String[] args) {
		String[] strings1 = {"2", "1", "+", "3", "*"}; 
		String[] strings2 = {"4", "13", "5", "/", "+"}; 
		evaluate(strings1);
		evaluate(strings2);
	}

	private static void evaluate(String[] strings) {
		int result;
		ArrayList<String> data = new ArrayList<String>();
		for(int i = 0; i < strings.length; i++) {
			String s = strings[i];
			data.add(s);
			if ("+".equals(s)) {
				int pos = data.indexOf("+");
				result = Integer.parseInt(data.get(pos - 1)) + Integer.parseInt(data.get(pos - 2));
				data.remove(pos);
				data.remove(pos - 1);
				data.remove(pos - 2);
				data.add(String.valueOf(result));
				continue;
			}
			
			if ("-".equals(s)) {
				int pos = data.indexOf("-");
				result = Integer.parseInt(data.get(pos - 2)) - Integer.parseInt(data.get(pos - 1));
				data.remove(pos);
				data.remove(pos - 1);
				data.remove(pos - 2);
				data.add(String.valueOf(result));
				continue;
			}
			
			if ("*".equals(s)) {
				int pos = data.indexOf("*");
				result = Integer.parseInt(data.get(pos - 1)) * Integer.parseInt(data.get(pos - 2));
				data.remove(pos);
				data.remove(pos - 1);
				data.remove(pos - 2);
				data.add(String.valueOf(result));
				continue;
			}
			
			if ("/".equals(s)) {
				int pos = data.indexOf("/");
				result = Integer.parseInt(data.get(pos - 2)) / Integer.parseInt(data.get(pos - 1));
				data.remove(pos);
				data.remove(pos - 1);
				data.remove(pos - 2);
				data.add(String.valueOf(result));
				continue;
			}
		}
		
		System.out.println(data.get(0));
		
	}

}
