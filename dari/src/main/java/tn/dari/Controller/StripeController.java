package tn.dari.Controller;

import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.web.bind.annotation.*;
import tn.dari.Model.stripe.CheckoutPayment;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/apii")
public class StripeController {
	private static Gson gson = new Gson();

	@PostMapping("/payment")
	/**
	 * Payment with Stripe checkout page
	 * 
	 * @param payment
	 * @return
	 * @throws StripeException
	 */
	public String paymentWithCheckoutPage(@RequestBody CheckoutPayment payment) throws StripeException {
		// We initilize stripe object with the api key
		init();
		// We create a stripe session
		SessionCreateParams params = SessionCreateParams.builder()
				// We will use the credit card payment method
				.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
				.setMode(SessionCreateParams.Mode.PAYMENT).setSuccessUrl(payment.getSuccessUrl())
				.setCancelUrl(
						payment.getCancelUrl())
				.addLineItem(
						SessionCreateParams.LineItem.builder().setQuantity(payment.getQuantity())
								.setPriceData(
										SessionCreateParams.LineItem.PriceData.builder()
												.setCurrency(payment.getCurrency()).setUnitAmount(payment.getAmount())
												.setProductData(SessionCreateParams.LineItem.PriceData.ProductData
														.builder().setName(payment.getName()).build())
												.build())
								.build())
				.build();

		Session session = Session.create(params);

		Map<String, String> responseData = new HashMap<>();
		responseData.put("id", session.getId());

		return gson.toJson(responseData);
	}



	private static void init() {
		Stripe.apiKey = "sk_test_51IS3xuEW0KlR6HuIVQ94DfBr8PBsxzflcoIcEarxDhZmKhK9hDrv8xvbgnZ9iQ4QQuTOIc4UPq8pDgpJ93Yhr3A800rTng9H8I";
	}
}
