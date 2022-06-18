[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=7982566&assignment_repo_type=AssignmentRepo)
# The Highway 

# Game Objective
The objective of "The Highway" is for the user to reach the highest distance they can, all while dodging objects including brick walls and birds. 

# Game Description

"The Highway" has many mechanics that make the game unique. Check some of them out below:

### How to Play
The player is in control of a car. In order to control movement you will use the awsd buttons on your keyboard. When you hit objects you will lose health. Once health is zero the game ends. Try to reach as high of a distance as you can.

### Speeding Up
In order to make the game fair, the player will phase through the various obstacles, and if they hit the objects while pressing the 'a' button they wont take damage. Pressing 'a' to accelerate will use gas. When in collision with an object you will take constant damage, the player needs to get out of the object's hitbox in order to lose minimum amounts of health.

### Obstacle 1: Brick Walls
Brick walls are the easiest obstacle to deal with and will spawn right at the begining of the game. They move from left to right. If you hit one of these they won't despawn and you will lose health.

### Obstacle 2: Birds
Birds are the second obstacle type that appear in the game. They spawn near the top of the map at a random x and y value. Their velocity changes rapidly at a random value so their movement is extremely unpredictable. When they go offscreen they return to the top which gives the player some breathing room. If you hit one of these they won't despawn and you will lose health.

### Gas
When you accelerate using the 'a' button you will lose gas. When you release the gas button you lose 10 gas and when holding it you lose 20 gas every interval. You automatically get gas every second with no limit.

### Trail
When you click anywhere on the screen while the game is running you can turn your car trail off and on. It automatically starts on but when you click the screen the trail turns off as the trail may be found annoying to some players.


# Scoring

### Distance
The only scoring that takes place in this game is distance. The objective is to get the most distance. In order to make the game more interesting you can try not losing health which can count as scoring; however, distance is the main scoring system.

# Limitations

### Lag
On certain devices, this game lags really hard due to the massive amount of images being displayed on the screen.