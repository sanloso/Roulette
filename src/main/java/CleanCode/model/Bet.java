package CleanCode.model;

import java.io.Serializable;

public class Bet implements Serializable{
    public Long id;
    public Long number;
    public String color;
    public Long idUser;
    public float money;
    public Long numRoulette;
    public String result = "loser";
    public float moneyEarned = 0;

    public Bet(Long number, String color, Long idUser, Long money, Long numRoulette) {
        this.number = number;
        this.color = color;
        this.idUser = idUser;
        this.money = money;
        this.numRoulette = numRoulette;
    }
    public float getMoneyEarned() {
        return moneyEarned;
    }
    public void setMoneyEarned(float moneyEarned) {
        this.moneyEarned = moneyEarned;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getNumber() {
        return number;
    }
    public void setNumber(Long number) {
        this.number = number;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    public float getMoney() {
        return money;
    }
    public void setMoney(Long money) {
        this.money = money;
    }
    public Long getNumRoulette() {
        return numRoulette;
    }
    public void setNumRoulette(Long numRoulette) {
        this.numRoulette = numRoulette;
    }
    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", number=" + number +
                ", color='" + color + '\'' +
                ", idUser=" + idUser +
                ", money=" + money +
                ", numRoulette=" + numRoulette +
                '}';
    }
}
