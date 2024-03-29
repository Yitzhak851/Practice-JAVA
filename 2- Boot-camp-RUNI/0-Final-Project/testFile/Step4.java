import java.util.Scanner;// Import the Scanner class
public class Step4 {
	public static void main(String[] args) {
		int n = 10; 
		int m = 10; 
		double p = 0.1;
		int [][] fieldHidden = setupGrid(buildGrid(n,m,p)); // Array with VAL
		int[][] tempField = fieldHidden;					// Array with status
        while(true){
            Scanner s = new Scanner(System.in);
            System.out.print("\n\tEnter Row Number: ");
            int a = s.nextInt();
            System.out.print("\tEnter Column Number: ");
            int b = s.nextInt();
            System.out.println("\tThe val on the coor: " + valCoor(a,b,fieldHidden)+"\n");
            clickCoor2(a,b,tempField);
            int[][] fixField = clickCoor(a, b, tempField);
            displayVisible(fixField);
        }
	}		
	public static int[][] buildGrid(int n, int m, double p) {
		int[][] fieldHidden = new int[n][m];
		for (int i = 0; i < fieldHidden.length; i++) {
			for (int j = 0; j < fieldHidden[i].length; j++) {
				if (Math.random() < p) {
					fieldHidden[i][j] = (-1);
				} else {
					fieldHidden[i][j] = (0);
				}
			}
		}
		return fieldHidden;
	}
    public static int[][] setupGrid(int[][] fieldHidden) {
		for (int i = 0; i < fieldHidden.length; i++) {
			for (int j = 0; j < fieldHidden[0].length; j++) {
				if (fieldHidden[i][j] == (-1) ){
					fieldHidden[i][j] = (-1);
				} else {
					int mineCount = 0; 
					for (int x = (i - 1); x <= (i + 1); x++) {
						for (int y = (j - 1); y <= (j + 1); y++) {
                            //TODO - to right here what is the logic
							if (x >= 0 && x < fieldHidden.length && y >= 0 && y < fieldHidden[0].length && fieldHidden[x][y] == (-1)) {
								mineCount++;
							}
						}
					}
					fieldHidden[i][j] = mineCount;
				}
			}
		}
		return fieldHidden;
	}
	public static int valCoor(int a, int b, int[][] fieldHidden ){
        int res = fieldHidden[a][b];
		return res;
	}
	public static int[][] clickCoor(int a, int b, int[][] fieldHidden){
        int[][] fieldVisible = new int[fieldHidden.length][fieldHidden[0].length];
        for(int i=0; i<fieldVisible.length; i++){
            for(int j=0; j<fieldVisible[0].length;j++){
                fieldVisible[i][j]=9;
            }
        }
        if(fieldHidden [a][b]==0){
            for (int i = a; i < fieldHidden.length; i++) {
			    for (int j = b; j < fieldHidden[b].length; j++) {
				    for (int x = (a - 1); x <= (a + 1); x++) {
    					for (int y = (b - 1); y <= (b + 1); y++) {
						    if (x >= 0 && x < fieldHidden.length && y >= 0 && y < fieldHidden[0].length && fieldHidden[x][y] == (0)) {
                                fieldVisible [a][b] = 8;
                            }
					    }
				    }
			    }
		    }
		return fieldVisible;
		} else if(fieldHidden [a][b] != -1 && fieldHidden [a][b] != 0){
            fieldVisible [a][b] = fieldHidden [a][b] ;
            return fieldVisible;
        } else {
            fieldVisible [a][b] = -1;
            return fieldHidden;
        }
	}
	public static int[][] displayVisible(int[][] fieldHidden){
		System.out.print("\t ");
		for(int i=0; i<fieldHidden.length; i++){
			System.out.print(" " + i + "  ");
		}
		System.out.print("\n");
		for(int i=0; i<fieldHidden.length; i++){
			System.out.print(i + "\t| ");
			for(int j=0; j<fieldHidden.length; j++){
				if(fieldHidden[i][j]==8){
					System.out.print(" ");
				} else if(fieldHidden[i][j]==9) {
					System.out.print("?");
                }else if(fieldHidden[i][j]!=-1 && fieldHidden[i][j]!=0){
					System.out.print(fieldHidden[i][j]);
                }else{
                    System.out.print("You lose!");
                }
				System.out.print(" | ");
			}
			System.out.print("\n");	
		}
		return fieldHidden;
	} 
    public static int[][] clickCoor2(int a, int b, int[][] fieldHidden){
        int[][] grid = fieldHidden;
        if(valCoor(a, b, fieldHidden) != -1){
            if(valCoor(a, b, fieldHidden) == 8){
                grid[a][b] = fieldHidden[a][b];    
            }else{
                grid[a][b] = 8;
            }
            return grid;
        }else {
            System.out.println("==================Game over!==================");
            display(fieldHidden);
            return grid;
        }
	}

	public static int[][] display(int[][] fieldHidden){
		System.out.print("\t ");
		for(int i=0; i<fieldHidden.length; i++){
			System.out.print(" " + i + "  ");
		}
		System.out.print("\n");
		for(int i=0; i<fieldHidden.length; i++){
			System.out.print(i + "\t| ");
			for(int j=0; j<fieldHidden.length; j++){
				if(fieldHidden[i][j]==0){
					System.out.print(" ");
				} else if(fieldHidden[i][j]==-1){
					System.out.print("X");
                } else if(fieldHidden[i][j]==8){
					System.out.print("8");
				}else{
					System.out.print(fieldHidden[i][j]);
				}
				System.out.print(" | ");
			}
			System.out.print("\n");	
		}
		return fieldHidden;
	}	
// Step 5: Get coordinate + mapGrid --> return "FLAG"
	public static int[][] addFlagToGrid(int a, int b, int[][] fieldVisible, int[][] fieldHidden) {
		fieldVisible[a][b] = 8;
		if(fieldVisible[a][b] != 8){
			fieldVisible[a][b] = 8;
		} else {
			fieldVisible[a][b] = fieldHidden[a][b];
		}
		return fieldVisible;
	}
}