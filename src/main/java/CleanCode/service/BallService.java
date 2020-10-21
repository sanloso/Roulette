package CleanCode.service;

import CleanCode.model.Ball;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BallService {
    public void createBall(Ball ball);
    public List<Ball> findBalls();
}
