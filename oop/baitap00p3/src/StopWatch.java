public class StopWatch {
    private long startTime;
    private long endTime;

    // Constructor: gán startTime là thời gian hiện tại
    public StopWatch() {
        startTime = System.currentTimeMillis();
    }

    // Bắt đầu lại đồng hồ
    public void start() {
        startTime = System.currentTimeMillis();
    }

    // Dừng đồng hồ
    public void stop() {
        endTime = System.currentTimeMillis();
    }

    // Trả về thời gian đã trôi qua (ms)
    public long getElapsedTime() {
        return endTime - startTime;
    }

    // Getter (nếu cần dùng)
    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
}
