package run;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;

import java.io.File;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, LiquibaseException {
        Connect.connect();
        createTables();
        columnType();
        changeOnUUID();
        relations();
    }

    public static void createTables() throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File create_tables = new File(ClassLoader.getSystemResource("liquibase/1.0-create-tables.xml").getFile());
        Liquibase create = new liquibase.Liquibase(create_tables.toString(), new FileSystemResourceAccessor(), database);
        create.update(new Contexts(), new LabelExpression());

        File set_data = new File(ClassLoader.getSystemResource("liquibase/2.0-set-data.xml").getFile());
        Liquibase insert = new liquibase.Liquibase(set_data.toString(), new FileSystemResourceAccessor(), database);
        insert.update(new Contexts(), new LabelExpression());
    }

    public static void columnType() throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File create_tables = new File(ClassLoader.getSystemResource("liquibase/3.0-type-column.xml").getFile());
        Liquibase create = new liquibase.Liquibase(create_tables.toString(), new FileSystemResourceAccessor(), database);
        create.update(new Contexts(), new LabelExpression());
    }

    public static void changeOnUUID() throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File create_tables = new File(ClassLoader.getSystemResource("liquibase/4.0-set-uuid.xml").getFile());
        Liquibase create = new liquibase.Liquibase(create_tables.toString(), new FileSystemResourceAccessor(), database);
        create.update(new Contexts(), new LabelExpression());
    }

    public static void relations() throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File create_tables = new File(ClassLoader.getSystemResource("liquibase/5.0-relations.xml").getFile());
        Liquibase create = new liquibase.Liquibase(create_tables.toString(), new FileSystemResourceAccessor(), database);
        create.update(new Contexts(), new LabelExpression());
    }
}
