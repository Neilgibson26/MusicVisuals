package c17438292;
import processing.core.*;

public class Cube 
{
    private float x;
    private float y;
    private float boxh;
    NeilsVisual nv;

    public Cube(NeilsVisual nv, float x, float y, float boxh)
    {
        this.nv = nv;
        this.x = x;
        this.y = y;
        this.boxh = boxh;
    }

    public void drawCube()
    {
        nv.translate(x, y);
        nv.box(boxh);

    }
    
}
