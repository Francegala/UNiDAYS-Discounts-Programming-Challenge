package unidayschallenge.galassi.francesco.test;
/**
 * This  JUnit Class tests boundaries of the software
 * 
 * @author Francesco Galassi
 */

import java.io.FileNotFoundException;

import org.junit.Test;

import unidayschallenge.galassi.francesco.MyException;
import unidayschallenge.galassi.francesco.UnidaysDiscountChallenge;

public class UnidaysDiscountChallengeTestBoundsandErrors {

	@Test(expected = FileNotFoundException.class)
	public void useWrongPricingRules() throws MyException, FileNotFoundException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRulesError.txt");
		shopping.addToBasket("B");
	}

	@Test(expected = MyException.class)
	public void addErrorItem() throws MyException, FileNotFoundException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("Z");
	}

}
