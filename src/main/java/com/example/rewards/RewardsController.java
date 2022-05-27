package com.example.rewards;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class RewardsController {

    @GetMapping("rewards")
    @CrossOrigin(origins = {"http://localhost:3000"})
    public String calculateRewardsTotal(@PathParam("customerId") int customerId, @PathParam("month") Month month, @ModelAttribute Transaction[] transactions) {
        int rewardsTotal = 0;
        for(int i = 0; i < transactions.length; i++) {
            if( transactions[i].getCustomerId() == customerId && transactions[i].getMonth() == month) {
                if(transactions[i].getTotal() > 50 && transactions[i].getTotal() < 100 ) {
                    rewardsTotal += transactions[i].getTotal() - 50;
                }
                else if(transactions[i].getTotal() > 100) {
                    rewardsTotal += (transactions[i].getTotal() - 100) * 2 + 50;
                }
            }
        }
        return ((Integer) rewardsTotal).toString();
    }


}
