package com.company;

/**
 * Created by b3tt0 on 27/04/17.
 */
public class productor implements Runnable {

    private cola q;

    public productor(cola x){
        this.q = x;
    }

    @Override
    public void run() {
        for(int i = 0; i < q.get_length(); i++){
            q.producir();
        }
    }
}
