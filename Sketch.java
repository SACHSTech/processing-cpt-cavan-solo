import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
import processing.core.PVector;

public class Sketch extends PApplet {

  // declare PImage variables
  PImage imgSetting1;
  PImage imgSetting2;
  PImage imgSetting3;
  PImage imgPlayer;
  PImage imgWall;
  PImage imgBird;
  PImage imgCarTrail;

  // declare int variables
  int intTimeCalc = 0;
  int intTime = 0;
  int intProjectileX;
  int intProjectileY;
  int intWallSpeed = 2;
  int intWallOneX = 0;
  int intWallTwoX = 0;
  int intHealth = 300;
  int intGas = 0;

  // cast random float as int
  float fltBirdCount = random(5,8);
  int intBirdCount = (int)fltBirdCount;

  // declare float variables
  float[] birdX = new float [intBirdCount];
  float[] birdY = new float [intBirdCount];
  float fltBirdSpeedX = 0;
  float fltBirdSpeedY = 0;
  float fltCarX = 700;
  float fltCarY = 300;

  // declare boolean variables
  boolean blnMainMenu = true;
  boolean blnGame1 = false;
  boolean blnGame2 = false;
  boolean blnGame3 = false;
  boolean blnGameStart = false;
  boolean blnIFrames = false;
  boolean blnTrailOn = true;
  
  // declare PVector arraylist
  ArrayList<PVector> pvCarTrail = new ArrayList<PVector>();

  // set size
  public void settings() {
    size(800, 400);
  }

  public void setup() {

    // resize and load images
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
    imgCarTrail.resize(200, 60);

    // setup bird's intial position
    for (int i = 0; i < birdY.length; i++){
      birdY[i] = random(0,100);
      birdX[i] = random(width);
    }
    
  }


