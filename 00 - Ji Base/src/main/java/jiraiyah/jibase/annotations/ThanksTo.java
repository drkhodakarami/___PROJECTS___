package jiraiyah.jibase.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Developer("Jiraiyah")
@CreatedAt("2025-04-18")
@Repository("https://github.com/drkhodakarami/___PROJECTS___")
@Discord("https://discord.gg/pmM4emCbuH")
@Youtube("https://www.youtube.com/@TheMentorCodeLab")

@Documented
@Target(value = {TYPE, METHOD, FIELD, CONSTRUCTOR})
public @interface ThanksTo
{
    String[] discordUsers() default {};
    String[] mcPlayers() default {};
    String[] githubUsers() default {};
    String[] youtubeUsers() default {};
}