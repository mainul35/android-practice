package mainul35.com.crapsgame;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    public static void main(String... args) throws InterruptedException {
        System.out.println(generateRandomNumber());
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return (random.nextInt(5)+1);
    }
}