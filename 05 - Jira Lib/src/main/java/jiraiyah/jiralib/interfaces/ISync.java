package jiraiyah.jiralib.interfaces;

import java.util.List;

// Author: turtywurty
// https://github.com/DaRealTurtyWurty/Industria
public interface ISync
{
    void sync();
    List<ISync> getSyncables();
}