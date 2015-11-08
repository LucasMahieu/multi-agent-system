import gui.*;
import java.awt.Color;

public class BoidsSimulator implements gui.Simulable {
    private Boids boids;
    private GUISimulator guiBoids;
    private static final int r=10 ;

    public BoidsSimulator(int n, GUISimulator g){
        this.setBoids(new Boids(n));
        this.setGuiBoids(g);
    }

    public Boids getBoids(){
        return this.boids;
    }
    public GUISimulator getGuiBoids(){
        return this.guiBoids;
    }

    public void setBoids(Boids b){
        this.boids = b;
    }
    public void setGuiBoids(GUISimulator g){
        this.guiBoids = g;
    }

    @Override
    public void next(){
        this.getBoids().step();
        this.getGuiBoids().reset();
        this.affiche();
    }
    @Override
    public void restart(){
        this.getBoids().reInit();
        this.getGuiBoids().reset();
        this.affiche();
    }
    public void affiche() {
        for(int i=0; i<this.getBoids().getNbBoids(); i++){
            this.getGuiBoids().addGraphicalElement(new Oval(this.getBoids().getPx(i),
                                                            this.getBoids().getPy(i),
                                                            Color.BLUE,
                                                            Color.RED,
                                                            r) 
                                );
        }

    }
}
