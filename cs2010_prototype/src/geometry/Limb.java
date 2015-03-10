package geometry;
/**
 * Abstract class for a biomorph limb. This will allow different types of limbs
 * to be modelled.
 * @author Jack Taylor
 */
public abstract class Limb
{
	protected int length;
	protected int thickness;
	protected int red;
	protected int green;
	protected int blue;
	/**
	 * Constructor
	 */
	public Limb(int length, int thickness, int red, int green, int blue)
	{
		this.length = length;
		this.thickness = thickness;
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	public abstract void draw();
}