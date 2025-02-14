package Model.Entities.Rents;

import Model.Enums.RentState;
import Model.Factory.IdFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Rent {

    private long id;
    private LocalDate date;
    private LocalDate giveBackDate;

    private LocalDate closeDate;
    private RentState rentState;
    public Rent(int days){
        this.id = IdFactory.generateUniqueId();
        this.date = LocalDate.now();
        this.giveBackDate = date.plusDays(days);
        this.rentState = RentState.STARTED;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public RentState getRentState() {
        return rentState;
    }

    public void setRentState(RentState rentState) {
        this.rentState = rentState;
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

    public RentState getState() {
        return rentState;
    }

    public void setState(RentState rentState) {
        this.rentState = rentState;
    }

    public long calculateFirstDuration(){
        return ChronoUnit.DAYS.between(this.date,this.giveBackDate);
    }

    public long calculateDuration(){
        return ChronoUnit.DAYS.between(this.date,this.closeDate);
    }
    public RentState checkStatus(){
        if(giveBackDate.isBefore(LocalDate.now())){
            this.setState(RentState.OUTOFDATE);
        }
        return this.rentState;
    }

    public long calculateDelayDays(){
        return ChronoUnit.DAYS.between(this.giveBackDate,LocalDate.now());
    }

    public RentState closeRent(LocalDate date){
        this.closeDate = date;
        this.rentState = RentState.CANCELED;
        
        return this.rentState;
    }

    @Override
    public String toString() {
        return date + " " + rentState + " " + giveBackDate;
    }
}
