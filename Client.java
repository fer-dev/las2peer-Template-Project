package i5.las2peer.services.servicePackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.*;
import java.net.*;

import java.ws.rs.GET
import java.ws.rs.POST

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import i5.las2peer.api.p2p.ServiceNameVersion;
import i5.las2peer.connectors.webConnector.WebConnector;
import i5.las2peer.connectors.webConnector.client.ClientResponse;
import i5.las2peer.connectors.webConnector.client.MiniClient;
import i5.las2peer.p2p.LocalNode;
import i5.las2peer.p2p.LocalNodeManager;
import i5.las2peer.security.ServiceAgentImpl;
import i5.las2peer.security.UserAgentImpl;
import i5.las2peer.testing.MockAgentFactory;

public class request {
//1. Create socket object
//2. define ip address as a string
//3. define int number as port
//4. setup and config template with the client properties
//5. connect all nodes from the network
Socket ObjectSocket;
private static final string HTTP_ADDRESS="www.jasper-domain.net";
private static final int PORT=25078 
private static final string mainPath = "template/"
private static  ByteArrayOutStream logStream;
private static UserAgentImpl clientAgent;
private static final LocalNode node clientAgent;
private static WebConnector connector;
private static final String clientPass="jasper_password"
request(){}
void run
  {
         //1.connection.
         try {
         ObjectSocket= new Socket(HTTP_ADDR, PORT);
         System.out.println("Connected to database | JASPER NETWORK");
do {
 //Actividades previas a la conexion iniciar red p2p
try {
 @BeforeClass
  public static void startServer() throws Exception {
  //reinicializar webconector con el puerto de conexion
  //inicializar nodos
  private static final int HTTP_PORT=WebConnector.PORT // si da problemas revisar linea 35
  node = new LocalNodeManager().newNode();
  //pasar argumentos de base de datos para , 1. usuario; 2. contraseña
  clientAgent.unlock(clientPass); // nececita ser desbloqueado para permitir el "Storage"
  node.storeAgent(clientAgent);
  node.launch();
  // during testing, the specified service version does not matter
		ServiceAgentImpl testService = ServiceAgentImpl
				.createServiceAgent(ServiceNameVersion.fromString(TemplateService.class.getName() + "@1.0"), "a pass");
		testService.unlock("a pass");
  node.registerReceiver(testService);
  //Inicializar "connector" <- Asociado al objeto webconector
  logStream= new ByteArrayOuputStream(); //log de data stream
  connector= new WebConnector(true, HTTP_PORT, false, 1000);
  //se traspasa data stream del objeto conector para que se almacene en el log de data stream
  connector.setLogStream(new PrintStream(logStream));
  connector.start(node);
  Thread.sleep(1000); //un segundo para sincronizar "connector"
  }
   }
    } while (clientAgent=MockAgentFactory.getAdam());

        catch(UnknownHostException unknownHost){
            System.err.println("[ HOST DOES NOT EXIST ]");
        }
        catch(IOException ioException){
            ioException.printStackTrace();
	    fail("IO Exception: " + ioException);
        }

   finally {
	//close p2p  connection, close node
	try {
		request.close
		//Acciones posteriores a cerrar el cliente
		@AfterClass
		public static void shutDownServer() throws Exception {
		//Se detiene la conexion
		connector.stop();
		//el node deja de funcionar.
		node.shutDown();
		connector=null;
	        node=null;
		System.out.println("------------------------------");
		System.out.println("Connector-Log: [ CLOSED NODE ]");
		System.out.println("------------------------------");
		System.out.println(logStream.toString());
		}
	    }
	    public static void main(Strings args[]) {
		request client = new request();
		client.setAddressPort(HTTP_ADDRESS, HTTP_PORT);
		try {
		     client.setLogin(testAgent.getIdentifier(),clientPass);
		     ClientResponse result = c.sendRequest("POST", mainPath + "post/TestInput", "");
		     assertEquals(200, result.getHttpCode());
		     assertTrue(result.getResponse().trim().contains("testInput"));
		     System.out.println("Result of 'testPost':" + result.getResponse().trim());
		      } catch (Exception e) {
			e.printStackTrace();
			fail("Exception: " + e );
					    }
		client.run();
						    }
	   }
