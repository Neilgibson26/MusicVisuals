package c17438292;
import java.util.Random;

import processing.core.*;

public class Rain {
    NeilsVisual nv;
    float x;
    float y;
    float ySpeed;

    public Rain(NeilsVisual nv)
    {
        this.nv = nv;
        this.x = nv.random(nv.width);
        this.y = nv.random(-200, -100);
        this.ySpeed = nv.random(4, 10);
    }
    //291.1
    public void fall()
    {
        y = y+ySpeed;
        if(y > nv.height)
        {
            y = nv.random(-200, -100);
        }
    }

    public void draw()
    {
        nv.fill(255);
        nv.stroke(255);
        nv.line(x, y, x, y+10);
    }
    
}
