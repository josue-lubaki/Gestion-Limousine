package Application;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
		ChauffeurTest.class,
		CompagnieTest.class,
		DepotTest.class,
		FournisseurTest.class,
		LimousineTest.class,
		TrajetTest.class
})
public class AllTests {

}
