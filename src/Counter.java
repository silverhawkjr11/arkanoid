/**
 * @author [saeed kanawat][saeed.kanawat@gmail.com][211757968]
 * @version 1
 * @since 3-6-2021
 * */
public class Counter {
    private int value;
    /**
     * this is a constructor.
     * */
    public Counter() {
        this.value = 0;
    }
    /**
     * add number to current count.
     * @param number the value that we seek to increase by.
     * */
    void increase(int number) {
        this.value += number;
    }
    /**
     * subtract number from current count.
     * @param number the value that we seek to increase by.
     * */
    void decrease(int number) {
        this.value -= number;
    }
    /**
     * @return get current count.
     * */
    int getValue() {
        return this.value;
    }
}
