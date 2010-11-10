package lk.appzone;

import lk.appzone.client.MchoiceAventuraMessagingException;
import lk.appzone.client.MchoiceAventuraResponse;
import lk.appzone.client.MchoiceAventuraSmsMessage;
import lk.appzone.client.MchoiceAventuraSmsMoServlet;
import lk.appzone.client.MchoiceAventuraSmsSender;


public class Receiver extends MchoiceAventuraSmsMoServlet {

	protected void onMessage(MchoiceAventuraSmsMessage sms) {
		try {
			MchoiceAventuraSmsSender smsSender = new MchoiceAventuraSmsSender("http://localhost:8008/simulator", "app", "pass");
			MchoiceAventuraResponse response = smsSender.sendMessage("hello content", sms.getAddress());
			if(response.isSuccess()) {
				System.out.println("Message Sent OK");
			} else {
				System.out.println("Message Sent Failed");
			}
			
		} catch (MchoiceAventuraMessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
