package CodingHire.StringAndArray;

/*Given two words (start and end), and a dictionary, find the length of shortest transformation 
sequence from start to end, such that only one letter can be changed at atime and each 
intermediate word must exist in the dictionary. 
For example, given:start = "hit" 
                   end = "cog"
                   dict = ["hot","dot","dog","lot","log"]
		One shortest transformation is "hit" ->"hot" ->"dot" ->"dog" ->"cog", the program should 
		return its length 5.
		Note: Return 0 if there is no such transformation sequence. 
		All words have the samelength. 
		All words contain only lowercase alphabetic characters.*/
public class A004_WordLadder {

	
	public static void main(String[] args) {
		
		String[] dict = {"hot","dot","dog","lot","cog", "log"};
		String start = "hit";
		String end = "cog";
		
	}
}
