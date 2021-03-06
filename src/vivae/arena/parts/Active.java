/**
 * This is VIVAE (Visual Vector Agent Environment)
 * a library allowing for simulations of agents in co-evolution 
 * written as a bachelor project 
 * by Petr Smejkal
 * at Czech Technical University in Prague
 * in 2008
 */

package vivae.arena.parts;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import net.phys2d.raw.Body;
import vivae.arena.Arena;
import vivae.arena.parts.sensors.Sensor;

/**
 * @author Petr Smejkal
 */
public abstract class Active extends VivaeObject {

	protected AlphaComposite opacityBack = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.10f);
	protected AlphaComposite opacityFront = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.30f);
	protected boolean isShowingStatusFrame = false;
	protected boolean isStatusFramePinedToPosition = false;
	protected int myNumber = 0;
	protected int STATUS_FRAME_LINE_HEIGHT = 20;
    protected Arena arena;
    public double odometer=0.0;
    public double crashmeter = 0.0;
    public double maxDeceleration = 0.0;
    public double overallDeceleration = 0.0;
    protected double lastVelocity = 0.0;

	public Active(float x, float y) {
		super(x, y);
	}

	public abstract float getAcceleration();
	public abstract float getRotationIncrement();
	public abstract float getMaxSpeed();
	public abstract int getNumber();
	public abstract void rotate(float radius);
	public abstract void accelerate(float speed);
	public abstract void decelerate(float speed);
	public abstract String getActiveName();
	public abstract void reportObjectOnSight(Sensor s, Body b);
	public float getFriction(){
		return body.getDamping();
	}
	
	public int getMyNumber() {
		return myNumber;
	}
	
	public void paintStatusFrame(Graphics g){
		int frameX = 5 + myNumber * 100;
		int frameY = 5;
		if (isStatusFramePinedToPosition){
			frameX = (int)this.x - 135;
			frameY = (int)this.y - 135;
		}
		paintStatusFrame(g,frameX,frameY);
	}
	
	public void paintStatusFrame(Graphics g, int baseX, int baseY){
		Graphics2D g2 = (Graphics2D)g;
		Color oldColor = g2.getColor();	
		Composite oldComposite = g2.getComposite();
		g2.setComposite(opacityBack);
		g2.setColor(Color.BLACK);
		g2.fillRect(baseX, baseY, 80, 80);
		g2.setComposite(opacityFront);
		g2.setColor(Color.YELLOW);
		g2.drawRect(baseX, baseY, 80, 80);
		if (isStatusFramePinedToPosition){
			g2.drawLine((int)this.x, (int)this.y, baseX+80, baseY+100 );
		}
		baseX +=5;
		baseY +=15;
		g2.drawString(String.format(getActiveName() + "  #%d", myNumber) , baseX, baseY);
		baseY +=STATUS_FRAME_LINE_HEIGHT;
//		g2.drawString(String.format("speed: %3.1f", body.getVelocity().length()) , baseX, baseY);
//		baseY +=STATUS_FRAME_LINE_HEIGHT;
		g2.drawString(String.format("x: %4.0f", x), baseX, baseY);
		baseY +=STATUS_FRAME_LINE_HEIGHT;
		g2.drawString(String.format("y: %4.0f", y), baseX, baseY);
		baseY +=STATUS_FRAME_LINE_HEIGHT;
		g2.drawString(String.format("friction: %2.1f", getFriction()), baseX, baseY);
		g2.setComposite(oldComposite);
		g2.setColor(oldColor);
	}
	
	public boolean isShowingStatusFrame() {
		return isShowingStatusFrame;
	}


	public void setShowingStatusFrame(boolean isShowingStatusFrame) {
		this.isShowingStatusFrame = isShowingStatusFrame;
	}


	public boolean isStatusFramePinedToPosition() {
		return isStatusFramePinedToPosition;
	}

	public void setStatusFramePinedToPosition(boolean isStatusFramePinedToPosition) {
		this.isStatusFramePinedToPosition = isStatusFramePinedToPosition;
	}
	

	public String toString(){
		return " Active VivaeObject at " + "[" + getX() + ", " + getY() + "]";
	}
        
        public Arena getArena() {
            return arena;
        }

        public void setArena(Arena arena) {
            this.arena = arena;
        }
}