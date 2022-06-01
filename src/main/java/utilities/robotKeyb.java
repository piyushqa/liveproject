package utilities;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class robotKeyb
{
	public void keyPress() throws Exception
	{
		Robot robt = new Robot();
		robt.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robt.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		robt.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
		robt.keyPress(java.awt.event.KeyEvent.VK_V);
		robt.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robt.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		Thread.sleep(4000);
//		robt.keyPress(KeyEvent.VK_CAPS_LOCK);
//		robt.keyPress(KeyEvent.CTRL_DOWN_MASK);
//		robt.keyPress(KeyEvent.VK_P);
//		//robt.keyRelease(KeyEvent.VK_P);
//		Thread.sleep(1000);
		//robt.keyRelease(KeyEvent.CTRL_DOWN_MASK);
	}

	public void moveClickMouse(String button, int x, int y) throws Exception
	{
		Robot robt = new Robot();
		if (x!=0 && y!=0)
		{
			robt.mouseMove(x, y);
		}

		if (button != "")
		{
			int buttonToClick = 0;
			switch (button)
			{
				case "left":
					buttonToClick = InputEvent.BUTTON1_DOWN_MASK;
					break;
				case "middle":
					buttonToClick = InputEvent.BUTTON2_DOWN_MASK;
					break;
				case "right":
					buttonToClick = InputEvent.BUTTON3_DOWN_MASK;
					break;
			}
			robt.mousePress(buttonToClick);
			robt.mouseRelease(buttonToClick);
		}
	}

	public void spinMouseWheel(String direction, int increment) throws Exception
	{
		Robot robt = new Robot();
		if (direction != "")
		{
			switch (direction)
			{
			case "up":
				increment = 0 - increment;
				break;
			case "down":
				break;
			}
		}
		robt.mouseWheel(increment);
	}

}
