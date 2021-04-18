package c17438292;
import processing.core.*;


public class Vinyl
{
    Cube c;
    private float halfh;
    private float halfw;
    float smoothedCircleSize = 0;
    NeilsVisual nv;

    public Vinyl(NeilsVisual nv)
    {
        this.nv = nv;
        this.halfh = (float) this.nv.height/2;
        this.halfw = (float) this.nv.width/2;

    //  chain a constructor to create a cube when Vinyl is created. passing reference to NV, x & y co-ord, and height.
        this.c = new Cube(this.nv, this.halfw, this.halfh, (float)(this.nv.height*0.25));
    }

    public void render()
    {
        nv.background(255);
        nv.colorMode(PApplet.RGB);
        float circleSize = 50 + (nv.getAmplitude() * 300);
    //  smoothed circle size will get our new h/w for the circle each render so it reacts to the music.
        smoothedCircleSize = PApplet.lerp(smoothedCircleSize, circleSize, 0.2f);

    //  height and width for the rectangle.
        float rectw = (float) (nv.width*0.4);
        float recth = (float) (nv.height*0.7);

    //  Draw the vinyl in the middle of the screen.
        nv.stroke(169,169,169);
        nv.strokeWeight(1);
        nv.fill(248, 248, 255);
        nv.rect((float)(nv.width*0.3), (float) (nv.height*0.15), rectw, recth);

        nv.noFill();
        nv.stroke(0);
        nv.strokeWeight(3);
        nv.circle((float)(nv.width*0.15), (float) (nv.height/2), smoothedCircleSize);
    //  Circles either side of the vinyl that use the smoothedCircleSize to react to the music.
        nv.noFill();
        nv.stroke(0);
        nv.strokeWeight(3);
        nv.circle((float)(nv.width*0.85), (float) (nv.height/2), smoothedCircleSize);

    //  Text to sit in the middle of the screen under the vinyl.
        nv.textSize(26);
        nv.textAlign(PConstants.CENTER);
        nv.fill(0);
        nv.text("Funky", (float)(nv.width*0.5), (float)(nv.height*0.9));
        nv.text("Record $", (float)(nv.width*0.5), (float)(nv.height*0.925));

        c.drawCube();

    }

}
