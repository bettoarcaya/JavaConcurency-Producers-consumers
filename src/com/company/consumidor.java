package com.company;

/**
 * Created by b3tt0 on 27/04/17.
 */
public class consumidor implements Runnable {


    private cola q;

    public consumidor(cola x){
        this.q = x;
    }

    @Override
    public void run() {
        for(int i = 0; i < q.get_length(); i++){
            System.out.println(q.consumir());
        }
    }
}
