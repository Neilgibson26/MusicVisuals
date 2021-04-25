package c17438292;

import processing.core.*;

public class Intro {

    private float x, y;
    private float i = -10;
    private float j = -10;
    private float k = -10;
    private float l = -10;

    NeilsVisual nv;
    Cube c;
    
    public Intro(NeilsVisual nv, float x, float y)
    {
        this.nv = nv;
        this.x = x;
        this.y = y;
    }

    public void render()
    {
        nv.background(0);
        nv.stroke(0);
        nv.textAlign(PConstants.CENTER);
        nv.textSize(50);
        nv.text("Welcome to my cool audio visual representation", x, i);
        nv.text("by Neil Gibson", x, j);
        nv.text("ft. Roísín Murphy", x, k);
        nv.text("Enjoy", x, l);
        i+=1;
        if(i<y)
        {
            j = -20;
            k = -21;
        }
        if(j<y)
        {
            k = -20;
        }
        if(k<y)
        {
            l = -12;
        }
        j+=1;
        k+=1;
        if(l<y)
        {
            l+=1;
        }
        if(l == y)
        {
            l = y;
        }

    }
}
