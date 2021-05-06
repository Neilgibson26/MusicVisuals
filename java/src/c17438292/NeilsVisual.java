package c17438292;

public class NeilsVisual extends Visual {

    Vinyl v, v2, v3, v4;
    Wave w, w1, w2, w3, w4;
    Intro io;
    Disco disco;
    RotatingAudioBands rb;
    float halfh, halfw;
    float waveX, waveY;
    Rain[] r = new Rain[250];

    public void settings()
    {
        //size(1024, 500, P3D);
    //  Use this to make fullscreen
        //fullScreen();

    //  Use this to make fullscreen and use P3D for 3D graphics
        fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
    //  surface.setResizable(true);
        startMinim();
        
        //setFrameSize(256);
                
    //  Call loadAudio to load an audio file to process 
        loadAudio("MurphysLaw.mp3");
        getAudioPlayer().play(); 
        
    //  Call this instead to read audio from the microphone
        //startListening(); 

        halfh = height/2;
        halfw = width/2;
        waveX = width * 0.38f;
        waveY = height * 0.35f;
        background(0);

        v = new Vinyl(this, 0);
        v2 = new Vinyl(this, 2);
        v3 = new Vinyl(this, 3);
        v4 = new Vinyl(this, 4);

        w = new Wave(this, waveX, waveY, width-waveX, waveY);
        w1 = new Wave(this, (width*0.1f), (height*0.1f), (width*0.1f),  (height*0.9f));
        w2 = new Wave(this, (width*0.9f), (height*0.1f), (width*0.9f),  (height*0.9f));
        w3 = new Wave(this, (width*0.1f), (height*0.1f), (width*0.9f),  (height*0.1f));
        w4 = new Wave(this, (width*0.1f), (height*0.9f), (width*0.9f),  (height*0.9f));

        io = new Intro(this, halfw, halfh);

        disco = new Disco(this, halfw, halfh);

        rb = new RotatingAudioBands(this, halfw, halfh);

        for(int i = 0; i<r.length; i++)
        {
            r[i] = new Rain(this);
        }
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            disco.render();
            for(int i = 0; i<r.length; i++)
            {
                r[i].draw();
                r[i].fall();
            }
        }
        if (key == '1')
        {
            v.render();
            w.render(); 
        }
        if (key == '2')
        {
            v2.render();
            w.render(); 
        }
        if (key == '3')
        {
            v3.render();
            w.render(); 
        }
        if (key == '4')
        {
            v4.render();
            w.render(); 
        }
        if (key == '5')
        {
            v4.render();
            w.render();
            w1.render();
            w2.render();
        }
        if (key == '6')
        {
            v4.render();
            w.render();
            w3.render();
            w4.render();
        }
        if (key == '7')
        {
            v4.render();
            w.render();
            w1.render();
            w2.render();
            w3.render();
            w4.render();
        }
        if (key == '8')
        {
            rb.render();
        }
    }

    public void draw()
    {
        io.render();

        //  Call this if you want to use FFT data
        try {
                calculateFFT();
        } catch (VisualException e) {
            e.printStackTrace();
        } 

    //  Call this is you want to use frequency bands
        calculateFrequencyBands(); 

    //  Call this is you want to get the average amplitude
        calculateAverageAmplitude();
        
        keyPressed();
        
     
    }
}
