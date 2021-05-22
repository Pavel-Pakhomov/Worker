public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback,OnTaskErrorListener errorCallback){
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start(){
        for(int i=1; i < 100; i++) {
            if (i < 67) {
                callback.onDone("Задание " + i + " выполнено");
            } else errorCallback.onError("Задание " + i + " не выполнено");
        }
    }
    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }
    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);

    }

}