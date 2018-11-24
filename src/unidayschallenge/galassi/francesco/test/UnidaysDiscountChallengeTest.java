package unidayschallenge.galassi.francesco.test;
/**
 * This JUnit class, tests all the test cases provided.
 * 
 * @author Francesco Galassi
 */
import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Test;
import unidayschallenge.galassi.francesco.MyException;
import unidayschallenge.galassi.francesco.UnidaysDiscountChallenge;

public class UnidaysDiscountChallengeTest {

	@Test
	public void noneItemsTotal() throws FileNotFoundException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		assertEquals(0, shopping.calculateTotalPrice());
	}

	@Test
	public void noneItemsDelivery() throws FileNotFoundException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		assertEquals(0, shopping.calculateDeliveryPrice());
	}

	@Test
	public void noneItemsOverall() throws FileNotFoundException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		int overallTotal = shopping.calculateDeliveryPrice()+shopping.calculateTotalPrice();
		assertEquals(0, overallTotal);
	}

	@Test
	public void addAItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("A");
		assertEquals(8, shopping.calculateTotalPrice());
	}

	@Test
	public void addAItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("A");
		assertEquals(7, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addAItemOverall() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("A");

		int overallTotal = shopping.calculateDeliveryPrice()+shopping.calculateTotalPrice();
		assertEquals(15, overallTotal);
	}

	@Test
	public void addBItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("B");
		assertEquals(12, shopping.calculateTotalPrice());
	}

	@Test
	public void addBItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("B");
		assertEquals(7, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addBItemOverall() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("B");

		int overallTotal = shopping.calculateDeliveryPrice()+shopping.calculateTotalPrice();
		assertEquals(19, overallTotal);
	}

	@Test
	public void addCItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("C");
		assertEquals(4, shopping.calculateTotalPrice());
	}

	@Test
	public void addCItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("C");
		assertEquals(7, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addCItemOverall() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("C");

		int overallTotal = shopping.calculateDeliveryPrice()+shopping.calculateTotalPrice();
		assertEquals(11, overallTotal);
	}


	@Test
	public void addDItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("D");
		assertEquals(7, shopping.calculateTotalPrice());
	}

	@Test
	public void addDItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("D");
		assertEquals(7, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addEItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("E");
		assertEquals(5, shopping.calculateTotalPrice());
	}

	@Test
	public void addEItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("E");
		assertEquals(7, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addBBItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("B");
		shopping.addToBasket("B");
		assertEquals(20, shopping.calculateTotalPrice());
	}

	@Test
	public void addBBItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("B");
		shopping.addToBasket("B");
		assertEquals(7, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addBBBItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("B");
		shopping.addToBasket("B");
		shopping.addToBasket("B");
		assertEquals(32, shopping.calculateTotalPrice());
	}

	@Test
	public void addBBBItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("B");
		shopping.addToBasket("B");
		shopping.addToBasket("B");
		assertEquals(7, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addCCCItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		assertEquals(10, shopping.calculateTotalPrice());
	}

	@Test
	public void addCCCItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		assertEquals(7, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addCCCCItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		assertEquals(14, shopping.calculateTotalPrice());
	}

	@Test
	public void addCCCCItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		assertEquals(7, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addDDItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		assertEquals(7, shopping.calculateTotalPrice());
	}

	@Test
	public void addDDItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		assertEquals(7, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addDDDItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		assertEquals(14, shopping.calculateTotalPrice());
	}

	@Test
	public void addDDDItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		assertEquals(7, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addEEItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("E");
		shopping.addToBasket("E");
		assertEquals(10, shopping.calculateTotalPrice());
	}

	@Test
	public void addEEItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("E");
		shopping.addToBasket("E");
		assertEquals(7, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addEEEItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("E");
		shopping.addToBasket("E");
		shopping.addToBasket("E");
		assertEquals(10, shopping.calculateTotalPrice());
	}

	@Test
	public void addEEEItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("E");
		shopping.addToBasket("E");
		shopping.addToBasket("E");
		assertEquals(7, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addDDDDDDDDDDDDDDItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		assertEquals(49, shopping.calculateTotalPrice());
	}

	@Test
	public void addDDDDDDDDDDDDDDItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		assertEquals(7, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addBBBBCCCItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("B");
		shopping.addToBasket("B");
		shopping.addToBasket("B");
		shopping.addToBasket("B");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		assertEquals(50, shopping.calculateTotalPrice());
	}

	@Test
	public void addBBBBCCCItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("B");
		shopping.addToBasket("B");
		shopping.addToBasket("B");
		shopping.addToBasket("B");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		assertEquals(0, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addABBCCCDDEEItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("A");
		shopping.addToBasket("B");
		shopping.addToBasket("B");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("E");
		shopping.addToBasket("E");
		assertEquals(55, shopping.calculateTotalPrice());
	}

	@Test
	public void addABBCCCDDEEItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("A");
		shopping.addToBasket("B");
		shopping.addToBasket("B");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("C");
		shopping.addToBasket("D");
		shopping.addToBasket("D");
		shopping.addToBasket("E");
		shopping.addToBasket("E");
		assertEquals(0, shopping.calculateDeliveryPrice());
	}

	@Test
	public void addEDCBAEDCBCItemTotal() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("E");
		shopping.addToBasket("D");
		shopping.addToBasket("C");
		shopping.addToBasket("B");
		shopping.addToBasket("A");
		shopping.addToBasket("E");
		shopping.addToBasket("D");
		shopping.addToBasket("C");
		shopping.addToBasket("B");
		shopping.addToBasket("C");
		assertEquals(55, shopping.calculateTotalPrice());
	}

	@Test
	public void addEDCBAEDCBCItemDelivery() throws FileNotFoundException, MyException {
		UnidaysDiscountChallenge shopping = new UnidaysDiscountChallenge("./pricingRules.txt");
		shopping.addToBasket("E");
		shopping.addToBasket("D");
		shopping.addToBasket("C");
		shopping.addToBasket("B");
		shopping.addToBasket("A");
		shopping.addToBasket("E");
		shopping.addToBasket("D");
		shopping.addToBasket("C");
		shopping.addToBasket("B");
		shopping.addToBasket("C");
		assertEquals(0, shopping.calculateDeliveryPrice());
	}







}
