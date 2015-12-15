package io.socket.backo;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.net.URISyntaxException;

import org.json.JSONException;
import org.json.JSONObject;

public class Test {

	public static void main(String[] args) {
		try {
			Socket socket=IO.socket("http://chat.socket.io");
			socket.on("login", onLogin);
			socket.emit("add user", "egima");
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	   private static Emitter.Listener onLogin = new Emitter.Listener() {
	        @Override
	        public void call(Object... args) {
	            JSONObject data = (JSONObject) args[0];
	          System.out.println(data.toString());
	            int numUsers;
	            try {
	                numUsers = data.getInt("numUsers");
	            } catch (JSONException e) {
	                return;
	            }
	        }
	    };

}
