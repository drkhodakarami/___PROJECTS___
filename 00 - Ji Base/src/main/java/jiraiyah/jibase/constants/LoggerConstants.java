package jiraiyah.jibase.constants;

import jiraiyah.jibase.annotations.*;
import jiraiyah.jibase.exceptions.Exceptions;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

public class LoggerConstants
{
    public LoggerConstants()
    {
        Exceptions.throwCtorAssertion();
    }

    public static final String RESET = "\u001B[0m";

    public static class Foreground
    {
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String MAGENTA = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";
        public static final String BRIGHT_BLACK = "\u001B[90m";
        public static final String BRIGHT_RED = "\u001B[91m";
        public static final String BRIGHT_GREEN = "\u001B[92m";
        public static final String BRIGHT_YELLOW = "\u001B[93m";
        public static final String BRIGHT_BLUE = "\u001B[94m";
        public static final String BRIGHT_MAGENTA = "\u001B[95m";
        public static final String BRIGHT_CYAN = "\u001B[96m";
        public static final String BRIGHT_WHITE = "\u001B[97m";

        public Foreground()
        {
            Exceptions.throwCtorAssertion();
        }
    }

    public static class Background
    {
        public static final String BLACK = "\u001B[40m";
        public static final String RED = "\u001B[41m";
        public static final String GREEN = "\u001B[42m";
        public static final String YELLOW = "\u001B[43m";
        public static final String BLUE = "\u001B[44m";
        public static final String MAGENTA = "\u001B[45m";
        public static final String CYAN = "\u001B[46m";
        public static final String WHITE = "\u001B[47m";
        public static final String BRIGHT_BLACK = "\u001B[100m";
        public static final String BRIGHT_RED = "\u001B[101m";
        public static final String BRIGHT_GREEN = "\u001B[102m";
        public static final String BRIGHT_YELLOW = "\u001B[103m";
        public static final String BRIGHT_BLUE = "\u001B[104m";
        public static final String BRIGHT_MAGENTA = "\u001B[105m";
        public static final String BRIGHT_CYAN = "\u001B[106m";
        public static final String BRIGHT_WHITE = "\u001B[107m";

        public Background()
        {
            Exceptions.throwCtorAssertion();
        }
    }
}