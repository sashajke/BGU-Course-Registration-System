package bgu.spl.net.srv.Commands;

import bgu.spl.net.impl.rci.Command;
import bgu.spl.net.srv.Database;

import java.io.Serializable;

public class ACK implements Command<Database> {
    @Override
    public Serializable execute(Database arg) {
        return null;
    }
}