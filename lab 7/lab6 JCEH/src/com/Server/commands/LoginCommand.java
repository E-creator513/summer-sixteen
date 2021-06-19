package com.Server.commands;

import com.Server.ServerCode.KingManager.KingDatabaseMan;
import com.Server.ServerCode.KingManager.KingPasswordMan;
import com.Server.ServerCode.KingManager.ServerConn;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.HashMap;

/**
 * Класс {@code LoginCommand} переопределяет метод {@code execute()} для подключения к БД и поиска соответствия почты
 * и пароля в таблице users.
 * @author zvaks
 */
public class LoginCommand extends AbstractCommand {
    private final ServerConn serverConn;

    public LoginCommand(ServerConn currentConnection) {

        this.serverConn = currentConnection;
        setDescription("Войти под своей учётной записью. Синтаксис {login email}.");
    }

    public synchronized String execute(String[] args) {
        try {
            if (args.length < 2) throw new IllegalArgumentException();
            InternetAddress email = new InternetAddress(args[0]);
            email.validate();
            try {
                PreparedStatement request = KingDatabaseMan.getInstance().getConnection().
                        prepareStatement("SELECT master_id FROM users WHERE email = ? AND password = ?");
                request.setString(1, email.toString());
                try {
                    request.setString(2, KingPasswordMan.getHash(args[1], "SHA512"));
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                    System.err.println("Обращение к БД без хэширования.");
                    request.setString(2, args[1]);
                }
                try (ResultSet answer = request.executeQuery()) {
                    int userID = 0;
                    while (answer.next()) userID = answer.getInt(1);
                    if (userID != 0) {
                        setAccess(userID);
                        return "Доступ разрешён.";
                    } else return "Пользователь с такими данными не найден.";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return "Произошла ошибка на стороне сервера. Попробуйте ещё раз позже.";
            }
        } catch (AddressException e) {
            return e.getMessage();
        } catch (IllegalArgumentException e) {
            return execute();
        }
    }

    private void setAccess(int ID) {
        serverConn.setId(ID);
        HashMap<String, AbstractCommand> commands = serverConn.getAvailableCommands();
        commands.put("help", new HelpCommand());
        commands.remove("login");
        commands.remove("register");
        System.out.println("Пользователь " + serverConn.getSocket() + " получил доступ к коллекции.");
    }
}
