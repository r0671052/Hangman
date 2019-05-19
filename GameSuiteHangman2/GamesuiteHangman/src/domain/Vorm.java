package domain;

import java.awt.Graphics;


public abstract class Vorm implements Drawable{
	private boolean zichtbaar;
	
	
	public Vorm(){
		zichtbaar = true;
	}
	
	public abstract Omhullende getOmhullende();

	@Override
	public abstract boolean equals(Object object);

	@Override
	public abstract String toString();
	
	
	public abstract void teken(Graphics graphics);
	
	public boolean isZichtbaar(){
		return zichtbaar;
	}
	
	public void setZichtbaar(boolean zichtbaar){
		this.zichtbaar = zichtbaar;
	}
}
