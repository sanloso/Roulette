package CleanCode.repository;

import CleanCode.model.Ball;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BallRepository {
    public void save(Ball ball);
    public List<Ball> findBalls();
}
