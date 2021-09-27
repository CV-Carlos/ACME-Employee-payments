import Helpers.PaymentsInformation;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features"
)

public class CucumberTestSuite
{
    @BeforeClass
    public static void setup()
    {
        PaymentsInformation.loadTimeSlots();
    }

    @AfterClass
    public static void teardown()
    {
        System.out.println("Ran the after");
    }
}