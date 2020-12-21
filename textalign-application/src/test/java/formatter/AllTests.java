package formatter;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import formatter.formatterutils.FillBetweenTest;
import formatter.formatterutils.FillOutsideTest;
import formatter.formatterutils.FormatterUtilsTest;
import formatter.implementedformatters.CenterAlignFormatterTest;
import formatter.implementedformatters.JustifyFormatterTest;
import formatter.implementedformatters.LeftAlignFormatterTest;
import formatter.implementedformatters.RightAlignFormatterTest;

@RunWith(Suite.class)
@SuiteClasses({ FormatterTest.class, FillOutsideTest.class, FillBetweenTest.class, FormatterUtilsTest.class, LeftAlignFormatterTest.class, RightAlignFormatterTest.class, CenterAlignFormatterTest.class, JustifyFormatterTest.class })
public class AllTests {

}
