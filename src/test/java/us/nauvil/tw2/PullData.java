package us.nauvil.tw2;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

public class PullData {

	public static void main(String[] args) {
		try {
			// open websocket
			String theUrl = "wss://us.tribalwars2.com/socket.io/1/websocket/" + UUID.randomUUID().toString();
			System.out.println("URL: " + theUrl);
			final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI(theUrl));

			// add listener
			clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
				public void handleMessage(String message) {
					System.out.println("message: " + message);
				}
			});

			// 5:::{"name":"msg","args":[{"type":"GameDataBatch/getGameData","id":4,"headers":{"traveltimes":[["browser_send",1486834757052]]}}]}
			// send message to websocket
			// clientEndPoint.sendMessage("{'id':
			// 36,'type':'VillageBatch/villageData'}");
			// 5:::{"name":"msg","args":[{"type":"VillageBatch/getVillageData","data":{"village_ids":["5848"]},"id":28,"headers":{"traveltimes":[["browser_send",1486834760703]]}}]}

			// 5:::{"name":"msg","args":[{"type":"System/welcome","data":{"message":"Connection
			// established using transport
			// websocket","transport":"websocket","host":"us0w3.twx","maintenance":false}}]}
			String login = "5:::{\"name\":\"msg\",\"args\":[{\"type\":\"Authentication/login\",\"data\":{\"name\":\"username\",\"pass\":\"password\"},\"id\":1,\"headers\":{\"traveltimes\":[[\"browser_send\"," + System.currentTimeMillis() / 1000 + "]]}}]}";

			clientEndPoint.sendMessage(login);

			// 5:::{"name":"msg","args":[{"type":"Chat/getTribeChatHistory","id":31,"headers":{"traveltimes":[["browser_send",1486834760734]]}}]}

			// wait 5 seconds for messages from websocket
			Thread.sleep(5000);

			System.out.println("COMPLETE");

		} catch (InterruptedException ex) {
			System.err.println("InterruptedException exception: " + ex.getMessage());
		} catch (URISyntaxException ex) {
			System.err.println("URISyntaxException exception: " + ex.getMessage());
		}
	}

}
