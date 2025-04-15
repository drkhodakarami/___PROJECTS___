package jiraiyah.jilogger;

public class ExceptionHelper
{
    public static String METHOD_CTOR_ASSERTION_TEXT = "This class should not be instantiated";

    public static void throwCtorAssertion()
    {
        throw new AssertionError(METHOD_CTOR_ASSERTION_TEXT);
    }
}