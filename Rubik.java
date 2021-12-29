package ceng344_lab2;


import java.awt.Color;
import java.util.Random;







public class Rubik {
Color[] colors = new Color[5];
Color[] currentColors = new Color[4];
										  
public Rubik() {
	StdDraw.setCanvasSize(500, 500);
	colors[0]=Color.magenta;
	colors[1]=Color.cyan;
	colors[2]=Color.green;                             //These are the palette colors
	colors[3]=Color.red;
	colors[4]=Color.orange;

	
	for(int i = 0; i<currentColors.length; i++) {
			currentColors[i]=randomColor();             // assign random colors for array length
		 }
	
	StdDraw.setPenColor(currentColors[0]);           //Left - Bottom    // Square 1
	StdDraw.filledSquare(0.25, 0.25, 0.25);
	StdDraw.setPenColor(currentColors[1]);			 // Right - Bottom  //Square 2
	StdDraw.filledSquare(0.75, 0.25, 0.25);
	StdDraw.setPenColor(currentColors[2]);			// Left - Top       //Square 3
	StdDraw.filledSquare(0.25, 0.75, 0.25);
	StdDraw.setPenColor(currentColors[3]);			// Right - Top      //Square 4
	StdDraw.filledSquare(0.75, 0.75, 0.25);

// Pick random 4 colors with the method you have written
// Change the currentColors array accordingly with these colors
// Set the colors for filling the squares and call the filledSquare method

}
// Main method should exactly be this
public static void main(String[] args) {
	System.out.println("a");
	Rubik r = new Rubik();
	r.play();
	
}
// Randomly chooses and returns a Color from your colors[] array
public Color randomColor() {
	
	
	int random = new Random().nextInt(colors.length);    // random variable holds integer index of colors array
	
	return colors[random];
	
	
	

}
// Returns true if all 4 squares have the same color, otherwise false
public boolean match(Color rand1, Color rand2, Color rand3, Color rand4) {
	
	if(rand1==rand2 && rand1 == rand3 && rand1 == rand4 && rand2==rand3 && rand2==rand4 && rand3==rand4) {
		return true;							// if the all colors has the same id return true otherwise false
	}
	else
		return false;

}

//Implements the game mechanism, while all squares do not have the same color lets the
//user press squares to change their colors.
//When all the squares have matching colors displays a text that says “You won!”
public void play() {
	
	int square;
	boolean temp;
	temp = match(currentColors[0],currentColors[1],currentColors[2],currentColors[3]); // match function call 
	if(temp == true) {																	// if the temp value true in the beginning
		StdDraw.setPenColor(Color.BLACK);												// system print "You won"
		StdDraw.text(0.5, 0.5, "!!!YOU WON!!!");
	}
	else
	while(temp==false) {						// if the temp value is false
		double [] mouseLoc=mouseLocation();   // calling the mouseLocation function for get x and y value.
		square = whichSquare(mouseLoc);		  // and determine which square has the mouse location for call whichSquare method  
		changeColor(square);				// change the square color the calling function
		temp = match(currentColors[0],currentColors[1],currentColors[2],currentColors[3]); // temp control
		if(temp==true) {																	// if true, all the colors are same
			break;
		}
		
		
		
	}
		
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0.5, 0.5, "!!!YOU WON!!!");
}
	
//Returns a double array which contains x and y coordinates of the mouse location
public double[] mouseLocation() {
	
	
	for(;;) {
	if(StdDraw.isMousePressed()) {         // control of the mousecliked 
		double x = StdDraw.mouseX();       // if true these function set the value of x and y values of mouse click
		double y = StdDraw.mouseY();
		double[] mouseLocation = {x,y};		// assigning x and y values of array
		return mouseLocation;
	
	
		
		}
		
	
	}

}
//Finds and returns the square which the mouse location resides in
public int whichSquare(double[] mouseLoc) {
	int square =0;
															//if the mouse location is in the left bottom area, assign 1 for square
	if(mouseLoc[0]>=0 && mouseLoc[0]<=0.50 && mouseLoc[1]>=0 && mouseLoc[1]<=0.50)   //left bottom         // Square 1
		square=1;
															//if the mouse location is in the right bottom area,  assign 2 for square
	else if(mouseLoc[0]>=0.5 && mouseLoc[0]<=1.0 && mouseLoc[1]>=0 && mouseLoc[1]<=0.50)  // right bottom // Square 2
		square=2;
															//if the mouse location is in the left top area,  assign 3 for square
	else if(mouseLoc[0]>=0 && mouseLoc[0]<=0.5 && mouseLoc[1]>=0.5 && mouseLoc[1]<=1.0) // left top       //Square 3
		square=3;
															//if the mouse location is in the right top area,  assign 4 for square
	else if(mouseLoc[0]>=0.5 && mouseLoc[0]<=1.0 && mouseLoc[1]>=0.5 && mouseLoc[1]<=1.0) // right top  // Square 4
		square=4;
	
	
	return square;

}
//Takes the square which the user has clicked and changes the color of that square randomly

public void changeColor(int whichSquare) {	// this code choose random color and append currentColors array
											//Updating the colors in the current Colors array according to the location of each square
	if(whichSquare == 1) {					
		StdDraw.setPenColor(currentColors[0]=randomColor());    //left bottom 
		StdDraw.filledSquare(0.25, 0.25, 0.25);
	}
	else if(whichSquare == 2) {
		StdDraw.setPenColor(currentColors[1]=randomColor());    //right bottom
		StdDraw.filledSquare(0.75, 0.25, 0.25);
	}
	else if(whichSquare == 3) {
		StdDraw.setPenColor(currentColors[2]=randomColor());    // left top
		StdDraw.filledSquare(0.25, 0.75, 0.25);
	}
	else if(whichSquare == 4) {
		StdDraw.setPenColor(currentColors[3]=randomColor());	// right top
		StdDraw.filledSquare(0.75, 0.75, 0.25);
	}

	StdDraw.show();
	}
}
