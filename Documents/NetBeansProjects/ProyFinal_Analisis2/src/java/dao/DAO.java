package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Negocio;
import model.User;
import model.Usuario;


public class DAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/proy_ads2?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

        
        //PRUEBA USERS
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
        //USUARIOS
        private static final String SELECT_ALL_USUARIOS = "select * from usuario";
        private static final String SELECT_USUARIO_BY_ID = "select idusuario,nombre,apellido,nickname, password, id_dir from usuario where idusuario =?";
	private static final String DELETE_USUARIO_SQL = "delete from usuario where idusuario = ?;";
	private static final String UPDATE_USUARIO_SQL = "update usuario set nombre = ?,apellido= ?, nickname =?, password =?, id_dir =? where idusuario = ?;";
        private static final String INSERT_USUARIO_SQL = "INSERT INTO usuario" + "  (nombre, apellido, nickname, password, id_dir) VALUES "
			+ " (?, ?, ?, ?, ?);";
        //NEGOCIOS
        private static final String SELECT_ALL_NEGOCIOS = "select * from negocio";
        private static final String SELECT_NEGOCIO_BY_ID = "select idnegocio,nombre,id_dir,descripcion,idusuario, sanciones from negocio where idnegocio =?";
        private static final String SELECT_NEGOCIO_BY_DIR = "select idnegocio,nombre,id_dir,descripcion,idusuario, sanciones from negocio where id_dir =?";
	private static final String DELETE_NEGOCIO_SQL = "delete from negocio where idnegocio = ?;";
	private static final String UPDATE_NEGOCIO_SQL = "update negocio set nombre = ?,id_dir= ?, descripcion =?, sanciones =?, idusuario=? where idnegocio = ?;";
        private static final String INSERT_NEGOCIO_SQL = "INSERT INTO negocio" + "  (nombre, id_dir, descripcion, sanciones, idusuario) VALUES "
			+ " (?, ?, ?, ?, ?);";
        
        //LOGIN
        private static final String SELECT_LOGIN = "select id_dir from usuario where nickname =? and password=?";
        
        
        //DAO
	public DAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
/*
	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				user = new User(id, name, email, country);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				users.add(new User(id, name, email, country));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getCountry());
			statement.setInt(4, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}*/
        
        
        /////////////////////////////USUARIO INICIO////////////////////////////////////////
        
        public void insertUsuario(Usuario user) throws SQLException {
		System.out.println(INSERT_USUARIO_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USUARIO_SQL)) {
			preparedStatement.setString(1, user.getNombre());
			preparedStatement.setString(2, user.getApellido());
			preparedStatement.setString(3, user.getNickname());
                        preparedStatement.setString(4, user.getPassword());
                        preparedStatement.setInt(5, user.getId_dir());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Usuario selectUsuario(int id) {
		Usuario user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USUARIO_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String nickname = rs.getString("nickname");
                                String password = rs.getString("password");
                                int id_dir = rs.getInt("id_dir");
				user = new Usuario(id, nombre, apellido, nickname, password, id_dir);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<Usuario> selectAllUsuarios() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Usuario> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USUARIOS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("idusuario");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String nickname = rs.getString("nickname");
                                String password = rs.getString("password");
                                int id_dir = rs.getInt("id_dir");
				users.add(new Usuario(id, nombre, apellido, nickname, password, id_dir));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUsuario(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USUARIO_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUsuario(Usuario user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USUARIO_SQL);) {
			statement.setString(1, user.getNombre());
			statement.setString(2, user.getApellido());
			statement.setString(3, user.getNickname());
                        statement.setString(4, user.getPassword());
                        statement.setInt(5, user.getId_dir());
			statement.setInt(6, user.getIdusuario());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
        
        /////////////////////////////USUARIO FIN///////////////////////////////////////////
        /////////////////////////////NEGOCIO INICIO////////////////////////////////////////
        
        
        public void insertNegocio(Negocio negocio) throws SQLException {
		System.out.println(INSERT_NEGOCIO_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEGOCIO_SQL)) {
			preparedStatement.setString(1, negocio.getNombre());
			preparedStatement.setInt(2, negocio.getId_dir());
			preparedStatement.setString(3, negocio.getDescripcion());
                        preparedStatement.setInt(4, negocio.getSanciones());
                        preparedStatement.setInt(5, negocio.getIdusuario());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Negocio selectNegocio(int id) {
		Negocio negocio = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NEGOCIO_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				int CAT_direcciones_id_dir = rs.getInt("id_dir");
				String descripcion = rs.getString("descripcion");
                                int sanciones = rs.getInt("sanciones");
                                int idusuario = rs.getInt("idusuario");
				negocio = new Negocio(id, nombre, CAT_direcciones_id_dir, descripcion, sanciones,idusuario);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return negocio;
	}
        
        public List<Negocio> selectNegocioByDir(int id_dir) {
		List<Negocio> negocios = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NEGOCIO_BY_DIR);) {
			preparedStatement.setInt(1, id_dir);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("idnegocio");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
                                int sanciones = rs.getInt("sanciones");
                                int idusuario = rs.getInt("idusuario");
				negocios.add(new Negocio(id, nombre, id_dir, descripcion, sanciones, idusuario));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return negocios;
	}

	public List<Negocio> selectAllNegocio() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Negocio> negocios = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NEGOCIOS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("idnegocio");
				String nombre = rs.getString("nombre");
				int CAT_direcciones_id_dir = rs.getInt("id_dir");
				String descripcion = rs.getString("descripcion");
                                int sanciones = rs.getInt("sanciones");
                                int idusuario = rs.getInt("idusuario");
				negocios.add(new Negocio(id, nombre, CAT_direcciones_id_dir, descripcion, sanciones, idusuario));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return negocios;
	}

	public boolean deleteNegocio(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_NEGOCIO_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateNegocio(Negocio negocio) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_NEGOCIO_SQL);) {
			statement.setString(1, negocio.getNombre());
			statement.setInt(2, negocio.getId_dir());
			statement.setString(3, negocio.getDescripcion());
                        statement.setInt(4, negocio.getSanciones());
                        statement.setInt(5, negocio.getIdusuario());
			statement.setInt(6, negocio.getIdnegocio());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
        
        
        
        /////////////////////////////NEGOCIO FIN///////////////////////////////////////////
        
        
        //////////////////////////////LOGIN INICIO/////////////////////////////////////////
        
        public int comprobarUsuario(String nickname, String password) {
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOGIN);) {
			preparedStatement.setString(1, nickname);
                        preparedStatement.setString(2, password);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			rs.next();
			int idusuario = rs.getInt("id_dir");
                        System.out.println("---"+idusuario+"---");
                        return idusuario;	
		} catch (SQLException e) {
			printSQLException(e);
		}
		return 0;
	}

        
        //////////////////////////////LOGIN FIN////////////////////////////////////////////
        
        
        
        

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
