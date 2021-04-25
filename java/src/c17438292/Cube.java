package c17438292;
import processing.core.*;

public class Cube 
{
    private float x;
    private float y;
    private float boxh;
    private float angle = 0;
    private boolean rx;
    NeilsVisual nv;

    //  Constructor that takes the x and y of where I want to draw a cube, the height, and NeilsVisual and Papplet
    //  functionality
    public Cube(NeilsVisual nv, float x, float y, float boxh, boolean rx)
    {
        this.nv = nv;
        this.x = x;
        this.y = y;
        this.boxh = boxh;
        this.rx = rx;
    }

    public void drawCube()
    {
        nv.colorMode(PApplet.RGB);

        //  Draw first outer Cube
        if(rx)
        {
        nv.pushMatrix();
        nv.translate(x, y);
        nv.rotateY(angle);
        nv.rotateX(angle);
        angle += 0.01;

        nv.lights();
        nv.noFill();
        nv.strokeWeight(2);
        nv.stroke(255, 255, 0);

        nv.box(boxh);
        nv.popMatrix();
        
        //  Draw second cube inside first
        nv.pushMatrix();
        nv.translate(x, y);
        nv.rotateY(angle);
        nv.rotateX(angle);
        angle += 0.01;

        nv.lights();
        nv.noFill();
        nv.strokeWeight(2);
        nv.stroke(255, 255, 0);

        nv.box(boxh/2);
        nv.popMatrix();
        }
        else 
        {
            nv.pushMatrix();
            nv.translate(x, y);
            nv.rotateY(angle);
            angle += 0.01;
    
            nv.lights();
            nv.noFill();
            nv.strokeWeight(2);
            nv.stroke(255, 255, 0);
    
            nv.box(boxh);
            nv.popMatrix();
            
            //  Draw second cube inside first
            nv.pushMatrix();
            nv.translate(x, y);
            nv.rotateY(angle);
            angle += 0.01;
    
            nv.lights();
            nv.noFill();
            nv.strokeWeight(2);
            nv.stroke(255, 255, 0);
    
            nv.box(boxh/2);
            nv.popMatrix();
        }

    }
    
}