  public void draw() {

    if (blnMainMenu == true) {
      // add main menu
    }

    // if key 1 is pressed easy difficulty is played
    if (keyPressed && key == '1' && blnMainMenu == true) {
      blnMainMenu = false;
      blnGame1 = true;
    }

    // if key 2 is pressed normal difficulty is played
    if (keyPressed && key == '2' && blnMainMenu == true) {
      blnMainMenu = false;
      blnGame2 = true;
    }

    // if key 3 is pressed hard difficulty is played
    if (keyPressed && key == '3' && blnMainMenu == true) {
      blnMainMenu = false;
      blnGame3 = true;
    }

    // loads background 1 if easy is selected
    if (blnGame1 == true) {
      intTime = 0;
      blnGameStart = true;
      image(imgSetting1, 0, 0);
    }

    // loads background 2 if medium is selected
    if (blnGame2 == true) {
      intTime = 0; 
      blnGameStart = true;
      image(imgSetting2, 0, 0);
    }

    // loads background 3 if hard is selected
    if (blnGame3 == true) {
      intTime = 0;
      blnGameStart = true;
      image(imgSetting3, 0, 0);
    }

  //game start
  if (blnGameStart == true && intHealth > 0){

    // automatically moves the player forward because they are on a highway
    // autmatically regenerates gas
    if (keyPressed == false){
      fltCarX -= 1;
      intGas += 1;
    }

    if (blnTrailOn == true) {
      // add trail to the position of the player car
      pvCarTrail.add(new PVector(fltCarX, fltCarY));
    }
    // if more than 10 trail images are printed then remove
    if (pvCarTrail.size() > 10){
      pvCarTrail.remove(0);
    }

    // not exact seconds but close enough
    intTimeCalc += 2;
    intTime = intTimeCalc/100;
    // display time
    fill(0);
    text("Time: " + intTime, width/1.5f, height/3.8f);
    text("Health: " + intHealth, width/2, height/3.8f);
    text("Gas: " + intGas, width/2.7f, height/3.8f);


    //player stuff
    image(imgPlayer, fltCarX, fltCarY);

    // x edge detection for player car
    if (fltCarX <= 0){
      fltCarX = width;
    }
    else if (fltCarX >= width-75){
      fltCarX = width-100;
    }

    // y edge detection for player car
    if (fltCarY <= height/2){
      fltCarY = height/2 + 1;
    }
    else if (fltCarY >= height-50){
      fltCarY = height-51;
    }

    // x edge detection for walls
    if (intWallOneX >= width){
      intWallOneX = 0;
    }
    if (intWallTwoX >= width){
      intWallTwoX = 0;
    }

    // When game starts spawns and moves brick walls
    if (intTime >= 0){
      image(imgWall, intWallOneX, height/2);
      intWallOneX += intWallSpeed;
      image(imgWall, intWallTwoX, height/1.3f);
      intWallTwoX += intWallSpeed + 1;
      }

    // random values of bird speed depend on the level of difficulty 
    if (intTime > 10 && blnGame1 == true){
      fltBirdSpeedX = random(0,5);
      fltBirdSpeedY = random(0,5);
    }
    else if (intTime > 10 && blnGame2 == true){
      fltBirdSpeedX = random(0,8);
      fltBirdSpeedY = random(0,8);
    }
    else if(intTime > 10 && blnGame3 == true){
      fltBirdSpeedX = random(0,15);
      fltBirdSpeedY = random(0,15);
    }

    // spawns the birds based on array length and makes the birds move 
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
      // collision detection birds, if iframes are on car can't get hit
      if (blnIFrames == false) {
        if (dist(fltCarX, fltCarY, birdX[i], birdY[i]) <= 37.4){
          intHealth -= 1;
        }
      }

  }
    // collision detection wall, if iframes are on car can't get hit
    if (blnIFrames == false){
      if (dist(fltCarX, fltCarY, intWallOneX, height/1.69f) <= 37.4){
          intHealth -= 1;
        }
      if (dist(fltCarX, fltCarY, intWallTwoX, height/1.26f) <= 37.4){
          intHealth -= 1;
        }
    }    
  }
    // game over screen
  if (intHealth <= 0){
    
    fill(255);
    rect(0, 0, width, height);
  }
} 
  /**
    * If key is pressed car will move and if 'a' key is pressed you gain invincibility, and lose gas, adds trails
    *
    * @param keyPressed
    * @return if key is pressed car moves and the 'a' key is pressed blnIframes = true, and gas decrease by 1, adds trails 
    * 
    */
  public void keyPressed() {
    if (key == 'w') {
      fltCarY -= 30;
    }   
    if (key == 's') {
      fltCarY += 30;
    }   
    if (key == 'a' && intGas > 0) {
      fltCarX -= 30;
      intGas -= 10;
      blnIFrames = true;
      if (intGas <= 0){
        blnIFrames = false;
      }
      // spawns trails based on array length
      if (blnTrailOn == true) {
        for (int i = 0; i < pvCarTrail.size(); i++) {
          PVector pvTrailPosition = pvCarTrail.get(i);
          image(imgCarTrail, pvTrailPosition.x, pvTrailPosition.y);
        }
      }
    }
    if (key == 'd') {
      fltCarX += 30;
    }   
  }
  
  /**
    * If key is released spawns trail, stops being invincible, gas decreases
    *
    * @param keyReleased
    * @return if key is released and equals 'a', spawns trail, blnIframes = false, gas decreases by 3
    * 
    */
  public void keyReleased(){
    if (key == 'a') {
      blnIFrames = false;
      intGas -= 20;
      // spawns trails based on array length
      if (blnTrailOn == true){
        for (int i = 0; i < pvCarTrail.size(); i++) {
          PVector pvTrailPosition = pvCarTrail.get(i);
          image(imgCarTrail, pvTrailPosition.x, pvTrailPosition.y);
        }
      }
    }
  }

  /**
    * If mouse is clicked then trail turns on or off depends on it's original boolean value
    *
    * @param blnTrailOn
    * @return blnTrailOn as false if true, blnTrailOn as true if false
    * 
    */
  public void mouseClicked() {
    if (blnTrailOn == true){
      blnTrailOn = false;
    }
    else if (blnTrailOn == false){
      blnTrailOn = true;
    } 
}
  
}