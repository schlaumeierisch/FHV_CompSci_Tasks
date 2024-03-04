import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class WebServer {
    // adapt path/port individually
    private static final File _root = new File("webroot");
    private static final int _port = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(_port);
        System.out.println("Server started on port " + _port + " and ready for connection with a client");

        while (true) {
            // wait for a client to connect
            Socket socket = serverSocket.accept();
            System.out.println("New client (" + socket.getInetAddress().getHostAddress() + ") connected with the server");
            Thread thread = new Thread(() -> buildConnection(socket));
            thread.start();
        }
    }

    private static void buildConnection(Socket socket) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // split HTTP request into parts (method, URI)
            String input = bufferedReader.readLine();
            String method = input.split(" ")[0].toUpperCase();
            String requestURI = input.split(" ")[1];
            if (requestURI.equals("/")) {
                requestURI = "/index.html";
            }

            // create path for requested file to search
            Path file = Path.of(String.valueOf(_root), requestURI.replace('/', '\\'));
            byte[] htmlResponse;

            // send the respective message to the client
            if (!method.equals("GET")) {
                htmlResponse = httpError("405 Method Not Allowed").getBytes();
                sendMessage(socket, "HTTP/1.1 405 Method Not Allowed", htmlResponse);
            } else if (Files.exists(file)) {
                htmlResponse = Files.readAllBytes(file);
                sendMessage(socket, "HTTP/1.1 200 OK", htmlResponse);
            } else if (!Files.exists(file)) {
                htmlResponse = httpError("404 Not Found").getBytes();
                sendMessage(socket, "HTTP/1.1 404 Not Found", htmlResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String httpError(String error) {
        return "<!DOCTYPE html><html><head><title>" + error + "</title></head><body><h1>" + error + "</h1></body></html>\r\n\r\n";
    }

    private static void sendMessage(Socket socket, String htmlStatus, byte[] htmlResponse) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write((htmlStatus + "\r\n").getBytes());
        bufferedOutputStream.write(("\r\n").getBytes());
        bufferedOutputStream.write(htmlResponse);
        bufferedOutputStream.write(("\r\n\r\n").getBytes());
        bufferedOutputStream.flush();

        bufferedOutputStream.close();
    }
}
