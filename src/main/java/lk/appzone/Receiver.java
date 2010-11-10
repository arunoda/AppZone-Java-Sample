/**
	Copyright [2010] [Arunoda Susiripala]
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
		http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */

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
