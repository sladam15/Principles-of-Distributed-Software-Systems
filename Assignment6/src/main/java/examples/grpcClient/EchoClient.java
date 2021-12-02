package example.grpcclient;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.TimeUnit;
import service.*;
import test.TestProtobuf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Client that requests `parrot` method from the `EchoServer`.
 */
public class EchoClient {
  private final EchoGrpc.EchoBlockingStub blockingStub;
  private final JokeGrpc.JokeBlockingStub blockingStub2;
  private final RegistryGrpc.RegistryBlockingStub blockingStub3;
  
  private final CalcGrpc.CalcBlockingStub blockingStub4;
  private final StoryGrpc.StoryBlockingStub blockingStub5;

  /** Construct client for accessing server using the existing channel. */
  public EchoClient(Channel channel, Channel regChannel) {
    // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's
    // responsibility to
    // shut it down.

    // Passing Channels to code makes code easier to test and makes it easier to
    // reuse Channels.
    blockingStub = EchoGrpc.newBlockingStub(channel);
    blockingStub2 = JokeGrpc.newBlockingStub(channel);
    blockingStub3 = RegistryGrpc.newBlockingStub(regChannel);
	
	blockingStub4 = CalcGrpc.newBlockingStub(channel);
	blockingStub5 = StoryGrpc.newBlockingStub(channel);
  }

  public void askServerToParrot(String message) {
    ClientRequest request = ClientRequest.newBuilder().setMessage(message).build();
    ServerResponse response;
    try {
      response = blockingStub.parrot(request);
    } catch (Exception e) {
      System.err.println("RPC failed: " + e.getMessage());
      return;
    }
    System.out.println("Received from server: " + response.getMessage());
  }

  public void askForJokes(int num) {
    JokeReq request = JokeReq.newBuilder().setNumber(num).build();
    JokeRes response;

    try {
      response = blockingStub2.getJoke(request);
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
    System.out.println("Your jokes: ");
    for (String joke : response.getJokeList()) {
      System.out.println("--- " + joke);
    }
  }

  public void setJoke(String joke) {
    JokeSetReq request = JokeSetReq.newBuilder().setJoke(joke).build();
    JokeSetRes response;

    try {
      response = blockingStub2.setJoke(request);
      System.out.println(response.getOk());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }
  
  public void askForStories(int num) {
    JokeReq request = JokeReq.newBuilder().setNumber(num).build();
    JokeRes response;

    try {
      response = blockingStub2.getJoke(request);
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
    System.out.println("Your stories: ");
    for (String stories : response.getJokeList()) {
      System.out.println("--- " + stories);
    }
  }

  public void writeStory(String story) {
    WriteRequest request = WriteRequest.newBuilder().setNewSentence(story).build();
	WriteResponse response;

    try {
      response = blockingStub5.write(request);
	  System.out.println(response.getStory());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }
  
	// add my code
	public void setSolution(double num) {
    CalcRequest request = CalcRequest.newBuilder().addNum(num).build();
    CalcResponse response;

    try {
      response = blockingStub4.add(request);
      System.out.println("add: " + response.getSolution());
	  
	  response = blockingStub4.subtract(request);
      System.out.println("subtract: " + response.getSolution());
	  
	  response = blockingStub4.multiply(request);
      System.out.println("multiply: " + response.getSolution());
	  
	  response = blockingStub4.divide(request);
      System.out.println("divide: " + response.getSolution());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
	
	}
	

  public void findServer(String name) {
    FindServerReq request = FindServerReq.newBuilder().setServiceName(name).build();
    SingleServerRes response;
    try {
      response = blockingStub3.findServer(request);
      System.out.println(response.toString());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public void findServers(String name) {
    FindServersReq request = FindServersReq.newBuilder().setServiceName(name).build();
    ServerListRes response;
    try {
      response = blockingStub3.findServers(request);
      System.out.println(response.toString());
    } catch (Exception e) {
      System.err.println("RPC failed: " + e);
      return;
    }
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 5) {
      System.out
          .println("Expected arguments: <host(String)> <port(int)> <regHost(string)> <regPort(int)> <message(String)>");
      System.exit(1);
    }
    int port = 9099;
    int regPort = 9003;
    String host = args[0];
    String regHost = args[2];
    String message = args[4];
    try {
      port = Integer.parseInt(args[1]);
      regPort = Integer.parseInt(args[3]);
    } catch (NumberFormatException nfe) {
      System.out.println("[Port] must be an integer");
      System.exit(2);
    }

    // Create a communication channel to the server, known as a Channel. Channels
    // are thread-safe
    // and reusable. It is common to create channels at the beginning of your
    // application and reuse
    // them until the application shuts down.
    String target = host + ":" + port;
    ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS
        // to avoid
        // needing certificates.
        .usePlaintext().build();

    String regTarget = regHost + ":" + regPort;
    ManagedChannel regChannel = ManagedChannelBuilder.forTarget(regTarget).usePlaintext().build();
    try {
	
	while (true) {
      EchoClient client = new EchoClient(channel, regChannel);
      client.askServerToParrot(message);
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	  
	  System.out.println("Main Menu");
	  System.out.println("1 - CalcImpl");
	  System.out.println("2 - StoryImpl");
      String choice = reader.readLine();
	  
	  if (Integer.valueOf(choice) == 1) {
		  client.findServers("services.Calc/add");
		  client.findServer("services.Calc/subtract");
		  client.findServers("services.Calc/multiply");
		  client.findServer("services.Calc/divide");
		  
		  System.out.println("How many numbers would you like?"); // NO ERROR handling of wrong input here.
		  String num = reader.readLine();
		  
		  client.setSolution(Integer.valueOf(num));
		  
	  } else if(Integer.valueOf(choice) == 2) {
		  client.findServers("services.Story/read");
		  client.findServer("services.Story/write");
		  
		  while (true) {
			  System.out.println("What sentence would you like to add to story?"); // NO ERROR handling of wrong input here.
			  String num = reader.readLine();
			  
			  client.writeStory(num);

			  client.writeStory("There was a secret meeting in the morning and she absolutely had to be there. ");
		  
		  }
		  
		  

	  } else {
		  break;
	  }

	}
    } finally {
      // ManagedChannels use resources like threads and TCP connections. To prevent
      // leaking these
      // resources the channel should be shut down when it will no longer be used. If
      // it may be used
      // again leave it running.
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
      regChannel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }
}
