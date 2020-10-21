package CleanCode.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Ball implements Serializable {
    @Id
    private Long id;
    private int position;

    public Ball(Long id, int position) {
        this.position = position;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    @Override
    public String toString() {
        return "Ball{" +
                "id=" + id +
                '}';
    }
}
