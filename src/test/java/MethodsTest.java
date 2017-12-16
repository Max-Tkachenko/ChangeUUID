import liquibase.exception.LiquibaseException;
import org.junit.Test;
import run.Connect;
import run.Main;

import java.sql.SQLException;

public class MethodsTest {

    @Test
    public void createTablesTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.createTables();
        Main.columnType();
        Main.changeOnUUID();
        Main.relations();
    }
}

