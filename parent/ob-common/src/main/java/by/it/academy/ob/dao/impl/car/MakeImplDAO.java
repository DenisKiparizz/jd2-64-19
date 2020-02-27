package by.it.academy.ob.dao.impl.car;

import by.it.academy.ob.dao.MakeDAO;
import by.it.academy.ob.dao.impl.AbstractDAO;
import by.it.academy.ob.model.cars.Make;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MakeImplDAO extends AbstractDAO implements MakeDAO {
    private static final MakeDAO INSTANCE = new MakeImplDAO();

    protected MakeImplDAO() {
        super(LoggerFactory.getLogger(Make.class));
    }

    public static final String GET = "SELECT*FROM make;";

    public static MakeDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Long add(Make make) throws SQLException {
        return null;
    }

    @Override
    public Optional<Make> read(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public int update(Make make) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Long id) throws SQLException {
        return 0;
    }

    @Override
    public List<Make> getAll() throws SQLException {
        ResultSet resultSet = null;
        List<Make> makes = new ArrayList<>();
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(GET, Statement.RETURN_GENERATED_KEYS)) {
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Make make = new Make();
                    make.setId(resultSet.getLong(1));
                    make.setName(resultSet.getString("Make"));
                    makes.add(make);
                }
            } finally {
                closeQuietly(resultSet);
            }
        return makes;
    }
}
