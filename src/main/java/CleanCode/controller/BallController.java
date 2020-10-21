package CleanCode.controller;

import CleanCode.model.Ball;
import CleanCode.service.impl.BallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/balls")
public class BallController {
    @Autowired
    public BallService ballService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createBall(@RequestBody Ball ball){
        try {
            ballService.createBall(ball);
            return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> GetAllBalls(){
        try {
            System.out.println(ballService.findBalls());
            return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
