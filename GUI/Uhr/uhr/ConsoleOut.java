package uhr;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ConsoleOut extends TimerTask implements Runnable {
  
  private String name;
  
  public ConsoleOut(String name) {
	  
    this.name = name;
    
    Timer timer = new Timer();

	   timer.schedule( this, 0, 1000 );
    
  }

  @Override
  public void run() {
    System.out.println(name + ": Es ist " + new Date());
    
  }

}
