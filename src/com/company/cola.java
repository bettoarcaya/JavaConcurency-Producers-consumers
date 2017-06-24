package com.company;
import java.util.concurrent.*;
/**
 * Created by b3tt0 on 06/05/17.
 */
public class cola {

    private int cnt;
    private int cnt2;
    private int [] q;

    private Semaphore mutex;
    private Semaphore sempro;
    private Semaphore semcon;


    public cola(int x){

        this.cnt = 0;
        this.cnt2 = 0;
        this.q = new int[x];

        this.mutex = new Semaphore(1,true);
        this.sempro = new Semaphore(x,true);
        this.semcon = new Semaphore(0,true);

    }

    public void producir(){

        try {
            sempro.acquire();
            mutex.acquire();
            q[cnt] = cnt;
            System.out.println("el productor produce: "+cnt);
            cnt = (cnt+1)%q.length;
            mutex.release();
            semcon.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int consumir(){

        int aux = 0;

        try {
            semcon.acquire();
            mutex.acquire();
            aux = cnt2;
            cnt2 = (cnt2+1)%q.length;
            mutex.release();
            sempro.release();
            System.out.println("el consumidor esta consumiendo...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return q[aux];
    }

    public int get_length(){return q.length;}















}
