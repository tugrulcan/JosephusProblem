import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Program {

	static Map<Integer, Integer> soldiers;
	public static void main(String[] args) {
	
		
		soldiers = new HashMap<Integer, Integer>();
		int numOfSoldiers, stepCount;
		

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		do{
		System.out.print("Please enter the number of soldiers (Should be 2 or bigger): ");
		numOfSoldiers = in.nextInt();
		if(numOfSoldiers<=2)
			System.out.println("Please enter number bigger than 2!");;
		}while(numOfSoldiers <=2);
		
		for(int i = 0; i<numOfSoldiers; i++){
			soldiers.put(i, 1);
		}
		do{
		System.out.printf("Please enter nuber of skipped soldier (Max %2d): ",numOfSoldiers);
		stepCount = in.nextInt();
		if(stepCount>numOfSoldiers)
			System.out.println("Number of skipped soldiers can not be bigger than number of soldiers!");
		}while(stepCount > numOfSoldiers);
		killAnySoldier(soldiers, stepCount);
		
	}
	
	
	public static int FindNumberofAliveSoldiers(Map<Integer, Integer> soldiers){
		int numOfAliveSoldiers = 0;
		for (int key : soldiers.keySet()) {
			numOfAliveSoldiers += soldiers.get(key);
		}
		return numOfAliveSoldiers;
	}
	
	public static boolean IsNumOfAliveSoldierEqualTo2(Map<Integer, Integer> soldiers){
		
		if(FindNumberofAliveSoldiers(soldiers) > 2){
			return false;
		}
		else return true;
	}
	
	public static void killAnySoldier(Map<Integer, Integer> soldiers, int stepCount){
		int indiceofSoldierWillbeKilled = 0;
		int totalNumofSoldiers = soldiers.size();
		int indiceofpreAliveSoldier = 0;
		while( !IsNumOfAliveSoldierEqualTo2(soldiers)){
			
			for(int i = 0; i<stepCount;){
				if(soldiers.get(indiceofSoldierWillbeKilled) == 1){
					i++;
					indiceofpreAliveSoldier = indiceofSoldierWillbeKilled;
				}
					
				indiceofSoldierWillbeKilled = (indiceofSoldierWillbeKilled + 1) % totalNumofSoldiers;
			}
			
			soldiers.put(indiceofpreAliveSoldier , 0);
			System.out.println((indiceofpreAliveSoldier + 1 )+ "'th soldier was killed...");
		}
		System.out.println("\n\n2 Soldiers are alive! Alive soldiers are; ");
		for (int key : soldiers.keySet()) {
			if(soldiers.get(key) == 1)
				System.out.println(key+1 + ". soldier");
		}
		WriteStatus(soldiers);
		
	}
	
	public static void WriteStatus(Map<Integer, Integer> soldiers){
		System.out.println("\nSoldiers num and state: ");
		for (int key : soldiers.keySet()) {
			System.out.println( "[" + key + "] : " + soldiers.get(key));
		}
	}

}
