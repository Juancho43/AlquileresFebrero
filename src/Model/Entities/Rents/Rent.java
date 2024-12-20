package Model.Entities.Rents;

import Model.Enums.State;
import Model.Factory.IdFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rent {

    private long id;
    private LocalDate date;
    private LocalDate giveBackDate;
    private State state;
    public Rent(int days){
        this.id = IdFactory.generateUniqueId();
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

    public long calculateDuration(){
        return ChronoUnit.DAYS.between(this.date,this.giveBackDate);
    }

    public State checkStatus(){
        if(giveBackDate.isBefore(LocalDate.now())){
            this.setState(State.OUTOFDATE);
        }
        return this.state;
    }

    public long calculateDelayDays(){
        return ChronoUnit.DAYS.between(this.giveBackDate,LocalDate.now());
    }

    public State closeRent(){
        this.state = State.CANCELED;
        return this.state;
    }

    @Override
    public String toString() {
        return date + " " + state + " " + giveBackDate;
    }
}
