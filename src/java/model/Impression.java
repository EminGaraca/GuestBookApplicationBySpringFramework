/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Emin
 */
public class Impression {

    private int id;
    private String username;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Impression{" + "id=" + id + ", username=" + username + ", text=" + text + '}';
    }
    
    

    public static String allImpressions() throws ClassNotFoundException {

        StringBuilder all_impressions = new StringBuilder();

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/guestbook?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "emin2210");) {

            Statement st = (Statement) conn.createStatement();
            st.executeQuery("select username, text from impression");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                all_impressions.append(rs.getString("username"));
                all_impressions.append(": ");
                all_impressions.append(rs.getString("text"));
                all_impressions.append("\n");
            }

        } catch (SQLException ex) {
            all_impressions.append(ex.getMessage());
        }

        return all_impressions.toString();
    }

    public void insertImpression() throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/guestbook?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "emin2210");) {

            if (username != null && !(username.isEmpty()) && text != null && !(text.isEmpty())) {
                Statement st =  conn.createStatement();
                st.execute("insert into impression ( username, text ) values ('" + username + "','" + text + "')");
            }

        } catch (SQLException ex) {
            System.out.println("Error in database connection: \n" + ex.getMessage());
        }
    }
}
