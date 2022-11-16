import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class Robot implements Contract{

    String name;
    //for user's object
    String object;
    int objectSize;
    ArrayList<String> inventory;
    //for the letter answer
    String prompt;
    //for flying
    int xCorrdinate;
    int yCorrdinate;
    ArrayList<String> flyingX = new ArrayList<String>();
    ArrayList<String> flyingY = new ArrayList<String>();
    
    HashMap<String, Integer> invent;
    ArrayList<String> cache;
 
    Scanner myObj = new Scanner(System.in);
    String robot = "🤖";
    //For size increasing
    int howMuchBigger;

    //a bunch of booleans for undo
    /* 
    boolean grabUndo = false;
    boolean dropUndo = false;
    boolean examineUndo = false;
    boolean walkUndo = false;
    boolean flyUndo = false;
    boolean shrinkUndo = false;
    boolean growUndo = false;
    boolean restUndo = false;
*/


    
    public Robot(){

    this("Mr.Robot 2000");
    System.out.println(robot);
    }

    public Robot(String name){
        this.name = name;
    }
    public void showOptions(){
        System.out.println("What would you like me to do" + this.name +  " to do? :] + Type 'A' for me to examine \n + Type 'B' for me to walk \n + Type 'C' for me to fly \n + Type 'D' for me to shrink \n + Type 'E' for me to grow \n + Type 'F' for me to rest \n + Type 'G' for me to undo \n + Type 'H' for me to grab that object");
        String prompt = myObj.nextLine();
        prompt = this.prompt;
        System.out.println("And what object do you have?");
        String object = myObj.nextLine();
        object = this.object;
        System.out.println("What size is the object in lbs?");
        int objectSize = myObj.nextInt();
        objectSize = this.objectSize;
        invent.put(object,objectSize);
        use(prompt);
    }
     
    public void grab(String item){
        item = this.object;
        invent.putIfAbsent(item,10);
        System.out.println("Beep Boop I'm holding" + item);
        inventory.add(item);
        inPossession(true);
        //grabUndo = true;

    }

    //KATIE DONE
   public String drop(String item){
    if (inventory.contains(object) && inPossession(true)){
    
    System.out.println("Beep Boop I shall drop this");
    inventory.remove(item);
    inPossession(false);

    } else {
    System.out.println("Silly human, I'm not holding anything. Try again");
    showOptions();
    }
    //dropUndo = true;
    cache.add("drop");
    return item;
    }

//I took this from GeeksForGeeks
    public void examine(String item){
        for (Map.Entry<String, Integer> set: invent.entrySet()){

            System.out.println("Your object is " + set.getKey() + " and it weights " + set.getValue());
        }
    }

  
    //KATIE DONE kinda
    public void use(String item){
       inventory.remove(item);
       invent.remove(item);

        if (prompt =="A"){
            examine(item);
        } else if (prompt == "B"){
            System.out.println("Which direction should I go?");
            //code for direction
        } else if (prompt == "C"){
            System.out.print("Starting point: " + robot + "Please input your x value \n");
            xCorrdinate = myObj.nextInt();
            System.out.println("Good, now input a y value \n");
            yCorrdinate = myObj.nextInt();
            fly(xCorrdinate, yCorrdinate);

        } else if (prompt == "D"){
            shrink();
        } else if (prompt == "E"){
            grow();
        } else if (prompt == "F") {
            rest();
        } else if (prompt == "G"){
            undo();
        } else if (prompt == "H") {
            grab(object);        
        }

    }

    public boolean walk(String direction){
        walkUndo = true;
    }

    //KATIE

    public boolean fly(int x, int y){
    //for array list length, stole this idea from Stack Overflow
        for (int i = 0; i < x; i++) {
            flyingX.add("*");
          }

        for (int i = 0; i < y; i++) {
            flyingY.add("*");
          }

    System.out.println("꒰ঌ"+robot+"໒꒱");
    flyUndo = true;

int starter = 0;

    for (int i = 1; i <= x; ++i,starter = 0) {
        for (int space = 1; space <= x - i; ++space) {
          System.out.print("  ");
        }
  
        while (starter != 2 * i - 1) {
          System.out.print("* ");
          ++starter;
        }
  
        System.out.println();
      }
    }
  
     



        /*
         * 
         * 
         *  for (String a: flyingX){
        System.out.print(a);
        System.out.print("");
      }

      for (String a: flyingY){
        System.out.println(a);
        System.out.println("");
    }
        }
    int rows = x, k = 0;

    
         */

    public Number shrink(){
        shrinkUndo = true;
    }

        //KATIE DONE

    public Number grow(){

        System.out.println("How many times bigger would you like" + this.name + "to be? Only integers");
        howMuchBigger = myObj.nextInt();

        if (howMuchBigger%2 == 0 || howMuchBigger%2 == 1){
            for (int i; howMuchBigger > i; i++){
                System.out.println(robot);
            }
        } else {
            System.out.println("I LITERALLY SAID ONLY INTEGERS. DAMN. Now you won't see me BLEEPING grow  >:0 ");
        }
        growUndo = true;
    }

    public void rest(){
        restUndo = true;
    }


    //KATIE done
    public void undo(){

System.out.println("It is undo");
        
if (grabUndo == true) {
    grabUndo = false;
} 

if (dropUndo == true){
    dropUndo = false;
}

if (examineUndo == true){
    examineUndo = false;
}
if (walkUndo == true){
    walkUndo = false;
}
if (flyUndo == true){
    flyUndo = false;
}
if (shrinkUndo == true){
    shrinkUndo = false;
}
if (growUndo == true){
    growUndo = false;
}

if (restUndo == true){
    restUndo = false;
}

    }

    //to see if the robot has it
    public boolean inPossession(boolean have){
        return false;
    }



    public static void main (String [] args){
    
    }

}
