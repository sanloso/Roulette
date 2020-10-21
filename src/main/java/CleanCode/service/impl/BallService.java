package CleanCode.service.impl;

import CleanCode.model.Ball;
import CleanCode.repository.BallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BallService implements CleanCode.service.BallService {
    @Autowired
    private BallRepository ballRepository;
    @Override
    public void createBall(Ball ball) {
        try {
            ballRepository.save(ball);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Ball> findBalls() {
        try {
            return ballRepository.findBalls();
        } catch (Exception e) {
            return null;
        }
    }
}
