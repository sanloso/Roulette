package CleanCode.model;

import org.springframework.data.annotation.Id;
import java.io.Serializable;

public class Roulette implements Serializable {
    @Id
    private Long id;
    private boolean status = false;
    private int bets = 0;

    public Roulette(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean isStatus() {
        return status;
    }
    public boolean getStatus(){
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getBets() {
        return bets;
    }
    public void setBets() {
        this.bets = bets + 1;
    }
    @Override
    public String toString() {
        return "Roulette{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
