import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
import processing.core.PVector;

public class Sketch extends PApplet {

  PImage imgSetting1;
  PImage imgSetting2;
  PImage imgSetting3;
  PImage imgPlayer;
  PImage imgWall;
  PImage imgBird;
  PImage imgCarTrail;
  
  int intTimeCalc = 0;
  int intTime = 0;
  int intProjectileX;
  int intProjectileY;
  int intWallSpeed = 2;
  int intWallOneX = 0;
  int intWallTwoX = 0;
  int intHealth = 100;
  int intGas = 100;
  
  float fltBirdCount = random(5,10);
  int intBirdCount = (int)fltBirdCount;
  
  float[] birdX = new float [intBirdCount];
  float[] birdY = new float [intBirdCount];
  float fltBirdSpeedX = 0;
  float fltBirdSpeedY = 0;
  float fltCarX = 700;
  float fltCarY = 300;
  
  

  boolean blnMainMenu = true;
  boolean blnGame1 = false;
  boolean blnGame2 = false;
  boolean blnGame3 = false;
  boolean blnGameStart = false;
  boolean blnIFrames = false;
  

  ArrayList<PVector> pvCarTrail = new ArrayList<PVector>();
  
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

    imgBird = loadImage("Bird.png");
    imgBird.resize(50, 50);

    imgCarTrail = loadImage("CarTrail.png");
    imgCarTrail.resize(400, 75);
      
    for (int i = 0; i < birdY.length; i++){
      birdY[i] = random(0,100);
      birdX[i] = random(width);
    }
    
  }


  public void draw() {

    if (blnMainMenu == true) {
      // main menu screen
    }

    if (keyPressed && key == '1' && blnMainMenu == true) {
      blnMainMenu = false;
      blnGame1 = true;
    }

    if (keyPressed && key == '2' && blnMainMenu == true) {
      blnMainMenu = false;
      blnGame2 = true;
    }

    if (keyPressed && key == '3' && blnMainMenu == true) {
      blnMainMenu = false;
      blnGame3 = true;
    }
    
    if (blnGame1 == true) {
      intTime = 0;
      blnGameStart = true;
      image(imgSetting1, 0, 0);
    }

    if (blnGame2 == true) {
      intTime = 0; 
      blnGameStart = true;
      image(imgSetting2, 0, 0);
    }


    if (blnGame3 == true) {
      intTime = 0;
      blnGameStart = true;
      image(imgSetting3, 0, 0);
    }

  //game start
  if (blnGameStart == true && intHealth > 0){

  if (keyPressed == false){
    fltCarX -= 1;
  }

  pvCarTrail.add(new PVector(fltCarX, fltCarY));
    
  if (pvCarTrail.size() > 20){
    pvCarTrail.remove(0);
  }

    // not exact seconds but close enough
    intTimeCalc += 2;
    intTime = intTimeCalc/100;
    // display time
    fill(0);
    text("time: " + intTime, width/1.5f, height/3.8f);
    text("health: " + intHealth, width/2.2f, height/3.8f);
    text("gas: " + intGas, width/1.2f, height/3.8f);


    //player stuff
    image(imgPlayer, fltCarX, fltCarY);

    if (fltCarX <= 0){
      fltCarX = width;
    }
    else if (fltCarX >= width-75){
      fltCarX = width-100;
    }

    if (fltCarY <= height/2){
      fltCarY = height/2 + 1;
    }
    else if (fltCarY >= height-50){
      fltCarY = height-51;
    }
    

    if (intWallOneX >= width){
      intWallOneX = 0;
    }
    if (intWallTwoX >= width){
      intWallTwoX = 0;
    }

    // Brick Wall
    if (intTime >= 0){
      image(imgWall, intWallOneX, height/2);
      intWallOneX += intWallSpeed;
      image(imgWall, intWallTwoX, height/1.3f);
      intWallTwoX += intWallSpeed + 1;
      }

    // Birds
    if (intTime > 10 && blnGame1 == true){
      fltBirdSpeedX = random(0,1);
      fltBirdSpeedY = random(0,1);
    }
    else if (intTime > 10 && blnGame2 == true){
      fltBirdSpeedX = random(0,5);
      fltBirdSpeedY = random(0,5);
    }
    else if(intTime > 10 && blnGame3 == true){
      fltBirdSpeedX = random(0,10);
      fltBirdSpeedY = random(0,10);
    }

    for (int i = 0; i < birdY.length; i++){
        
      image(imgBird, birdX[i], birdY[i]);
      birdX[i] += fltBirdSpeedX;
      birdY[i] += fltBirdSpeedY;

      // Edge detection, when the birds go offscreen they respawn at the top
      
      if (birdX[i] < 0 || birdX[i] > width) {
        birdX[i] = random(width);;
      }
      if (birdY[i] < 0 || birdY[i] > height) {
        birdY[i] = random(0, 10);
    }
      if (blnIFrames == false) {
        // collision detection birds
        if (dist(fltCarX, fltCarY, birdX[i], birdY[i]) <= 37.4){
          intHealth -= 1;
        }
      }

  }
    // Drunk Drivers
    if (intTime % 30 == 0){
      
    }

    if (blnIFrames == false){
      //collision detection wall
      if (dist(fltCarX, fltCarY, intWallOneX, height/1.69f) <= 37.4){
          intHealth -= 1;
        }
      if (dist(fltCarX, fltCarY, intWallTwoX, height/1.26f) <= 37.4){
          intHealth -= 1;
        }
    }
      
  }

    
  } 
  public void keyPressed() {
    if (key == 'w') {
      fltCarY -= 30;
    }   
    if (key == 's') {
      fltCarY += 30;
    }   
    if (key == 'a') {
      fltCarX -= 30;
      intGas -= 1;
      blnIFrames = true;
      for (int i = 0; i < pvCarTrail.size(); i++) {
        PVector pvTrailPosition = pvCarTrail.get(i);
        image(imgCarTrail, pvTrailPosition.x, pvTrailPosition.y);
      }
    }
    if (key == 'd') {
      fltCarX += 30;
    }   
  }

  public void keyReleased(){
    if (key == 'a') {
      blnIFrames = false;
      intGas -= 3;
      for (int i = 0; i < pvCarTrail.size(); i++) {
        PVector pvTrailPosition = pvCarTrail.get(i);
        image(imgCarTrail, pvTrailPosition.x, pvTrailPosition.y);
      }
    }
  }
  
}