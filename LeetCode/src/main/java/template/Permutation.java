package template;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {

/*	public ArrayList<Integer> permute(int[] num){
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> results=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path=new ArrayList<Integer>();
		permuteHelper(results,path,num*//*?*//*);
		return results;
	}*/
	
	private void permuteHelper(ArrayList<ArrayList<Integer>> results,ArrayList<Integer> path,int[] num){
		if(path.size()==num.length){ //�Ƿ������������
			results.add(new ArrayList<Integer>(path));
			return;
		}
		/*for(int =*//*?*//*;i<numm.length;i++){
			//����Ҫ��Ҫ�����Щ���� 
			path.add(num[i]);
			permuteHelper(results, path, num);
		 path.remove(path.size()-1);
		}*/
	}
	
}
