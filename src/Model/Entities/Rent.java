package Model.Entities;

import java.time.LocalDate;

public class Rent {
    private long id;
    private LocalDate date;
    private LocalDate giveBackDate;
    private State state;
    public Rent(int days){
        this.date = LocalDate.now();
        this.giveBackDate = date.plusDays(days);
        this.state = State.STARTED;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getGiveBackDate() {
        return giveBackDate;
    }

    public void setGiveBackDate(LocalDate giveBackDate) {
        this.giveBackDate = giveBackDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
