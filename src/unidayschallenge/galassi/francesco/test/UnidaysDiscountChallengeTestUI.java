package unidayschallenge.galassi.francesco.test;
/**
 * This test case allow the programmer to test the User Interface.
 * 
 * @author Francesco Galassi
 */

import java.io.FileNotFoundException;

import org.junit.Test;

import unidayschallenge.galassi.francesco.MyException;
import unidayschallenge.galassi.francesco.UnidaysDiscountChallenge;

public class UnidaysDiscountChallengeTestUI {

	@Test
	public void testingUI() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.userInterface();

	}

}
