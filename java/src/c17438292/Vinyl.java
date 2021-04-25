package c17438292;
import processing.core.*;


public class Vinyl
{
    NeilsVisual nv;
    Cube c, b, b1, b2, b3;
    private float halfh;
    private float halfw;
    private float bx;
    private float by;
    private float bx1;
    private float by1;
    private float bx2;
    private float by2;
    private float bx3;
    private float by3;

    //  frX and frY is to increase and decrease until text is off the screen!!
    float frX;
    float frY;
    float smoothedCircleSize = 0;
    private float howMany;

    public Vinyl(NeilsVisual nv, float howMany)
    {
        this.nv = nv;
        this.howMany = howMany;
        this.halfh = (float) this.nv.height/2;
        this.halfw = (float) this.nv.width/2;
        this.frX = (float) this.nv.width/2;
        this.frY = (float) this.nv.width/2;
        by1 = nv.height*0.9f;
        bx1 = nv.width*0.9f;
        bx = nv.width*0.1f;
        by = nv.height*0.08f;
        by2 = nv.height*0.08f;
        bx2 = nv.width*0.9f;
        bx3 = nv.width*0.1f;
        by3 = nv.height*0.9f;


    //  chain a constructor to create a cube when Vinyl is created. passing reference to NV, x & y co-ord, and height.
        this.c = new Cube(this.nv, this.halfw, (this.halfh) + 75, (float)(this.nv.height*0.25), true);
        this.b = new Cube(this.nv, this.bx, by, 50, false);
        this.b1 = new Cube(this.nv, this.bx1, by1, 50, false);
        this.b2 = new Cube(this.nv, this.bx2, by2, 50, false);
        this.b3 = new Cube(this.nv, this.bx3, by3, 50, false);

    }

    public void render()
    {
        nv.background(169,169,169);
        nv.colorMode(PApplet.RGB);
        float circleSize = 50 + (nv.getAmplitude() * 300);
    //  smoothed circle size will get our new h/w for the circle each render so it reacts to the music.
        smoothedCircleSize = PApplet.lerp(smoothedCircleSize, circleSize, 0.2f);
        if(howMany == 2)
        {
            b.drawCube();
            b1.drawCube();
        }
        if(howMany == 3)
        {
            b2.drawCube();
            b3.drawCube();
        }
        if(howMany==4)
        {
            b.drawCube();
            b1.drawCube();
            b2.drawCube();
            b3.drawCube();
        }

    //  height and width for the rectangle.
        float rectw = (float) (nv.width*0.4);
        float recth = (float) (nv.height*0.7);

    //  Draw the vinyl in the middle of the screen.
        nv.stroke(255,255,0);
        nv.strokeWeight(7);
        nv.fill(255, 0, 25);
        nv.rect((float)(nv.width*0.3), (float) (nv.height*0.15), rectw, recth);

        nv.noFill();
        nv.stroke(255, 255, 0);
        nv.strokeWeight(3);
        nv.circle((float)(nv.width*0.2), (float) (nv.height/2), smoothedCircleSize);
    //  Circles either side of the vinyl that use the smoothedCircleSize to react to the music.
        nv.noFill();
        nv.stroke(255, 255, 0);
        nv.strokeWeight(3);
        nv.circle((float)(nv.width*0.8), (float) (nv.height/2), smoothedCircleSize);

    //  Text to sit in the middle of the screen under the vinyl.
        nv.textSize(26);
        nv.textAlign(PConstants.CENTER);
        nv.fill(255, 255, 0);
        nv.text("Funky", frX, (float)(nv.height*0.9));
        nv.text("Record $", frY, (float)(nv.height*0.93));
        nv.text("Roisin Murphy", (float)(nv.width*0.5), (float)(nv.height*0.2));
        nv.text("Murphy's Law", (float)(nv.width*0.5), (float)(nv.height*0.25));

        c.drawCube();
        // frX -= 1;
        // frY += 1;

    }
}