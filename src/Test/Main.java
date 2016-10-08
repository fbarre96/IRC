package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("Serveur ou client? (s/c)");
		String rep;
		try {
			rep = input.readLine();

			if (rep.equals("s")) {
				TestServeur testS = new TestServeur();
				testS.start();
			} else {
				TestClient testC = new TestClient();
				testC.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
