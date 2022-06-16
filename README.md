[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=7982566&assignment_repo_type=AssignmentRepo)
# The Highway 

# Game Objective
The objective of "The Highway" is for the user to reach the highest distance they can, all while dodging objects including brick walls, drunk drivers, and birds. 

# Game Description

"The Highway" has many mechanics that make the game unique. Check some of them out below:

### How to Play
The player is in control of a car. In order to control movement you will use the awsd buttons on your keyboard. When you hit objects you will lose health. Once health is zero the game ends. As you gain more distance you will encounter different projectiles with different movement patterns.

### Speeding Up
In order to make the game fair, the player will phase through the various obstacles, and if they hit the objects while pressing the 'a' button. The problem with abusing this feature is that you have limited gas and using too much will penalize you (more on this later). Simply pressing the 'a' button to save on gas won't make you completely invincible. When in collision with an object you will take constant damage. In order to prevent all damage you must hold the 'a' button for the duration of the collision

### Obstacle 1: Brick Walls
Brick walls are the easiest obstacle to deal with and will spawn right at the begining of the game. They move from left to right. If you hit one of these they won't despawn and you will lose health. If you want to take minimum damage from these, crash into them at top speed to demolish the wall and take reduced damage.

### Obstacle 2: Birds
Birds are the second obstacle type that appear in the game. They spawn near the top of the map at a random x and y value. Their velocity changes rapidly at a random value so their movement is extremely unpredictable. When they go offscreen they return to the top which gives the player some breathing room. Same as the walls if you crash into them at top speed you will take reduced damage; however, the sheer number of birds will make the damage brutally add up.

### Obstacle 3: Drunk Drivers
Drunk drivers are the 3rd obstacle. They behave like the player in that they have to stay on the road and have a health pool. When hit with obstacles they will also take damage. When you hit a drunk driver your health will go down by a massive random amount. 

### Gas
When you move forward using the 'a' button you will lose gas. Once gas runs out you have to go to a gas station and refill, which makes you lose 30 distance. Using gas gives invincibility frames.
