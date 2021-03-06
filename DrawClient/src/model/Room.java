package model;

import java.util.ArrayList;

/**
 *
 * @author whiwf
 */
public class Room implements java.io.Serializable {

    private static final long serialVersionUID = 6529685098267757690L;

    private int id;
    private ArrayList<Player> listPlayer;
    private ArrayList<String> lsPainterUsername;
    private String word;
    private boolean isStart;
    public int getId() {
        return id;
    }

    public ArrayList<Player> getListPlayer() {
        return listPlayer;
    }

    public ArrayList<String> getLsPainterUsername() {
        return lsPainterUsername;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", listPlayer=" + listPlayer + ", lsPainterUsername=" + lsPainterUsername + '}';
    }
}
