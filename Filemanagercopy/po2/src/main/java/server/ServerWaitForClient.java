package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import server.loadBalancer.ServerSaveData;

/**
 * Klasa udostepnia serwer na porcie
 * @see ServerWaitForClient#PORT
 */
public class ServerWaitForClient implements Runnable
    {
    /**
     * port serwera
     */
    public static int PORT = 1232;
    private ServerSocket serverSocket = new ServerSocket();
    private Path serverPath;
    private ArrayList<Path> paths;
    private ServerSaveData loadBalancer;


    public ServerWaitForClient() throws Exception
        {
        serverSocket.bind(new InetSocketAddress("localhost", PORT), 100);
        serverPath = Paths.get(System.getProperty("user.home"));
        paths = new ArrayList<>();


        initServerPaths();

        paths.clear();
        paths.add(serverPath.resolve("server0"));

        loadBalancer = new ServerSaveData(paths);
        }

    private void initServerPaths()
        {
        paths.add(serverPath.resolve("server0"));
        paths.add(serverPath.resolve("server1"));
        paths.add(serverPath.resolve("server2"));
        paths.add(serverPath.resolve("server3"));
        paths.add(serverPath.resolve("server4"));
        try
            {
            paths.forEach(e ->
            {
            try
                {
                Files.createDirectories(e);
                }
            catch (IOException ex)
                {
                ex.printStackTrace();
                }
            });
            Files.createDirectories(serverPath.resolve("log"));
            }
        catch (Exception e)
            {
            Logger.getAnonymousLogger().log(Level.WARNING, "create failed");
            }
        }


    @Override
    public void run()
        {
        try
            {
            while (true)
                {
                Socket socket = serverSocket.accept();
                new Thread(new ServerWaitClass(socket, loadBalancer)).start();
                }
            }
        catch (IOException e)
            {
            e.printStackTrace();
            }
        }
    }
