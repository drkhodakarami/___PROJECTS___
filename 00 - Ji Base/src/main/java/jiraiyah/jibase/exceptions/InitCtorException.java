package jiraiyah.jibase.exceptions;

import jiraiyah.jibase.annotations.*;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class InitCtorException extends RuntimeException
{
    public static String METHOD_CTOR_ASSERTION_TEXT = "This class should not be instantiated";

    public InitCtorException()
    {
        super(METHOD_CTOR_ASSERTION_TEXT);
    }
}