package module12.task1;

class ThreadGetTime extends Thread {
    public void getTimeSinceStart()
            throws InterruptedException {
        Thread printThreadEverySec = new Thread() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();

                while (!isInterrupted()) {
                    long time = (System.currentTimeMillis() - startTime) / 1000;
                    System.out.println("Минуло: " + time + " сек.");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        printThreadEverySec.start();
        Thread printThreadEveryFiveSec = new Thread() {
            @Override
            public void run() {

                while (!isInterrupted()) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Минуло 5 секунд");

                }
            }
        };
        printThreadEveryFiveSec.start();
    }
}