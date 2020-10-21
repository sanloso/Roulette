package CleanCode.repository.impl;

import CleanCode.model.Ball;
import CleanCode.repository.BallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BallRespository implements CleanCode.repository.BallRepository{
    @Autowired
    private RedisTemplate redisTemplate;
    private static final String KEY = "BALL";
    @Override
    public void save(Ball ball) {
        try {
            redisTemplate.opsForHash().put(KEY, ball.getId().toString(), ball);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public List<Ball> findBalls() {
        try {
            List<Ball> balls;
            balls = redisTemplate.opsForHash().values(KEY);
            return balls;
        } catch (Exception e) {
            return null;
        }
    }
}
