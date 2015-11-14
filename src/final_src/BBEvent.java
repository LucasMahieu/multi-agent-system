public class BBEvent extends Event {
    private Balls[] balls;
    private int[] delai;

    public BBEvent(Balls[] balls, long date, EventManager manager, int[] delai) {
        super(date, manager);
        this.balls = balls;
        this.delai = delai;
    }

    public void execute() {
        for(int i = 0; i < this.balls.length; i++) {
            this.balls[i].actualiser();
            super.getManager().addEvent(new BBEvent(this.balls, super.getDate() + this.delai[i], this.getManager(), this.delai));
        }
    }
}
