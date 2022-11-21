import java.util.concurrent.Semaphore;
class reader_writer{
    static int readerCount = 0;
    static Semaphore rsem = new Semaphore(1);
    static Semaphore wsem = new Semaphore(1);

    static class Read implements Runnable{
        @Override
        public void run()
        {
            try{
                rsem.acquire();
                readerCount++;
                if(readerCount==1)
                {
                    wsem.acquire();
                }
                rsem.release();
                System.out.println("Thread " +Thread.currentThread().getName()+ " is READING");
                Thread.sleep(1500);
                System.out.println("Thread " +Thread.currentThread().getName()+ " has FINISHED READING");
                rsem.acquire();
                readerCount--;
                if(readerCount==0)
                {
                    wsem.release();
                }
                rsem.release();
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    static class Write implements Runnable{
        @Override
        public void run()
        {
            try{
                wsem.acquire();
                System.out.println("Thread " +Thread.currentThread().getName()+ " is WRITING");
                Thread.sleep(2500);
                System.out.println("Thread " +Thread.currentThread().getName()+ " has FINISHED WRITING");
                wsem.release();
            }
            catch(InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }    
    
    public static void main(String[] args) throws Exception{
        Read read = new Read();
        Write write = new Write();
        Thread t1 = new Thread(read);
        t1.setName("Thread1");
        Thread t2 = new Thread(read);
        t2.setName("Thread2");
        Thread t3 = new Thread(write);
        t3.setName("Thread3");
        Thread t4 = new Thread(read);
        t4.setName("Thread4");
        t1.start();
        t3.start();
        t2.start();
        t4.start();
    }
}
