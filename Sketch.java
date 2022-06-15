import processing.core.PApplet;
import processing.core.PImage;
public class Sketch extends PApplet {

  PImage imgSetting1;
  PImage imgSetting2;
  PImage imgSetting3;
  PImage imgPlayer;
  PImage imgWall;
  int intTimeCalc = 0;
  int intTime = 0;
  int intProjectileX;
  int intProjectileY;
  int intWallSpeed = 2;
  int intWallOneX = 0;
  int intWallTwoX = 0;
  
  

  boolean mainMenu = true;
  boolean blnGame1 = false;
  boolean blnGame2 = false;
  boolean blnGame3 = false;
  boolean blnGameStart = false;

  
  public void settings() {
    size(800, 400);
  }


  public void setup() {

    imgSetting1 = loadImage("StreetBackground1.jpg");
    imgSetting1.resize(width, height);

    imgSetting2 = loadImage("StreetBackground2.jpg");
    imgSetting2.resize(width, height);

    imgSetting3 = loadImage("StreetBackground3.jpg");
    imgSetting3.resize(width, height);
      
      
    imgPlayer = loadImage("PlayerCar.png");
    imgPlayer.resize(50, 75);

    imgWall = loadImage("BrickWall.jpg");
    imgWall.resize(25, height/3);
    
  }


  public void draw() {

    if (mainMenu == true) {
      // main menu screen
    }

    if (keyPressed && key == '1' && mainMenu == true) {
      mainMenu = false;
      blnGame1 = true;
    }

    if (keyPressed && key == '2' && mainMenu == true) {
      mainMenu = false;
      blnGame2 = true;
    }

    if (keyPressed && key == '3' && mainMenu == true) {
      mainMenu = false;
      blnGame3 = true;
    }
    
    if (blnGame1 == true) {
      intTime = 0;
      blnGameStart = true;
    }

    if (blnGame2 == true) {
      intTime = 30; 
      blnGameStart = true;
    }


    if (blnGame3 == true) {
      intTime = 60;
      blnGameStart = true;
    }

    if (blnGameStart == true){
        
    // at different times the background/level changes
    if (intTime >= 0 && intTime <= 30){
      image(imgSetting1, 0, 0);
    }
    if (intTime > 30 && intTime <= 60){  
      image(imgSetting2, 0, 0);
    }
    if (intTime > 60) {
      image(imgSetting3, 0, 0);
    }

    // not exact seconds but close enough
    intTimeCalc += 2;
    intTime = intTimeCalc/100;
    // display time
    fill(0);
    text("time: " + intTime, width/1.5f, height/3.8f);

    //player stuff
      

    if (intWallOneX >= width){
      intWallOneX = 0;
    }
    if (intWallTwoX >= width){
      intWallTwoX = 0;
    }
      
    if (intTime >= 0 && intTime <= 30){
      image(imgWall, intWallOneX, height/2);
      intWallOneX += intWallSpeed;
      image(imgWall, intWallTwoX, height/1.3f);
      intWallTwoX += intWallSpeed + 1;
      }

    
    

      
  }  
}
} 