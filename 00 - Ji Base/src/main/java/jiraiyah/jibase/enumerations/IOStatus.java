package jiraiyah.jibase.enumerations;

import jiraiyah.jibase.annotations.*;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public enum IOStatus
{
    NONE,
    INPUT,
    OUTPUT,
    INPUT_OUTPUT;

    public boolean isInput() {
        return this == INPUT || this == INPUT_OUTPUT;
    }

    public boolean isOutput() {
        return this == OUTPUT || this == INPUT_OUTPUT;
    }
}