package _Java8._Глава_11_Многопоточность._Глава_11_Пример3_synchronized;
class Com {
   int a = 0;
}
class XOX implements Runnable {
   final Com res;
   XOX(Com res) {
      this.res = res;
   }
   @Override
   public void run () {
      synchronized (res) {
         res.a = 1;
         for (int i = 0; i < 5; i++) {
             // currentThread() -Возвращает
             // ссылку на выполняемый в данный момент объект
             // потока.
            System.out.println(Thread.currentThread().
                    getName() + " - " + res.a);
            res.a++;
            try {
               Thread.sleep(500);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }
   }
}
class SynchronizedThread1 {
   public static void main (String[] args) {
      Com commo = new Com();
      Thread t;
      for (int i = 1; i<4; i++){
         t = new Thread(new XOX(commo),("Поток " + i));
        // t.setName("Поток " + i);
         t.start();
      }
   }
}
