package Test;

import Client.Client;

public class TestClient {

	public void start() {
		Client client = new Client("localhost", 13300);
		// Le serveur envoie son bonjour
		String test = client.readBytesAsString(7);
		// On lui répond
		System.out.println("Recu:" + test);
		if (test.equals("Bonjour")) {
			System.out.println("Envoie:Les licornes multicolores");
			client.sendBytes("Les licornes multicolores".getBytes());
			while(!client.isClosed()){
				String recu = client.readBytesAsString(50);
				System.out.println("Recu:"+recu +" Init?"+recu.equals("INIT"));
				if(recu.equals("INIT")){
					System.out.println("Envoi:C48999");
					System.out.println("Envoi coordonnées");
					client.addData('C');
					client.addData((byte)4);
					client.addData((byte)8);
					client.addData(999);
					client.sendData();
				}else if(recu.equals("Fin de partie. Deconnexion.")){
					client.close();
				}
			}
		}
	}
}
