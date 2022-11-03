

public class Main {
	static Server server= new Server();
	
	

	public static void main(String[] args) {
		System.out.println("hi\n");
		server.Add(new Chatter("Bob",server));
		server.Add(new Chatter("Lily",server));
		server.Add(new Chatter("John",server));
		server.Add(new Chatter("Celine",server));
	}
}
