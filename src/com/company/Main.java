package com.company;


public class Main extends Thread {

    public static void main(String[] args) {
	// write your code here

        cola q = new cola(5);

        productor [] pro = new productor[5];
        consumidor [] con = new consumidor[5];
        for (int i = 0; i < q.get_length(); i++){
            pro[i] = new productor(q);
            con[i] = new consumidor(q);
        }
       while (true){
           for (int i = 0; i < q.get_length(); i++){

               Thread hilos1 = new Thread(pro[i]);
               hilos1.start();
               Thread hilos2 = new Thread(con[i]);
               hilos2.start();

           }
       }

    }
}
