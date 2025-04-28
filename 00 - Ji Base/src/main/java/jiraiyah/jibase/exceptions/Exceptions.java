package jiraiyah.jibase.exceptions;

import jiraiyah.jibase.annotations.*;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class Exceptions
{
    public Exceptions()
    {
        throwCtorAssertion();
    }

    public static void throwCtorAssertion()
    {
        throw new InitCtorException();
    }
}