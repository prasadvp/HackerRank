package codeintvw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player>{

	@Override
	public int compare(Player obj1, Player obj2) {
		if(obj1.score == obj2.score) {
			return (obj1.name.compareTo(obj2.name));
		}else {
			return -1*(obj1.score - obj2.score);
		}
		
	}
	
}
class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}