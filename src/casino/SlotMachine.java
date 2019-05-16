/*
 * This class generate a slotMachine for mini casino game.
 * It has random three numbers or things generated.
 * Spin the reel and won something if two or three random numbers are same.
 */
package casino;

import java.util.Random;

/**
 *
 * @author Jinkal Dudhat, 000762953
 */
public class SlotMachine {

    /**
     * Maximum value *
     */
    private static final int MAX = 3;

    /**
     * quarter value to reload machine*
     */
    private static final float QUARTER = (float) 0.25;

    /**
     * total cash in machine *
     */
    private float totalCash;

    /**
     * winning cash per spin *
     */
    private float totalWinningCash;

    /**
     * default cash in the machine *
     */
    private int defaultCash;

    /**
     * reel1 *
     */
    private int reel1;

    /**
     * reel2 *
     */
    private int reel2;

    /**
     * reel3 *
     */
    private int reel3;

    /**
     * Getters and Setters method
     *
     */
    /**
     * @return the total cash in totalCash of the slot machine 
          *
     */
    public float getTotalCash() {
        return totalCash;
    }

    /**
     * Create new total cash.
     *
     * @param totalCash contain value of slot machine.
          *
     */
    public void setTotalCash(float totalCash) {
        this.totalCash = totalCash;
    }

    /**
     * @return the total winning cash value of the slot machine         
         *
     */
    public float getTotalWinningCash() {
        return totalWinningCash;
    }

    /**
     * Create new total winning cash.
     *
     * @param totalWinningCash contain value of slot machine.
         *
     */
    public void setTotalWinningCash(float totalWinningCash) {
        this.totalWinningCash = totalWinningCash;
    }

    /**
     * @return value of default cash of the slot machine *
     */
    public int getDeafultCash() {
        return defaultCash;
    }

    /**
     * Create new defaultCash.
     *
     * @param defaultCash contain value of slot machine.
         *
     */
    public void setDeafultCash(int defaultCash) {
        this.defaultCash = defaultCash;
    }

    /**
     * @return value of reel1 *
     */
    public int getReel1() {
        return reel1;
    }

    /**
     * @param reel1 set new value in reel1 *
     */
    public void setReel1(int reel1) {
        this.reel1 = reel1;
    }

    /**
     * @return value of reel2 *
     */
    public int getReel2() {
        return reel2;
    }

    /**
     * @param reel2 set new value in reel2 *
     */
    public void setReel2(int reel2) {
        this.reel2 = reel2;
    }

    /**
     * @return value of reel3 *
     */
    public int getReel3() {
        return reel3;
    }

    /**
     * @param reel3 set new value in reel3 *
     */
    public void setReel3(int reel3) {
        this.reel3 = reel3;
    }

    /**
     * Enum to define store slot machine reel values
     *
     */
    private enum ReelValues {
        APPLE,
        CHERRY,
        GRAPES
    }

    /**
     * Class Constructor
     *
     */
    public SlotMachine() {
        this.initializeSlotMachine();
    }

    /**
     * Generate random numbers between 0 to 2 and this values are map to one
     * Enum "ReelValues" *
     */
    Random rand = new Random();

    /**
     * instance methods
     *
     */
    /**
     * create new values for default cash, total winning cash and total cash.
     * Also creates value for reel1, reel2 and reel3 which is -1(this means no
     * value of reels). 
        *
     */
    public void initializeSlotMachine() {
        this.defaultCash = 10;
        this.reel1 = -1;
        this.reel2 = -1;
        this.reel3 = -1;
        this.totalWinningCash = 0;
        this.totalCash = this.defaultCash;
    }

    /**
     * if machine has less than $10 reload the machine Adds quarter to the total
     * cash of the slot machine
     */
    public void putQuarter() {

        if (this.totalCash < 10) {
            System.out.println("Machine is out of cash. Please reload it.");
            return;
        }

        this.totalCash += QUARTER;

        this.spinMachine();
        this.matchReelvalues();
    }

    /**
     * spin the machine and generate random numbers for three reels.
     */
    public void spinMachine() {
        this.reel1 = rand.nextInt(MAX);
        this.reel2 = rand.nextInt(MAX);
        this.reel3 = rand.nextInt(MAX);
    }

    /**
     * If all three values matched then player won $10. If two values are
     * matched then player won $5. If all the numbers are different then nothing
     * to win.
         *
     */
    public void matchReelvalues() {
        if (this.reel1 == this.reel2 && this.reel2 == this.reel3) {
            //System.out.println("three value matched");
            this.totalWinningCash += 10;
            this.totalCash -= 10;
            System.out.println("You won $10.00");
        } else if (this.reel1 == this.reel2 || this.reel1 == this.reel3 || this.reel2 == this.reel3) {
            //System.out.println("two value matched");
            this.totalWinningCash += 5;
            this.totalCash -= 5;
            System.out.println("You won $5.00");
        } else {
            //System.out.println("no match");
            System.out.println("You won $0.00");
        }
    }

    /**
     * If every reel is out of cash then reload slot machine by put quarter
     * first.
     */
    public void getReelValues() {

        if (this.reel1 < 0 || this.reel2 < 0 || this.reel3 < 0) {
            System.out.println("First put Quarter in Machine");
            return;
        }
        ReelValues[] enumValues = ReelValues.values();

        //System.out.println(this.reel1 + " " + this.reel2 + " " + this.reel3);
        System.out.println(enumValues[this.reel1] + " " + enumValues[this.reel2] + " " + enumValues[this.reel3]);
    }
}
