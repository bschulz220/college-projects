package Game;
//Ben Schulz
import java.util.Random;

import javax.swing.JOptionPane;

public class Game
{
  private Grid grid;
  private int userRow;
  private int msElapsed;
  private int timesGet;
  private int timesAvoid;
  
  public Game()
  {
    grid = new Grid(10, 10);
    userRow = 5;
    msElapsed = 0;
    timesGet = 0;
    timesAvoid = 0;
    updateTitle();
    grid.setImage(new Location(userRow, 0), "user.gif");
  }
  
  public void play()
  //TAS: Runs the game while isGameOver is false
  {
    while (!isGameOver())
    {
      grid.pause(100);
      handleKeyPress();
      if (msElapsed % 300 == 0)
      {
        scrollLeft();
        populateRightEdge();
      }
      updateTitle();
      msElapsed += 100;
    }
    System.out.println("Game Over! Your score is: " + getScore());
    //JOptionPane.showMessageDialog(null, "Game Over! Your score is: " + getScore());
  }
  
  public void handleKeyPress()
//TAS: moves the user up and down when the up and down arrow keys are pressed
  {
	  int key = grid.checkLastKeyPressed();
	  grid.setImage(new Location(userRow, 0), null);
	  if (key == 38)//up
	  {
		  if (userRow > 0)
			  userRow -= 1;
		  //System.out.println((userRow > 0) + "pants");
	  }//if
	  else if (key == 40)//down
	  {
		  if (userRow < grid.getNumRows()-1)
			  userRow += 1;
	  }//else if
	  handleCollision(new Location(userRow, 0));
	  grid.setImage(new Location(userRow, 0), "user.gif");
  }
  
  public void populateRightEdge()
//TAS: Randomly adds obstacles and objectives to the right edge of the screen
  {
	  Random rand = new Random();
	  
	  for (int i = 0; i < grid.getNumRows(); i++)
	  {
		  int random = rand.nextInt(100);
		  if (random > 60 && random < 80)
		  {
			  grid.setImage(new Location(i, grid.getNumCols()-1), "get.gif");
			  //grid.setColor(new Location(i, grid.getNumCols()-1), new Color(0, 200, 0));
		  }//if
		  else if (random >= 80)
			  grid.setImage(new Location(i, grid.getNumCols()-1), "avoid.gif");
		  else
			  grid.setImage(new Location(i, grid.getNumCols()-1), null);
	  }//for
  }
  
  public void scrollLeft()
//TAS: Scrolls everything to the left of their current 
  {
	  boolean isUser = false;
	  handleCollision(new Location(userRow, 1));
	  for (int col = 1; col < grid.getNumCols(); col++)
	  {
		  for (int row = 0; row < grid.getNumRows(); row++)
		  {
			  
			  if (grid.getImage(new Location(row, col-1)) != null)
			  {
				  //System.out.println(grid.getImage(new Location(row, col-1)).equals("avoid.gif"));
				  if (grid.getImage(new Location(row, col-1)).equals("user.gif"))//(row != userRow)
				  {
					  isUser = true;
					  //grid.setImage(new Location(row, col-1), grid.getImage(new Location(row, col)));
				  }//if
			  }//if
			  if (!isUser)
			  {
				  grid.setImage(new Location(row, col-1), grid.getImage(new Location(row, col)));
			  }//if
			  isUser = false;
		  }//for row
	  }//for col
  }
  
  public void handleCollision(Location loc)
//TAS: Increments timesAvoid or timesGet whenever the user collides with an object
  {
	  if (grid.getImage(loc) != null)
	  {
		  if (grid.getImage(loc).equals("avoid.gif"))
			  timesAvoid++;
		  else if (grid.getImage(loc).equals("get.gif"))
			  timesGet++;
		  if (!grid.getImage(loc).equals("user.gif"))
			  grid.setImage(loc, null);
		  
//		  System.out.println("Avoids hit: " + timesAvoid);
//		  System.out.println("Gets hit:   " + timesGet);
	  }//if
		  
  }
  
  public int getScore()
//TAS: returns timesGet minus timesAvoid
  {
    return timesGet - timesAvoid;
  }
  
  public void updateTitle()
//TAS: updates the title
  {
    grid.setTitle("Game:  " + getScore());
  }
  
  public boolean isGameOver()
  {
	if (msElapsed >= 30000)//after 30 seconds
		return true;
    return false;
  }
  
  public static void test()
  {
    Game game = new Game();
    game.scrollLeft();
    game.populateRightEdge();//step 4
    game.play();
  }
  
  public static void main(String[] args)
  {
    test();
  }
}