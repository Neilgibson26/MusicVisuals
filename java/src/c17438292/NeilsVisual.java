package c17438292;

public class NeilsVisual extends Visual {

    Vinyl v;

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
                
    //  Call loadAudio to load an audio file to process 
        loadAudio("Narcissus.mp3"); 
        
    //  Call this instead to read audio from the microphone
        //startListening(); 
        v = new Vinyl(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    public void draw()
    {
        background(0);

        // Call this if you want to use FFT data
        // try {
                //  calculateFFT();
        // } catch (VisualException e) {
        //     e.printStackTrace();
        // } 

    //  Call this is you want to use frequency bands
        calculateFrequencyBands(); 

    //  Call this is you want to get the average amplitude
        calculateAverageAmplitude();
        
    //  Render the Vinyl visuals.
        v.render();      
    }
}
